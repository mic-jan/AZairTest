package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By buttonSearch = By.xpath("//input[@value='Search']");
    By checkboxTakeMeAnywhere = By.xpath("//input[@name='anywhere']");
    By inputDestinationAirport = By.xpath("//input[@name='dstAirport']");
    By inputSourceAirport = By.xpath("//input[@name='srcAirport']");
    By listCurrency = By.name("currency");
    By listDepartureMonth = By.name("depmonth");
    By listReturnMonth = By.name("arrmonth");
    By radiobuttonOneWay = By.xpath("//input[@value='oneway']");
    By radiobuttonReturn = By.xpath("//input[@value='return']");
    By buttonAdvancedSearchParameters = By.id("showMoreParams");

    public void goTo(String searchURL) {
        driver.navigate().to(searchURL);
    }

    public void selectSourceAirport(String sourceAirportCode) throws InterruptedException {
        driver.findElement(inputSourceAirport).sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        driver.findElement(inputSourceAirport).sendKeys(sourceAirportCode);
//        Thread.sleep(1000);
        By buttonSourceAirport = By.xpath("//strong[text()='" + sourceAirportCode + "']//parent::span[@class='code']");
        driver.findElement(buttonSourceAirport).click();
    }

    public void selectSourceArea(String sourceArea) throws InterruptedException {
        driver.findElement(inputSourceAirport).sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        driver.findElement(inputSourceAirport).sendKeys(sourceArea);
//        Thread.sleep(1000);
        By buttonSourceAirport = By.xpath("//span[@class='code' and text()='All airports']");
        driver.findElement(buttonSourceAirport).click();
    }

    public void selectDestinationAirport(String destinationAirportCode) throws InterruptedException {
        driver.findElement(inputDestinationAirport).sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        driver.findElement(inputDestinationAirport).sendKeys(destinationAirportCode);
        By buttonDestinationAirport = By.xpath("//strong[text()='" + destinationAirportCode + "']//parent::span[@class='code']");
        driver.findElement(buttonDestinationAirport).click();
    }

    public void selectDestinationArea(String destinationArea) throws InterruptedException {
        driver.findElement(inputDestinationAirport).sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        driver.findElement(inputDestinationAirport).sendKeys(destinationArea);
//        Thread.sleep(1000);
        By buttonSourceAirport = By.xpath("//span[@class='code' and text()='All airports']");
        driver.findElement(buttonSourceAirport).click();
    }

    public void searchFlight() {
        driver.findElement(buttonSearch).click();
    }

    public void selectTakeMeAnywhere() {
        driver.findElement(checkboxTakeMeAnywhere).click();
    }

    public void selectOneWayTicket() {
        driver.findElement(radiobuttonOneWay).click();
    }

    public SearchPage selectReturnTicket() {
        driver.findElement(radiobuttonReturn).click();
        return this;
    }

    public void selectCurrency(String currencyCode) {
        Select currency = new Select(driver.findElement(listCurrency));
        currency.selectByValue(currencyCode); //Selecting correct month & year from list
    }

    public void selectMaxChanges(int maxChanges) {
        driver.findElement(By.xpath("//input[@name='maxChng'][@value='" + maxChanges + "']")).click();
    }

    /**
     * Selects departure date using dropdown list (month and year) and calendar widget (day)
     * @param departureDate -> date format: DD.MM.YYYY, e.g. 31.12.2022
     */
    public void selectDepartureDate(String departureDate) throws InterruptedException {
        String[] date = departureDate.split("\\.");
        String day = date[0];
        String month = date[1];
        String year = date[2];
        String departureYearMonth = year + month;
        Select departureMonth = new Select(driver.findElement(listDepartureMonth));
        departureMonth.selectByValue(departureYearMonth); //Selecting correct month & year from list
        driver.findElement(By.xpath("//table[@class='dep']//td[text()=" + Integer.valueOf(day).toString() + "]")).click();
    }

    public void selectReturnDate(String returnDate) throws InterruptedException {
        String[] date = returnDate.split("\\.");
        String day = date[0];
        String month = date[1];
        String year = date[2];
        String returnYearMonth = year + month;
        Select returnMonth = new Select(driver.findElement(listReturnMonth));
        returnMonth.selectByValue(returnYearMonth); //Selecting correct month & year from list
        driver.findElement(By.xpath("//table[@class='arr']//td[text()=" + Integer.valueOf(day).toString() + "]")).click();
    }

    public void showAdvancedSearchParameters() throws InterruptedException {
        driver.findElement(buttonAdvancedSearchParameters).click();
        Thread.sleep(1000);
    }

    public void selectWeekdays(String departureWeekdays, String returnWeekdays) throws InterruptedException {
        for (int i = 1; i <= 7; i++) {
            Thread.sleep(250);
            if (!departureWeekdays.contains(Integer.toString(i))) {
                driver.findElement((By.xpath("//input[@name='dep" + Integer.toString(i - 1) + "']"))).click();
            }
            if (!returnWeekdays.contains(Integer.toString(i))) {
                driver.findElement((By.xpath("//input[@name='arr" + Integer.toString(i - 1) + "']"))).click();
            }
        }
    }
}
