package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    private final By usernameInputXpath = By.xpath("//input[@name='username']");
    private final By passwordInputXpath = By.xpath("//input[@name='password']");
    private final By loginBtnXpath = By.xpath("//button[@type='submit']");
    private final By dashboardTitleXpath = By.xpath("//img[@alt='profile picture']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void loginWithUsername(String username, String password) throws Exception {
        waitUntilElementIsVisible(usernameInputXpath);
        fillElement(username, usernameInputXpath);
        fillElement(password, passwordInputXpath);
        clickOnClickableElement(loginBtnXpath);
    }

    public boolean checkUserIsLogged() throws Exception {
        waitUntilElementIsVisible(dashboardTitleXpath);
        return elementIsVisible(dashboardTitleXpath);
    }
}
