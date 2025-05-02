package stepdefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.DSAlgoPortalPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.RegisterPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import webdriver.DriverFactory;

public class RegisterStep {
	
	private WebDriver driver = DriverFactory.getDriver(); 
	private DSAlgoPortalPage portalPage = new DSAlgoPortalPage(driver);
    private HomePage homePage = new HomePage(driver);
    private RegisterPage registerPage = new RegisterPage(driver);
    Properties prop = new Properties();
	private String error;
	
	private static List<Map<String, String>> testData;
	private static final String sheetName ="DSAlgoRegister";
	private static final String filePath = "src/test/resources/testdata/DSAlgoRegister.xlsx";


	public RegisterStep() {
		this.prop = new ConfigReader().init_prop();
       //String filePath = prop.getProperty("excelTestdataPath");
        ExcelReader reader = new ExcelReader(filePath);
        testData = reader.getDataAll(sheetName);
	}
	
	@Given("user is in Register page after clicking register in home page")
	public void user_is_in_register_page_after_clicking_register_in_home_page() {
		portalPage.getStartedBtnClick();
        homePage.RegisterLinkClick();
        }

	@When("user name and passsword filed will be empty and then click on register")
	public void user_name_and_passsword_filed_will_be_empty_and_then_click_on_register() {
		registerPage.clickRegisterWithEmptyFields();
	}
	
	@Then("user see the error message {string} appears below the Username textbox")
	public void user_see_the_error_message_appears_below_the_username_textbox(String expectedMessage) {
	    //String actualMessage = registerPage.getUsernameValidationMessage();
	    //System.out.println("Validation message: " + actualMessage);
	    //Assert.assertEquals(actualMessage, expectedMessage, "Username validation message mismatch!");
		String actualError = registerPage.getUsernameFieldValidationMessage();
        Assert.assertEquals(actualError, "Please fill out this field.");
	}

   @When("the user enters a Username {string} leaves the Password {string} and Confirm Password {string} fields empty and clicks the Register button")
	public void user_enters_username_and_leaves_password_and_confirm_password_empty(String username, String password, String confirmPassword) {
		registerPage.enterUsername(username);
	    registerPage.enterPassword(password);           // Should be empty
	    registerPage.enterConfirmPassword(confirmPassword); // Should be empty
	    registerPage.clickRegisterButton();                   // Attempt to submit form
	}
	
	
	@Then("the error message {string} appears below the Password textbox")
	public void error_message_appears_below_password_textbox(String expectedMessage) {
	   String actualMessage = registerPage.getPasswordFieldValidationMessage();
	    Assert.assertEquals(actualMessage, expectedMessage, "Password field validation message mismatch!");
	    
	}
	
	@When("user enters login button on registration page")
	public void user_enters_login_button_on_registration_page() {
		registerPage.clickSignInButton();
	}

	@Then("user should redirected to login page")
	public void user_should_redirected_to_login_page() {
		  String signinpagetitle = registerPage.getSignInPageTitle();
		  Assert.assertTrue(signinpagetitle.contentEquals("Login"));
	}
	@When("the user enters username {string}, password {string}, and confirm password {string} and clicks the Register button")
    public void the_user_enters_credentials_and_clicks_register(String username, String password, String confirmPassword) {
        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.clickRegisterButton();
    }

    @Then("the error message {string} should be displayed below the Confirm Password field")
    public void the_error_message_should_be_displayed(String expectedMessage) {
        String actualMessage = registerPage.getPasswordFieldValidationMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Mismatch in error message for Confirm Password field.");
    }
	
	@When("User clicks Register button with username and password and confirm password for validation {string}")
    public void user_clicks_register_button_with_username_and_password_and_confirm_password_for_validation(String validation) {
        if (testData == null) {
            ExcelReader reader = new ExcelReader(filePath);//user interactions and form submission
            testData = reader.getDataAll(sheetName);
        }
        //for(Map<String, String> row: testData) {
        Map<String, String> dataRow = testData.stream()
            .filter(row -> row.get("validation").equalsIgnoreCase(validation))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No test data found for validation: " + validation));

        String username = dataRow.get("username");
        String password = dataRow.get("password");
        String confirmPassword = dataRow.get("confirmPassword");

        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.clickRegisterButton();
    }

    @Then("User gets corresponding messages for register validation {string}")
    public void user_gets_corresponding_messages_for_register_validation(String validation) {
        String actualMessage = registerPage.getRegisterValidationMessage();//validation application responce

        Map<String, String> dataRow = testData.stream()
            .filter(row -> row.get("validation").equalsIgnoreCase(validation))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No test data found for validation: " + validation));

        String expectedMessage = dataRow.get("expectedMessage");

        Assert.assertEquals(actualMessage, expectedMessage);
    }  
	}

	