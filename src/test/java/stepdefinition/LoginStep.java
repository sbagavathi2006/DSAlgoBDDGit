package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

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
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	
	@Given("User is in Login page after clicking signin in home page")
	public void user_is_in_login_page_after_clicking_signin_in_home_page() {
		portalPage.getStartedBtnClick();
		homePage.signInLinkClick();	    
	}

	@When("User clicks Login button with {string} and {string}")
	public void user_clicks_login_button_with_and(String string, String string2) {

	}

	@Then("User User gets an alert {string} appears below Password textbox")
	public void user_user_gets_an_alert_appears_below_password_textbox(String string) {
	
	}

	@When("User clicks login button with valid User name {string} and valid password {string}")
	public void user_clicks_login_button_with_valid_user_name_and_valid_password(String string, String string2) {
	    loginPage.enterUserName();
	    loginPage.enterPwd();
	    loginPage.loginBtnClick();
	}

	@Then("User redirected to Data Structure Home Page with message You are logged in")
	public void user_redirected_to_data_structure_home_page_with_message_you_are_logged_in() {
		landPage.getLoginSuccessMsg();
		assertTrue(landPage.getLoginSuccessMsg(), 
	            "User is not redirected to the Login page or login success message is not visible.");
	}

	@When("User clicks on login button with valid credentials")
	public void user_clicks_on_login_button_with_valid_credentials() {
	
	}

	@Then("User can see the logged in user name")
	public void user_can_see_the_logged_in_user_name() {
	  
	}

	@Then("User can see Sign out link")
	public void user_can_see_sign_out_link() {
	
	}
}
