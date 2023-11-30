package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/features/Carrito.feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber"})
public class RunnerCarrito extends AbstractTestNGCucumberTests {

}
