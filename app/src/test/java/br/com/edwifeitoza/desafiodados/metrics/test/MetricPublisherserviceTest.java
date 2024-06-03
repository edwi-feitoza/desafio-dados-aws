package br.com.edwifeitoza.desafiodados.metrics.test;

import br.com.edwifeitoza.desafiodados.metrics.MetricPublisherservice;
import br.com.edwifeitoza.desafiodados.model.dto.MetricCollected;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.PutMetricDataRequest;
import software.amazon.awssdk.services.cloudwatch.model.PutMetricDataResponse;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MetricPublisherserviceTest {
    private MetricPublisherservice metricPublisherservice;
    private CloudWatchClient cloudWatchClient;

    @BeforeEach
    public void setup() {
        cloudWatchClient = mock(CloudWatchClient.class);
        metricPublisherservice = new MetricPublisherservice(cloudWatchClient);
    }

    @Test
    public void testPublishCustomMetrics() {
        MetricCollected metricCollected = new MetricCollected("namespace", "metricName", "resourceId", Collections.singletonList(1.0));
        List<MetricCollected> metricsCollected = Collections.singletonList(metricCollected);
        PutMetricDataResponse response = PutMetricDataResponse.builder().build();
        when(cloudWatchClient.putMetricData(any(PutMetricDataRequest.class))).thenReturn(response);
        metricPublisherservice.publishCustomMetrics(metricsCollected);
        verify(cloudWatchClient, times(1)).putMetricData(any(PutMetricDataRequest.class));
    }
}
