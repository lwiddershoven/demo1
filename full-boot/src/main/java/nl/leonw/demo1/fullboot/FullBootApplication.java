package nl.leonw.demo1.fullboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Full application:
// DB: Hikari Connection Pool
// DB: Liquibase schema management
// DB: Generated repositories
// REST: API
// REST: JSON support
// REST: SpringFox Swagger (OpenAPI) support
// REST: Spring security secured endpoints
// Insight: Actuator insight in application
// Insight: micrometer/prometheus metrics


@SpringBootApplication
public class FullBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullBootApplication.class, args);
	}

}
