package com.example.demo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberDetailsSteps {
    private final InitializationSteps initializationSteps;
    private Response response;
    public MemberDetailsSteps(InitializationSteps initializationSteps) {
        this.initializationSteps = initializationSteps;
    }

    @When("I request member details for mobile number {string}")
    public void requestMemberDetailsForMobileNumber(String mobileNumber) {
        // Send the GET request with authorization header and query parameter
        response = given()
                .header("Authorization", "Bearer " + initializationSteps.getAccessToken())
                .queryParam("mobileNumber", mobileNumber)
                .when()
                .get("/us/loyalty/v2/members");
    }

    @Then("the response should have status code {int}")
    public void responseShouldHaveStatusCode(int expectedStatusCode) {
        // Assert the response status code
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("the member status should be {string}")
    public void memberStatusShouldBe(String expectedStatus) {
        // Get the member status property value from the response
        String actualStatus = response.jsonPath().getString("memberStatus");

        // Validate the member status property value
        assertEquals(expectedStatus, actualStatus);
    }
}
