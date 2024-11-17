package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dataproviders.ConfigFileReader;

import static java.util.concurrent.TimeUnit.SECONDS;
import static managers.DriverFactory.getDriver;

public interface Waitable extends Findable {

    default void waitUntilElementIsVisible(By locator) throws Exception {
        WebDriverWait wait = new WebDriverWait(getDriver(), ConfigFileReader.getImplicitlyWait());
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(InvalidArgumentException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    default void waitUntilElementIsClicked(By locator) throws Exception {
        WebDriverWait wait = new WebDriverWait(getDriver(), ConfigFileReader.getImplicitlyWait());
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(webDriver -> webDriver.findElement(locator).isDisplayed());
        getDriver().findElement(locator).click();
    }

    default void waitSeconds(int seconds) {
        try {
            SECONDS.sleep(seconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
