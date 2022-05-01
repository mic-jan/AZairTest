Feature: AZair OW Flight test no. 2

  @Test2
  Scenario: AZair OW Flight test no. 2
    Given Browser is open
    And   User is on AZair search page
    When  Select one way ticket
    And   Select source airport: "BER"
    And   Select destination airport "MAD"
    And   Select soonest departure date "01.06.2022"
    And   Select latest departure date "15.06.2022"
    And   Select currency "PLN"
    And   Select maximum number of changes 0
    And   Perform search
    Then  User is navigated to result page