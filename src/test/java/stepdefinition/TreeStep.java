package stepdefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import pagefactory.TreePage;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class TreeStep {
	
	private WebDriver driver = DriverFactory.getDriver();
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private TreePage treePage;	
	
	@Given("User is on Tree page after clicks on Get Started button on Tree panel")
	public void user_is_on_tree_page_after_clicks_on_get_started_button_on_tree_panel() {
		LoggerLoad.info("User clicks on Get Started button in Tree panel");
		treePage = landPage.treeGetStartBtnClick();

	}
	
	@When("User clicks on {string} tree links")
	public void user_clicks_on_tree_links(String links) {
		LoggerLoad.info("User clicks on tree link: " + links);
		treePage.clickTreeSubLinks(links);
	    
	}
}