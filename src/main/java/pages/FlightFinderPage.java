package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightFinderPage extends BasePage {

    @FindBy(xpath = ".//input[@name='tripType'][@value = 'oneway']")
    WebElement oneWayRadioButton;
    @FindBy(xpath = ".//select[@name = 'passCount']/option[@value = '2']")
    WebElement threePassengersSelect;
    @FindBy(xpath = ".//select[@name='fromPort']/option[@value='Sydney']")
    WebElement fromPortSelect;
    @FindBy(xpath = ".//select[@name='fromMonth']/option[@value='7']")
    WebElement fromMonthSelect;
    @FindBy(xpath = ".//select[@name='toDay']/option[@value='27']")
    WebElement toDaySelect;
    @FindBy(xpath = ".//select[@name='toPort']/option[@value='Portland']")
    WebElement toPortSelect;
    @FindBy(xpath = ".//input[@name='servClass'][@value = 'Business']")
    WebElement servClassRadioButton;
    @FindBy(xpath = ".//select[@name='airline']/option[text()='Blue Skies Airlines']")
    WebElement airLineSelect;

    @FindBy(xpath = ".//input[@name='findFlights'][@type = 'image']")
    WebElement continueButton;

    public FlightFinderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void findFlights(){
        waitClickable(oneWayRadioButton);
        oneWayRadioButton.click();
        threePassengersSelect.click();
        fromPortSelect.click();
        fromMonthSelect.click();
        toDaySelect.click();
        servClassRadioButton.click();
        airLineSelect.click();
        continueButton.click();
    }
}
