package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSAlgoPortalPage;
import pagefactory.HomePage;
import webdriver.DriverFactory;

public class DSAlgoPortalStep {
	
	private WebDriver driver;
	private DSAlgoPortalPage portalPage;
    private HomePage homePage;
	
	@Given("User is on the DS Algo Portal")
	public void user_is_on_the_ds_algo_portal() {
		driver = DriverFactory.getDriver();
		portalPage = new DSAlgoPortalPage(driver); 
	}

	@When("User clicks the Get Started button")
	public void user_clicks_the_get_started_button() {
		homePage = portalPage.doGetStart();
	}

	@Then("User is redirected to home page")
	public void user_is_redirected_to_home_page() {
		String expectedURLContains = "home";
		String actualURL = driver.getCurrentUrl();
		assertTrue(actualURL.contains(expectedURLContains), "User is not redirected to home page");
	}

	@Then("User should see {string} links")
	public void user_should_see_links(String link) {
		assertTrue(homePage.isHomeHeaderLinksDisplayed(link), link+" link is not displayed");
		}
}
