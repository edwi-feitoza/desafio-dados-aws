package br.com.edwifeitoza.desafiodados.metrics.test;

import br.com.edwifeitoza.desafiodados.metrics.MetricsCollectorService;
import br.com.edwifeitoza.desafiodados.model.dto.MetricCollected;
import br.com.edwifeitoza.desafiodados.model.entity.MetricMonitored;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.GetMetricDataRequest;
import software.amazon.awssdk.services.cloudwatch.model.GetMetricDataResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MetricsCollectorServiceTest {

    private MetricsCollectorService metricsCollectorService;
    private CloudWatchClient cloudWatchClient;

    @BeforeEach
    public void setup() {
        cloudWatchClient = mock(CloudWatchClient.class);
        metricsCollectorService = new MetricsCollectorService(cloudWatchClient);
    }

    @Test
    public void testGetMetrics() {
        MetricMonitored metricMonitored = this.buildMetricMonitored();
        List<MetricMonitored> metricsMonitored = new ArrayList<>();
        metricsMonitored.add(metricMonitored);
        GetMetricDataResponse response = GetMetricDataResponse.builder().build();
        when(cloudWatchClient.getMetricData(any(GetMetricDataRequest.class))).thenReturn(response);
        List<MetricCollected> metricsCollected = metricsCollectorService.getMetrics(metricsMonitored);
        verify(cloudWatchClient, times(1)).getMetricData(any(GetMetricDataRequest.class));
    }

    private MetricMonitored buildMetricMonitored() {
        var metricMonitored = new MetricMonitored();
        metricMonitored.setMetricName("teste");
        metricMonitored.setResourceIds(Collections.singletonList("teste-resourceid"));
        metricMonitored.setNamespace("teste-namespace");
        metricMonitored.setHoursInterval(1L);
        metricMonitored.setMinutesInterval(30L);
        metricMonitored.setMinutesBefore(30L);
        return metricMonitored;
    }
}
