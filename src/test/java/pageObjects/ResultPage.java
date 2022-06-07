package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ResultPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='noResults']")
    private WebElement divNoResults;

    @FindBy(xpath = "//div[@class='result ']//div[@class='text']")
    private WebElement divFirstResult;

    @FindBy(xpath = "//a[@name='FlightALBooking']")
    private WebElement divBookFirstResult;

    @FindBy(xpath = "//button[@data-ref='cookie.accept-all']")
    private WebElement buttonAcceptCookies;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    public void bookFirstResult() throws InterruptedException {
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@class='result ']//div[@class='text']")).click();
        divFirstResult.click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//a[@name='FlightALBooking']")).click();
        divBookFirstResult.click();
        Thread.sleep(10000);
//        buttonAcceptCookies.click();
    }

    public int countResults() {
    return 0;
    }

    public void switchToSecondTab() {
        Set<String> browserWindows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        browserWindows.remove(parentWindow);
        String newWindow = browserWindows.iterator().next();
        driver.switchTo().window(newWindow);
//        driver.switchTo().window(browserTabs.get(1));
    }
}
