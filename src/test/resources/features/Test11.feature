Feature: Swap origin and destination on result page

  @Test11 @All
  Scenario: Direct one-way flight on selected route
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "southern Poland"
    And   Select destination airport(s) from list: "Mediterranean coa"
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "05.08.2022"
    And   Select maximum number of changes 0
    And   Perform search
    And   Swap origin and destination on result page
    And   Perform search on result page
    And   Return to search page
#    Then  Book cheapest result
#    And   Switch to second tab
#    And   Accept RyanAir page cookies