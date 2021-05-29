package com.predjeskovic.neo4jrestapi.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
public class YAMLConfig {


    private String name;
    private String environment;
    private boolean enabled;
    private List<String> servers = new ArrayList<>();

    // standard getters and setters

}