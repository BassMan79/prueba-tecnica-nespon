package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Ruta a tus archivos .feature
        glue = "stepdefinitions",  // Ruta a tus clases de definición de pasos
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class RunMainTest {
}