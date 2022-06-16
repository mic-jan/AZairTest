Feature: Book random flight from result list

  @Test9 @All
  Scenario: AZair OW Flight test no. 9
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select source airport(s) from list: "KRK"
    And   Select destination airport(s) from list: "STN"
    And   Select soonest departure date "01.07.2022"
    And   Select latest departure date "05.07.2022"
    And   Select maximum number of changes 0
    And   Select currency "PLN"
    And   Perform search
    And   Book random result
    And   Switch to second tab
    And   Accept RyanAir page cookies
