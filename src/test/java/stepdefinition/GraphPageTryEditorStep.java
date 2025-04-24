package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSOptionsPage;
import pagefactory.GraphPage;
import pagefactory.GraphPageTryEditorPage;
import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.ExcelReader;
import webdriver.DriverFactory;

public class GraphPageTryEditorStep {
	
	
	private WebDriver driver = DriverFactory.getDriver();	
	private DSOptionsPage landPage = new DSOptionsPage(driver);
	private GraphPage graphPage = new GraphPage(driver);
	private GraphPageTryEditorPage tryEditor;
	Properties prop = new Properties();
	
	private String filePath;
	private String sheetName = "GraphTryEditor";
	private String codeKey;
	private String expectedMsg;
	
	public GraphPageTryEditorStep() {
		this.prop = new ConfigReader().init_prop();
        this.filePath = prop.getProperty("excelTestdataPath");
	}
	
	@Given("User is on {string} page after clicking its link in the Graph Page")
	public void user_is_on_page_after_clicking_its_link_in_the_graph_page(String string) {
		graphPage = landPage.graphGetStartBtnClick();
	}

	@When("User click the {string} graph link")
	public void user_click_the_graph_link(String graphSubPage) {
		tryEditor = graphPage.clickGraphPageLinks(graphSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}
	
	@Then("User can see graph Try here button")
	public void user_can_see_graph_try_here_button(){
		tryEditor.isTryHereBtnDisplayed();
	}

	@Given("User is on the {string} graph subpage")
	public void user_is_on_the_graph_subpage(String graphSubPage){
		tryEditor = graphPage.clickGraphPageLinks(graphSubPage);  //Assign tryEditor here which is initialized in the ArrayPage class 
	}	
	
	@When("User click graph Try here button")
	public void user_click_graph_try_here_button(){
		tryEditor.clickTryHereBtn();
	}
	
	@Then("User redirected to the tryEditor graph page")
	public void user_redirected_to_the_try_editor_graph_page() {
		String expectedResult = "Assessment";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.equals(expectedResult),"User is not in the tryeditor page");
	}
	
	@Then("User able to see graph Run button")
	public void user_able_to_see_graph_run_button() {
		tryEditor.isRunBtnDisplayed();
	}

	@Given("User is on graph Try Editor page for row {int}")
	public void user_is_on_graph_try_editor_page_for_row(Integer rowNum) {
		Map<String, String> rowData = ExcelReader.getData(sheetName, rowNum, filePath);
		String graphSubPageKey = rowData.get("graphSubPage");
		tryEditor = graphPage.clickGraphPageLinks(graphSubPageKey);
		tryEditor.clickTryHereBtn();
	}
	
	@When("User clicks on graph Run button for row {int} graph")
	public void user_clicks_on_graph_run_button_for_row_graph(Integer rowNum) {
		Map<String, String> rowData = ExcelReader.getData(sheetName, rowNum, filePath);
		codeKey = rowData.get("code");
		tryEditor.writeCode(codeKey);
		tryEditor.clickRunTryHere();
	}
	
	@Then("User should see results for graph for row {int} graph")
	public void user_should_see_results_for_graph_for_row_graph(Integer rowNum) {
		Map<String, String> rowData = ExcelReader.getData(sheetName, rowNum, filePath);
		expectedMsg = rowData.get("expectedResults");
		String actualMsg = CommonMethods.getAlertText(driver, 3);
		
		if(actualMsg == null) {
	        if (tryEditor.isOutputSuccess()) {  // No alert- should be successful output scenario
	            System.out.println("Success output shown as expected: " + expectedMsg);
	        } else {  assertTrue(false, "Test failed: No alert appeared and no output was displayed. Expected: " + expectedMsg);}
	    } else { // Alert exists, check for NameError or SyntaxError		
            assertTrue(actualMsg.contains(expectedMsg),
                "Expected alert message to contain '" + expectedMsg + "' but got '" + actualMsg + "'");
        } 	     
	}	
	
	@When("User clicks on graph Practice Questions link")
	public void user_clicks_on_graph_practice_questions_link() {
		tryEditor.clickPracticeQnsLink();
	}

	@Then("User is redirected to graph practice page")
	public void user_is_redirected_to_graph_practice_page() {
		String expectedResult = "Practice Questions";
		String actualResult = driver.getTitle();
		assertTrue(actualResult.contains(expectedResult), " User is not on the practice Page");
	}

}
