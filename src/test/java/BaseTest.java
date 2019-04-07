import logger.EventHandler;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseTest {
    EventFiringWebDriver chromeWebDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\afterschool\\RSEU\\2 course\\fintech tinkoff\\webDrivers\\chromedriver.exe");
        chromeWebDriver = new EventFiringWebDriver(new ChromeDriver());
        chromeWebDriver.register(new EventHandler());
        chromeWebDriver.get("http://newtours.demoaut.com");
    }

    @After
    public void tearDown() {
//        chromeWebDriver.quit();
    }
}
