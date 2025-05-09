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
import pagefactory.QueuePage;
import pagefactory.QueuePageTryEditorPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class QueuePageTryEditorStep {
	
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private QueuePage queuePage = new QueuePage(driver);
	private QueuePageTryEditorPage tryEditor;
	Properties prop = new Properties();
	
	private static List<Map<String, String>> testData;
	private static final String sheetName ="QueueTryEditor";
	
	public QueuePageTryEditorStep() {
		this.prop = new ConfigReader().init_prop();
        String filePath = prop.getProperty("excelTestdataPath");
        ExcelReader reader = new ExcelReader(filePath);
        testData = reader.getDataAll(sheetName);
		LoggerLoad.info("Loaded test data from Excel sheet: " + sheetName);
	}
	
	@Given("User is in Queue Page after clicking its link in the Queue Page")
	public void user_is_on_Queue_page_after_clicking_its_link_in_the_Queue_page() {
		LoggerLoad.info("Navigating to Queue Page from Get Started button");
		queuePage = landPage.queueGetStartBtnClick();
	}

	@When("User click the {string} queue link")
	public void user_click_the_queue_link(String queueSubPage) {
		LoggerLoad.info("Clicking queue subpage link: " + queueSubPage);
		tryEditor = queuePage.clickQueuePageLinks(queueSubPage); //Assign tryEditor here which is initialized in the ArrayPage class 
		
	}
	
	@Then("User can see queue Try here button")
	public void user_can_see_queue_try_here_button(){
		LoggerLoad.info("Checking if Try Here button is displayed.");
		tryEditor.isTryHereBtnDisplayed();
	}

	@Given("User is on the {string} queue subpage")
	public void user_is_on_the_queue_subpage(String queueSubPage){
		LoggerLoad.info("Navigating directly to queue subpage: " + queueSubPage);
		tryEditor = queuePage.clickQueuePageLinks(queueSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}	
	
	@When("User click queue Try here button")
	public void user_click_queue_try_here_button(){
		LoggerLoad.info("Clicking Try Here button on queue subpage.");
		tryEditor.clickTryHereBtn();
	}
	
	@Then("User redirected to the QueuetryEditor queue page")
	public void user_redirected_to_the_Queuetry_editor_queue_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		LoggerLoad.info("Validating redirection to TryEditor page. Expected: " + expectedResult + ", Actual: " + actualResult);
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	}
	
	@Then("User able to see queue Run button")
	public void user_able_to_see_queue_run_button() {
		LoggerLoad.info("Checking if Run button is visible.");
		tryEditor.isRunBtnDisplayed();
	}

	@Given("User is on Queuetryeditor page for {string}")
	public void user_is_on_Queuetryeditor_page_for(String queueSubPage) {
		LoggerLoad.info("Navigating to TryEditor for queue subpage: " + queueSubPage);
		tryEditor = queuePage.clickQueuePageLinks(queueSubPage);
		tryEditor.clickTryHereBtn();
	}
	
	@When("User click Run button for {string} queueSubPage with code {string}")
	public void user_clicks_run_button_for_queue_sub_page_with_code(String queueSubPage, String codeValidationsType) {
		LoggerLoad.info("Fetching test data for subpage: " + queueSubPage + " ,and type: " + codeValidationsType);
		String codeTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("queueSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(queueSubPage.equalsIgnoreCase(pageTestData)&&
			   codeValidationsType.equalsIgnoreCase(validationTestData)) {
				codeTestData = row.get("code");	
				break;
			}

		}
		
		if(codeTestData != null) {
		LoggerLoad.info("Writing code to editor:\n" + codeTestData);
		tryEditor.writeCode(codeTestData);
		tryEditor.clickRunTryHere();
		} else {
			LoggerLoad.error("Test data not found for: " + codeValidationsType);
			throw new RuntimeException ("Test data not found for:" + codeValidationsType);
		}
	}
	
	@Then("User view message {string} for {string} queueSubPage with code {string}")
	public void user_view_message_for_queue_sub_page_with_code(String message, String queueSubPage, String codeValidationsType) {
		LoggerLoad.info("Validating output or alert message for subpage: " + queueSubPage + " validation type: " + codeValidationsType);
		String expectedTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("queueSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(queueSubPage.equalsIgnoreCase(pageTestData)&&
			   codeValidationsType.equalsIgnoreCase(validationTestData)) {
				expectedTestData = row.get("expectedResults");	
				break;
			}
		}
		
		String actualMsg = CommonMethods.getAlertText(driver);
		
		if(actualMsg == null) {
	        if (tryEditor.isOutputSuccess()) {  // No alert- should be successful output scenario
				LoggerLoad.info("No alert - success output verified.");
	        	 assertTrue(tryEditor.isOutputSuccess(),"Success output shown as expected: " + expectedTestData);
	        } else {  
				LoggerLoad.error("No alert and no output found. Expected: " + expectedTestData);
	        	assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedTestData);}
	    } else if (expectedTestData != null) {
			LoggerLoad.info("Alert received. Validating message.");
		    assertTrue(actualMsg.contains(expectedTestData),
			        "Expected alert message to contain '" + expectedTestData + "' but got '" + actualMsg + "'");
		} else {
			LoggerLoad.error("Alert received but expected message is null.");
			    assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
			} 
	}	
	
	@When("User clicks on queue Practice Questions link")
	public void user_clicks_on_queue_practice_questions_link() {
		LoggerLoad.info("Clicking Practice Questions link on queue page.");
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to queue practice page")
	public void user_is_redirected_to_queue_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		LoggerLoad.info("Validating Practice Questions page redirection. Actual title: " + actualResult);
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}

}
