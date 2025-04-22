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
		String pageTitle = landPage.getTitle();
		if(pageTitle.equalsIgnoreCase("NumpyNinja")){
		System.out.println("User is on the HomePage after login");
		}else {System.out.println("User is not in the HomePage.");}
//		portalPage.getStartedBtnClick();
//		homePage.signInLinkClick();
//		loginPage.enterUserName();
//	loginPage.enterPwd();
//		loginPage.loginBtnClick();		
	}

	@When("User selects {string} from Data Structures dropdown")
	public void user_selects_from_data_structures_dropdown(String dropdownOptions) throws InterruptedException {
		landPage.selectDropdownOptions();
		Thread.sleep(1000);
		landPage.clickDropdownList(dropdownOptions);
		Thread.sleep(1000);
	}

	@Then("User is redirected to {string} page")
	public void user_is_redirected_to_page(String flexOptions) {
		String expectedURLContains = flexOptions;
		String actualURL = driver.getCurrentUrl();
		assertTrue(actualURL.contains(expectedURLContains), "User is not redirected to the "+flexOptions+" page");	}

	@When("User clicks on Getting Started button in {string} panel")
	public void user_clicks_on_getting_started_button_in_panel(String panel) throws InterruptedException {
		Thread.sleep(1000);
		landPage.clickGettingStartedForPanel(panel);
		Thread.sleep(100);
	}
}
