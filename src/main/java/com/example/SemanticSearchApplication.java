package com.example;

import com.example.utils.EnvUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SemanticSearchApplication {
    public static void main(String[] args) {
        EnvUtil.initMQFromEnv(System.getenv());
        SpringApplication.run(SemanticSearchApplication.class, args);
    }

}
