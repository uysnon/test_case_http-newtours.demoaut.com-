package logger;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        System.out.println("beforeAlertAccept");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("afterAlertAccept");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("afterAlertDismiss");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("beforeAlertDismiss");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("BeforeNavigateTo " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("afterNavigate to " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("beforeNavigateBack");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("afterNavigateBack");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("beforeNavigateForward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("afterNavigateForward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("beforeNavigateRefresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("afterNavigateRefresh");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("beforeFindBy; by: " + by.toString() + " element: " + webElement);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("afterFindBy; by: " + by.toString() + " element: " + webElement);
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("beforeClickOn " + webElement.toString());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("afterClickOn " + webElement.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("beforeChangeValueOf; element: " + webElement.toString() + " value: " +
                charSequences);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("afterChangeValueOf; element: " + webElement.toString() + " value: " +
                charSequences);
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        System.out.println("beforeScript " + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        System.out.println("afterScript " + s);
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("beforeSwitchToWindow");
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("afterSwitchToWindow " + s);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("onException: " + throwable.toString());
    }
}