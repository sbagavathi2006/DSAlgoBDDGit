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
	}
	
	@Given("User is on {string} page after clicking its link in the Tree Page")
	public void user_is_on_page_after_clicking_its_link_in_the_tree_page(String string) {
		 treePage = landPage.treeGetStartBtnClick();
	}

	@When("user click the {string} tree link")
	public void user_click_the_tree_link(String treeSubPage ) {
		tryEditor = treePage.clickTreeSubLinks(treeSubPage);
	    	}
	
	@Then("user can see tree Try here button")
	public void user_can_see_tree_try_here_button(){
		tryEditor.isTryHereBtnDisplayed();
	}
	
	@Given("User is on the {string} tree subpage")
	public void user_is_on_the_tree_subpage(String treeSubPage) {
		tryEditor = treePage.clickTreeSubLinks(treeSubPage);
	   	}

	@When("the user click tree Try here button")
	public void the_user_click_tree_try_here_button() {
		tryEditor.clickTryHereBtn();
	}

	@Then("the user should redirected to the tryEditor tree page")
	public void the_user_should_redirected_to_the_try_editor_tree_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	    	}
	
	@Then("The user should able to see tree Run button")
	public void the_user_should_able_to_see_tree_run_button() {
		tryEditor.isRunBtnDisplayed();
	   	}


	@Given("user is on tryeditor page for {string}")
	public void user_is_on_tryeditor_page_for(String treeSubPage) {
		tryEditor = treePage.clickTreeSubLinks(treeSubPage);
		tryEditor.clickTryHereBtn();
	    
	}

	@When("user click Run button for {string} treeSubPage with code {string}")
	public void user_click_run_button_for_tree_sub_page_with_code(String treeSubPage, String codeValidationsType) {
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
		tryEditor.writeCode(codeTestData);
		tryEditor.clickRunTryHere();
		} else {
			throw new RuntimeException ("Test data not found for:" + codeValidationsType);
		} 
	}

	@Then("user view message {string} for {string} treeSubPage with code {string}")
	public void user_view_message_for_tree_sub_page_with_code(String message, String treeSubPage, String codeValidationsType) {
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
	            System.out.println("Success output shown as expected: " + expectedTestData);
	        } else {  assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedTestData);}
	    } else if (expectedTestData != null) {
		    assertTrue(actualMsg.contains(expectedTestData),
			        "Expected alert message to contain '" + expectedTestData + "' but got '" + actualMsg + "'");
			} else {
			    assertTrue(false, "Test failed: Alert message was received, but expected message was null.");
			} 
	}
	
	@When("User clicks on tree Practice Questions link")
	public void user_clicks_on_tree_practice_questions_link() {
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to tree practice page")
	public void user_is_redirected_to_tree_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}
	
	//@Then("the user able to view the tree questions")
	//public void the_user_able_to_view_the_tree_questions() {
	//treePage.istreequestonsdisplayed();
	   //}

}