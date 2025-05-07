package stepdefinition;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import pagefactory.LinkedListPage;
import webdriver.DriverFactory;

public class LinkedListStep {
	private WebDriver driver = DriverFactory.getDriver();
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private LinkedListPage linkedlistPage;
	
	@Given("User is on LinkedList page after clicks on Get Started button on LinkedList flex")
	public void user_is_on_linked_list_page_after_clicks_on_get_started_button_on_linked_list_flex() {
		linkedlistPage = landPage.linkedListGetStartBtnClick();
	}
	  	
	@When("User clicks on {string} link of LinkedList")
	public void user_clicks_on_link_of_linked_list(String links) {
		linkedlistPage.clickLinkedListPageLinks(links);
	}
	    
	
	@Then("User redirected to {string} page of LinkedList")
	public void user_redirected_to_page_of_linked_list(String pages) {
		String expectedResult = pages;
		String actualResult = driver.getCurrentUrl();
		assertTrue(actualResult.contains(expectedResult),"User is not redirected to the "+pages+" page.");
		  //System.out.println("STEP HIT: " + pages);
	}
	    
	}


