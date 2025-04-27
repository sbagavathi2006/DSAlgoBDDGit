package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.ArrayPage;
import pagefactory.ArrayPageTryEditorPage;
import pagefactory.ArrayPraticeQnsPage;
import pagefactory.DSOptionsPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelReader;
import webdriver.DriverFactory;

public class ArrayPraticeQnsStep {
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private ArrayPage arrayPage = new ArrayPage(driver);
	private ArrayPageTryEditorPage tryEditor = new ArrayPageTryEditorPage(driver);
	private ArrayPraticeQnsPage practicePage;
	Properties prop = new Properties();
	
	private static List<Map<String, String>> testData;
	private static final String sheetName = "ArrayPracticeQns";
	
	public ArrayPraticeQnsStep() {
		this.prop = new ConfigReader().init_prop();
		String filePath = prop.getProperty("excelTestdataPath");
		ExcelReader reader = new ExcelReader(filePath);
		testData = reader.getDataAll(sheetName);
	}

	
	@Given("User is on the arrays sublink page")
	public void user_is_on_the_arrays_sublink_page() {
		arrayPage = landPage.arrayGetStartBtnClick();
		arrayPage.clickArraysInPython();
	}
	
	@When("User clicks on pratice questions link")
	public void user_clicks_on_pratice_questions_link() {
		practicePage = tryEditor.clickPracticeQnsLink();
	}

	@Then("User able to view the questions")
	public void user_able_to_view_the_questions() {
		practicePage.isPraticeQnsLinksDisplayed();   
	}
	
	@Given("User clicks on the pratice questions link")
	public void user_clicks_on_the_pratice_questions_link() {
		practicePage = tryEditor.clickPracticeQnsLink();
	}


	@When("User clicks on {string} Link")
	public void user_clicks_on_link(String linkText){
		practicePage.clickPracticeQns(linkText);
	}

	@Then("User is redirected to {string} Page")
	public void user_is_redirected_to_page(String questionPage) {
	   String expectedResult = questionPage;
	   String actuatlResult = driver.getCurrentUrl();
	   assertTrue(actuatlResult.contains(expectedResult), "User is not redirected to "+ questionPage  +" page.");
	}

	@Then("User is able to see Run button")
	public void user_is_able_to_see_run_button() {
		practicePage.isBtnDisplayed("run");
	}

	@Then("User is able to see Submit button")
	public void user_is_able_to_see_submit_button() {
		practicePage.isBtnDisplayed("submit");	 
	}

	@Given("User is on {string} page after clicks on arraysubpage Link")
	public void user_is_on_page_after_clicks_on_arraysubpage_link(String questionsFea){
		practicePage = tryEditor.clickPracticeQnsLink();
		practicePage.clickPracticeQns(questionsFea);
	}

	@When("User click on run button with {string} code snippet and {string} questions")
	public void user_click_on_run_button_with_code_snippet_and_questions(String codeValidationsType, String questionsFea){

		String codeSnippet = null;

	    for (Map<String, String> row : testData) {
	        String question = row.get("questions");
	        String validation = row.get("codeValidations");

	        if (question.equalsIgnoreCase(questionsFea) &&
	            validation.equalsIgnoreCase(codeValidationsType)) {
	            codeSnippet = row.get("code");
	            break;
	        }
	        
	    }

	    if (codeSnippet != null) {
	        practicePage.writeCode(codeSnippet);
	        practicePage.clickRunBtn(); 
	    } else {
	        throw new RuntimeException("Test data not found for: " + codeValidationsType);
	    }    
	}

	@Then("User gets an message {string} for {string} questions for {string}")
	public void user_gets_an_message(String expectedMsg, String questionsFea, String codeValidationsType) {

		for (Map<String, String> row : testData) {
	        String question = row.get("questions");
	        String validation = row.get("codeValidations");

	        if (question.equalsIgnoreCase(questionsFea) &&
	            validation.equalsIgnoreCase(codeValidationsType)) {
	        	expectedMsg = row.get("errRun");
	            break;
	        }
	    }

		String actualMsg = CommonMethods.getAlertText(driver);
		if (actualMsg == null) {
		    if (practicePage.isOutputSuccess()) {
		        System.out.println("Success output shown as expected: " + expectedMsg);
		    } else {
		        assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedMsg);
		    }
		} else if (expectedMsg != null) {
		    assertTrue(actualMsg.contains(expectedMsg),
		        "Expected alert message to contain '" + expectedMsg + "' but got '" + actualMsg + "'");
		} else {
		    assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
		}
	}

	@When("User click on submit button with {string} code snippet and {string} questions")
	public void user_click_on_submit_button_with_code_snippet_and_questions(String codeValidationsType, String questionsFea) {

		String codeSnippet = null;

	    for (Map<String, String> row : testData) {
	        String question = row.get("questions");
	        String validation = row.get("codeValidations");

	        if (question.equalsIgnoreCase(questionsFea) &&
	            validation.equalsIgnoreCase(codeValidationsType)) {
	            codeSnippet = row.get("code");
	            break;
	        }
	        
	    }

	    if (codeSnippet != null) {
	        practicePage.writeCode(codeSnippet);
//	        practicePage.clickRunBtn();
//	        CommonMethods.acceptAlert(driver);
	        practicePage.btnSubmit(); 
	    } else {
	        throw new RuntimeException("Test data not found for: " + codeValidationsType);
	    }  
	}

	@Then("User gets message {string} for {string} questions for {string} submit")
	public void user_gets_message_for_questions_for_submit(String expectedMsg, String questionsFea, String codeValidationsType) {
		for (Map<String, String> row : testData) {
	        String question = row.get("questions");
	        String validation = row.get("codeValidations");

	        if (question.equalsIgnoreCase(questionsFea) &&
	            validation.equalsIgnoreCase(codeValidationsType)) {
	        	expectedMsg = row.get("errSubmit");
	        	System.out.println("Expected message from Excel: " + expectedMsg);

	            break;
	        }
	    }

		String actualMsg = practicePage.getSubmitMsg();
		System.out.println("Actual message from page: " + actualMsg);
		assertTrue(actualMsg.equalsIgnoreCase(expectedMsg), "Expected: " + expectedMsg + ", but got: " + actualMsg);
//	    try {
//	        actualMsg = CommonMethods.getAlertText(driver); // Handle possible alert
//	    } catch (UnhandledAlertException e) {
//	        actualMsg = driver.switchTo().alert().getText(); // Fallback if alert already open
//	        driver.switchTo().alert().accept(); // Accept the alert to continue
//	    }
//
//	    if (actualMsg != null) {
//	        assertTrue(actualMsg.contains(expectedMsg), "Expected alert to contain: " + expectedMsg + ", but got: " + actualMsg);
//	    } else {
//	        actualMsg = practicePage.getSubmitMsg();
//	        assertTrue(actualMsg.equalsIgnoreCase(expectedMsg), "Expected: " + expectedMsg + ", but got: " + actualMsg);
//	    }
	}
}
