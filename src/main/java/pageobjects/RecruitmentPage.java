package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RecruitmentPage extends PageBase{

    Actions actions = new Actions(driver);

    private final By recruitmentSideBarXpath = By.xpath("(//a[contains(@class, 'oxd-main-menu-item')])[5]");

    private final By succesButtonXpath = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--success']");
    private final By buttonAddXpath = By.xpath("//button[text() = ' Add ']");
    private final By buttonSaveXpath = By.xpath("//button[text() = ' Save ']");
    private final By buttonShortlistXpath = By.xpath("//button[text() = ' Shortlist ']");
    private final By firstNameInputXpath = By.xpath("//input[@name='firstName']");
    private final By middleNameInputXpath = By.xpath("//input[@name='middleName']");
    private final By lastNameInputXpath = By.xpath("//input[@name='lastName']");
    private final By focusInputXpath = By.xpath("//input[@class='oxd-input oxd-input--focus']");
    private final By genericCheckboxXpath = By.xpath("//input[@type='checkbox']");
    private final By genericTextareaXpath = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    public RecruitmentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addNewEmployee() throws Exception {
        waitUntilElementIsVisible(recruitmentSideBarXpath);
        clickOnClickableElement(recruitmentSideBarXpath);
        waitUntilElementIsVisible(buttonAddXpath);
        clickOnClickableElement(buttonAddXpath);
        fillEmployeeForm();
        shortlistCandidate();
    }

    public void fillEmployeeForm() throws Exception {
        waitUntilElementIsVisible(firstNameInputXpath);
        fillElement("John", firstNameInputXpath);
        fillElement("Doe", middleNameInputXpath);
        fillElement("Test", lastNameInputXpath);

        //Utilizamos teclas para operar en el select
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        fillElement("fakemail@example.com", focusInputXpath);
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        fillElement("45665621", focusInputXpath);

        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

        fillElement("QA, Automation", focusInputXpath);
        clickOnClickableElement(genericCheckboxXpath);
        clickOnClickableElement(buttonSaveXpath);
    }

    public void shortlistCandidate() throws Exception {
        waitUntilElementIsClicked(succesButtonXpath);
        waitUntilElementIsVisible(genericTextareaXpath);
        fillElement("Lorem ipsum dolor sit amet", genericTextareaXpath);
        waitUntilElementIsClicked(buttonSaveXpath);
    }

}
