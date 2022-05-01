package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WizzAirPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    public WizzAirPage(WebDriver driver) {
        this.driver = driver;
    }
}
