package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage {
    WebDriver driver;
    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void bookFirstResult() throws InterruptedException {
        System.out.println("TEST");
        Thread.sleep(5000);
//        driver.findElement((By.xpath("//a[@class='logo']"))).click();

//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//div[@class='result ']//div[@class='text']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//a[@name='FlightALBooking']")).click();
//        Thread.sleep(10000);
    }

    public int countResults() {
    return 0;
    }
}
