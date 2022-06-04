Feature: AZair OW Flight test no. 6 Ryanair

  @Test6
  Scenario: AZair OW Flight test no. 6
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select source airport: "WRO"
    And   Select destination airport "STN"
    And   Select soonest departure date "10.07.2022"
    And   Select latest departure date "15.07.2022"
    And   Select maximum number of changes 0
    And   Select currency "PLN"
    And   Perform search
    And   User is navigated to result page
    And   Results are displayed
    Then  Book cheapest result
    And   Switch to second tab
    And   Accept RyanAir page cookies