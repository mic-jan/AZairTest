Feature: AZair smoke test

  @SmokeTest
  Scenario: AZair smoke test
    Given Browser is open
    And   User is on AZair search page
    When  Select source airport: "WRO"
    And   Select Take Me Anywhere
    And   Perform search
    Then  User is navigated to result page