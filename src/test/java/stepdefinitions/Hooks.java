package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import managers.DriverFactory;

public class Hooks {

    final private WebDriver driver;

    // Inyecto el webDriver
    public Hooks() throws Exception {
        this.driver = DriverFactory.getDriver();
    }

    @After
    public void attachScreenshotOnFailure(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            saveScreenshot();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] saveScreenshot() throws Exception {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Escenario finalizado. Navegador cerrado.");
        }
    }
}
