package com.api.thymeleaf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Date;
import java.util.Locale;

@Configuration
public class Initialize {

    private static final Logger LOGGER = LoggerFactory.getLogger(Initialize.class);

    @Bean
    @Order(1)
    public CommandLineRunner initializeLogs() {
        return (args) -> {
            LOGGER.info("-------------SUBIU-------------");
            LOGGER.info(String.valueOf(new Date()).concat(new Locale(" pt", "BR").toString()));
        };
    }
}
