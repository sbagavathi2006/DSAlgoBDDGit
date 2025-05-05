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
import webdriver.DriverFactory;

public class HomeStep {
	
	private WebDriver driver = DriverFactory.getDriver(); 		//get the driver from DriverFactory;
	private DSAlgoPortalPage portalPage = new DSAlgoPortalPage(driver); 		//initialize the page object;
	private HomePage homePage;
	
	@Given("User is in home Page after clicking get started button in DS Algo page")
	public void user_is_in_home_page_after_clicking_get_started_button_in_ds_algo_page() {
		homePage = portalPage.doGetStart();
	}

	@When("User clicks NumpyNinja link")
	public void user_clicks_numpy_ninja_link() {
	   homePage.clickNumpyNinja();
	}

	@Then("Home page is refreshed")
	public void home_page_is_refreshed() {
		assertTrue(homePage.getTitle().contains("NumpyNinja"),"Home page is not refreshed");
	}

	@When("User clicks {string} link")
	public void user_clicks_link(String linkText) {
		homePage.clickHeaderLink(linkText);		
	}

	@Then("User is redirected to the {string} page")
	public void user_is_redirected_to_the_page(String pages) {
		String expectedURLContains = pages;
		String actualURL = driver.getCurrentUrl();
		assertTrue(actualURL.contains(expectedURLContains), "User is not redirected to "+ pages +" page");
	}

	@When("User clicks the Data Structures dropdown")
	public void user_clicks_the_data_structures_dropdown() {
		homePage.clickDataStructuresDropdown();
	}

	@Then("User sees the following options in the dropdown:")
	public void user_sees_the_following_options_in_the_dropdown(DataTable dataTable) {
		List<String> expectedOptions = dataTable.asList();
	    assertTrue(homePage.areDropdownOptionsVisible(expectedOptions), "Not all dropdown options are visible");
	}

	@When("User selects {string} from the drop down")
	public void user_selects_from_the_drop_down(String option) {
		homePage.clickDataStructuresDropdown();
		homePage.selectFromDropdown(option);	
	}

	@Then("User views an alert {string}")
	public void user_views_an_alert_for_the_dropdown(String expectedMsg) {
	    assertTrue(homePage.isLoginErrMsgDisplayed(),"error message is not displayed");
	}

	@When("User clicks Get Started button on {string} flex")
	public void user_clicks_get_started_button_on_flex(String name) {
	  homePage.clickFlexGetStarted(name);
	}
}
