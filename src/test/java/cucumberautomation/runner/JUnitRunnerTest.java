package cucumberautomation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"cucumberautomation"},
        features = "src/test/resources/cucumberautomation"
)
public class JUnitRunnerTest {
}
