package stepdefinition;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import pagefactory.QueuePage;
import webdriver.DriverFactory;

public class QueueStep {
	private WebDriver driver = DriverFactory.getDriver();
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private QueuePage queuePage;
	
	
	@Given("User is on Queue page after clicks on Get Started button on Queue flex")
	public void user_is_on_queue_page_after_clicks_on_get_started_button_on_queue_flex() {
		queuePage = landPage.queueGetStartBtnClick();
		String queuePageTitle = queuePage.getQueuePageTitle();
		if(queuePageTitle.equalsIgnoreCase("Queue")) {
			System.out.println("User is on the queue page.");
		} else System.out.println("User is not on the queue page.");
	}
	
	
	@When("User clicks on {string} link for Queue")
	public void user_clicks_on_link_for_queue(String links) {
		queuePage.clickQueuePageLinks(links);
	}

	@Then("User redirected to {string} page for Queue")
	public void user_redirected_to_page_for_queue(String pages) {
		String expectedResult = pages;
		String actualResult = driver.getCurrentUrl();
		assertTrue(actualResult.contains(expectedResult),"User is not redirected to the "+pages+" page.");
	}
	}

