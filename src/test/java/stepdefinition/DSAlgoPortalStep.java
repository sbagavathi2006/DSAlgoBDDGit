package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSAlgoPortalPage;
import webdriver.DriverFactory;

public class DSAlgoPortalStep {
	
	private WebDriver driver;
	private DSAlgoPortalPage portalPage;
	
	@Given("User is on the DS Algo Portal")
	public void user_is_on_the_ds_algo_portal() {
		driver = DriverFactory.getDriver(); //get the driver from DriverFactory
		portalPage = new DSAlgoPortalPage(driver); //initialize the page object
	}

	@When("User clicks the Get Started button")
	public void user_clicks_the_get_started_button() {
		portalPage.getStartedBtnClick();
	}

	@Then("User is redirected to home page")
	public void user_is_redirected_to_home_page() {
		String expectedURLContains = "home";
		String actualURL = driver.getCurrentUrl();
		assertTrue(actualURL.contains(expectedURLContains), "User is not redirected to home page");
	}

	@Then("User should see {string} on the home page")
	public void user_should_see_on_the_home_page(String string) {
		

	}
}
