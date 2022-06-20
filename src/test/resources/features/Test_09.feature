Feature: 09. Origin and destination provided as an area

  @Test_09 @All
  Scenario: Origin and destination provided as an area
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "southern Poland"
    And   Select destination airport(s) from list: "Mediterranean coast"
    And   Select soonest departure date "01.07.2022"
    And   Select latest departure date "05.07.2022"
    And   Select maximum number of changes 0
    And   Select currency "PLN"
    And   Perform search
    And   Book random result
    And   Switch to second tab
    Then  I check if user is redirected to airline page