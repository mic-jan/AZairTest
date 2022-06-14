package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.ResultPage;
import stepDefinitions.core.DriverClass;

public class ResultPageStepDefinition {

    ResultPage resultPage;

    public ResultPageStepDefinition (DriverClass driverClass){
        resultPage = new ResultPage(driverClass.getDriver());
    }

    @And("I check if user is navigated to result page")
    public void userIsOnResultPage() throws InterruptedException {
        resultPage.userIsOnResultPage();
        Thread.sleep(2500);
    }

    @And("I check if matching flights are found")
    public void matchingFlightsAreFound() throws InterruptedException {
        resultPage.matchingFlightsAreFound();
        Thread.sleep(1000);
    }

    @And("Book cheapest result")
    public void bookCheapestResult() throws InterruptedException {
        resultPage.bookFirstResult();
        Thread.sleep(1000);
    }

    @And("Switch to second tab")
    public void switchToSecondTab() {
        resultPage.switchToSecondTab();
    }

    @And("I check if no flights are found")
    public void noFlightsAreFound() {
        resultPage.noFlightsAreFound();
    }

    @Then("Book random result")
    public void bookRandomResult() throws InterruptedException {
        resultPage.bookRandomResult();
        Thread.sleep(1000);
    }
}
