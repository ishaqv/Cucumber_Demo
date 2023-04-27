Feature: Verify member details API
  Background:
    Given I have a base url and a valid access token

  Scenario: Retrieve member details using mobile number
    When I request member details for mobile number "5627431807"
    Then the response should have status code 200
    And the member status should be "Active"
    

