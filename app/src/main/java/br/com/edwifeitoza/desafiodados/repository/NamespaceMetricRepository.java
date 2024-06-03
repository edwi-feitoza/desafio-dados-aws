package br.com.edwifeitoza.desafiodados.repository;

import br.com.edwifeitoza.desafiodados.model.entity.NamespaceMetric;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class NamespaceMetricRepository {

    private final DynamoDbTable<NamespaceMetric> namespaceMetricTable;

    public NamespaceMetricRepository(DynamoDbEnhancedClient client) {
        this.namespaceMetricTable = client.table(NamespaceMetric.TABLE_NAME, TableSchema.fromBean(NamespaceMetric.class));
    }

    public NamespaceMetric getmetricsByNamespace(String namespace) {
        return this.namespaceMetricTable.getItem(Key
                .builder()
                        .partitionValue(namespace)
                .build());
    }
}
