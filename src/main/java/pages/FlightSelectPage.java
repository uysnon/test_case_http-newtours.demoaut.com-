package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightSelectPage extends BasePage {

    @FindBy(xpath = ".//input[@type='radio'][@name = 'outFlight'][@value = 'Blue Skies Airlines$361$271$7:10']")
    public WebElement outFlightRadioButton;
    @FindBy(xpath = ".//input[@type='radio'][@name = 'inFlight'][@value = 'Blue Skies Airlines$630$270$12:23']")
    WebElement inFlightRadioButton;
    @FindBy(xpath = ".//input[@type='image'][@name = 'reserveFlights']")
    WebElement continueButton;

    public FlightSelectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void selectFlight(){
        waitClickable(continueButton);
        outFlightRadioButton.click();
        inFlightRadioButton.click();
        continueButton.click();
    }
}
