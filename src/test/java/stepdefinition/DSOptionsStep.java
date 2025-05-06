package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class DSOptionsStep {
	
	private WebDriver driver = DriverFactory.getDriver(); 		//get the driver from DriverFactory;
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	
	@Given("User is on the home page")	
	public void user_is_on_the_home_page() {
		String pageTitle = landPage.getTitle();
		LoggerLoad.info("Validating user is on the home page"+ pageTitle);
		if(pageTitle.equalsIgnoreCase("NumpyNinja")){
		LoggerLoad.info("User is on the home page after login");
		}else {LoggerLoad.error("User is not in the HomePage.");
		}	
	}

	@When("User selects {string} from Data Structures dropdown")
	public void user_selects_from_data_structures_dropdown(String dropdownOptions) {
		landPage.selectDropdownOptions();
		LoggerLoad.info("Selecting option from dropdown: " + dropdownOptions);
		landPage.clickDropdownList(dropdownOptions);
	}

	@Then("User is redirected to {string} page")
	public void user_is_redirected_to_page(String flexOptions) {
		String actualURL = driver.getCurrentUrl();
		boolean result = actualURL.contains(flexOptions);
		if(!result) {
			LoggerLoad.error("Redirection failed. Expected to contain: " + flexOptions);
		}
		assertTrue(result, "User is not redirected to the "+flexOptions+" page");	}

	@When("User clicks on Getting Started button in {string} panel")
	public void user_clicks_on_getting_started_button_in_panel(String panel) {
		LoggerLoad.info("Clicking on 'Getting Started' button in the " + panel + " panel.");
		landPage.clickGettingStartedForPanel(panel);
	}
}
