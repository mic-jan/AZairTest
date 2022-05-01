package stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.SearchPage;

import java.util.concurrent.TimeUnit;

public class SearchPageStepDefinition {
    WebDriver driver;
    SearchPage searchPage;

    @Given("Browser is open")
    public void browserIsOpen() {
        System.out.println("Browser window is open");
        System.setProperty("webdriver.chrome.driver","C:\\Programowanie\\chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1360, 800));
        driver.manage().window().setPosition(new Point(30, 30));
    }

    @Given("User is on AZair search page")
    public void user_is_on_a_zair_search_page() {
        System.out.println("On search page");
        String searchURL = "https://www.azair.eu/";
        searchPage.goTo(searchURL);
    }

    @When("Select source airport: {string}")
    public void select_source_airport(String sourceAirport) throws InterruptedException {
        searchPage.selectSourceAirport(sourceAirport);
    }

    @When("Select destination airport {string}")
    public void select_destination_airport(String destinationAirport) throws InterruptedException {
        searchPage.selectDestinationAirport(destinationAirport);
    }

    @When("Perform search")
    public void performSearch() {
        searchPage.searchFlight();
    }

    @Then("User is navigated to result page")
    public void user_is_navigated_to_result_page() {

    }



}
