package runners;

import static org.junit.Assert.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import org.junit.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/signup.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)

public class TestRunner {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
