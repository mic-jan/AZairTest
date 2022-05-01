package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RyanAirPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    public RyanAirPage(WebDriver driver) {
        this.driver = driver;
    }
}
