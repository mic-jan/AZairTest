package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@value='Search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//input[@name='anywhere']")
    private WebElement checkboxTakeMeAnywhere;

    @FindBy(xpath = "//input[@name='dstAirport']")
    private WebElement inputDestinationAirport;

    @FindBy(xpath = "//input[@name='srcAirport']")
    private WebElement inputSourceAirport;

    @FindBy(name = "currency")
    private WebElement listCurrency;

    @FindBy(name = "depmonth")
    private WebElement listDepartureMonth;

    @FindBy(name = "arrmonth")
    private WebElement listReturnMonth;

    @FindBy(xpath = "//input[@value='oneway']")
    private WebElement radiobuttonOneWay;

    @FindBy(xpath = "//input[@value='return']")
    private WebElement radiobuttonReturn;

    @FindBy(id = "showMoreParams")
    private WebElement buttonAdvancedSearchParameters;

    @FindBy(id = "minHourOutbound")
    private WebElement inputOutboundDepartureTimeMin;

    @FindBy(id = "maxHourOutbound")
    private WebElement inputOutboundDepartureTimeMax;

    @FindBy(id = "minHourInbound")
    private WebElement inputInboundDepartureTimeMin;

    @FindBy(id = "maxHourInbound")
    private WebElement inputInboundDepartureTimeMax;

    @FindBy(name = "adults")
    private WebElement listAdults;

    @FindBy(name = "children")
    private WebElement listChildren;

    @FindBy(name = "infants")
    private WebElement listInfants;

    @FindBy(name = "nextday")
    private WebElement checkboxOvernight;

    @FindBy(css = ".errCaption")
    private List<WebElement> spanErrorMessage;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void goTo(String searchURL) {
        driver.navigate().to(searchURL);
    }

    public void selectOrigin(String origin) throws InterruptedException {
        inputSourceAirport.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        inputSourceAirport.sendKeys(origin);
        if (origin.length() == 3) {
            By buttonOriginAirport = By.xpath("//strong[text()='" + origin + "']//parent::span[@class='code']");
            driver.findElement(buttonOriginAirport).click();
        } else {
            inputSourceAirport.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER));
        }
    }

    public void typeOrigin(String origin) throws InterruptedException {
        inputSourceAirport.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        inputSourceAirport.sendKeys(origin);
        inputSourceAirport.sendKeys(Keys.ENTER);
    }

    public void selectDestination(String destination) throws InterruptedException {
        inputDestinationAirport.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        inputDestinationAirport.sendKeys(destination);
        if (destination.length() == 3) {
            By buttonDestinationAirport = By.xpath("//strong[text()='" + destination + "']//parent::span[@class='code']");
            driver.findElement(buttonDestinationAirport).click();
        } else {
            inputDestinationAirport.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER));
        }
    }

    public void typeDestination(String destination) throws InterruptedException {
        inputDestinationAirport.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        inputDestinationAirport.sendKeys(destination);
        inputDestinationAirport.sendKeys(Keys.ENTER);

    }

    public void searchFlight() {
        buttonSearch.click();
    }

    public void selectTakeMeAnywhere() {
        checkboxTakeMeAnywhere.click();
    }

    public void selectOneWayTicket() {
        radiobuttonOneWay.click();
    }

    public SearchPage selectReturnTicket() {
        radiobuttonReturn.click();
        return this;
    }

    public void selectCurrency(String currencyCode) {
        Select currency = new Select(listCurrency);
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
        Select departureMonth = new Select(listDepartureMonth);
        departureMonth.selectByValue(departureYearMonth); //Selecting correct month & year from list
        driver.findElement(By.xpath("//table[@class='dep']//td[text()=" + Integer.valueOf(day).toString() + "]")).click();
    }

    public void selectReturnDate(String returnDate) throws InterruptedException {
        String[] date = returnDate.split("\\.");
        String day = date[0];
        String month = date[1];
        String year = date[2];
        String returnYearMonth = year + month;
        Select returnMonth = new Select(listReturnMonth);
        returnMonth.selectByValue(returnYearMonth); //Selecting correct month & year from list
        driver.findElement(By.xpath("//table[@class='arr']//td[text()=" + Integer.valueOf(day).toString() + "]")).click();
    }

    public void showAdvancedSearchParameters() throws InterruptedException {
        buttonAdvancedSearchParameters.click();
        Thread.sleep(1000);
    }

    public void selectWeekdays(String departureWeekdays, String returnWeekdays) throws InterruptedException {
        for (int i = 1; i <= 7; i++) {
            Thread.sleep(750);
            if (!departureWeekdays.contains(Integer.toString(i))) {
                driver.findElement((By.xpath("//input[@name='dep" + Integer.toString(i - 1) + "']"))).click();
            }
            if (!returnWeekdays.contains(Integer.toString(i))) {
                driver.findElement((By.xpath("//input[@name='arr" + Integer.toString(i - 1) + "']"))).click();
            }
        }
    }

    public void openAZAir() {
//        WebDriverManager.chromedriver().setup();
        driver.get("https://www.azair.eu");
    }

    public void setNumberOfTravellers(String adults, String children, String infants) {
        Select numberOfAdults = new Select(listAdults);
        numberOfAdults.selectByValue(adults);
        Select numberOfChildren = new Select(listChildren);
        numberOfChildren.selectByValue(children);
        Select numberOfInfants = new Select(listInfants);
        numberOfInfants.selectByValue(infants);

    }

    public void setOutboundDepartureTime(String outboundDepartureTimeMin, String outboundDepartureTimeMax) {
        inputOutboundDepartureTimeMin.clear();
        inputOutboundDepartureTimeMin.sendKeys(outboundDepartureTimeMin);
        inputOutboundDepartureTimeMax.clear();
        inputOutboundDepartureTimeMax.sendKeys(outboundDepartureTimeMax);
    }

    public void setInboundDepartureTime(String inboundDepartureTimeMin, String inboundDepartureTimeMax) {
        inputInboundDepartureTimeMin.clear();
        inputInboundDepartureTimeMin.sendKeys(inboundDepartureTimeMin);
        inputInboundDepartureTimeMax.clear();
        inputInboundDepartureTimeMax.sendKeys(inboundDepartureTimeMax);
    }

    public void checkErrorMsg() {
        Assertions.assertTrue(spanErrorMessage.size() >= 1, "Error message wasn't display");
    }

    public void allowOvernightChanges() {
        checkboxOvernight.click();
    }
}
