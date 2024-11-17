package stepdefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.*;
import pageobjects.RecruitmentPage;

public class RecruitmentStep {

    private final RecruitmentPage recruitmentPage;

    public RecruitmentStep(TestContext context){
        recruitmentPage = context.getPageObjectManager().getRecruitmentPage();
    }

    @And("I add a new employee")
    public void iLogInWithUsername() throws Exception {
        recruitmentPage.addNewEmployee();
    }
}
