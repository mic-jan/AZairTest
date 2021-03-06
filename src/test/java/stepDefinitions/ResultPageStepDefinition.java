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

    @And("Book cheapest result")
    public void bookCheapestResult() throws InterruptedException {
        resultPage.bookFirstResult();
        Thread.sleep(1000);
    }

    @And("Switch to second tab")
    public void switchToSecondTab() {
        resultPage.switchToSecondTab();
    }

    @Then("Book random result")
    public void bookRandomResult() throws InterruptedException {
        resultPage.bookRandomResult();
        Thread.sleep(1000);
    }

    @And("Swap origin and destination on result page")
    public void swapOriginAndDestination() throws InterruptedException {
        resultPage.swapOriginAndDestination();
    }

    @And("Perform search on result page")
    public void performSearchOnResultPage() throws InterruptedException {
        resultPage.search();
    }

    @And("Return to search page")
    public void returnToSearchPage() throws InterruptedException {
        resultPage.returnToSearchPage();
    }

    @And("Select origin airport\\(s) from list: {string} on result page")
    public void selectOrigin(String origin) {
        resultPage.selectOrigin(origin);
    }

    @And("Select destination airport\\(s) from list: {string} on result page")
    public void selectDestination(String destination) {
        resultPage.selectDestination(destination);
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

    @Then("I check if flights from {string} to {string} were displayed")
    public void correctRouteIsDisplayed(String origin, String destination) {
        resultPage.correctRouteIsDisplayed(origin, destination);
    }

    @And("I check if user is redirected to airline page")
    public void userRedirected() throws InterruptedException {
        Thread.sleep(12000);
        resultPage.userRedirected();
    }

    @And("I check if no flights are found")
    public void noFlightsAreFound() {
        resultPage.noFlightsAreFound();
    }
}