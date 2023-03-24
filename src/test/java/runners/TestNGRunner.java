package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Contact_Us.feature",
        glue = {"stepDefinitions"},
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports/report.html"}
        //tags = "@RegressionTest",
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
