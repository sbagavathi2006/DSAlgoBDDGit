package stepdefinition;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

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
import pagefactory.RegisterPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import webdriver.DriverFactory;

public class RegisterStep {
	
	private WebDriver driver = DriverFactory.getDriver(); 
	private DSAlgoPortalPage portalPage = new DSAlgoPortalPage(driver);
    private HomePage homePage = new HomePage(driver);
    private RegisterPage registerPage = new RegisterPage(driver);
    Properties prop = new Properties();
	
	private List<Map<String, String>> testData;
	private static final String sheetName ="DSAlogRegister";

    public RegisterStep() {
		this.prop = new ConfigReader().init_prop();
        String filePath = prop.getProperty("excelTestdataPath");
        ExcelReader reader = new ExcelReader(filePath);
        testData = reader.getDataAll(sheetName);
        LoggerLoad.info("Excel data loaded for Register from sheet: " + sheetName);
	 }
	
	@Given("user is in Register page after clicking register in home page")
	public void user_is_in_register_page_after_clicking_register_in_home_page() {
		LoggerLoad.info("Navigating to Register page through Home page");
		portalPage.getStartedBtnClick();
        homePage.RegisterLinkClick();
    }

    @When("user enters login button on registration page")
	public void user_enters_login_button_on_registration_page() {
		LoggerLoad.info("Clicking Sign In button on Registration page");
		registerPage.clickSignInButton();
    }

	@Then("user should redirected to login page")
	public void user_should_redirected_to_login_page() {
		  String signinpagetitle = registerPage.getSignInPageTitle();
		  LoggerLoad.info("Validating navigation to Login page. Actual title: " + signinpagetitle);
		  Assert.assertTrue(signinpagetitle.contentEquals("Login"));
		  }
	
	
	@When("User clicks Register button with username and password and confirm password for validation {string}")
    public void user_clicks_register_button_with_username_and_password_and_confirm_password_for_validation(String validation) {
		LoggerLoad.info("Filling registration form with validation type: " + validation);

		String usernameTestData = null;
        String passwordTestData = null;
        String confirmpasswordTestData = null;
        
        for( Map<String, String> row : testData) {
        	String validationTestData = row.get("validation");
        	 
        	if(validation.equalsIgnoreCase(validationTestData)) {
        		usernameTestData = row.get("username");
        		passwordTestData = row.get("password");
        		confirmpasswordTestData = row.get("confirmpassword");
        		break;
        	      }
            }
       if(usernameTestData !=null || passwordTestData !=null || confirmpasswordTestData !=null) {
			LoggerLoad.info("Entering Username: " + usernameTestData + ", Password: " + passwordTestData + ", ConfirmPassword: " + confirmpasswordTestData);

           registerPage.enterUsername(usernameTestData);
           registerPage.enterPassword(passwordTestData);
           registerPage.enterConfirmPassword(confirmpasswordTestData);
           registerPage.clickRegisterButton();
               }
         }

   @Then("User gets corresponding messages for register validation {string}")
   public void user_gets_corresponding_messages_for_register_validation(String validation) {
		 LoggerLoad.info("Verifying messages for validation type: " + validation);

         String messageTestData = null;
    	 String usernameTestData = null;
         String passwordTestData = null;
         String confirmpasswordTestData = null;
         
         for( Map<String, String> row : testData) {
         	String validationTestData = row.get("validation");
         	
         	if(validation.equalsIgnoreCase(validationTestData)) {
         		messageTestData = row.get("message");
        		usernameTestData = row.get("username");
        		passwordTestData = row.get("password");
        		confirmpasswordTestData = row.get("confirmpassword");
        		System.out.println(messageTestData);
        		break;
                    }  
	             }
               String currentUrl = driver.getCurrentUrl();
              if(usernameTestData.isEmpty()) {
            	     //empty user
                  String alertMessage = registerPage.getEmptyUsernameAlertMsg();
      			  LoggerLoad.info("Empty Username Alert: " + alertMessage);
               	  assertTrue(alertMessage.contains(messageTestData), "Expected success message'" + messageTestData + "' but got '" + alertMessage + "'");	
               }else if(passwordTestData.isEmpty()) {
            		
               	   //registration failed due to empty passowrd
        	      String alertMesssage = registerPage.getEmptyPasswordAlertMsg();
      			  LoggerLoad.info("Empty Password Alert: " + alertMesssage);
        	      assertTrue(alertMesssage.contains(messageTestData), "Expected success message'" + messageTestData + "' but got '" + alertMesssage + "'");
               }else if(confirmpasswordTestData.isEmpty()) {
            		
            		//empty confirm password
            	  String alertMessage = registerPage.getEmptyConfirmPasswordAlertMsg();
      			  LoggerLoad.info("Empty Confirm Password Alert: " + alertMessage);
                  assertTrue(alertMessage.contains(messageTestData), "Expected success message'" + messageTestData + "' but got '" + alertMessage + "'");		
               }else if(currentUrl.contains("register")) {
        	  
        	         //register failed due to the mismatch password error
        	       String errorMessage = registerPage.getMismatchPasswordError();
       			   LoggerLoad.info("Error message for mismatch password: " + errorMessage);
         	       assertTrue(errorMessage.equalsIgnoreCase(messageTestData),
         	       "Expected error message '" + messageTestData + "' but got '" + errorMessage + "'");
               }else if(currentUrl.contains("register")){
        	  
                    //register shortpassword error
                  String errorMessage = registerPage.getMismatchPasswordError();
         		  LoggerLoad.info("Error message for short password: " + errorMessage);
        	      assertTrue(errorMessage.equalsIgnoreCase(messageTestData),
        	     "Expected error message '" + messageTestData + "' but got '" + errorMessage + "'");
               }else if(currentUrl.contains("register")){
              
            	   //numaric password error
            	  String errorMessage = registerPage.getMismatchPasswordError();
       			  LoggerLoad.info("Error message for numeric password: " + errorMessage);
            	  assertTrue(errorMessage.equalsIgnoreCase(messageTestData),
            	  "Expected error message '" + messageTestData + "' but got '" + errorMessage + "'");	  
               }else{
       			     LoggerLoad.error("No matching validation condition found for: " + validation);
                	 fail("No error,alert,or success message found.");
                 }
                	 
                 }

   @When("User clicks on register button with valid credentials {string}")
   public void user_clicks_on_register_button_with_valid_credentials(String validation) {
		LoggerLoad.info("Submitting registration with valid credentials for validation: " + validation);

	  for (Map<String, String> data : testData) {
	        if (data.get("validation").equalsIgnoreCase(validation)) {
	            String username = data.get("username");
	            String password = data.get("password");
	            String confirmpassword = data.get("confirmpassword");

	             // Handle dynamic username generation
	            if (validation.equalsIgnoreCase("ValidCredential")) {
	                username = username + System.currentTimeMillis();  // Makes username unique
					LoggerLoad.info("Generated dynamic username: " + username);	                
	              }

	            registerPage.enterUsername(username);
	            registerPage.enterPassword(password);
	            registerPage.enterConfirmPassword(confirmpassword);
	            registerPage.clickRegisterButton();

	            break;
	              }
	            }
	        }
  
   	
  @Then("User can see the register logged in user name for valid credentials {string}")
  public void user_can_see_the_register_logged_in_user_name_for_valid_credentials(String validation) {
   	for (Map<String, String> data : testData) {
           if (data.get("validation").equalsIgnoreCase(validation)) {
               String expectedUsername = data.get("username");
               String displayedUser = registerPage.userId(); // you must implement this
				LoggerLoad.info("Expected username: " + expectedUsername + ", Displayed username: " + displayedUser);
               assertTrue(displayedUser.contains(expectedUsername), "Logged-in user is displayed correctly");
               break;
                   }
                }
         }

  @Then("user should be redirected to Home Page")
   public void user_should_be_redirected_to_home_page() {
		String msg = registerPage.getsuccessmsg();
	    String userid = registerPage.userId();
		LoggerLoad.info("Success message: " + msg);
		Assert.assertEquals(msg, ("New Account Created. You are logged in as "+ userid.toLowerCase()));
	         }
	   }
