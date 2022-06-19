Feature: AZair OW Flight test no. 4

  @Test4 @All
  Scenario: AZair OW Flight test no. 4
    Given Browser is open on AZair homepage
    When  Select one way ticket
    And   Select origin airport(s) from list: "Poland"
    And   Select destination airport(s) from list: "Spain"
    And   Select soonest departure date "01.09.2022"
    And   Select latest departure date "15.10.2022"
    And   Select maximum number of changes 0
#    And   Show advanced search parameters
#    And   Select departure days "467" and return days "123"
    And   Perform search
    And   Book random result
    Then  I check if user is redirected to airline page