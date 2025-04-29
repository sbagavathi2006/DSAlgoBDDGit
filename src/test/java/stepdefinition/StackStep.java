package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import pagefactory.QueuePage;
import pagefactory.StackPage;
import webdriver.DriverFactory;

public class StackStep {
	private WebDriver driver = DriverFactory.getDriver();
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private StackPage stackPage;

	@Given("User is on Stack page after clicks on Get Started button on Stack flex")
	public void user_is_on_stack_page_after_clicks_on_get_started_button_on_stack_flex() {
		stackPage = landPage.stackGetStartBtnClick();
	}
	
	@When("User clicks on {string} link for Stack")
	public void user_clicks_on_link_for_stack(String links) {
		stackPage.clickStackPageLinks(links);
	}

	@Then("User redirected to {string} page for Stack")
	public void user_redirected_to_page_for_stack(String pages) {
		String expectedResult = pages;
		String actualResult = driver.getCurrentUrl();
		assertTrue(actualResult.contains(expectedResult),"User is not redirected to the "+pages+" page.");
	}
}
