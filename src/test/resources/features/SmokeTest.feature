Feature: AZair smoke test

  @Test0 @SmokeTest
  Scenario: AZair smoke test
    Given Browser is open on AZair homepage
    When  Select source airport: "WRO"
    And   Select Take Me Anywhere
    And   Perform search
    Then  User is navigated to result page
    And   Book cheapest result