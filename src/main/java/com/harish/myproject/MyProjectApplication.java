package com.harish.myproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@SpringBootApplication(scanBasePackages={"com.harish.myproject.*"})
@EntityScan( basePackages = {"com.harish.myproject.*"} )
@EnableReactiveMongoRepositories( basePackages = {"com.harish.myproject.*"} )
public class MyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyProjectApplication.class, args);
    }

}
