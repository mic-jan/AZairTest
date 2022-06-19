Feature: 02. One-way flight on selected route and selected dates

  @Test_02 @All
  Scenario Outline: One way flight on selected route and selected dates
    Given Browser is open on AZair homepage
    And   Select one way ticket
    And   Select origin airport(s) from list: <source>
    And   Select destination airport(s) from list: <destination>
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "07.08.2022"
    And   Select currency "random"
    When  Perform search
    Then  I check if user is navigated to result page
    Examples:
      | source | destination |
      | "PMI"  | "BCN"       |
      | "BGY"  | "OPO"       |