Feature: Return flight on selected route and selected dates

  @Test1
  Scenario: Return flight on selected route and selected dates
    Given Browser is open on AZair homepage
    And   Select source airport: "BER"
    And   Select destination airport "MAD"
    And   Select departure date "01.08.2022"
    And   Select return date "15.08.2022"
    And   Show advanced search parameters
    And   Select departure days "456" and return days "123"
    When  Perform search
    Then  User is navigated to result page
    And   Results are displayed