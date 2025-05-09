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
import pagefactory.DataStructurePage;
import pagefactory.DataStructurePageTryEditorPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class DataStructurePageTryEditorStep {
	
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private DataStructurePage dataStructurePage = new DataStructurePage(driver);
	private DataStructurePageTryEditorPage tryEditor;
	Properties prop = new Properties();
	
	private static List<Map<String, String>> testData;
	private static final String sheetName ="DataStructureTryEditor";
	
	public DataStructurePageTryEditorStep() {
		this.prop = new ConfigReader().init_prop();
        String filePath = prop.getProperty("excelTestdataPath");
        ExcelReader reader = new ExcelReader(filePath);
        testData = reader.getDataAll(sheetName);
        LoggerLoad.info("Excel data loaded for DataStructureTryEditor from sheet: " + sheetName);
	}
	
	@Given("User is on DataStructure page after clicking its link in the DataStructure Page")
	public void user_is_on_DataStructure_page_after_clicking_its_link_in_the_DataStructure_page() {
		LoggerLoad.info("Navigating to DataStructure page via Get Started button");
		dataStructurePage = landPage.dsIntroGetStartBtnClick();
	}

	@When("User click the {string} datastructure link")
	public void user_click_the_datastructure_link(String datastructureSubPage) {
		LoggerLoad.info("Clicking datastructure subpage link: " + datastructureSubPage);
		tryEditor = dataStructurePage.clickDataStructurePageLinks(datastructureSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}
	
	@Then("User can see datastructure Try here button")
	public void user_can_see_datastructure_try_here_button(){
		LoggerLoad.info("Verifying 'Try here' button is displayed");
		tryEditor.isTryHereBtnDisplayed();
	}

	@Given("User is on the {string} datastructure subpage")
	public void user_is_on_the_datastructure_SubPage(String datastructureSubPage){
		LoggerLoad.info("User navigates to subpage: " + datastructureSubPage);
		tryEditor = dataStructurePage.clickDataStructurePageLinks(datastructureSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}	
	
	@When("User click datastructure Try here button")
	public void user_click_datastructure_try_here_button(){
		LoggerLoad.info("Clicking 'Try here' button on datastructure");
		tryEditor.clickTryHereBtn();
	}
	
	@Then("User redirected to the tryEditor datastructure page")
	public void user_redirected_to_the_try_editor_datastructure_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		LoggerLoad.info("Verifying redirection to tryEditor page, expected title: " + expectedResult);
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	}
	
	@Then("User able to see datastructure Run button")
	public void user_able_to_see_datastructure_run_button() {
		LoggerLoad.info("Checking if 'Run' button is displayed");
		tryEditor.isRunBtnDisplayed();
	}

	@Given("User is on datastructure tryeditor page for {string}")
	public void user_is_on_datastructure_tryeditor_page_for(String datastructureSubPage) {
		LoggerLoad.info("Navigating to TryEditor for: " + datastructureSubPage);
		tryEditor = dataStructurePage.clickDataStructurePageLinks(datastructureSubPage);
		tryEditor.clickTryHereBtn();
	}
	
	@When("User click Run button for {string} datastructureSubPage with code {string}")
	public void user_clicks_run_button_for_datastructureSubPage_with_code(String datastructureSubPage, String codeValidationsType) {
		LoggerLoad.info("Running code for subpage: " + datastructureSubPage + " with validation type: " + codeValidationsType);

		String codeTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("datastructureSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(datastructureSubPage.equalsIgnoreCase(pageTestData)&&
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
	
	@Then("User view message {string} for {string} datastructureSubPage with code {string}")
	public void user_view_message_for_datastructureSubPage_with_code(String message, String datastructureSubPage, String codeValidationsType) {
		LoggerLoad.info("Validating result message for " + datastructureSubPage + " with " + codeValidationsType + " code");
		String expectedTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("datastructureSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(datastructureSubPage.equalsIgnoreCase(pageTestData)&&
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
	
	@When("User clicks on datastructure Practice Questions link")
	public void user_clicks_on_datastructure_practice_questions_link() {
		LoggerLoad.info("Clicking Practice Questions link on Graph page");
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to datastructure practice page")
	public void user_is_redirected_to_datastructure_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		LoggerLoad.info("Validating navigation to practice page with title: " + actualResult);
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}

}
