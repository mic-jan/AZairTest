Feature: 03. Flight with Take Me Anywhere option selected

  @Test_03 @All
  Scenario: Flight with Take Me Anywhere option selected
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "EDI"
    And   Select Take Me Anywhere
    And   Select soonest departure date "01.08.2022"
    And   Select latest departure date "05.08.2022"
    And   Select maximum number of changes 2
    And   Allow overnight changes
    And   Perform search
    And   Book cheapest result
    And   Switch to second tab
    Then  I check if user is redirected to airline page