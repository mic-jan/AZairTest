package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pageObjects.ResultPage;
import pageObjects.SearchPage;

public class ResultPageStepDefinition {
    ResultPage resultPage;

    @And("Results are displayed")
    public void resultsAreDisplayed() throws InterruptedException {
        Thread.sleep(5000);
    }

    @And("Book cheapest result")
    public void bookCheapestResult() throws InterruptedException {
        resultPage.bookFirstResult();
        Thread.sleep(10000);
    }
}
