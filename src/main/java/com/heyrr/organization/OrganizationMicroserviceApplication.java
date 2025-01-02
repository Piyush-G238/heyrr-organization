package com.heyrr.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OrganizationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationMicroserviceApplication.class, args);
	}

}
