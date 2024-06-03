package br.com.edwifeitoza.desafiodados.model.dto;

import java.util.List;

public class MetricCollected {

    public MetricCollected(String namespace, String metricName, String resourceId, List<Double> values) {
        this.namespace = namespace;
        this.metricName = metricName;
        this.resourceId = resourceId;
        this.values = values;
    }

    private String namespace;
    private String metricName;
    private String resourceId;
    private List<Double> values;

    public String getNamespace() {
        return namespace;
    }

    public String getMetricName() {
        return metricName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public List<Double> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "MetricCollected{" +
                "namespace='" + namespace + '\'' +
                ", metricName='" + metricName + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", values=" + values +
                '}';
    }
}
