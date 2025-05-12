package testRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listeners.ITestListenerImpl;
import utilities.ConfigReader;

@Listeners(ITestListenerImpl.class)
@CucumberOptions(		//Cucumber Test Runner using TestNG

		plugin = {"pretty","html:target/dsalgo.html","html:target/cucumber-reports/reports.html",
				 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/extent-report.html",// Generates readable and HTML reports
		          "rerun:target/failedrerun.txt",
		          "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"},
		         monochrome=false, // If true, enables colored console output (more readable)
		features = {"src/test/resources/features/TreePageTryEditor.feature"}, // Path to the feature files
 		glue={"stepdefinition","hooks"})// Packages containing step definitions and hooks

public class TestRunner extends AbstractTestNGCucumberTests{	
	String browser;
	@Override
	@DataProvider(parallel = false) // Set to true for parallel scenario execution
	public Object[][] scenarios(){
		return super.scenarios();
	}	
	
	@BeforeClass    //Enable during cross browser testing
	@Parameters("browser")	//Inject browser value from testng-parallel.xml into this method for cross browser execution
	public void defineBrowser(@Optional String browser) throws Throwable {
		this.browser = browser;
		if(browser != null && !browser.equals("param-val-not-found")) {
			ConfigReader.setBrowserType(browser);
		}
	}
}
