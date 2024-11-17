package managers;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import pageobjects.RecruitmentPage;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPage loginPage;

    private RecruitmentPage recruitmentPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public RecruitmentPage getRecruitmentPage() {
        if (recruitmentPage == null) {
            recruitmentPage = new RecruitmentPage(driver);
        }
        return recruitmentPage;
    }
}
