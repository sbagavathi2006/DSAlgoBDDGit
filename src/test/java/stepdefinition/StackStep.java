package stepdefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
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
	
	@When("User clicks on {string} Stack links")
	public void user_clicks_on_Stack_links(String links) {
		stackPage.clickStackPageLinks(links);
	}
// Add Then class and make the step unique by adding stack in the feature file.
	}
