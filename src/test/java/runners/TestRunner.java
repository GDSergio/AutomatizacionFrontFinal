package runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions (
        features = "src/test/resources/features/google_search.feature"
        ,glue = {"stepdefinitions"}
        ,monochrome=true
        ,tags = "@readDataOfDB"
        ,plugin= {"pretty", "json:target/JSONReports/report.json"}
)
public class TestRunner {

}



