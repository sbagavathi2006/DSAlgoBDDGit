package stepdefinition;

import static org.testng.Assert.assertTrue;

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
import webdriver.DriverFactory;


public class ArrayPageTryEditorStep {
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private ArrayPage arrayPage = new ArrayPage(driver);
	private ArrayPageTryEditorPage tryEditor;
	Properties prop = new Properties();
	
	private String filePath;
	private String sheetName = "ArrayTryEditor";
	private String codeKey;
	private String expectedMsg;

	
	public ArrayPageTryEditorStep() {
		this.prop = new ConfigReader().init_prop();
        this.filePath = prop.getProperty("excelTestdataPath");
	}
	
	@Given("User is on {string} page after clicking its link in the Array Page")
	public void user_is_on_page_after_clicking_its_link_in_the_array_page(String string) {
			arrayPage = landPage.arrayGetStartBtnClick();
	}

	@When("User click the {string} link")
	public void user_click_the_link(String arraySubPages){
		tryEditor = arrayPage.clickArrayPageLinks(arraySubPages);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}
	
	@Then("User can see view Try here button")
	public void user_can_see_view_try_here_button(){
		tryEditor.isTryHereBtnDisplayed();
	}
	
	@Given("User is on the {string} arraysubpage")
	public void user_is_on_the_arraysubpage(String arraySubPages) {
		tryEditor = arrayPage.clickArrayPageLinks(arraySubPages);
	}
	
	@When("User click the Try here button")
	public void user_click_the_try_here_button(){
		tryEditor.clickTryHereBtn();
	}
		
	@Then("User redirected to the tryEditor page")
	public void user_redirected_to_the_try_editor_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	}

	@Then("User able to see Run button")
	public void user_able_to_see_run_button() {
		tryEditor.isRunBtnDisplayed();
	}

	
	@Given("User is on Try Editor page for row {int}")
	public void user_is_on_try_editor_page_for(int rowNum){
		Map<String, String> rowData = ExcelReader.getData(sheetName, rowNum, filePath);
		String arraySubPageKey = rowData.get("arraySubPage");
		tryEditor = arrayPage.clickArrayPageLinks(arraySubPageKey);
		tryEditor.clickTryHereBtn();
	}

	@When("User clicks on Run button for row {int}")
	public void user_clicks_on_run_button_for_row(int rowNum) {
		Map<String, String> rowData = ExcelReader.getData(sheetName, rowNum, filePath);
		codeKey = rowData.get("code");
		tryEditor.writeCode(codeKey);
		tryEditor.clickRunTryHere();
	}

	@Then("User should see for row {int}")
	public void user_should_see_for_row(int rowNum) {
		Map<String, String> rowData = ExcelReader.getData(sheetName, rowNum, filePath);
		expectedMsg = rowData.get("expectedResults");
		String actualMsg = CommonMethods.getAlertText(driver);
		
		if(actualMsg == null) {
	        if (tryEditor.isOutputSuccess()) {  // No alert- should be successful output scenario
	            System.out.println("Success output shown as expected: " + expectedMsg);
	        } else {  assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedMsg);}
	    } else { // Alert exists, check for NameError or SyntaxError		
            assertTrue(actualMsg.contains(expectedMsg),
                "Expected alert message to contain '" + expectedMsg + "' but got '" + actualMsg + "'");
        } 	     
	}

	@When("User clicks on Practice Questions link")
	public void user_clicks_on_practice_questions_link() {
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to practice page")
	public void user_is_redirected_to_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}

}
