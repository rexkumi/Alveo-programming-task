import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/resources/features"},
        glue="stepDefinitions",
        plugin={"pretty",
                "html:TargetReport/cucumber-html-report",
                "json:TargetReport/cucumber.json",
                "junit:TargetReport/cucumber.xml",
                "rerun:TargetReport/rerun.txt" }
        //tags = {}
)

public class RunnerClassTest {
}
