package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features/SpaceBeyond.feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber"},
        publish = true)
public class RunnerSpaceBeyond extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
