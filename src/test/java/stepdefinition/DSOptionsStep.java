package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSOptionsStep {
	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
	
	}

	@When("User selects {string} from Data Structures dropdown")
	public void user_selects_from_data_structures_dropdown(String string) {

	}

	@Then("User is redirected to {string} page")
	public void user_is_redirected_to_page(String string) {

	}

	@When("User clicks on Getting Started button in {string} panel")
	public void user_clicks_on_getting_started_button_in_panel(String string) {

	}
}
