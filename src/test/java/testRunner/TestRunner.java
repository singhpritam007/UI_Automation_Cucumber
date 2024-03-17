package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue="steps",
				features="src/test/resources/Features",
				plugin = {"pretty", "html:target/cucumber-reports"}
				)
public class TestRunner {

}
