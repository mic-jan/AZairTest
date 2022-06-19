Feature: 07. Departure time limitations

  @Test_07 @All
  Scenario: AZair OW Flight test no. 7
    Given Browser is open on AZair homepage
    And   Select origin airport(s) from list: "KRK"
    And   Select destination airport(s) from list: "STN"
    And   Select soonest departure date "05.08.2022"
    And   Select latest departure date "15.08.2022"
    And   Show advanced search parameters
    And   Departure time of outbound flight must be between "5:00" and "9:15"
    And   Departure time of inbound flight must be between "13:00" and "19:59"
    And   Select maximum number of changes 0
    And   Select currency "PLN"
    And   Perform search
    And   Book cheapest result
    And   Switch to second tab
    Then  I check if user is redirected to Ryanair page
    And   Accept RyanAir page cookies