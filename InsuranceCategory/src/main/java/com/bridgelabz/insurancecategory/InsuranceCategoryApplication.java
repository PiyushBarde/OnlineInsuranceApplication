package com.bridgelabz.insurancecategory;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class InsuranceCategoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceCategoryApplication.class, args);
        log.info("Insurance From online insurance app started");
    }
}
