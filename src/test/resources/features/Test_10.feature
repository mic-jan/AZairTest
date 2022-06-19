Feature: 10. Check if flight is available on Ryanair page

  @Test10 @All
  Scenario: Check if flight is available on Ryanair page
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "WRO"
    And   Select destination airport(s) from list: "ALC"
    And   Select soonest departure date "30.06.2022"
    And   Select latest departure date "30.06.2022"
    And   Select maximum number of changes 0
    And   Select currency "random"
    And   Perform search
    And   Book random result
    And   Switch to second tab
    And   Accept RyanAir page cookies
    Then  I check if flights are available