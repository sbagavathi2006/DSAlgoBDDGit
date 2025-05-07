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
import pagefactory.StackPage;
import pagefactory.StackPageTryEditorPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelReader;
import webdriver.DriverFactory;


public class StackPageTryEditorStep {
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private StackPage stackPage = new StackPage(driver);
	private StackPageTryEditorPage tryEditor;
	Properties prop = new Properties();
	
	private static List<Map<String, String>> testData;
	private static final String sheetName ="StackTryEditor";
	
	public StackPageTryEditorStep() {
		this.prop = new ConfigReader().init_prop();
        String filePath = prop.getProperty("excelTestdataPath");
        ExcelReader reader = new ExcelReader(filePath);
        testData = reader.getDataAll(sheetName);
	}
	
	@Given("User is in the Stack Page after clicking its link in the Stack Page")
	public void user_is_in_the_Stack_Page_after_clicking_its_link_in_the_Stack_page() {
		stackPage = landPage.stackGetStartBtnClick();
			   
	}
	
	@When("User click the {string} stack link")
	public void user_click_the_stack_link(String stackSubPage) {
		tryEditor = stackPage.clickStackPageLinks(stackSubPage); //Assign tryEditor here which is initialized in the ArrayPage class 
	}
	
	@Then("User can see stack Try here button")
	public void user_can_see_stack_try_here_button(){
		tryEditor.isTryHereBtnDisplayed();
	}

	@Given("User is on the {string} stack subpage")
	public void user_is_on_the_stack_subpage(String stackSubPage){
		tryEditor = stackPage.clickStackPageLinks(stackSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}	

	@When("User click stack Try here button")
	public void user_click_stack_try_here_button(){
		tryEditor.clickTryHereBtn();
	}
	
	@Then("User redirected to the StacktryEditor stack page")
	public void user_redirected_to_the_StacktryEditor_stack_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	}
	
	@Then("User able to see stack Run button")
	public void user_able_to_see_stack_run_button() {
		tryEditor.isRunBtnDisplayed();
	}

	@Given("User is on Stacktryeditor page for {string}")
	public void user_is_on_Stacktryeditor_page_for(String stackSubPage) {
		tryEditor = stackPage.clickStackPageLinks(stackSubPage);
		tryEditor.clickTryHereBtn();
	}
	
	@When("User click Run button for {string} stackSubPage with code {string}")
	public void user_clicks_run_button_for_stack_sub_page_with_code(String stackSubPage, String codeValidationsType) {
		String codeTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("stackSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(stackSubPage.equalsIgnoreCase(pageTestData)&&
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
	
	@Then("User view message {string} for {string} stackSubPage with code {string}")
	public void user_view_message_for_stack_sub_page_with_code(String message, String stackSubPage, String codeValidationsType) {
		String expectedTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("stackSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(stackSubPage.equalsIgnoreCase(pageTestData)&&
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
	
	@When("User clicks on stack Practice Questions link")
	public void user_clicks_on_stack_practice_questions_link() {
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to stack practice page")
	public void user_is_redirected_to_stack_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}

		
	}
	

		