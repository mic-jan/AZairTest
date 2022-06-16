Feature: Search with no results

  @Test8 @All
  Scenario: Search with no results
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "WAW"
    And   Select destination airport(s) from list: "WMI"
    And   Select maximum number of changes 0
    And   Perform search
    Then  I check if user is navigated to result page
    And   I check if no flights are found