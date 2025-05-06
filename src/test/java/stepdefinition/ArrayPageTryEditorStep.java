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
import pagefactory.DSOptionsPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;


public class ArrayPageTryEditorStep {
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private ArrayPage arrayPage = new ArrayPage(driver);
	private ArrayPageTryEditorPage tryEditor;
	Properties prop = new Properties();
	
	private static List<Map<String, String>> testData;
	private static final String sheetName = "ArrayTryEditor";
		
	public ArrayPageTryEditorStep() {
		this.prop = new ConfigReader().init_prop();
        String filePath = prop.getProperty("excelTestdataPath");
        ExcelReader reader = new ExcelReader(filePath);
        testData = reader.getDataAll(sheetName);
		LoggerLoad.info("Test data loaded for sheet: " + sheetName);
	}
	
	@Given("User is on array page after clicking its link in the Array Page")
	public void user_is_on_array_page_after_clicking_its_link_in_the_array_page() {
		LoggerLoad.info("Navigating to Array page via Get Started");
			arrayPage = landPage.arrayGetStartBtnClick();
	}

	@When("User click the {string} link")
	public void user_click_the_link(String arraySubPages){
		LoggerLoad.info("Clicking on Array subpage link: " + arraySubPages);
		tryEditor = arrayPage.clickArrayPageLinks(arraySubPages);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}
	
	@Then("User can see view Try here button")
	public void user_can_see_view_try_here_button(){
		LoggerLoad.info("Checking visibility of 'Try here' button");
		tryEditor.isTryHereBtnDisplayed();
	}
	
	@Given("User is on the {string} arraysubpage")
	public void user_is_on_the_arraysubpage(String arraySubPages) {
		LoggerLoad.info("Navigating to arraysubpage: " + arraySubPages);
		tryEditor = arrayPage.clickArrayPageLinks(arraySubPages);
	}
	
	@When("User click the Try here button")
	public void user_click_the_try_here_button(){
		LoggerLoad.info("Clicking on 'Try here' button");
		tryEditor.clickTryHereBtn();
	}
		
	@Then("User redirected to the tryEditor page")
	public void user_redirected_to_the_try_editor_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		LoggerLoad.info("Verifying redirection to Try Editor. Page title: "+ actualResult);
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	}

	@Then("User able to see Run button")
	public void user_able_to_see_run_button() {
		LoggerLoad.info("Checking visibility of 'Run' button");
		tryEditor.isRunBtnDisplayed();
	}

	
	@Given("User is on array tryeditor page for {string}")
	public void user_is_on_array_try_editor_page_for(String arraySubPage){
		LoggerLoad.info("Navigating to tryeditor page for: " + arraySubPage);
		tryEditor = arrayPage.clickArrayPageLinks(arraySubPage);
		tryEditor.clickTryHereBtn();
	}

	@When("User click Run button for {string} arraySubPage with code {string}")
	public void user_clicks_run_button_for_array_sub_page_with_code(String arraySubPage, String codeValidationsType) {
		LoggerLoad.info("Executing code on tryeditor for page: "+ arraySubPage +", validation: " + codeValidationsType);

		String codeTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("arraySubPage");
			String validationTestData = row.get("codeValidations");
			
			if(arraySubPage.equalsIgnoreCase(pageTestData)&&
			   codeValidationsType.equalsIgnoreCase(validationTestData)) {
				codeTestData = row.get("code");	
				break;
			}
		}
		
		if(codeTestData != null) {
			LoggerLoad.info("Code found and executing:\n"+ codeTestData);

		tryEditor.writeCode(codeTestData);
		tryEditor.clickRunTryHere();
		} else {
			LoggerLoad.info("Test data not found:\n"+ codeTestData);
			throw new RuntimeException ("Test data not found for:" + codeValidationsType);
		}
	}
	
	@Then("User view message {string} for {string} arraySubPage with code {string}")
	public void user_view_message_for_array_sub_page_with_code(String message, String arraySubPage, String codeValidationsType) {
		LoggerLoad.info("Validating message output for page: "+ arraySubPage +", validation: " + codeValidationsType);

		String expectedTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("arraySubPage");
			String validationTestData = row.get("codeValidations");
			
			if(arraySubPage.equalsIgnoreCase(pageTestData)&&
			   codeValidationsType.equalsIgnoreCase(validationTestData)) {
				expectedTestData = row.get("expectedResults");	
				break;
			}
		}
		
		String actualMsg = CommonMethods.getAlertText(driver);
		
		if(actualMsg == null) {
	        if (tryEditor.isOutputSuccess()) {  	// No alert- should be successful output scenario
	        	assertTrue(tryEditor.isOutputSuccess(), "Success output not shown as expected: " + expectedTestData);
				LoggerLoad.info("Output is successfully displayed");
	        } else { 
	        	assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedTestData);
	        	LoggerLoad.error("No output displayed, expected: "+ expectedTestData);
	        }
	    } else if (expectedTestData != null) { 		// Alert - invalid code scenarios
		    assertTrue(actualMsg.contains(expectedTestData),
			        "Expected alert message to contain '" + expectedTestData + "' but got '" + actualMsg + "'");
		    LoggerLoad.info("Alert message received: "+ actualMsg);

		} else {  // Alert received but no expected msg
			LoggerLoad.error("Expected message was null but alert appeared.");
			assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
		} 
	}	

	@When("User clicks on Practice Questions link")
	public void user_clicks_on_practice_questions_link() {
		LoggerLoad.info("Clicking on Practice Questions link");
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to practice page")
	public void user_is_redirected_to_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		LoggerLoad.info("Verifying redirection to Practice Questions page. Title: "+ actualResult);
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}
}
