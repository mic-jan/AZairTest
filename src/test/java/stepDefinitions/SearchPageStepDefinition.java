package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchPage;
import stepDefinitions.core.DriverClass;

import java.util.Random;

public class SearchPageStepDefinition {

    SearchPage searchPage;

    public SearchPageStepDefinition (DriverClass driverClass){
        searchPage = new SearchPage(driverClass.getDriver());
    }

    @Given("Browser is open on AZair homepage")
    public void browserIsOpen() {
        searchPage.openAZAir();
    }

    @Given("User is on AZair search page")
    public void userIsOnAZairSearchPage() {
        String searchURL = "https://www.azair.eu/";
        searchPage.goTo(searchURL);
    }

    @When("Select one way ticket")
    public void selectOneWayTicket() {
        searchPage.selectOneWayTicket();
    }

    @When("Select origin airport\\(s) from list: {string}")
    public void selectOrigin(String origin) throws InterruptedException {
        searchPage.selectOrigin(origin);
    }

    @And("Type origin: {string}")
    public void typeOrigin(String sourceArea) throws InterruptedException {
        searchPage.typeOrigin(sourceArea);
    }

    @And("Select destination airport\\(s) from list: {string}")
    public void selectDestination(String destination) throws InterruptedException {
        searchPage.selectDestination(destination);
    }

    @And("Type destination: {string}")
    public void typeDestination(String destination) throws InterruptedException {
        searchPage.typeDestination(destination);
    }

    @And("Select Take Me Anywhere")
    public void selectTakeMeAnywhere() throws InterruptedException {
        searchPage.selectTakeMeAnywhere();
    }

    @And("Select soonest departure date {string}")
    @And("Select departure date {string}")
    public void selectDepartureDate(String departureDate) throws InterruptedException {
        searchPage.selectDepartureDate(departureDate);
    }

    @And("Select latest departure date {string}")
    @And("Select return date {string}")
    public void selectReturnDate(String returnDate) throws InterruptedException {
        searchPage.selectReturnDate(returnDate);
    }

    @And("Select currency {string}")
    public void selectCurrency(String currencyCode) throws InterruptedException {
        if (currencyCode.equals("random")){
            String[] currency = {"EUR", "USD", "GBP", "CZK", "PLN", "HUF", "RUB", "BYR"};
            int rnd = new Random().nextInt(currency.length);
            currencyCode = currency[rnd];
        }
        searchPage.selectCurrency(currencyCode);
    }

    @And("Select maximum number of changes {int}")
    public void selectMaxChanges(int maxChanges) throws InterruptedException {
        searchPage.selectMaxChanges(maxChanges);
    }

    @And("Perform search")
    public void performSearch() throws InterruptedException {
        Thread.sleep(1000);
        searchPage.searchFlight();
        Thread.sleep(2000);
    }

    @And("Show advanced search parameters")
    public void showAdvancedSearchParameters() throws InterruptedException {
        searchPage.showAdvancedSearchParameters();
        Thread.sleep(1000);
    }

    @And("Select departure days {string} and return days {string}")
    public void selectDepartureDaysAndReturnDays(String departureDays, String returnDays) throws InterruptedException {
        searchPage.selectWeekdays(departureDays, returnDays);
        Thread.sleep(1000);
    }

    @And("Set number of travellers to {string} adults, {string} children, {string} infants")
    public void setNumberOfTravellers(String adults, String children, String infants) {
        searchPage.setNumberOfTravellers(adults, children, infants);
    }

    @And("Departure time of outbound flight must be between {string} and {string}")
    public void setOutboundDepartureTime(String outboundDepartureTimeMin, String outboundDepartureTimeMax) {
        searchPage.setOutboundDepartureTime(outboundDepartureTimeMin, outboundDepartureTimeMax);
    }

    @And("Departure time of inbound flight must be between {string} and {string}")
    public void setInboundDepartureTime(String inboundDepartureTimeMin, String inboundDepartureTimeMax) {
        searchPage.setInboundDepartureTime(inboundDepartureTimeMin, inboundDepartureTimeMax);
    }

    @Then("I check if error message is displayed")
    public void checkErrorMsg() throws InterruptedException {
        Thread.sleep(3000);
        searchPage.checkErrorMsg();
    }

    @And("Allow overnight changes")
    public void allowOvernightChanges() {
        searchPage.allowOvernightChanges();
    }
}
