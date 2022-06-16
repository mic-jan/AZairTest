Feature: AZair OW Flight test no. 5

  @Test5 @All
  Scenario: AZair OW Flight test no. 5
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select source airport(s) from list: "Poland"
    And   Select destination airport(s) from list: "STN"
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "15.08.2022"
    And   Select maximum number of changes 0
    And   Select currency "PLN"
#    And   Show advanced search parameters
#    And   Select departure days "467" and return days "123"
    And   Perform search
    Then  Book cheapest result