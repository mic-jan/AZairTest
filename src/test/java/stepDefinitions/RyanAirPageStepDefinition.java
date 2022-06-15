package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.RyanAirPage;
import stepDefinitions.core.DriverClass;

public class RyanAirPageStepDefinition {

    RyanAirPage ryanAirPage;

    public RyanAirPageStepDefinition (DriverClass driverClass){
        ryanAirPage = new RyanAirPage(driverClass.getDriver());
    }

    @And("Accept RyanAir page cookies")
    public void acceptRyanAirPageCookies() throws InterruptedException {
        ryanAirPage.acceptRyanAirPageCookies();
        Thread.sleep(7000);
    }

    @And("I check if flights are available")
    public void checkAvailablity() {
        ryanAirPage.checkAvailablity();
    }
}
