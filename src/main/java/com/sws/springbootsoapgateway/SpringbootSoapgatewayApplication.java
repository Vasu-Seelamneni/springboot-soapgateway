package com.sws.springbootsoapgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sws.springbootsoapgateway")
public class SpringbootSoapgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSoapgatewayApplication.class, args);
    }

}
