package stepDefinitions;

import io.cucumber.java.af.En;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageStepDefinition implements En {
    public SearchPageStepDefinition() {

        @Given("User is on AZair search page")
        public void user_is_on_a_zair_search_page() {
            System.out.println("On search page");
        };

        @When("Select source airport: {string}")
        public void select_source_airport(String string) {
        };

        @When("Select destination airport {string}")
        public void select_destination_airport(String string) {
        };

        @When("Perform search")
        public void perform_search() {
        };

        @Then("User is navigated to result page")
        public void user_is_navigated_to_result_page() {
        };

    }
}
