package br.com.edwifeitoza.desafiodados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class AwsDynamoDbConfig {

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return getDynamoDbClient();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient() {
        return DynamoDbEnhancedClient
                .builder()
                .dynamoDbClient(getDynamoDbClient())
                .build();
    }

    public DynamoDbClient getDynamoDbClient() {
        return DynamoDbClient
                .builder()
                .build();
    }
}
