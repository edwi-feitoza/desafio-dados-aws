package br.com.edwifeitoza.desafiodados.metrics;

import br.com.edwifeitoza.desafiodados.model.dto.MetricCollected;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.Dimension;
import software.amazon.awssdk.services.cloudwatch.model.MetricDatum;
import software.amazon.awssdk.services.cloudwatch.model.PutMetricDataRequest;
import software.amazon.awssdk.services.cloudwatch.model.StandardUnit;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MetricPublisherservice {

    private final CloudWatchClient cloudWatchClient;
    private final ZonedDateTime current;
    Logger logger = LoggerFactory.getLogger(MetricPublisherservice.class);

    public MetricPublisherservice(CloudWatchClient cloudWatchClient) {
        this.cloudWatchClient = cloudWatchClient;
        Instant now = Instant.now();
        ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");
        this.current = ZonedDateTime.ofInstant(now, saoPaulo);
    }

    public void publishCustomMetrics(List<MetricCollected> metricsCollected) {
        logger.info("Iniciando publicação de métricas...");
        metricsCollected.forEach(metricCollected -> {
            metricCollected.getValues().forEach(value -> {
                Dimension dimension = Dimension.builder()
                        .name("resourceId")
                        .value(metricCollected.getResourceId())
                        .build();

                MetricDatum metricDatum = MetricDatum.builder()
                        .metricName(metricCollected.getMetricName())
                        .unit(StandardUnit.NONE)
                        .value(value)
                        .dimensions(dimension)
                        .timestamp(this.current.toInstant())
                        .build();

                List<MetricDatum> metrics = new ArrayList<>();
                metrics.add(metricDatum);

                PutMetricDataRequest putMetricDataRequest = PutMetricDataRequest.builder()
                        .namespace("DesafioDadosCustomMetrics")
                        .metricData(metrics)
                        .build();

                var response = this.cloudWatchClient.putMetricData(putMetricDataRequest);
                logger.info("Métricas publicadas neste ciclo: " + response);
            });
        });
        logger.info("Métricas publicadas com sucesso.");
    }
}
