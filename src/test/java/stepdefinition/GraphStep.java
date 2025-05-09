package stepdefinition;

import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import pagefactory.GraphPage;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class GraphStep {
	
	private WebDriver driver = DriverFactory.getDriver();
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private GraphPage graphPage;
	
	
	@Given("User is on graph page after clicks on Get Started button on Graph panel")
	public void user_is_on_graph_page_after_clicks_on_get_started_button_on_graph_panel() {
		graphPage = landPage.graphGetStartBtnClick();
		LoggerLoad.info("User is navigated to Graph page");
	}

	@When("User clicks on {string} graph links")
	public void user_clicks_on_graph_links(String links) {
		LoggerLoad.info("User clicks on Graph page link: " + links);
		graphPage.clickGraphPageLinks(links);
	}
}