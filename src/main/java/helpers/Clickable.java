package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static managers.DriverFactory.getDriver;

public interface Clickable extends Findable {

    default void clickOnClickableElement(By locator) throws Exception {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", findElement(locator));
    }
}
