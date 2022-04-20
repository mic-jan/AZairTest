package TestyPOM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ResultPage;
import pageObjects.SearchPage;

import java.util.concurrent.TimeUnit;

public class SearchPageTest {
    WebDriver driver;
    @BeforeEach
    public void testSetUp(){
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","C:\\Programowanie\\chromedriver.exe");
        driver = new ChromeDriver();
//        Actions actions = new Actions(driver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1360, 800));
        driver.manage().window().setPosition(new Point(30, 30));

//        driver.navigate().to("https://www.azair.eu/");
    }
    @Test
    public void searchFirstFlight() throws InterruptedException {
        String searchURL = "https://www.azair.eu/";
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo(searchURL)
                .selectOneWayTicket()
                .selectSourceAirport("WRO")
                .selectTakeMeAnywhere();
        searchPage.searchFlight();
        Thread.sleep(5000);
    }

    @Test
    public void searchSecondFlight() throws InterruptedException {
        String searchURL = "https://www.azair.eu/";
        SearchPage searchPage = new SearchPage(driver);
        ResultPage resultPage = new ResultPage(driver);
        searchPage.goTo(searchURL)
                .selectOneWayTicket()
                .selectSourceAirport("WRO")
                .selectDestinationAirport("BCN")
                .selectCurrency("PLN")
                .selectDepartureDate("30.04.2022")
                .selectReturnDate("14.09.2022")
                .selectMaxChanges(1);
        searchPage.searchFlight();
        Thread.sleep(5000);
        resultPage.bookFirstResult();
    }
    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}
