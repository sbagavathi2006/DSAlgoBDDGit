package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Cucumber Test Runner using TestNG
@CucumberOptions(
		plugin = {"pretty","html:target/dsalgo.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, // Generates readable and HTML reports
		monochrome=false, // If true, enables colored console output (more readable)
//		tags = "@DSAlgoPortal or @Home or @Login",//Filter which tagged scenarios to run
//		tags = "@DSAlgoPortal or @Home or @Login or @DSOptions",
		features = {"src/test/resources/features/DSAlgoPortal.feature",
				"src/test/resources/features/Home.feature",
		        "src/test/resources/features/Login.feature",
		        "src/test/resources/features/DSOptions.feature"}, // Path to the feature files
//		features = {"src/test/resources/features/"}, // Path to the feature files

		glue={"stepdefinition","hooks"})// Packages containing step definitions and hooks

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = false) // Set to true for parallel scenario execution
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}
