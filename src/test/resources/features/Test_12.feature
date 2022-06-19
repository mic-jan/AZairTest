Feature: 12. User enters non-existing airport parameter

  @Test_12 @All
  Scenario: One way flight on selected route and selected dates
    Given Browser is open on AZair homepage
    And   Select one way ticket
    And   Type origin: "ABC"
    And   Type destination: "DEF"
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "07.08.2022"
    When  Perform search
    Then  I check if error message is displayed