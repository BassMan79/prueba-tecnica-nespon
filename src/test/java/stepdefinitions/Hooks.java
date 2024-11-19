package stepdefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import managers.DriverFactory;

public class Hooks {

    final private WebDriver driver;

    // Inyecto el webDriver
    public Hooks() throws Exception {
        this.driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Escenario finalizado. Navegador cerrado.");
        }
    }
}
