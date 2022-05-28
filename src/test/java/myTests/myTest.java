package myTests;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ResultPage;
import pageObjects.RyanAirPage;
import pageObjects.SearchPage;
import pageObjects.WizzAirPage;

public class myTest {
    ChromeDriver driver;
    SearchPage searchPage;
    ResultPage resultPage;
    RyanAirPage ryanAirPage;
    WizzAirPage wizzAirPage;

    @Before
    void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Programowanie\\chromedriver.exe");
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        resultPage = new ResultPage(driver);
        ryanAirPage = new RyanAirPage(driver);
        wizzAirPage = new WizzAirPage(driver);

    }

    @Test
    public void searchFirstFlight() throws InterruptedException {
        String searchURL = "https://www.azair.eu/";
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo(searchURL);
        searchPage.selectOneWayTicket();
        searchPage.selectSourceAirport("WRO");
        searchPage.selectTakeMeAnywhere();
        searchPage.searchFlight();
        Thread.sleep(10000);
        resultPage.bookFirstResult();
    }

    @After
    void tearDown() {
        driver.quit();
    }

}
