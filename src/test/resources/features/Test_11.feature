Feature: 11. Swap origin and destination on result page

  @Test11 @All
  Scenario: Swap origin and destination on result page
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "BER"
    And   Select destination airport(s) from list: "BCN"
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "15.08.2022"
    And   Select maximum number of changes 0
    And   Perform search
    And   Swap origin and destination on result page
    And   Perform search on result page
    Then  I check if flights from "BCN" to "BER" were displayed
