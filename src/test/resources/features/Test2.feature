Feature: One-way flight on selected route and selected dates

  @Test2
  Scenario Outline: One way flight on selected route and selected dates
    Given Browser is open on AZair homepage
    And   Select one way ticket
    And   Select source airport: <source>
    And   Select destination airport <destination>
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "07.08.2022"
    And   Select currency "PLN"
    When  Perform search
    Then  I check if user is navigated to result page
    Examples:
      | source | destination |
      | "BER"  | "LIS"       |
      | "BGY"  | "OPO"       |
      | "ABC"  | "DEF"       |
