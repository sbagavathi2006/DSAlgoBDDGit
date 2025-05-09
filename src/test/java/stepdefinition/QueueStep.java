package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import pagefactory.QueuePage;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class QueueStep {
	private WebDriver driver = DriverFactory.getDriver();
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private QueuePage queuePage;
	
	@Given("User is on Queue page after clicks on Get Started button on Queue flex")
	public void user_is_on_queue_page_after_clicks_on_get_started_button_on_queue_flex() {
		LoggerLoad.info("Clicking on Get Started button for Queue");
		queuePage = landPage.queueGetStartBtnClick();
		LoggerLoad.info("User navigated to Queue page.");
	}
	  	
	@When("User clicks on {string} link of Queue")
	public void user_clicks_on_link_of_queue(String links) {
		LoggerLoad.info("Clicking on Queue link: " + links);
		queuePage.clickQueuePageLinks(links);
	}
	    
	
	@Then("User redirected to {string} page of Queue")
	public void user_redirected_to_page_of_queue(String pages) {
		LoggerLoad.info("Validating redirection to page: " + pages);
		String expectedResult = pages;
		String actualResult = driver.getCurrentUrl();
		assertTrue(actualResult.contains(expectedResult),"User is not redirected to the "+pages+" page.");
		LoggerLoad.info("Redirection successful. Current URL: " + actualResult);
	}
	    
	}

