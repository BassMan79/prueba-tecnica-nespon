package helpers;

import managers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Findable {

    default WebElement findElement(By locator) throws Exception {
        return DriverFactory.getDriver().findElement(locator);  // Llamada a DriverFactory
    }
}
