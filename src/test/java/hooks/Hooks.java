package hooks;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import pagefactory.DSAlgoPortalPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class Hooks {

	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	private DriverFactory driverFactory;
	
	private List<Map<String, String>> testData;
	private static final String sheetName = "DSAlgoLogin";
	
	@Before(order =0)	//Execute first
	public void getProperty() { 	//reads configuration values browser, URL from the config.properties file using the ConfigReader utility.
		LoggerLoad.info("Loading configuration properties and test data");
		configReader=new ConfigReader();
		prop =configReader.init_prop();// Load properties into prop
		String filePath = prop.getProperty("excelTestdataPath");	
		ExcelReader reader = new ExcelReader(filePath);
		testData = reader.getDataAll(sheetName);
		LoggerLoad.info("Configuration and test data loaded successfully.");
	}
	 
	@Before(order =1)	//Execute second
	public void launchbrowser() throws Throwable{ 	//Launch browser and open the base URL which are fetched from the loaded properties
		String browsername = ConfigReader.getBrowserType(); 
		if (browsername == null || browsername.isEmpty()) {
			browsername=prop.getProperty("browser"); 
		}
		LoggerLoad.info("browser loaded for setbrowser: "+browsername);
		String urlname=prop.getProperty("url");
		driverFactory = new DriverFactory();  	// Initialize the driver factory
		driver = driverFactory.init_driver(browsername); 	// Launch the browser
		DriverFactory.getDriver().get(urlname); 	// Navigate to the base URL
		LoggerLoad.info("Navigated to URL: " + urlname);
	}
	
	@Before("@afterSignIn")
	public void loginBeforeAfterSignInScenarios() {
		LoggerLoad.info("Preparing to log in @afterSignIn scenario");
	    driver = DriverFactory.getDriver();
	    DSAlgoPortalPage portalPage = new DSAlgoPortalPage(driver);
	    HomePage homePage = new HomePage(driver);
	    LoginPage loginPage = new LoginPage(driver);
	    
	    String usernameTestData = null;
		String passwordTestData = null;
		
		for( Map<String, String> row : testData) {
			
			if(row.get("validation").contains("ValidCredential")){
				usernameTestData = row.get("username");
				passwordTestData = row.get("password");
				break;
			}
			
			break;
		}

	    portalPage.getStartedBtnClick();
	    homePage.signInLinkClick();
	    loginPage.enterUserName(usernameTestData);
	    loginPage.enterPwd(passwordTestData);
	    LoggerLoad.info("User Name is : " + usernameTestData);
	    LoggerLoad.info("User Name is : " + passwordTestData);
	    loginPage.loginBtnClick();	   
	    LoggerLoad.info("Login button clicked");
	}
	
	@After(order=1) 	//execute before closing the browser
	public void tearDown(Scenario scenario){ 	//Take a screenshot automatically if a scenario fails
		if(scenario.isFailed()) {
			LoggerLoad.error("Scenario failed: " + scenario.getName() + " — capturing screenshot.");
			String screenshotName = scenario.getName().replaceAll("", "_");
			byte [] sourcePath=((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES); 
			scenario.attach(sourcePath, "image/png", screenshotName);
			LoggerLoad.info("Screenshot attached to scenario: " + screenshotName);
			Allure.addAttachment("failedScreenshot", new ByteArrayInputStream(sourcePath));
		}
	}
	
	@After(order =0) 	// execute last
	public static void quitBrowser() { 	//Quits the browser and removes the thread-local WebDriver instance
		 if (DriverFactory.getDriver() != null) {
		        DriverFactory.getDriver().quit(); 	// Close the browser
		        DriverFactory.tlDriver.remove(); 	// Clean up ThreadLocal driver
				LoggerLoad.info("Browser closed and WebDriver instance removed.");
		    }
    }

}
