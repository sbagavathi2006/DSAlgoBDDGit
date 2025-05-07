package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.ArrayPage;
import pagefactory.DSOptionsPage;
import webdriver.DriverFactory;

public class ArrayStep {
	private WebDriver driver = DriverFactory.getDriver();
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private ArrayPage arrayPage;
	
	@Given("User is on array page after clicks on Get Started button on Array flex")
	public void user_is_on_array_page_after_clicks_on_get_started_button_on_array_flex() {
		arrayPage = landPage.arrayGetStartBtnClick();
	}

	@When("User clicks on {string} array links")
	public void user_clicks_on_array_links(String links) {
		arrayPage.clickArrayPageLinks(links);
	}

	@Then("User redirected to {string} page")
	public void user_redirected_to_page(String pages) {
		String expectedResult = pages;
		String actualResult = driver.getCurrentUrl();
		assertTrue(actualResult.contains(expectedResult),"User is not redirected to the "+pages+" page.");
	}
	
}