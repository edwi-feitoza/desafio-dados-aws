package br.com.edwifeitoza.desafiodados.metrics;

import br.com.edwifeitoza.desafiodados.model.dto.MetricCollected;
import br.com.edwifeitoza.desafiodados.model.entity.MetricMonitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class MetricsCollectorService {

    private final CloudWatchClient cloudWatchClient;
    Logger logger = LoggerFactory.getLogger(MetricsCollectorService.class);

    public MetricsCollectorService(CloudWatchClient cloudWatchClient) {
        this.cloudWatchClient = cloudWatchClient;
    }

    public List<MetricCollected> getMetrics(List<MetricMonitored> metricsMonitored) {
        logger.info("Inciando coleta de métricas...");
        List<MetricCollected> metricsCollected = new ArrayList<>();
        metricsMonitored.forEach(metricMonitored -> {
            metricMonitored.getResourceIds().forEach(resourceId -> {
                try {
                    Instant nowDate = Instant.now().minus(metricMonitored.getMinutesBefore(), ChronoUnit.MINUTES);
                    Long hours = Long.valueOf(metricMonitored.getHoursInterval().toString());
                    Long minutes = Long.valueOf(metricMonitored.getMinutesInterval().toString());
                    Instant secondDate = nowDate.plus(hours, ChronoUnit.HOURS).plus(minutes, ChronoUnit.MINUTES);
                    Dimension dimension = Dimension.builder()
                            .name("resourceId")
                            .value(resourceId)
                            .build();
                    Metric metric = Metric.builder()
                            .metricName(metricMonitored.getMetricName())
                            .namespace(metricMonitored.getNamespace())
                            .dimensions(dimension)
                            .build();
                    MetricStat metricStat = MetricStat.builder()
                            .stat("Maximum")
                            .period(3600)
                            .metric(metric)
                            .build();
                    MetricDataQuery metricDataQuery = MetricDataQuery.builder()
                            .metricStat(metricStat)
                            .id("desafio_dados")
                            .returnData(Boolean.TRUE)
                            .build();
                    List<MetricDataQuery> dataQueries = new ArrayList<>();
                    dataQueries.add(metricDataQuery);
                    GetMetricDataRequest request = GetMetricDataRequest.builder()
                            .maxDatapoints(10)
                            .scanBy(ScanBy.TIMESTAMP_DESCENDING)
                            .startTime(nowDate)
                            .endTime(secondDate)
                            .metricDataQueries(dataQueries)
                            .build();
                    GetMetricDataResponse response = this.cloudWatchClient.getMetricData(request);
                    List<MetricDataResult> data = response.metricDataResults();
                    data.forEach(result -> {
                        var metricCollected = new MetricCollected(metricMonitored.getNamespace(), metricMonitored.getMetricName(), resourceId, result.values());
                        metricsCollected.add(metricCollected);
                    });

                } catch (CloudWatchException e) {
                    logger.error("Falha ao realizar coleta de métricas.", e);
                }
            });
        });
        logger.info("Métricas coletadas com sucesso.");
        return metricsCollected;
    }
}