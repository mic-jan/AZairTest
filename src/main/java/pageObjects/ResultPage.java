package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage bookFirstResult() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='result ']//div[@class='text']")).click();
        driver.findElement(By.xpath("//a[@name='FlightALBooking']")).click();
        Thread.sleep(20000);
        return this;
    }
}
