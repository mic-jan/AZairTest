package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(name = "adults")
    private WebElement listAdults;

    @FindBy(name = "children")
    private WebElement listChildren;

    @FindBy(name = "infants")
    private WebElement listInfants;

//    TO DO: Delete after implementing page factory
//    By buttonSearch = By.xpath("//input[@value='Search']");
//    By checkboxTakeMeAnywhere = By.xpath("//input[@name='anywhere']");
//    By inputDestinationAirport = By.xpath("//input[@name='dstAirport']");
//    By inputSourceAirport = By.xpath("//input[@name='srcAirport']");
//    By listCurrency = By.name("currency");
//    By listDepartureMonth = By.name("depmonth");
//    By listReturnMonth = By.name("arrmonth");
//    By radiobuttonOneWay = By.xpath("//input[@value='oneway']");
//    By radiobuttonReturn = By.xpath("//input[@value='return']");
//    By buttonAdvancedSearchParameters = By.id("showMoreParams");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void goTo(String searchURL) {
        driver.navigate().to(searchURL);
    }

    public void selectSourceAirport(String sourceAirportCode) throws InterruptedException {
        inputSourceAirport.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        inputSourceAirport.sendKeys(sourceAirportCode);
//        Thread.sleep(1000);
        By buttonSourceAirport = By.xpath("//strong[text()='" + sourceAirportCode + "']//parent::span[@class='code']");
        driver.findElement(buttonSourceAirport).click();
    }

    public void selectSourceArea(String sourceArea) throws InterruptedException {
        inputSourceAirport.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        inputSourceAirport.sendKeys(sourceArea);
//        Thread.sleep(1000);
        By buttonSourceAirport = By.xpath("//span[@class='code' and text()='All airports']");
        driver.findElement(buttonSourceAirport).click();
    }

    public void selectDestinationAirport(String destinationAirportCode) throws InterruptedException {
        inputDestinationAirport.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        inputDestinationAirport.sendKeys(destinationAirportCode);
        By buttonDestinationAirport = By.xpath("//strong[text()='" + destinationAirportCode + "']//parent::span[@class='code']");
        driver.findElement(buttonDestinationAirport).click();
    }

    public void selectDestinationArea(String destinationArea) throws InterruptedException {
        inputDestinationAirport.sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.BACK_SPACE));
        inputDestinationAirport.sendKeys(destinationArea);
//        Thread.sleep(1000);
        By buttonSourceAirport = By.xpath("//span[@class='code' and text()='All airports']");
        driver.findElement(buttonSourceAirport).click();
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
}
