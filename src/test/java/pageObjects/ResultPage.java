package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void bookFirstResult() throws InterruptedException {
        Thread.sleep(1000);
        divFirstResult.click();
        Thread.sleep(1000);
        divBookFirstResult.click();
        Thread.sleep(5000);
    }

    public int countResults() {
        System.out.println("Results number: " + divResults.size());
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
        Assert.assertTrue("There are flight results", divNoResults.isDisplayed());
    }

    public void bookRandomResult() throws InterruptedException {
        int resultNumber = (int) (Math.random() * countResults());
        Thread.sleep(4000);
        hideAd.click();
        Thread.sleep(2500);
        divResults.get(resultNumber - 1).click();
        if (resultNumber > 5) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = "window.scrollBy(0, 300);";
            js.executeScript(script);
        }
        Thread.sleep(1000);
        divBookResults.get(resultNumber - 1).click();
        Thread.sleep(5000);
    }
}
