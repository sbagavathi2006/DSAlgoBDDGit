package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;
import utilities.ExcelReader;

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
	private WebDriver driver = DriverFactory.getDriver(); //get the driver from DriverFactory;
	private DSAlgoPortalPage portalPage = new DSAlgoPortalPage(driver); //initialize the page object;
	private HomePage homePage = new HomePage(driver);
	private LoginPage loginPage= new LoginPage(driver);
	private DSOptionsPage landPage;
	Properties prop = new Properties();
	
	private String filePath;
	private String sheetName = "DSAlgoLogin";
	private String unKey;
	private String pwdKey;
	private String expectedMsg;
	

	public LoginStep() {
		 this.prop = new ConfigReader().init_prop(); // Ensures properties file is loaded
		 this.filePath = prop.getProperty("excelTestdataPath");	
		 }
	
	@Given("User is in Login page after clicking signin in home page")
	public void user_is_in_login_page_after_clicking_signin_in_home_page() {
		portalPage.getStartedBtnClick();
		homePage.signInLinkClick();	    
	}

	@When("User clicks Login button for row {int}")
	public void user_clicks_login_button_for_row(Integer rowNum) {
	  Map<String, String> rowData = ExcelReader.getData(sheetName, rowNum, filePath);

			unKey = rowData.get("username");
			pwdKey = rowData.get("password");
			
			loginPage.enterUserName(unKey);
		    loginPage.enterPwd(pwdKey);
		    loginPage.loginBtnClick();			
	}

	@Then("User gets an alert or error message for row {int}")
	public void user_gets_an_alert_or_error_message_for_row(Integer rowNum) {
	    Map<String, String> rowData = ExcelReader.getData(sheetName, rowNum, filePath);

			unKey = rowData.get("username");
			pwdKey = rowData.get("password");
			expectedMsg = rowData.get("messages"); 
			
			boolean actualMsg = false;	
			String errorMessage = "";
			
			if (unKey.isEmpty()) {
		        actualMsg = loginPage.getAlertForEmptyUsernameField();
		        assertTrue(actualMsg, "The Username field is not marked as required!");
		    } else if (pwdKey.isEmpty()){
		        actualMsg = loginPage.getAlertForEmptyPasswordField();
		        assertTrue(actualMsg, "The Password field is not marked as required!");
		    	
		    }else {
		    	errorMessage = loginPage.getErrMsg();
		        assertTrue(errorMessage.equalsIgnoreCase(expectedMsg),
		                "Expected error message '" + expectedMsg + "' but got '" + actualMsg + "'");
		    }
	}

	@Then("User redirected to Data Structure Home Page with message You are logged in")
	public void user_redirected_to_data_structure_home_page_with_message_you_are_logged_in() {
		landPage.getLoginSuccessMsg();
		assertTrue(landPage.getLoginSuccessMsg(), 
	            "User is not redirected to the Login page or login success message is not visible.");
	}

	@When("User clicks on login button with valid credentials")
	public void user_clicks_on_login_button_with_valid_credentials() {
	    loginPage.enterUserName(prop.getProperty("username"));
	    loginPage.enterPwd(prop.getProperty("password"));
	    loginPage.loginBtnClick();
	    landPage = new DSOptionsPage(driver);
	}

	@Then("User can see the logged in user name")
	public void user_can_see_the_logged_in_user_name() {
		String expectedUserName = prop.getProperty("username");
		assertTrue(expectedUserName.equalsIgnoreCase(landPage.loggedInUser()));
	}

	@Then("User can see Sign out link")
	public void user_can_see_sign_out_link() {
		landPage.signoutLinkDisplayed();
	}
}
