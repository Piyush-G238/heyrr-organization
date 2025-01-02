package com.heyrr.organization;

import org.springframework.boot.SpringApplication;

public class TestOrganizationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrganizationMicroserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
