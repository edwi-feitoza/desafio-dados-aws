package br.com.edwifeitoza.desafiodados;

import br.com.edwifeitoza.desafiodados.metrics.MetricPublisherservice;
import br.com.edwifeitoza.desafiodados.metrics.MetricsCollectorService;
import br.com.edwifeitoza.desafiodados.repository.ResourceMonitoredRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioDadosApplication  implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(DesafioDadosApplication.class);
	private final MetricsCollectorService metricsCollectorService;
	private final MetricPublisherservice metricPublisherservice;

	private final ResourceMonitoredRepository resourceMonitoredRepository;

	public DesafioDadosApplication(MetricsCollectorService ec2MetricsCollector,
								   ResourceMonitoredRepository resourceMonitoredRepository,
								   MetricPublisherservice metricPublisherservice) {
		this.metricsCollectorService = ec2MetricsCollector;
		this.resourceMonitoredRepository = resourceMonitoredRepository;
		this.metricPublisherservice = metricPublisherservice;
	}

	public static void main(String[] args) {
		SpringApplication.run(DesafioDadosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Iniciando coleta de métricas");
		var resourcesMonitored = this.resourceMonitoredRepository.getAllResourcesMonitored();
		var metricsCollected = this.metricsCollectorService.getMetrics(resourcesMonitored);
		this.metricPublisherservice.publishCustomMetrics(metricsCollected);
		logger.info("Coleta de métricas realizada com sucesso.");
	}
}
