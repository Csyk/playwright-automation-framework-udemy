package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "step_definitions",
        tags = "@contact-us and not @ignore",
        plugin = {"pretty", "json:target/cucumber.json"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
