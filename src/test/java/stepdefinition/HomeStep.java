package stepdefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSAlgoPortalPage;
import pagefactory.HomePage;
import webdriver.DriverFactory;

public class HomeStep {
	
	private WebDriver driver = DriverFactory.getDriver(); //get the driver from DriverFactory;
	private DSAlgoPortalPage portalPage = new DSAlgoPortalPage(driver); //initialize the page object;
	private HomePage homePage = new HomePage(driver);
	
	@Given("User is in home Page after clicking get started button in DS Algo page")
	public void user_is_in_home_page_after_clicking_get_started_button_in_ds_algo_page() {
		portalPage.getStartedBtnClick();
	}

	@When("User clicks NumpyNinja link")
	public void user_clicks_numpy_ninja_link() {
	   
	}

	@Then("Home page is refreshed")
	public void home_page_is_refreshed() {

	}

	@When("User clicks {string} link")
	public void user_clicks_link(String linkText) {
		homePage.clickLink(linkText);
		
	}

	@Then("User is redirected to the {string} page")
	public void user_is_redirected_to_the_page(String string) {
	
	}

	@When("User clicks the Data Structures dropdown")
	public void user_clicks_the_data_structures_dropdown() {
	
	}

	@Then("User sees the following options in the dropdown:")
	public void user_sees_the_following_options_in_the_dropdown(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	}

	@When("User selects {string} from the drop down")
	public void user_selects_from_the_drop_down(String string) {
	
	}

	@Then("User views an alert {string} for the dropdown")
	public void user_views_an_alert_for_the_dropdown(String string) {
	
	}

	@When("User clicks Get Started button on {string} flex")
	public void user_clicks_get_started_button_on_flex(String string) {
	  
	}

	@Then("User views an alert {string} for the flex")
	public void user_views_an_alert_for_the_flex(String string) {
	   
	}
}
