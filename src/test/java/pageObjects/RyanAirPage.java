package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class RyanAirPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@data-ref='cookie.accept-all']")
    private WebElement buttonAcceptCookies;

    @FindBy(xpath = "//p[contains(@class,'no-flights')]")
    private List<WebElement> pNoFlights;

    @FindBy(xpath = "//div[contains(text(),'Sold out')]")
    private List<WebElement> divsSoldOut;

    @FindBy(xpath = "//flight-card")
    private List<WebElement> flightCards;

    public RyanAirPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void acceptRyanAirPageCookies() {
        buttonAcceptCookies.click();
    }

    public void checkAvailablity() {
        Assertions.assertFalse(pNoFlights.size() != 0, "There are no flights that day");
        Assertions.assertNotEquals(divsSoldOut.size(), flightCards.size(), "All flights are sold out");
    }

    public void redirectionToRyanair() {
        String windowTitle = driver.getTitle();
        Assertions.assertEquals(windowTitle, "Ryanair");
    }
}