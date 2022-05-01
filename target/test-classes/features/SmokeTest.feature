Feature: AZair smoke test
  Scenario: AZair smoke test
    Given Browser is open
    And   User is on AZair search page
    When  Select source airport: "WRO"
    And   Select destination airport "WAW"
    And   Perform search
    Then  User is navigated to result page