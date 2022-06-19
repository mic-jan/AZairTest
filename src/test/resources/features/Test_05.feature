Feature: 05. Return flight on selected weekdays

  @Test5 @All
  Scenario: Return flight on selected route and selected dates
    Given Browser is open on AZair homepage
    When  Select origin airport(s) from list: "PRG"
    And   Select destination airport(s) from list: "MAD"
    And   Select departure date "01.08.2022"
    And   Select return date "15.08.2022"
    And   Show advanced search parameters
    And   Select departure days "456" and return days "123"
    And   Perform search
    Then  I check if matching flights are found