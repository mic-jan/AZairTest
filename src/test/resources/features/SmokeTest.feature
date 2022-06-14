Feature: Smoke test with prepopulated data

  @Test0 @SmokeTest
  Scenario: Smoke test with prepopulated data
    Given Browser is open on AZair homepage
    When  Perform search
    Then  User is navigated to result page