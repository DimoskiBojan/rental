package mk.ukim.finki.emt.rental.cdcatalog;

import mk.ukim.finki.emt.rental.sharedkernel.SharedConfiguration;
import mk.ukim.finki.emt.rental.sharedkernel.infra.eventlog.RemoteEventLogService;
import mk.ukim.finki.emt.rental.sharedkernel.port.client.RemoteEventLogServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@Import(SharedConfiguration.class)
public class CdCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdCatalogApplication.class, args);
    }

    @Bean
    public RemoteEventLogService rentEvents(@Value("${app.renting.url}") String serverUrl,
                                            @Value("${app.cd-catalog.connect-timeout-ms}") int connectTimeout,
                                            @Value("${app.cd-catalog.read-timeout-ms}") int readTimeout) {
        return new RemoteEventLogServiceClient(serverUrl, connectTimeout, readTimeout);
    }

}
