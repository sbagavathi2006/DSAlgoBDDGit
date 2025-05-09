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
import pagefactory.LinkedListPage;
import pagefactory.LinkedListPageTryEditorPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class LinkedListPageTryEditorStep {
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private LinkedListPage linkedlistPage = new LinkedListPage(driver);
	private LinkedListPageTryEditorPage tryEditor;
	Properties prop = new Properties();
	
	private static List<Map<String, String>> testData;
	private static final String sheetName ="LinkedListTryEditor";
	
	public LinkedListPageTryEditorStep() {
		this.prop = new ConfigReader().init_prop();
        String filePath = prop.getProperty("excelTestdataPath");
        ExcelReader reader = new ExcelReader(filePath);
        testData = reader.getDataAll(sheetName);
		LoggerLoad.info("Loaded test data from Excel sheet: " + sheetName);
	}
	
	
	@Given("User is in LinkedList page after clicking its link in the LinkedList Page")
	public void user_is_in_LinkedList_page_after_clicking_its_link_in_the_LinkedList_page() {
		LoggerLoad.info("Navigating to LinkedList page");
		linkedlistPage = landPage.linkedListGetStartBtnClick();
	}

	@When("User click the {string} linkedlist link")
	public void user_click_the_linkedlist_link(String linkedListSubPage) {
		LoggerLoad.info("Clicking LinkedList subpage link: " + linkedListSubPage);
		tryEditor = linkedlistPage.clickLinkedListPageLinks(linkedListSubPage); //Assign tryEditor here which is initialized in the ArrayPage class 
	}
	
	@Then("User can see linkedList Try here button")
	public void user_can_see_linkedList_try_here_button(){
		LoggerLoad.info("Checking if 'Try here' button is visible");
		tryEditor.isTryHereBtnDisplayed();
	}

	@Given("User is on the {string} linkedList subpage")
	public void user_is_on_the_linkedList_subpage(String linkedListSubPage){
		LoggerLoad.info("Navigating to LinkedList subpage: " + linkedListSubPage);
		tryEditor = linkedlistPage.clickLinkedListPageLinks(linkedListSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}	
	
	@When("User click linkedList Try here button")
	public void user_click_linkedList_try_here_button(){
		LoggerLoad.info("Clicking 'Try here' button on LinkedList subpage");
		tryEditor.clickTryHereBtn();
	}
	
	@Then("User redirected to the linkedListtryEditor linkedlist page")
	public void user_redirected_to_the_linkedListtryEditor_linkedlist_page() {
		LoggerLoad.info("Verifying redirection to Try Editor page");
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
		LoggerLoad.info("Redirection successful. Page title: " + actualResult);
	}
	
	@Then("User able to see linkedlist Run button")
	public void user_able_to_see_linkedlist_run_button() {
		LoggerLoad.info("Checking if Run button is visible");
		tryEditor.isRunBtnDisplayed();
	}

	@Given("User is on LinkedListtryeditor page for {string}")
	public void user_is_on_LinkedListtryeditor_page_for(String linkedListSubPage) {
		LoggerLoad.info("Navigating to TryEditor for: " + linkedListSubPage);
		tryEditor = linkedlistPage.clickLinkedListPageLinks(linkedListSubPage);
		tryEditor.clickTryHereBtn();
	}
	
	@When("User click Run button for {string} linkedlistSubPage with code {string}")
	public void user_clicks_run_button_for_linkedlist_sub_page_with_code(String linkedListSubPage, String codeValidationsType) {
		LoggerLoad.info("Executing code for page: " + linkedListSubPage + ", type: " + codeValidationsType);
		String codeTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("linkedListSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(linkedListSubPage.equalsIgnoreCase(pageTestData)&&
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
	
	@Then("User view message {string} for {string} linkedlistSubPage with code {string}")
	public void user_view_message_for_linkedlist_sub_page_with_code(String message, String linkedListSubPage, String codeValidationsType) {
		LoggerLoad.info("Verifying output message for: " + linkedListSubPage + ", validation type: " + codeValidationsType);

		String expectedTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("linkedListSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(linkedListSubPage.equalsIgnoreCase(pageTestData)&&
			   codeValidationsType.equalsIgnoreCase(validationTestData)) {
				expectedTestData = row.get("expectedResults");	
				break;
			}
		}
		
		String actualMsg = CommonMethods.getAlertText(driver);
		
		if(actualMsg == null) {
	        if (tryEditor.isOutputSuccess()) {  // No alert- should be successful output scenario
				LoggerLoad.info("Output success without alert. Output validated successfully.");
	        } else {  
				LoggerLoad.error("No alert or output displayed. Expected: " + expectedTestData);
	        	assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedTestData);}
	    } else if (expectedTestData != null) {
			LoggerLoad.info("Validating alert: " + actualMsg + " against expected: " + expectedTestData);
		    assertTrue(actualMsg.contains(expectedTestData),
			        "Expected alert message to contain '" + expectedTestData + "' but got '" + actualMsg + "'");
		} else {
			LoggerLoad.error("Alert appeared but expected message is null.");
			assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
		} 
	}	
	
	@When("User clicks on linkedlist Practice Questions link")
	public void user_clicks_on_linkedlist_practice_questions_link() {
		LoggerLoad.info("Clicking on Practice Questions link...");
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to linkedlist practice page")
	public void user_is_redirected_to_linkedlist_practice_page() {
		LoggerLoad.info("Verifying redirection to practice page");
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
		LoggerLoad.info("Practice page reached. Page title: " + actualResult);
	}

}
