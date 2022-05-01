package stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchPageStepDefinition {
    @Given("Browser is open")
    public void browserIsOpen() {
        System.out.println("Browser is open page");
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Programowanie\\chromedriver.exe");
        driver = new ChromeDriver();
//        Actions actions = new Actions(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1360, 800));
        driver.manage().window().setPosition(new Point(30, 30));
        driver.navigate().to("https://www.azair.eu/");
    }

    @Given("User is on AZair search page")
    public void user_is_on_a_zair_search_page() {
        System.out.println("On search page");
    }

    @When("Select source airport: {string}")
    public void select_source_airport(String string) {
    }

    @When("Select destination airport {string}")
    public void select_destination_airport(String string) {
    }

    @When("Perform search")
    public void perform_search() {
    }

    @Then("User is navigated to result page")
    public void user_is_navigated_to_result_page() {
    }

}
