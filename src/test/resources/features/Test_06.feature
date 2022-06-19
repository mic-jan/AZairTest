Feature: 06. Multiple passengers selected, origin and destination typed from keyboard

  @Test_06 @All
  Scenario: Multiple passengers selected, origin and destination typed from keyboard
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Type origin: "Wroclaw"
    And   Type destination: "Athens"
    And   Select soonest departure date "10.07.2022"
    And   Select latest departure date "25.07.2022"
    And   Set number of travellers to "3" adults, "1" children, "1" infants
    And   Select maximum number of changes 0
    And   Select currency "PLN"
    And   Perform search
    And   Book random result
    And   Switch to second tab
    Then  I check if user is redirected to Ryanair page
    And   Accept RyanAir page cookies