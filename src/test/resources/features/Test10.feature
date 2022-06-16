Feature: Check if flight is available on airline's page

  @Test10 @All
  Scenario: AZair OW Flight test no. 10
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "WRO"
    And   Select destination airport(s) from list: "ALC"
    And   Select soonest departure date "16.06.2022"
    And   Select latest departure date "16.06.2022"
    And   Select maximum number of changes 0
    And   Select currency "EUR"
    And   Perform search
    And   Book random result
    And   Switch to second tab
    And   Accept RyanAir page cookies
    And   I check if flights are available