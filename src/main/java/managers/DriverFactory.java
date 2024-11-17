package managers;

import dataproviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() throws Exception {
        if (driver == null) {
            // Configuración automática del WebDriver para Chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(ConfigFileReader.getApplicationUrl());
            driver.manage().window().maximize();
        }
        return driver;
    }


}
