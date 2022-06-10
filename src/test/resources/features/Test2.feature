Feature: One-way flight on selected route and selected dates

  @Test2
  Scenario: One way flight on selected route and selected dates
    Given Browser is open on AZair homepage
    And   Select one way ticket
    And   Select source airport: "BER"
    And   Select destination airport "LIS"
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "07.08.2022"
    And   Select currency "PLN"
    When  Perform search
    Then  User is navigated to result page
    And   Close browser window