package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Login.feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber"})
public class RunnerLogin extends AbstractTestNGCucumberTests {

}
