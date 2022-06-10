package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RyanAirPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@data-ref='cookie.accept-all']")
    private WebElement buttonAcceptCookies;

    public RyanAirPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void acceptRyanAirPageCookies() {
        buttonAcceptCookies.click();
    }
}
