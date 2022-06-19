Feature: Modify search query on result page

  @Test13 @All
  Scenario: Modify search query on result page
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "WAW"
    And   Select destination airport(s) from list: "BCN"
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "14.08.2022"
    And   Select maximum number of changes 0
    And   Perform search
    And   I check if flights from "WAW" to "BCN" were displayed
    And   Select origin airport(s) from list: "KRK" on result page
    And   Select destination airport(s) from list: "MAD" on result page
    And   Perform search on result page
    Then  I check if flights from "KRK" to "MAD" were displayed
#    Then  Book cheapest result
#    And   Switch to second tab
#    And   Accept RyanAir page cookies