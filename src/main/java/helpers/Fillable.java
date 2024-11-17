package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface Fillable extends Waitable {

    default void fillElement(String value, By locator) throws Exception {
        if (!value.isEmpty()) {
            WebElement element = findElement(locator);
            element.clear();
            element.sendKeys(value);
        }
    }

    default void fillSelectFieldByVisibleText(String fieldValue, By locator) throws Exception {
        if (!fieldValue.isEmpty()) {
            Select element = new Select(findElement(locator));
            element.selectByVisibleText(fieldValue);
        }
    }
}
