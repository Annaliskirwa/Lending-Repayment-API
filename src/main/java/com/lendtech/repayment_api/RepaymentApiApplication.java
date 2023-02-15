package com.lendtech.repayment_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RepaymentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepaymentApiApplication.class, args);
    }

}
