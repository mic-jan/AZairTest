Feature: Direct one-way flight on selected route

  @Test3
  Scenario: Direct one-way flight on selected route
    Given Browser is open on AZair homepage
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
    And   Switch to second tab
    And   Accept RyanAir page cookies
    And   Close browser window