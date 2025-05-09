package stepdefinition;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import pagefactory.DataStructurePage;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class DataStructureStep {
	
	private WebDriver driver = DriverFactory. getDriver();
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private DataStructurePage dataStructurePage;
	
			
	
	@Given("User is on DataStructure page after clicks on Get Started button on DataStructure flex")
	public void user_is_on_data_structure_page_after_clicks_on_get_started_button_on_data_structure_flex() {
		dataStructurePage = landPage.dsIntroGetStartBtnClick();
		LoggerLoad.info("User is navigated to DataStructure page");
	}

	@When("User clicks on {string} DataStructure links")
	public void user_clicks_on_Data_structure_links(String links) {
		LoggerLoad.info("User clicks on DataStructure page link: " + links);
		dataStructurePage.clickDataStructurePageLinks(links);
	}
	   

	@Then("User redirected to {string} page of DataStructure")
	public void user_redirected_to_page_of_Data_structure(String pages) {
		String expectedResult = pages;
		String actualResult = driver.getCurrentUrl();
		assertTrue(actualResult.contains(expectedResult),"User is not redirected to the "+pages+" page.");
		LoggerLoad.info("User redirected to page of DataStructure: " + pages);
	   
	}


}
