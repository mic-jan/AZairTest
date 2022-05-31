Feature: AZair RT Flight test no. 1

  @Test1
  Scenario: AZair RT Flight test no. 1
    Given Browser is open on AZair homepage
#    When  Select one way ticket
    And   Select source airport: "BER"
    And   Select destination airport "MAD"
    And   Select departure date "01.06.2022"
    And   Select return date "15.06.2022"
    And   Show advanced search parameters
    And   Select departure days "456" and return days "123"
    And   Perform search
    Then  User is navigated to result page
    And   Results are displayed