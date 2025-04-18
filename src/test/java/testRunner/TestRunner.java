package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Cucumber Test Runner using TestNG
@CucumberOptions(
		plugin = {"pretty","html:target/dsalgo.html"}, // Generates readable and HTML reports
		monochrome=false, // If true, enables colored console output (more readable)
//		tags = "@DSAlgoPortal or @Home or @Login",//Filter which tagged scenarios to run
		tags = "@Run",
		features = {"src/test/resources/features/DSOptions.feature"}, // Path to the feature files
		glue={"stepdefinition","hooks"})// Packages containing step definitions and hooks

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = false) // Set to true for parallel scenario execution
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}
