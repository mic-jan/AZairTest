Feature: AZair OW Flight test no. 3

  @Test3
  Scenario: AZair OW Flight test no. 3
    Given Browser is open
    And   User is on AZair search page
    When  Select one way ticket
    And   Select source airport: "WRO"
    And   Select destination airport "STN"
    And   Select soonest departure date "01.06.2022"
    And   Select latest departure date "05.06.2022"
    And   Select maximum number of changes 0
    And   Perform search
    And   User is navigated to result page
    And   Results are displayed
    Then  Book cheapest result