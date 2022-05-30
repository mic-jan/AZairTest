Feature: AZair OW Flight test no. 5

  @Test5
  Scenario: AZair OW Flight test no. 5
    Given Browser is open
#    And   User is on AZair search page
    When  Select one way ticket
    And   Select source area: "Poland"
    And   Select destination airport "STN"
    And   Select soonest departure date "01.09.2022"
    And   Select latest departure date "15.09.2022"
    And   Select maximum number of changes 0
#    And   Show advanced search parameters
#    And   Select departure days "467" and return days "123"
    And   Perform search
    And   User is navigated to result page
    And   Results are displayed
    Then  Book cheapest result