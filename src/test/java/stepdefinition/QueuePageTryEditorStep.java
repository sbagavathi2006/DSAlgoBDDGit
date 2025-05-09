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
	}
	
	@Given("User is in Queue Page after clicking its link in the Queue Page")
	public void user_is_on_Queue_page_after_clicking_its_link_in_the_Queue_page() {
		queuePage = landPage.queueGetStartBtnClick();
	}

	@When("User click the {string} queue link")
	public void user_click_the_queue_link(String queueSubPage) {
		tryEditor = queuePage.clickQueuePageLinks(queueSubPage); //Assign tryEditor here which is initialized in the ArrayPage class 
	}
	
	@Then("User can see queue Try here button")
	public void user_can_see_queue_try_here_button(){
		tryEditor.isTryHereBtnDisplayed();
	}

	@Given("User is on the {string} queue subpage")
	public void user_is_on_the_queue_subpage(String queueSubPage){
		tryEditor = queuePage.clickQueuePageLinks(queueSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}	
	
	@When("User click queue Try here button")
	public void user_click_queue_try_here_button(){
		tryEditor.clickTryHereBtn();
	}
	
	@Then("User redirected to the QueuetryEditor queue page")
	public void user_redirected_to_the_Queuetry_editor_queue_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	}
	
	@Then("User able to see queue Run button")
	public void user_able_to_see_queue_run_button() {
		tryEditor.isRunBtnDisplayed();
	}

	@Given("User is on Queuetryeditor page for {string}")
	public void user_is_on_Queuetryeditor_page_for(String queueSubPage) {
		tryEditor = queuePage.clickQueuePageLinks(queueSubPage);
		tryEditor.clickTryHereBtn();
	}
	
	@When("User click Run button for {string} queueSubPage with code {string}")
	public void user_clicks_run_button_for_queue_sub_page_with_code(String queueSubPage, String codeValidationsType) {
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
		tryEditor.writeCode(codeTestData);
		tryEditor.clickRunTryHere();
		} else {
			throw new RuntimeException ("Test data not found for:" + codeValidationsType);
		}
	}
	
	@Then("User view message {string} for {string} queueSubPage with code {string}")
	public void user_view_message_for_queue_sub_page_with_code(String message, String queueSubPage, String codeValidationsType) {
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
	        	 assertTrue(tryEditor.isOutputSuccess(),"Success output shown as expected: " + expectedTestData);
	        } else {  assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedTestData);}
	    } else if (expectedTestData != null) {
		    assertTrue(actualMsg.contains(expectedTestData),
			        "Expected alert message to contain '" + expectedTestData + "' but got '" + actualMsg + "'");
			} else {
			    assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
			} 
	}	
	
	@When("User clicks on queue Practice Questions link")
	public void user_clicks_on_queue_practice_questions_link() {
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to queue practice page")
	public void user_is_redirected_to_queue_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}

}
