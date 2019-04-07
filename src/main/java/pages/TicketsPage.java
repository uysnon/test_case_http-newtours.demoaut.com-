package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketsPage extends BasePage {

    public TicketsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "./html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]"
            + "/table/tbody/tr[5]/td/table/tbody/tr[3]/td/font")
    public WebElement departing;

    @FindBy(xpath = "./html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]"
            + "/table/tbody/tr[5]/td/table/tbody/tr[5]/td/font")
    public WebElement returning;

    @FindBy(xpath = "./html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]"
            + "/table/tbody/tr[5]/td/table/tbody/tr[7]/td/font")
    public WebElement passengers;

    @FindBy(xpath = "./html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]"
            + "/table/tbody/tr[5]/td/table/tbody/tr[9]/td/p")
    public WebElement billedToAddress;

    @FindBy(xpath = "./html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]"
            + "/table/tbody/tr[5]/td/table/tbody/tr[11]/td/p")
    public WebElement deliveryAddress;

    @FindBy(xpath = "./html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody"
            + "/tr[5]/td/table/tbody/tr[12]/td/table/tbody/tr[2]/td[2]/font/b/font/font/b/font")
    public WebElement totalPrice;


}
