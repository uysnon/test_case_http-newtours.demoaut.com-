package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBookPage extends BasePage {

    @FindBy(xpath = ".//select[@name = 'creditCard']/option[@value = 'BA']")
    public WebElement visaSelectOption;

    @FindBy(xpath = ".//input[@name = 'creditnumber']")
    public WebElement creditNumber;

    @FindBy(xpath = ".//input[@name='cc_frst_name']")
    public WebElement firstNameCreditCardField;

    @FindBy(xpath = ".//input[@name='cc_mid_name']")
    public WebElement middleNameCreditCardField;

    @FindBy(xpath = ".//input[@name='cc_last_name']")
    public WebElement lastNameCreditCardField;

    @FindBy(xpath = ".//input[@name='billAddress1']")
    public WebElement billAddressField;

    @FindBy(xpath = ".//input[@name='billCity']")
    public  WebElement billCityField;

    @FindBy(xpath = ".//input[@name='billState']")
    public WebElement billStateField;

    @FindBy(xpath = ".//input[@name='billZip']")
    public WebElement billZipField;

    @FindBy(xpath = ".//select[@name='billCountry']//option[@value='218']")
    public WebElement UzbekistanBillCountry;

    @FindBy(xpath = ".//input[@name='delAddress1']")
    public WebElement delAddressField;

    @FindBy(xpath = ".//input[@name='delCity']")
    public WebElement delCityField;

    @FindBy(xpath = ".//input[@name='delState']")
    public WebElement delStateField;

    @FindBy(xpath = ".//input[@name='delZip']")
    public WebElement delZipField;

    @FindBy(xpath = ".//select[@name='delCountry']//option[@value='218']")
    public WebElement UzbekistanDelCountry;

    @FindBy(xpath = ".//input[@name = 'buyFlights']")
    public WebElement buyFlightsButton;


    public WebElement getElementMonthCreditField(int numMonth) {
        if ((numMonth > 12) || (numMonth <= 0)){
            throw  new RuntimeException();
        }
        String stringNumMonth;
        stringNumMonth = String.valueOf(numMonth+1);
        return driver.findElement(By.xpath(".//select[@name='cc_exp_dt_mn']/option["+ stringNumMonth+ "]"));
    }

    public WebElement getElementYearCreditField(int numYear) {
        if ((numYear > 2010) || (numYear < 2000)){
            throw  new RuntimeException();
        }
        String stringNumYear = String.valueOf(numYear);

        return driver.findElement(By.xpath(".//select[@name='cc_exp_dt_yr']/option[@value='"+ stringNumYear+"']"));
    }

    public FlightBookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setNamePassengers(int numPassengers, String[][] name) {
        String maskInputFirst = ".//input[@name='passFirst";
        String maskInputLast = ".//input[@name='passLast";
        if ((name.length != numPassengers) || (name[0].length != 2)) {
            throw new RuntimeException();
        }
        for (int i = 0; i < name.length; i++) {
            WebElement inputName = driver.findElement(By.xpath(maskInputFirst + String.valueOf(i) + "']"));
            WebElement surName = driver.findElement(By.xpath(maskInputLast + String.valueOf(i) + "']"));
            inputName.sendKeys(name[i][0]);
            surName.sendKeys(name[i][1]);
        }
    }

}
