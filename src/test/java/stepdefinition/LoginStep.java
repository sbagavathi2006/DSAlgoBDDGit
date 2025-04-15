package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	
	@Given("User is in Login page after clicking signin in home page")
	public void user_is_in_login_page_after_clicking_signin_in_home_page() {
	    
	}

	@When("User clicks Login button with {string} and {string}")
	public void user_clicks_login_button_with_and(String string, String string2) {

	}

	@Then("User User gets an alert {string} appears below Password textbox")
	public void user_user_gets_an_alert_appears_below_password_textbox(String string) {
	
	}

	@When("User clicks login button with valid User name {string} and valid password {string}")
	public void user_clicks_login_button_with_valid_user_name_and_valid_password(String string, String string2) {
	    
	}

	@Then("User redirected to Data Structure Home Page with message You are logged in")
	public void user_redirected_to_data_structure_home_page_with_message_you_are_logged_in() {
	 
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
