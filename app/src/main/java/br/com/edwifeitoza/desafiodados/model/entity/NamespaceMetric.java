package br.com.edwifeitoza.desafiodados.model.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.List;

@DynamoDbBean
public class NamespaceMetric {

    public static final String TABLE_NAME = "desafio-dados-namespace-metrics";

    private String namespace;
    private List<String> metrics;

    @DynamoDbPartitionKey
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @DynamoDbAttribute("metrics")
    public List<String> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<String> metrics) {
        this.metrics = metrics;
    }

    @Override
    public String toString() {
        return "NamespaceMetric{" +
                "namespace='" + namespace + '\'' +
                ", metrics=" + metrics +
                '}';
    }
}
