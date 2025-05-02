package stepdefinition;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSAlgoPortalPage;
import pagefactory.DSOptionsPage;
import pagefactory.GraphPage;
import pagefactory.LogoutPage;
import webdriver.DriverFactory;

public class LogoutStep {
	
	private WebDriver driver = DriverFactory.getDriver(); 
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private LogoutPage logoutPage = new LogoutPage(driver);
	private GraphPage graphPage;
	
	@Given("user is on the graph page after clicks Get Started button on Graph panel")
	public void user_is_on_the_graph_page_after_clicks_get_started_button_on_graph_panel() {
		graphPage = landPage.graphGetStartBtnClick();
	}

	@Given("The user is in the Graph page")
	public void the_user_is_in_the_graph_page() {
		String title = graphPage.getGraphPageTitle();
	       Assert.assertEquals(title, "Graph");  
	}
	

	@When("The user clicks on Signout")
	public void the_user_clicks_on_signout() {
		logoutPage.signoutBtnclick();
	}

	@Then("The user be directed to Home page")
	public void the_user_be_directed_to_home_page() {
		String title = logoutPage.getHomePageTitle();
	 	  Assert.assertEquals(title, "NumpyNinja"); 
		} 
	}




