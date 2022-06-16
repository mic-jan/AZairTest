Feature: Direct one-way flight on selected route

  @Test3 @All
  Scenario: Direct one-way flight on selected route
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select source airport(s) from list: "WRO"
    And   Select destination airport(s) from list: "STN"
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "05.08.2022"
    And   Select maximum number of changes 0
    And   Perform search
    Then  Book cheapest result
    And   Switch to second tab
    And   Accept RyanAir page cookies