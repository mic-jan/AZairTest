package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.ResultPage;
import stepDefinitions.core.DriverClass;

public class ResultPageStepDefinition {

    ResultPage resultPage;

    public ResultPageStepDefinition (DriverClass driverClass){
        resultPage = new ResultPage(driverClass.getDriver());
    }

    @And("Results are displayed")
    public void resultsAreDisplayed() throws InterruptedException {
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
}
