package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import pagefactory.GraphPage;
import pagefactory.GraphPageTryEditorPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class GraphPageTryEditorStep {
	
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private GraphPage graphPage = new GraphPage(driver);
	private GraphPageTryEditorPage tryEditor;
	Properties prop = new Properties();
	
	private static List<Map<String, String>> testData;
	private static final String sheetName ="GraphTryEditor";
	
	public GraphPageTryEditorStep() {
		this.prop = new ConfigReader().init_prop();
        String filePath = prop.getProperty("excelTestdataPath");
        ExcelReader reader = new ExcelReader(filePath);
        testData = reader.getDataAll(sheetName);
        LoggerLoad.info("Excel data loaded for GraphTryEditor from sheet: " + sheetName);
	}
	
	@Given("User is on graph page after clicking its link in the Graph Page")
	public void user_is_on_graph_page_after_clicking_its_link_in_the_graph_page() {
		LoggerLoad.info("Navigating to Graph page via Get Started button");
		graphPage = landPage.graphGetStartBtnClick();
	}

	@When("User click the {string} graph link")
	public void user_click_the_graph_link(String graphSubPage) {
		LoggerLoad.info("Clicking graph subpage link: " + graphSubPage);
		tryEditor = graphPage.clickGraphPageLinks(graphSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}
	
	@Then("User can see graph Try here button")
	public void user_can_see_graph_try_here_button(){
		LoggerLoad.info("Verifying 'Try here' button is displayed");
		tryEditor.isTryHereBtnDisplayed();
	}

	@Given("User is on the {string} graph subpage")
	public void user_is_on_the_graph_subpage(String graphSubPage){
		LoggerLoad.info("User navigates to subpage: " + graphSubPage);
		tryEditor = graphPage.clickGraphPageLinks(graphSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}	
	
	@When("User click graph Try here button")
	public void user_click_graph_try_here_button(){
		LoggerLoad.info("Clicking 'Try here' button on graph subpage");
		tryEditor.clickTryHereBtn();
	}
	
	@Then("User redirected to the tryEditor graph page")
	public void user_redirected_to_the_try_editor_graph_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		LoggerLoad.info("Verifying redirection to tryEditor page, expected title: " + expectedResult);
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	}
	
	@Then("User able to see graph Run button")
	public void user_able_to_see_graph_run_button() {
		LoggerLoad.info("Checking if 'Run' button is displayed");
		tryEditor.isRunBtnDisplayed();
	}

	@Given("User is on tryeditor page for {string}")
	public void user_is_on_tryeditor_page_for(String graphSubPage) {
		LoggerLoad.info("Navigating to TryEditor for: " + graphSubPage);
		tryEditor = graphPage.clickGraphPageLinks(graphSubPage);
		tryEditor.clickTryHereBtn();
	}
	
	@When("User click Run button for {string} graphSubPage with code {string}")
	public void user_clicks_run_button_for_graph_sub_page_with_code(String graphSubPage, String codeValidationsType) {
		LoggerLoad.info("Running code for subpage: " + graphSubPage + " with validation type: " + codeValidationsType);

		String codeTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("graphSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(graphSubPage.equalsIgnoreCase(pageTestData)&&
			   codeValidationsType.equalsIgnoreCase(validationTestData)) {
				codeTestData = row.get("code");	
				break;
			}
		}
		
		if(codeTestData != null) {
		tryEditor.writeCode(codeTestData);
		LoggerLoad.info("Code: " + codeTestData);
		tryEditor.clickRunTryHere();
		} else {
			LoggerLoad.error("Test data not found for codeValidationsType: " + codeValidationsType);
			throw new RuntimeException ("Test data not found for:" + codeValidationsType);
		}
	}
	
	@Then("User view message {string} for {string} graphSubPage with code {string}")
	public void user_view_message_for_graph_sub_page_with_code(String message, String graphSubPage, String codeValidationsType) {
		LoggerLoad.info("Validating result message for " + graphSubPage + " with " + codeValidationsType + " code");
		String expectedTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("graphSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(graphSubPage.equalsIgnoreCase(pageTestData)&&
			   codeValidationsType.equalsIgnoreCase(validationTestData)) {
				expectedTestData = row.get("expectedResults");	
				break;
			}
		}
		
		String actualMsg = CommonMethods.getAlertText(driver);
		
		if(actualMsg == null) {
	        if (tryEditor.isOutputSuccess()) {  // No alert- should be successful output scenario
				LoggerLoad.info("Success output shown for valid code.");
	            assertTrue(tryEditor.isOutputSuccess(),"Success output shown as expected: " + expectedTestData);
	        } else { 
				LoggerLoad.error("No alert and no success output for expected: " + expectedTestData);
	        	assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedTestData);}
	    } else if (expectedTestData != null) {
			LoggerLoad.info("Alert appeared. Verifying expected message.");
		    assertTrue(actualMsg.contains(expectedTestData),
			        "Expected alert message to contain '" + expectedTestData + "' but got '" + actualMsg + "'");
			} else {
				LoggerLoad.error("Alert received but expected message was null.");
			    assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
			} 
	}	
	
	@When("User clicks on graph Practice Questions link")
	public void user_clicks_on_graph_practice_questions_link() {
		LoggerLoad.info("Clicking Practice Questions link on Graph page");
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to graph practice page")
	public void user_is_redirected_to_graph_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		LoggerLoad.info("Validating navigation to practice page with title: " + actualResult);
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}

}
