package trip.cafe.tripcafebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TripCafeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripCafeBackendApplication.class, args);
    }

}
