package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.Set;

public class ResultPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@data-ref='cookie.accept-all']")
    private WebElement buttonAcceptCookies;

    @FindBy(xpath = "//a[@name='FlightALBooking']")
    private WebElement divBookFirstResult;

    @FindBy(xpath = "//div[@class='result ']//div[@class='text']")
    private WebElement divFirstResult;

    @FindBy(css = "div.noResults")
    private WebElement divNoResults;

    @FindBy(css = "div.result ")
    private List<WebElement> divResults;

    @FindBy(xpath = "//a[@name='FlightALBooking']")
    private List<WebElement> divBookResults;

    @FindBy(xpath = "//*[name()='svg']")
    private WebElement hideAd;

    @FindBy(xpath = "//input[@name='srcAirport']")
    private WebElement inputSourceAirport;

    @FindBy(xpath = "//input[@name='dstAirport']")
    private WebElement inputDestinationAirport;

    @FindBy(xpath = "//span[@class='from']/span[@class='code']")
    private WebElement originCode;

    @FindBy(xpath = "//span[@class='to']/span[@class='code']")
    private WebElement destinationCode;

    @FindBy(xpath = "//span[@id='swap']/a")
    private WebElement linkSwap;

    @FindBy(name = "resultSubmit")
    private WebElement inputSearch;

    @FindBy(css = "a.nS")
    private WebElement linkNewSearch;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void bookFirstResult() throws InterruptedException {
        Thread.sleep(1000);
        divFirstResult.click();
        Thread.sleep(1000);
        divBookFirstResult.click();
        Thread.sleep(10000);
    }

    public int countResults() {
        return divResults.size();
    }

    public void switchToSecondTab() {
        Set<String> browserWindows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        browserWindows.remove(parentWindow);
        String newWindow = browserWindows.iterator().next();
        driver.switchTo().window(newWindow);
//        driver.switchTo().window(browserTabs.get(1));
    }

    public void noFlightsAreFound() {
        Assertions.assertTrue(divNoResults.isDisplayed());
    }

    public void bookRandomResult() throws InterruptedException {
        int resultNumber = (int) (Math.random() * countResults());
        Thread.sleep(4000);
        hideAd.click();
        Thread.sleep(2500);
        divResults.get(resultNumber).click();
        if (resultNumber > 5) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = "window.scrollBy(0, 300);";
            js.executeScript(script);
        }
        Thread.sleep(1000);
        divBookResults.get(resultNumber).click();
        Thread.sleep(5000);
    }

    public void userIsOnResultPage() {
        String windowTitle = driver.getTitle();
        Assertions.assertTrue(linkNewSearch.isDisplayed());
    }

    public void matchingFlightsAreFound() {
        Assertions.assertTrue(divResults.size()>0);
    }

    public void swapOriginAndDestination() throws InterruptedException {
        linkSwap.click();
        Thread.sleep(1000);
    }

    public void search() throws InterruptedException {
        inputSearch.click();
        Thread.sleep(3000);
    }

    public void returnToSearchPage() throws InterruptedException {
        linkNewSearch.click();
        Thread.sleep(7000);
    }

    public void selectOrigin(String origin) {
        inputSourceAirport.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        inputSourceAirport.sendKeys(origin);
        if (origin.length() == 3) {
            By buttonOriginAirport = By.xpath("//strong[text()='" + origin + "']//parent::span[@class='code']");
            driver.findElement(buttonOriginAirport).click();
        } else {
            inputSourceAirport.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER));
        }
    }

    public void selectDestination(String destination) {
        inputDestinationAirport.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        inputDestinationAirport.sendKeys(destination);
        if (destination.length() == 3) {
            By buttonDestinationAirport = By.xpath("//strong[text()='" + destination + "']//parent::span[@class='code']");
            driver.findElement(buttonDestinationAirport).click();
        } else {
            inputDestinationAirport.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER));
        }
    }

    public void correctRouteIsDisplayed(String origin, String destination) {
        String originDisplayed = originCode.getText();
        String destinationDisplayed = destinationCode.getText();
        Assertions.assertEquals(originDisplayed, origin);
        Assertions.assertEquals(destinationDisplayed, destination);
    }

    public void userRedirected() {
        String windowTitle = driver.getTitle();
        Assertions.assertFalse(windowTitle.contains("AZair"));
    }
}