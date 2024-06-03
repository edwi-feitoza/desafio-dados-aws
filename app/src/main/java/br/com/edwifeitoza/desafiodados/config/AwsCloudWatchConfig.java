package br.com.edwifeitoza.desafiodados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;

@Configuration
public class AwsCloudWatchConfig {

    @Bean
    public CloudWatchClient getCloudWatchClient() {
        return CloudWatchClient.builder()
                .build();
    }
}
