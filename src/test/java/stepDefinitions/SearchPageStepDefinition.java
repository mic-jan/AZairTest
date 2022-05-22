package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ResultPage;
import pageObjects.SearchPage;
//import pageObjects.Pages;

import java.util.concurrent.TimeUnit;

public class SearchPageStepDefinition {

    WebDriver driver;
    SearchPage searchPage;
    ResultPage resultPage;

    @Given("Browser is open")
    public void browserIsOpen() {
        System.setProperty("webdriver.chrome.driver", "C:\\Programowanie\\chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);

//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1360, 800));
//        driver.manage().window().setPosition(new Point(30, 30));
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

    @When("Select source airport: {string}")
    public void selectSourceAirport(String sourceAirport) throws InterruptedException {
        searchPage.selectSourceAirport(sourceAirport);
    }

    @And("Select destination airport {string}")
    public void selectDestinationAirport(String destinationAirport) throws InterruptedException {
        searchPage.selectDestinationAirport(destinationAirport);
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
        searchPage.selectCurrency(currencyCode);
    }

    @And("Select maximum number of changes {int}")
    public void selectMaxChanges(int maxChanges) throws InterruptedException {
        searchPage.selectMaxChanges(maxChanges);
    }

    @And("Perform search")
    public void performSearch() throws InterruptedException {
        Thread.sleep(500);
        searchPage.searchFlight();
        resultPage = new ResultPage(driver);
    }

    @And("User is navigated to result page")
    public void user_is_navigated_to_result_page() throws InterruptedException {
        Thread.sleep(5000);
    }


    @And("Show advanced search parameters")
    public void showAdvancedSearchParameters() throws InterruptedException {
        searchPage.showAdvancedSearchParameters();
        Thread.sleep(1000);
    }

    @And("Select departure days {string} and return days {string}")
    public void selectDepartureDaysAndReturnDays(String departureDays, String returnDays) throws InterruptedException {
        searchPage.selectWeekdays(departureDays, returnDays);
        Thread.sleep(5000);
    }
}
