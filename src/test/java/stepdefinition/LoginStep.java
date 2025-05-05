package stepdefinition;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;
import utilities.ExcelReader;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSAlgoPortalPage;
import pagefactory.DSOptionsPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import webdriver.DriverFactory;

public class LoginStep {
	private WebDriver driver = DriverFactory.getDriver(); 		//get the driver from DriverFactory;
	private DSAlgoPortalPage portalPage = new DSAlgoPortalPage(driver); 		//initialize the page object;
	private HomePage homePage = new HomePage(driver);
	private LoginPage loginPage= new LoginPage(driver);
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	Properties prop = new Properties();
	
	private List<Map<String, String>> testData;
	private static final String sheetName = "DSAlgoLogin";

	public LoginStep() {
		 this.prop = new ConfigReader().init_prop(); 	// Ensures properties file is loaded
		 String filePath = prop.getProperty("excelTestdataPath");	
		 ExcelReader reader = new ExcelReader(filePath);
		 testData = reader.getDataAll(sheetName);
		 }
	
	@Given("User is in Login page after clicking signin in home page")
	public void user_is_in_login_page_after_clicking_signin_in_home_page() {
		portalPage.getStartedBtnClick();
		homePage.signInLinkClick();	    
	}

	@When("User clicks Login button with username and password for validation {string}")
	public void user_clicks_login_button_with_username_and_password_for_validation(String validation) {
		String usernameTestData = null;		
		String passwordTestData = null;
		
		for( Map<String, String> row : testData) {
			String validationTestData = row.get("validation");
		
			if(validation.equalsIgnoreCase(validationTestData)) {
				usernameTestData = row.get("username");
				passwordTestData = row.get("password");
				break;
			}			
		}
		
		if(usernameTestData != null || passwordTestData != null) {
			loginPage.enterUserName(usernameTestData);
		    loginPage.enterPwd(passwordTestData);
		    loginPage.loginBtnClick();
		}
	}

	@Then("User gets corresponding messages for validation {string}")
	public void user_gets_corresponding_messages_for_validation(String validation) {		
		String messageTestData = null;//Null Pointer exception
		String usernameTestData = null;
		String passwordTestData = null;
		
		for( Map<String, String> row : testData) {
			String validationTestData = row.get("validation");
		
			if(validation.equalsIgnoreCase(validationTestData)) {
				messageTestData = row.get("message");
				usernameTestData = row.get("username");
				passwordTestData = row.get("password");
				System.out.println(messageTestData);
				break;
			}
		}
		
		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.contains("home")) {
			
		    // User is on the home page — successful login
		    
			String successMessage = landPage.getLoginSuccessMsg();
		    assertTrue(successMessage.equalsIgnoreCase(messageTestData),
		        "Expected success message '" + messageTestData + "' but got '" + successMessage + "'");
		} else if (usernameTestData.isEmpty()) {
			
		    // Login failed due to empty user name

			String alertMessage = loginPage.getEmptyUserNameAlertMsg();
		     assertTrue(alertMessage.contains(messageTestData), "Expected success message '" + messageTestData + "' but got '" + alertMessage + "'");
		} else if (passwordTestData.isEmpty()) {
		    
			// Login failed due to empty password

			String alertMessage = loginPage.getEmptyPasswordAlertMsg();
			System.out.println( "Empty password field alert: " +alertMessage);
		     assertTrue(alertMessage.contains(messageTestData), "Expected success message '" + messageTestData + "' but got '" + alertMessage + "'");
	    } else if (currentUrl.contains("login")) {
		    
	    	// Login failed due to invalid user name and password
		    
	    	String errorMessage = loginPage.getErrMsg();
		    assertTrue(errorMessage.equalsIgnoreCase(messageTestData),
		    "Expected error message '" + messageTestData + "' but got '" + errorMessage + "'");
		} else {
		        fail("No error, alert, or success message found.");
		}
	}

	@When("User clicks on login button with valid credentials {string}")
	public void user_clicks_on_login_button_with_valid_credentials(String validation) {
		
		String usernameTestData = null;
		String passwordTestData = null;
		
		for( Map<String, String> row : testData) {
			String validationTestData = row.get("validation");
		
			if(validation.equalsIgnoreCase(validationTestData)) {
				usernameTestData = row.get("username");
				passwordTestData = row.get("password");
				break;
			}
			break;
		}
		
	    loginPage.enterUserName(usernameTestData);
	    loginPage.enterPwd(passwordTestData);
	    loginPage.loginBtnClick();
	    landPage = new DSOptionsPage(driver);
	}

	@Then("User can see the logged in user name for valid credentials {string}")
	public void user_can_see_the_logged_in_user_name(String validation) {
		String usernameTestData = null;
		
		for( Map<String, String> row : testData) {
			String validationTestData = row.get("validation");
		
			if(validation.equalsIgnoreCase(validationTestData)) {
				usernameTestData = row.get("username");
				break;
			}
			break;
		}
		
		String expectedUserName = usernameTestData.substring(0, 1).toUpperCase() + usernameTestData.substring(1);
		String actualUserName = landPage.loggedInUser(expectedUserName);

		assertTrue(actualUserName.equalsIgnoreCase(expectedUserName));
	}

	@Then("User can see Sign out link")
	public void user_can_see_sign_out_link() {
		landPage.signoutLinkDisplayed();
	}
}
