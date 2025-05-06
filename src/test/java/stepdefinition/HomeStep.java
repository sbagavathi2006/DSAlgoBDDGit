package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSAlgoPortalPage;
import pagefactory.HomePage;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class HomeStep {
	
	private WebDriver driver = DriverFactory.getDriver(); 		//get the driver from DriverFactory;
	private DSAlgoPortalPage portalPage = new DSAlgoPortalPage(driver); 		//initialize the page object;
	private HomePage homePage;
	
	@Given("User is in home Page after clicking get started button in DS Algo page")
	public void user_is_in_home_page_after_clicking_get_started_button_in_ds_algo_page() {
		LoggerLoad.info("User in on home page via clicking get started button from DSAlgo");
		homePage = portalPage.doGetStart();
	}

	@When("User clicks NumpyNinja link")
	public void user_clicks_numpy_ninja_link() {
		LoggerLoad.info("Clicking NumpyNinja link on Home Page");
	   homePage.clickNumpyNinja();
	}

	@Then("Home page is refreshed")
	public void home_page_is_refreshed() {
		LoggerLoad.info("Validating Home page is refreshed");
		boolean result = homePage.getTitle().contains("NumpyNinja");
		if(!result) {
			LoggerLoad.error("Home page is not refreshed correctly");
		}
		assertTrue(result,"Home page is not refreshed");
	}

	@When("User clicks {string} link")
	public void user_clicks_link(String linkText) {
		LoggerLoad.info("Clicking header link: " + linkText);
		homePage.clickHeaderLink(linkText);		
	}

	@Then("User is redirected to the {string} page")
	public void user_is_redirected_to_the_page(String pages) {
		String actualURL = driver.getCurrentUrl();
		LoggerLoad.info("Validating redirection to: " + pages + " page. Current URL: " + actualURL);
		if(!actualURL.contains(pages)) {
			LoggerLoad.error("Redirection failed: Expected page: " + pages + " but URL is: " + actualURL);
		}
		assertTrue(actualURL.contains(pages), "User is not redirected to "+ pages +" page");
	}

	@When("User clicks the Data Structures dropdown")
	public void user_clicks_the_data_structures_dropdown() {
		LoggerLoad.info("Clicking the Data Structures dropdown");
		homePage.clickDataStructuresDropdown();
	}

	@Then("User sees the following options in the dropdown:")
	public void user_sees_the_following_options_in_the_dropdown(DataTable dataTable) {
		List<String> expectedOptions = dataTable.asList();
		LoggerLoad.info("Validating dropdown options: " + expectedOptions);
		boolean result = homePage.areDropdownOptionsVisible(expectedOptions);
		if(!result) {
			LoggerLoad.error("One or more dropdown options are not visible: " + expectedOptions);
		}
	    assertTrue(result, "Not all dropdown options are visible");
	}

	@When("User selects {string} from the drop down")
	public void user_selects_from_the_drop_down(String option) {
		homePage.clickDataStructuresDropdown();
		LoggerLoad.info("Selecting option '" + option + "' from dropdown");
		homePage.selectFromDropdown(option);	
	}

	@Then("User views an alert {string}")
	public void user_views_an_alert_for_the_dropdown(String expectedMsg) {
		LoggerLoad.info("Validating alert with expected message: " + expectedMsg);
		boolean result = homePage.isLoginErrMsgDisplayed();
		if (!result) {
			LoggerLoad.error("Expected alert message not displayed: " + expectedMsg);
		}
		assertTrue(result, "error message is not displayed");	}

	@When("User clicks Get Started button on {string} flex")
	public void user_clicks_get_started_button_on_flex(String name) {
		LoggerLoad.info("Clicking Get Started on flex: " + name);
	  homePage.clickFlexGetStarted(name);
	}
}
