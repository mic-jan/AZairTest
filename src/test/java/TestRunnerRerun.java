import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "@target/cucumber-reports/rerun.txt", //Cucumber picks the failed scenarios from this file
        plugin = {"pretty",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber.json"}
)

public class TestRunnerRerun {
}
