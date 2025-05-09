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
	}
	
	
	@Given("User is in LinkedList page after clicking its link in the LinkedList Page")
	public void user_is_in_LinkedList_page_after_clicking_its_link_in_the_LinkedList_page() {
		linkedlistPage = landPage.linkedListGetStartBtnClick();
	}

	@When("User click the {string} linkedlist link")
	public void user_click_the_linkedlist_link(String linkedListSubPage) {
		tryEditor = linkedlistPage.clickLinkedListPageLinks(linkedListSubPage); //Assign tryEditor here which is initialized in the ArrayPage class 
	}
	
	@Then("User can see linkedList Try here button")
	public void user_can_see_linkedList_try_here_button(){
		tryEditor.isTryHereBtnDisplayed();
	}

	@Given("User is on the {string} linkedList subpage")
	public void user_is_on_the_linkedList_subpage(String linkedListSubPage){
		tryEditor = linkedlistPage.clickLinkedListPageLinks(linkedListSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}	
	
	@When("User click linkedList Try here button")
	public void user_click_linkedList_try_here_button(){
		tryEditor.clickTryHereBtn();
	}
	
	@Then("User redirected to the linkedListtryEditor linkedlist page")
	public void user_redirected_to_the_linkedListtryEditor_linkedlist_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	}
	
	@Then("User able to see linkedlist Run button")
	public void user_able_to_see_linkedlist_run_button() {
		tryEditor.isRunBtnDisplayed();
	}

	@Given("User is on LinkedListtryeditor page for {string}")
	public void user_is_on_LinkedListtryeditor_page_for(String linkedListSubPage) {
		tryEditor = linkedlistPage.clickLinkedListPageLinks(linkedListSubPage);
		tryEditor.clickTryHereBtn();
	}
	
	@When("User click Run button for {string} linkedlistSubPage with code {string}")
	public void user_clicks_run_button_for_linkedlist_sub_page_with_code(String linkedListSubPage, String codeValidationsType) {
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
		tryEditor.writeCode(codeTestData);
		tryEditor.clickRunTryHere();
		} else {
			throw new RuntimeException ("Test data not found for:" + codeValidationsType);
		}
	}
	
	@Then("User view message {string} for {string} linkedlistSubPage with code {string}")
	public void user_view_message_for_linkedlist_sub_page_with_code(String message, String linkedListSubPage, String codeValidationsType) {
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
	           	        } else {  assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedTestData);}
	    } else if (expectedTestData != null) {
		    assertTrue(actualMsg.contains(expectedTestData),
			        "Expected alert message to contain '" + expectedTestData + "' but got '" + actualMsg + "'");
			} else {
			    assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
			} 
	}	
	
	@When("User clicks on linkedlist Practice Questions link")
	public void user_clicks_on_linkedlist_practice_questions_link() {
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to linkedlist practice page")
	public void user_is_redirected_to_linkedlist_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}

}
