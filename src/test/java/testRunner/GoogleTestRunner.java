package testRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/GoogleSearch.feature",
		glue=".",
		dryRun=true,
		monochrome=true,
		strict=true,
		plugin= {"pretty", "html:test-output","json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter: target/report.html"}
		)
public class GoogleTestRunner {

}
