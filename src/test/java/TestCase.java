import org.hamcrest.MatcherAssert;
import org.junit.Test;
import pages.*;

public class TestCase extends BaseTest {
    private static String LOGIN = "test1";
    private static String PASSWORD = "test1";
    private static String START_PAGE = "http://newtours.demoaut.com/";
    private static String[][] NAME_PASSENGERS = {{"Vova", "Ivanov"}, {"Vasya", "Petrov"}};

    @Test
    public void testMethod() {
        chromeWebDriver.get(START_PAGE);
        loginIn();
        findFlights();
        selectFlight();
        bookFlight();
        checkTicketsInfo();
    }

    private void loginIn() {
        if (!chromeWebDriver.getTitle().equals("Welcome: Mercury Tours")) {
            MatcherAssert.assertThat("Ожидается title: Welcome: Mercury Tours ; " +
                    "Найдено: " + chromeWebDriver.getTitle(), false);
        }
        HomePage homePage = new HomePage(chromeWebDriver);
        homePage.login(LOGIN, PASSWORD);
    }

    private void findFlights() {
        if (!chromeWebDriver.getTitle().equals("Find a Flight: Mercury Tours:")) {
            MatcherAssert.assertThat("Ожидается title: Find a Flight: Mercury Tours: ; " +
                    "Найдено: " + chromeWebDriver.getTitle(), false);
        }
        FlightFinderPage flightFinderPage = new FlightFinderPage(chromeWebDriver);
        flightFinderPage.findFlights();
    }

    private void selectFlight() {
        if (!chromeWebDriver.getTitle().equals("Select a Flight: Mercury Tours")) {
            MatcherAssert.assertThat("Ожидается title: Select a Flight: Mercury Tours ; " +
                    "Найдено: " + chromeWebDriver.getTitle(), false);
        }
        FlightSelectPage flightSelectPage = new FlightSelectPage(chromeWebDriver);
        flightSelectPage.waitClickable(flightSelectPage.outFlightRadioButton);
        flightSelectPage.selectFlight();
    }

    private void bookFlight() {
        if (!chromeWebDriver.getTitle().equals("Book a Flight: Mercury Tours")) {
            MatcherAssert.assertThat("Ожидается title: Book a Flight: Mercury Tours ; " +
                    "Найдено: " + chromeWebDriver.getTitle(), false);
        }
        FlightBookPage flightBookPage = new FlightBookPage(chromeWebDriver);
        flightBookPage.waitClickable(flightBookPage.buyFlightsButton);
        flightBookPage.setNamePassengers(2, NAME_PASSENGERS);

        flightBookPage.visaSelectOption.click();
        flightBookPage.creditNumber.sendKeys("753287463287");
        flightBookPage.getElementMonthCreditField(3).click();
        flightBookPage.getElementYearCreditField(2005).click();
        flightBookPage.firstNameCreditCardField.sendKeys(NAME_PASSENGERS[0][0]);
        flightBookPage.middleNameCreditCardField.sendKeys("-");
        flightBookPage.lastNameCreditCardField.sendKeys(NAME_PASSENGERS[0][1]);

        flightBookPage.UzbekistanBillCountry.click();
        flightBookPage.billAddressField.clear();
        flightBookPage.billCityField.clear();
        flightBookPage.billStateField.clear();
        flightBookPage.billZipField.clear();
        flightBookPage.billAddressField.sendKeys("40, Bobura");
        flightBookPage.billCityField.sendKeys("Tashkent");
        flightBookPage.billZipField.sendKeys("100135");

        flightBookPage.UzbekistanDelCountry.click();
        chromeWebDriver.switchTo().alert().accept();
        flightBookPage.delAddressField.clear();
        flightBookPage.delCityField.clear();
        flightBookPage.delStateField.clear();
        flightBookPage.delZipField.clear();
        flightBookPage.delAddressField.sendKeys("40, Bobura");
        flightBookPage.delCityField.sendKeys("Tashkent");
        flightBookPage.delZipField.sendKeys("100135");
        flightBookPage.buyFlightsButton.click();
    }

    private void checkTicketsInfo() {
        if (!chromeWebDriver.getTitle().equals("Flight Confirmation: Mercury Tours")) {
            MatcherAssert.assertThat("Ожидается title: Flight Confirmation: Mercury Tours ; " +
                    "Найдено: " + chromeWebDriver.getTitle(), false);
        }
        TicketsPage ticketsPage = new TicketsPage(chromeWebDriver);
        ticketsPage.waitDisplayed(ticketsPage.departing);

        String departing = ticketsPage.departing.getText();
        String departingExpected = "Sydney to Acapulco \n" +
                "7/7/2019 @ 7:10 w/ Blue Skies Airlines 361 \n" +
                "Business\n" +
                "$271 each";
        String startCityTo =  "Sydney";
        String finalCityTo =  "Acapulco";
        String airLines = "Blue Skies Airlines";
        String priceTo = "271";
        if (!(departing.contains(startCityTo) && departing.contains(finalCityTo)
                && departing.contains(airLines) && departing.contains(priceTo))) {
            MatcherAssert.assertThat("Билет в место назначения не совпал с ожидаемым.\n" +
                    "Ожидается: " + departingExpected +
                    "\nВстречено: " + departing, false);
        }

        String returning = ticketsPage.returning.getText();
        String returningExpected = "Acapulco to Sydney \n" +
                "4/27/2019 @ 12:23 w/ Blue Skies Airlines 630 \n" +
                "Business\n" +
                "$270 each";
        String startCityOut =  "Acapulco";
        String finalCityOut =  "Sydney";
        String priceOut = "270";
        if (!(returning.contains(startCityOut) && returning.contains(finalCityOut)
                && returning.contains(airLines) && returning.contains(priceOut))) {
            MatcherAssert.assertThat("Обратный билет не совпал с ожидаемым.\n" +
                    "Ожидается: " + returningExpected +
                    "\nВстречено: " + returning, false);
        }

        String passengers = ticketsPage.passengers.getText();
        String passengersExpected = "2 passengers";
        if (!passengers.equals(passengersExpected)) {
            MatcherAssert.assertThat("Число пассажиров не совпало с ожидаемым.\n" +
                    "Ожидается: " + passengersExpected +
                    "\nВстречено: " + passengers, false);
        }

        String billedTo = ticketsPage.billedToAddress.getText();
        String billedToExpected = "Vova - Ivanov\n" +
                "40, Bobura\n" +
                "\n" +
                "Tashkent, , 100135\n" +
                "AX 0";
        if (!billedTo.equals(billedToExpected)) {
            MatcherAssert.assertThat("Паспортные данные плательщика не совпали с ожидаемыми.\n" +
                    "Ожидается: " + billedToExpected +
                    "\nВстречено: " + billedTo, false);
        }

        String deliveryAddress = ticketsPage.deliveryAddress.getText();
        String deliveryAddressExpected = "40, Bobura\n" +
                "\n" +
                "Tashkent, , 100135";
        if (!deliveryAddress.equals(deliveryAddressExpected)) {
            MatcherAssert.assertThat("Адрес доставки не совпал с ожидаемым.\n" +
                    "Ожидается: " + deliveryAddressExpected +
                    "\nВстречено: " + deliveryAddress, false);
        }

        String totalPrice = ticketsPage.totalPrice.getText();
        String totalPriceExpected = "$1171 USD";
        if (!totalPrice.equals(totalPriceExpected)) {
            MatcherAssert.assertThat("Цена не совпала с ожидаемой.\n" +
                    "Ожидается: " + totalPriceExpected +
                    "\nВстречено: " + totalPrice, false);
        }
    }

}



