package br.com.edwifeitoza.desafiodados.model.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import java.util.List;

@DynamoDbBean
public class MetricMonitored {

    public static final String TABLE_NAME = "desafio-dados-metric-monitored";

    private String metricName;
    private String namespace;
    private Long minutesBefore;
    private Long hoursInterval;
    private Long minutesInterval;
    private List<String> resourceIds;


    @DynamoDbPartitionKey
    public String getMetricName() {
        return metricName;
    }

    @DynamoDbSortKey
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public List<String> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<String> resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Long getHoursInterval() {
        return hoursInterval;
    }

    public void setHoursInterval(Long hoursInterval) {
        this.hoursInterval = hoursInterval;
    }

    public Long getMinutesInterval() {
        return minutesInterval;
    }

    public void setMinutesInterval(Long minutesInterval) {
        this.minutesInterval = minutesInterval;
    }

    public Long getMinutesBefore() {
        return minutesBefore;
    }

    public void setMinutesBefore(Long minutesBefore) {
        this.minutesBefore = minutesBefore;
    }

    @Override
    public String toString() {
        return "ResourceMonitored{" +
                "metricName='" + metricName + '\'' +
                ", namespace='" + namespace + '\'' +
                ", minutesBefore=" + minutesBefore +
                ", hoursInterval=" + hoursInterval +
                ", minutesInterval=" + minutesInterval +
                ", resourceIds=" + resourceIds +
                '}';
    }
}
