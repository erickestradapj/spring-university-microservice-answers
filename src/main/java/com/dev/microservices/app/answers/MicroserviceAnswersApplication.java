package com.dev.microservices.app.answers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.dev.microservices.app.answers.models.entity",
        "com.dev.microservices.commons.students.models.entity",
        "com.dev.microservices.commons.exams.models.entity"})
public class MicroserviceAnswersApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAnswersApplication.class, args);
    }
}
