Feature: 04. One-way flight using country selection

  @Test_04 @All
  Scenario: One-way flight using country selection
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "Poland"
    And   Select destination airport(s) from list: "Spain"
    And   Select soonest departure date "01.09.2022"
    And   Select latest departure date "15.10.2022"
    And   Select maximum number of changes 0
    And   Perform search
    And   Book random result
    And   Switch to second tab
    Then  I check if user is redirected to airline page