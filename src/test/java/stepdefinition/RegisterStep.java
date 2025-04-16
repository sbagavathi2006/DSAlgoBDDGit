package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStep {
	
	@Given("User is in Register page after clicking register in home page")
	public void user_is_in_register_page_after_clicking_register_in_home_page() {
	    
	}

	@When("the user clicks the {string} link on the Home page")
	public void the_user_clicks_the_link_on_the_home_page(String string) {
	    	}

	@Then("the user should be redirected to the Register form")
	public void the_user_should_be_redirected_to_the_register_form() {
	    	}

	@Given("the user is on the user registration page")
	public void the_user_is_on_the_user_registration_page() {
	    
	}

	@When("the user clicks the Register button with all fields empty")
	public void the_user_clicks_the_register_button_with_all_fields_empty() {
	    	}

	@Then("the error message {string} appears below the Username textbox")
	public void the_error_message_appears_below_the_username_textbox(String string) {
	    
	}

	@When("the user enters a Username but leaves the Password field empty and clicks the Register button")
	public void the_user_enters_a_username_but_leaves_the_password_field_empty_and_clicks_the_register_button() {
	    
	}

	@Then("the error message {string} appears below the Password textbox")
	public void the_error_message_appears_below_the_password_textbox(String string) {
	    
	}

	@When("the user enters different values in the Password and Confirm Password fields and clicks the Register button")
	public void the_user_enters_different_values_in_the_password_and_confirm_password_fields_and_clicks_the_register_button() {
	    
	}

	@Then("User should see the error message {string} is displayed")
	public void user_should_see_the_error_message_is_displayed(String string) {
	    
	}

	@When("the user enters a password value with numeric data only and clicks the Register button")
	public void the_user_enters_a_password_value_with_numeric_data_only_and_clicks_the_register_button() {
	    	}

	@Then("the error message {string} is displayed")
	public void the_error_message_is_displayed(String string) {
	   
	}

	@When("the user enters a password with less than {int} characters and clicks the Register button")
	public void the_user_enters_a_password_with_less_than_characters_and_clicks_the_register_button(Integer int1) {
	    
	}

	@When("user clicks the Register button after entering a username {string}")
	public void user_clicks_the_register_button_after_entering_a_username(String string) {
	    
	}

	@Then("user should see an error message indicating that the username {string}")
	public void user_should_see_an_error_message_indicating_that_the_username(String string) {
	    
	}

	@When("user clicks Register button after entering  with valid username, password and password confirmation in related textboxes")
	public void user_clicks_register_button_after_entering_with_valid_username_password_and_password_confirmation_in_related_textboxes() {
	    
	}

	@Then("user should be redirected to Home Page of DS Algo with message New Account Created You are logged in as username Data Structures")
	public void user_should_be_redirected_to_home_page_of_ds_algo_with_message_new_account_created_you_are_logged_in_as_username_data_structures() {
	   
	}

	@When("the user clicks the {string} link on the Register page")
	public void the_user_clicks_the_link_on_the_register_page(String string) {
	    
	}

	@Then("the user should be navigated to the {string} page")
	public void the_user_should_be_navigated_to_the_page(String string) {
	    	}




	
	
}