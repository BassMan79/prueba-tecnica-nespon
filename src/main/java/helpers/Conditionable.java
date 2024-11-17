package helpers;

import org.openqa.selenium.By;

public interface Conditionable extends Waitable {

    default boolean elementIsVisible(By locator) throws Exception {
        return findElement(locator).isDisplayed();
    }
}
