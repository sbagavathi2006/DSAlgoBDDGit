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

public class DSOptionsStep {
	
	private WebDriver driver = DriverFactory.getDriver(); //get the driver from DriverFactory;
	private DSAlgoPortalPage portalPage = new DSAlgoPortalPage(driver); //initialize the page object;
	private HomePage homePage = new HomePage(driver);
	private LoginPage loginPage= new LoginPage(driver);
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	
	@Given("User is on the home page")	
	public void user_is_on_the_home_page() {
		portalPage.getStartedBtnClick();
		homePage.signInLinkClick();
		loginPage.enterUserName();
		loginPage.enterPwd();
		loginPage.loginBtnClick();		
	}

	@When("User selects {string} from Data Structures dropdown")
	public void user_selects_from_data_structures_dropdown(String string) {

	}

	@Then("User is redirected to {string} page")
	public void user_is_redirected_to_page(String panel) {
		String expectedURLContains = panel;
		String actualURL = driver.getCurrentUrl();
		assertTrue(actualURL.contains(expectedURLContains), "User is not redirected to home page");	}

	@When("User clicks on Getting Started button in {string} panel")
	public void user_clicks_on_getting_started_button_in_panel(String panel) {
		landPage.clickGettingStartedForPanel(panel);
	}
}
