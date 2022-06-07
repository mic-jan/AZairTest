Feature: Search with no results

  @Test8
  Scenario: Search with no results
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select source airport: "WAW"
    And   Select destination airport "WMI"
    And   Select maximum number of changes 0
    And   Perform search
    Then  User is navigated to result page
    And   No flights are found