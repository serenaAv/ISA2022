package isa.ProgettoEsame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProgettoEsameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoEsameApplication.class, args);
	}
}