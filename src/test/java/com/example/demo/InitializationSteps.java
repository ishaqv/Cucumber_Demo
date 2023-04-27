package com.example.demo;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import lombok.Getter;

@Getter
public class InitializationSteps {
    private String accessToken;

    @Given("I have a base url and a valid access token")
    public void haveAValidAccessToken() {
        // Set the base URL for the API endpoint
        RestAssured.baseURI = CucumberConfig.baseURI;
        // Set the access token
        accessToken = CucumberConfig.accessToken;
    }
}
