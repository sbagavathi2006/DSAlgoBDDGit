package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Properties;

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
import utilities.LoggerLoad;
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
		LoggerLoad.info("Test data loaded for sheet: " + sheetName);
	}

	
	@Given("User is on the arrays sublink page")
	public void user_is_on_the_arrays_sublink_page() {
		arrayPage = landPage.arrayGetStartBtnClick();
		arrayPage.clickArraysInPython();
		LoggerLoad.info("Navigating to Arrays sublink page");
	}
	
	@When("User clicks on pratice questions link")
	public void user_clicks_on_pratice_questions_link() {
		LoggerLoad.info("Clicking on Practice Questions link");
		practicePage = tryEditor.clickPracticeQnsLink();
	}

	@Then("User able to view the questions")
	public void user_able_to_view_the_questions() {
		LoggerLoad.info("Validating practice questions are displayed");
		boolean isDisplayed = practicePage != null && practicePage.isPraticeQnsLinksDisplayed();	    
	    assertTrue(isDisplayed, "Practice questions are not displayed or not available for this scenario.");		
	}
	
	@Given("User clicks on the pratice questions link")
	public void user_clicks_on_the_pratice_questions_link() {
		LoggerLoad.info("Clicking on Practice Questions link");
		practicePage = tryEditor.clickPracticeQnsLink();
	}


	@When("User clicks on {string} Link")
	public void user_clicks_on_link(String linkText){
		LoggerLoad.info("Clicking on question link: " + linkText);
		practicePage.clickPracticeQns(linkText);
	}

	@Then("User is redirected to {string} Page")
	public void user_is_redirected_to_page(String questionPage) {
	   String expectedResult = questionPage;
	   String actuatlResult = driver.getCurrentUrl();
	   LoggerLoad.info("Verifying redirection to page: " + expectedResult);
	   assertTrue(actuatlResult.contains(expectedResult), "User is not redirected to "+ questionPage  +" page.");
	}

	@Then("User is able to see Run button")
	public void user_is_able_to_see_run_button() {
		LoggerLoad.info("Checking if Run button is displayed");
		practicePage.isBtnDisplayed("run");
	}

	@Then("User is able to see Submit button")
	public void user_is_able_to_see_submit_button() {
		LoggerLoad.info("Checking if Submit button is displayed");
		practicePage.isBtnDisplayed("submit");	 
	}

	@Given("User is on {string} page after clicks on arraysubpage Link")
	public void user_is_on_page_after_clicks_on_arraysubpage_link(String questionsFea){
		LoggerLoad.info("Navigating to practice question: " + questionsFea);
		practicePage = tryEditor.clickPracticeQnsLink();
		practicePage.clickPracticeQns(questionsFea);
	}

	@When("User click on run button with {string} code snippet and {string} questions")
	public void user_click_on_run_button_with_code_snippet_and_questions(String codeValidationsType, String questionsFea){
		LoggerLoad.info("Running code for question: " + questionsFea + " , Validation type: " + codeValidationsType);

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
	        LoggerLoad.info(codeValidationsType);
	        LoggerLoad.info(codeSnippet);
	        practicePage.clickRunBtn(); 
	        LoggerLoad.info("Code executed via Run button.");
	    } else {
	        LoggerLoad.error("Test data not found for: " + codeValidationsType);
	        throw new RuntimeException("Test data not found for: " + codeValidationsType);
	    }    
	}

	@Then("User gets an message {string} for {string} questions for {string}")
	public void user_gets_an_message(String expectedMsg, String questionsFea, String codeValidationsType) {
		LoggerLoad.info("Validating run output for question: " + questionsFea + " , Type: " + codeValidationsType);

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
		        LoggerLoad.info("Success output displayed for valid code.");
		        assertTrue(practicePage.isOutputSuccess(),"Success output shown as expected: " + expectedMsg);
		    } else {
		        LoggerLoad.error("Neither alert nor output found. Expected: " + expectedMsg);
		        assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedMsg);
		    }
		} else if (expectedMsg != null) {
		    LoggerLoad.info("Verifying alert message: " + actualMsg);
		    assertTrue(actualMsg.contains(expectedMsg),
		        "Expected alert message to contain '" + expectedMsg + "' but got '" + actualMsg + "'");
		} else {
		    LoggerLoad.error("Expected message is null but alert appeared.");
		    assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
		}
	}

	@When("User click on submit button with {string} code snippet and {string} questions")
	public void user_click_on_submit_button_with_code_snippet_and_questions(String codeValidationsType, String questionsFea) {
		LoggerLoad.info("Submitting code for question: " + questionsFea + " , Validation type: " + codeValidationsType);

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
	        LoggerLoad.info(codeValidationsType);
	        LoggerLoad.info(codeSnippet);
	        practicePage.btnSubmit(); 
	        LoggerLoad.info("Code submitted.");
	    } else {
	        LoggerLoad.error("Test data not found for submit: " + codeValidationsType);
	        throw new RuntimeException("Test data not found for: " + codeValidationsType);
	    }  
	}

	@Then("User gets message {string} for {string} questions for {string} submit")
	public void user_gets_message_for_questions_for_submit(String expectedMsg, String questionsFea, String codeValidationsType) {
		LoggerLoad.info("Validating submit output for question: " + questionsFea + " , Type: " + codeValidationsType);

		for (Map<String, String> row : testData) {
	        String question = row.get("questions");
	        String validation = row.get("codeValidations");

	        if (question.equalsIgnoreCase(questionsFea) &&
	            validation.equalsIgnoreCase(codeValidationsType)) {
	        	expectedMsg = row.get("errSubmit");
	            break;
	        }
	    }

		String actualMsg = practicePage.getSubmitMsg();
		LoggerLoad.info("Comparing actual vs expected submit message: " + actualMsg + " vs " + expectedMsg);
		assertTrue(actualMsg.equalsIgnoreCase(expectedMsg), "Expected: " + expectedMsg + ", but got: " + actualMsg);
	}
}
