package pageobjects;

import helpers.Clickable;
import helpers.Conditionable;
import helpers.Fillable;
import helpers.Waitable;
import org.openqa.selenium.WebDriver;


public class PageBase implements Clickable, Fillable, Waitable, Conditionable {

    protected WebDriver driver;

    protected PageBase(WebDriver webDriver) {
        this.driver = webDriver;
    }

}
