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
import pagefactory.TreePage;
import pagefactory.TreePageTryEditorPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class TreePageTryEditorStep {
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private TreePage treePage = new TreePage(driver);
	private TreePageTryEditorPage tryEditor;
	Properties prop = new Properties();
	
	private static List<Map<String, String>> testData;
	private static final String sheetName ="TreeTryEditor";
	
	public TreePageTryEditorStep() {
		this.prop = new ConfigReader().init_prop();
        String filePath = prop.getProperty("excelTestdataPath");
        ExcelReader reader = new ExcelReader(filePath);
        testData = reader.getDataAll(sheetName);
        LoggerLoad.info("Excel data loaded for TreeTryEditor from sheet: " + sheetName);
	    }
	
	 @Given("User is on TreePage after clicking its link in the Tree Page")
	  public void user_is_on_tree_page_after_clicking_its_link_in_the_tree_page() {
		  LoggerLoad.info("Navigating to Tree page via Get Started button");
		  treePage = landPage.treeGetStartBtnClick();
	  }

	@When("user click the {string} tree link")
	public void user_click_the_tree_link(String treeSubPage ) {
	  LoggerLoad.info("User clicks tree sublink: " + treeSubPage);
	  tryEditor = treePage.clickTreeSubLinks(treeSubPage);
	  }
	
	@Then("user can see tree Try here button")
	public void user_can_see_tree_try_here_button(){
	  LoggerLoad.info("Checking if 'Try Here' button is displayed");
	  tryEditor.isTryHereBtnDisplayed();
	  }
	
	@Given("User is on the {string} tree subpage")
	public void user_is_on_the_tree_subpage(String treeSubPage) {
	  LoggerLoad.info("Navigating to tree subpage: " + treeSubPage);
	  tryEditor = treePage.clickTreeSubLinks(treeSubPage);
	  }
	
    @When("the user click tree Try here button")
	public void the_user_click_tree_try_here_button() {
	  LoggerLoad.info("User clicks 'Try Here' button");
	  tryEditor.clickTryHereBtn();
	  }

	@Then("the user should redirected to the tryEditor tree page")
	public void the_user_should_redirected_to_the_try_editor_tree_page() {
	  String expectedResult = "Assessment";
	  String actualResult = driver.getTitle();
	  LoggerLoad.info("Verifying redirection to tryEditor page. Page title: " + actualResult);
	  assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	  }
	
	@Then("The user should able to see tree Run button")
	public void the_user_should_able_to_see_tree_run_button() {
	  LoggerLoad.info("Checking if 'Run' button is displayed");
	  tryEditor.isRunBtnDisplayed();
	  }

    @Given("user is on tryeditor page for {string}")
	public void user_is_on_tryeditor_page_for(String treeSubPage) {
	  LoggerLoad.info("Navigating to tryeditor for subpage: " + treeSubPage);
	  tryEditor = treePage.clickTreeSubLinks(treeSubPage);
	  tryEditor.clickTryHereBtn();
	  }

	@When("user click Run button for {string} treeSubPage with code {string}")
    public void user_click_run_button_for_tree_sub_page_with_code(String treeSubPage, String codeValidationsType) {
		LoggerLoad.info("Preparing to run code on tryEditor for " + treeSubPage + " with validation: " + codeValidationsType);
		
       String codeTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("treeSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(treeSubPage.equalsIgnoreCase(pageTestData)&&
			   codeValidationsType.equalsIgnoreCase(validationTestData)) {
				codeTestData = row.get("code");	
				break;
			   }
		    }
		
	   if(codeTestData != null) {
		LoggerLoad.info("Running code:\n" + codeTestData);
		tryEditor.writeCode(codeTestData);
		tryEditor.clickRunTryHere();
		} else {
			LoggerLoad.error("Test data not found for: " + codeValidationsType);
			throw new RuntimeException ("Test data not found for:" + codeValidationsType);
		 } 
	   }

	@Then("user view message {string} for {string} treeSubPage with code {string}")
	public void user_view_message_for_tree_sub_page_with_code(String message, String treeSubPage, String codeValidationsType) {
		LoggerLoad.info("Verifying output message for page: " + treeSubPage + ", validation: " + codeValidationsType);

       String expectedTestData = null;
		
		for(Map<String, String> row: testData) {
			String pageTestData = row.get("treeSubPage");
			String validationTestData = row.get("codeValidations");
			
			if(treeSubPage.equalsIgnoreCase(pageTestData)&&
			   codeValidationsType.equalsIgnoreCase(validationTestData)) {
				expectedTestData = row.get("expectedResults");	
				break;
			   }
		     }
		
		 String actualMsg = CommonMethods.getAlertText(driver);
		
		 if(actualMsg == null) {
	        if (tryEditor.isOutputSuccess()) {  // No alert- should be successful output scenario
				 LoggerLoad.info("Success output shown as expected: " + expectedTestData);
	        	 assertTrue(tryEditor.isOutputSuccess(),"Success output shown as expected: " + expectedTestData);
	        } else {  
				LoggerLoad.error("No alert and no output found.");
	        	assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedTestData);}
	    } else if (expectedTestData != null) {
			LoggerLoad.info("Comparing alert: expected='" + expectedTestData + "', actual='" + actualMsg + "'");
		    assertTrue(actualMsg.contains(expectedTestData),
			        "Expected alert message to contain '" + expectedTestData + "' but got '" + actualMsg + "'");
			} else {
				LoggerLoad.error("Alert message was received, but expected message was null.");
			    assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
			  } 
	    }
	
	@When("User clicks on tree Practice Questions link")
	public void user_clicks_on_tree_practice_questions_link() {
		LoggerLoad.info("User clicks on Practice Questions link");
		tryEditor.clickPracticeQnsLink();
	}
	@Then("User is redirected to tree practice page")
	public void user_is_redirected_to_tree_practice_page() {
	  String expectedResult = "Practice Questions";
	  String actualResult = driver.getTitle();
	  LoggerLoad.info("Verifying redirection to Practice Questions page. Page title: " + actualResult);
	  assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	  }
	
	@Then("the user able to view the tree questions page")
	public void the_user_able_to_view_the_tree_questions_page() {
		LoggerLoad.info("Validating practice questions are displayed");
		boolean isDisplayed = tryEditor.isPraticeQnsLinksDisplayed();	    
	    assertTrue(isDisplayed, "Practice questions are not displayed");
	   }
}