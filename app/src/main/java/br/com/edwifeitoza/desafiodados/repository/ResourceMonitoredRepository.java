package br.com.edwifeitoza.desafiodados.repository;

import br.com.edwifeitoza.desafiodados.model.entity.MetricMonitored;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResourceMonitoredRepository {

    private final DynamoDbTable<MetricMonitored> resourceMonitoredTable;

    public ResourceMonitoredRepository(DynamoDbEnhancedClient client) {
        this.resourceMonitoredTable = client.table(MetricMonitored.TABLE_NAME, TableSchema.fromBean(MetricMonitored.class));
    }

    public List<MetricMonitored> getAllResourcesMonitored () {
        PageIterable<MetricMonitored> response = this.resourceMonitoredTable.scan();
        List<MetricMonitored> resourcesMonitored = new ArrayList<>();
        response.forEach(page -> {
            resourcesMonitored.addAll(page.items());
        });
        return resourcesMonitored;
    }
}
