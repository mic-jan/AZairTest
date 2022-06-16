Feature: AZair OW Flight test no. 6 Ryanair

  @Test6 @All
  Scenario: AZair OW Flight test no. 6
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "WRO"
    And   Select destination airport(s) from list: "STN"
    And   Select soonest departure date "10.07.2022"
    And   Select latest departure date "15.07.2022"
    And   Set number of travellers to "5" adults, "0" children, "0" infants
    And   Select maximum number of changes 0
    And   Select currency "PLN"
    And   Perform search
    Then  Book cheapest result
    And   Switch to second tab
    And   Accept RyanAir page cookies