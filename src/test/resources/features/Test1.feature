Feature: AZair OW Flight test no. 1

  @Test1
  Scenario: AZair OW Flight test no. 1
    Given Browser is open
    And   User is on AZair search page
    When  Select one way ticket
    And   Select source airport: "BER"
    And   Select destination airport "MAD"
    And   Select departure date "01.06.2022"
    And   Select return date "15.06.2022"
    And   Perform search
    Then  User is navigated to result page