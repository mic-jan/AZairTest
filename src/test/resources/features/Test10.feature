Feature: Book random flight from result list

  @Test10
  Scenario: AZair OW Flight test no. 10
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select source airport: "BGY"
    And   Select destination airport "NAP"
    And   Select soonest departure date "16.07.2022"
    And   Select latest departure date "16.07.2022"
    And   Select maximum number of changes 0
    And   Select currency "EUR"
    And   Perform search
    And   Book random result
    And   Switch to second tab
    And   Accept RyanAir page cookies
    And   I check if flights are available