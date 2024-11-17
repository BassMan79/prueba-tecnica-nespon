package stepdefinitions;

import cucumber.TestContext;
import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.*;
import pageobjects.LoginPage;

public class LoginStep {

    private final LoginPage loginPage;

    public LoginStep(TestContext context){
        loginPage = context.getPageObjectManager().getLoginPage();
    }


    @Given("^I log in with (.*) username and (.*) password$")
    public void iLogInWithUsername(String username, String password) throws Exception {
        loginPage.loginWithUsername(username, password);
    }

    @And("I check login is correct")
    public void iCheckLoginIsCorrect() throws Exception {
        Assertions.assertTrue(loginPage.checkUserIsLogged());
    }
}
