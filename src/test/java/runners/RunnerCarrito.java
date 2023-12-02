package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features/Carrito.feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber"},
        publish = true)
public class RunnerCarrito extends AbstractTestNGCucumberTests {

}
