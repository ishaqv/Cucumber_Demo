package com.example.demo;

import io.cucumber.java.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CucumberConfig {

    public static String accessToken;
    public static String baseURI;


    @Before
    public void beforeScenario() throws IOException {
        // Load the cucumber.properties file
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("cucumber.properties");
        properties.load(inputStream);

        // Read the values from the properties file
        accessToken = properties.getProperty("access_token");
        baseURI = properties.getProperty("base_uri");
    }
}

