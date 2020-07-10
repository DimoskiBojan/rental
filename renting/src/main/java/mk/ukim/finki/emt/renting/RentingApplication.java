package mk.ukim.finki.emt.renting;

import mk.ukim.finki.emt.rental.sharedkernel.SharedConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@Import(SharedConfiguration.class)
public class RentingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentingApplication.class, args);
    }

}