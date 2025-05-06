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
		          "rerun:target/failedrerun.txt" },
		         monochrome=false, // If true, enables colored console output (more readable)
//		tags = "@DSAlgoPortal",//Filter which tagged scenarios to run
//		features = {"src/test/resources/features/DSAlgoPortal.feature",
//					"src/test/resources/features/Home.feature",
//					"src/test/resources/features/Login.feature",
//					"src/test/resources/features/DSOptions.feature",
//					"src/test/resources/features/Array.feature",
//					"src/test/resources/features/ArrayPageTryEditor.feature",
//					"src/test/resources/features/ArrayPracticeQns.feature",
//					"src/test/resources/features/Graph.feature",
//					"src/test/resources/features/GraphPageTryEditor.feature",
//					"src/test/resources/features/Tree.feature",
//					"src/test/resources/features/TreePageTryEditor.feature",
//         			"src/test/resources/features/Logout.feature"}, // Path to the feature files
		features = {"src/test/resources/features/Register.feature"}, // Path to the feature files
 		glue={"stepdefinition","hooks"})// Packages containing step definitions and hooks

public class TestRunner extends AbstractTestNGCucumberTests{	
	@Override
	@DataProvider(parallel = false) // Set to true for parallel scenario execution
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}
