package testRunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listeners.ITestListenerImpl;

@Listeners(ITestListenerImpl.class)
@CucumberOptions(		//Cucumber Test Runner using TestNG

		plugin = {"pretty","html:target/dsalgo.html","html:target/cucumber-reports/reports.html",
				 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/extent-report.html",// Generates readable and HTML reports
		          "rerun:target/failedrerun.txt",
		          "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"},
		         monochrome=false, // If true, enables colored console output (more readable)
		features = {"src/test/resources/features/DataStructurePageTryEditor.feature"}, // Path to the feature files
 		glue={"stepdefinition","hooks"})// Packages containing step definitions and hooks

public class TestRunner extends AbstractTestNGCucumberTests{	
	@Override
	@DataProvider(parallel = false) // Set to true for parallel scenario execution
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}
