package pagefactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//button[@class='btn']")
	WebElement getStartedBtn;
	
	@FindBy(xpath ="//a[@href='/register']")
	WebElement RegisterLink;
	
	@FindBy(xpath = "//input[@name='username']")
	 WebElement Username_field;
	
	@FindBy(xpath = "//input[@name='password1']")
	WebElement Password_field;
	
	@FindBy(xpath = "//input[@name='password2']")
	WebElement Confirm_password;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Register']")
	WebElement Registerbutton;
	
	@FindBy(xpath = "//a[@href='/login']")
	WebElement  Login_registration;
	
	@FindBy(xpath = "//div[contains(@class, 'alert') and @role='alert']")
	WebElement errormsg_register;
	
	//@FindBy(xpath = " //*[@id=\"navbarCollapse\"]/div[2]/ul/a[2]")
	//WebElement userId;
	@FindBy(xpath = "//div[@class='alert alert-primary']") 
	private WebElement loggedInUserElement;
	
	@FindBy(xpath = "//div[contains(text(), 'New Account Created')]")
	WebElement NewAccountCreated;
	
	
	
    public RegisterPage(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	      }
	 
    public void clickRegisterButton() {
	   Registerbutton.click();
	     }
    
    public void clickSignInButton() {
	   Login_registration.click();
	     }
    
    public String getSignInPageTitle() {
	   return driver.getTitle();
	     }
    
    public void clickRegisterWithEmptyFields() {
       Registerbutton.click();
	     }
    
    public boolean getAlertForEmptyField() {
	   return Registerbutton.getDomAttribute("required") != null;
		 }
    
    public void enterUsername(String username) {
	   getUsername_field().clear();
	   getUsername_field().sendKeys(username);
	       }
    
    public void enterPassword(String password) {
	   getPassword_field().clear();
	   getPassword_field().sendKeys(password);
	     }

    public void enterConfirmPassword(String confirmPassword) {
	   getConfirm_password().clear();
	   getConfirm_password().sendKeys(confirmPassword);
	      }
    
    public void registerWithMismatchedPassword(String password,String confirmpassword) {
	   getPassword_field().sendKeys(password);
	   getConfirm_password().sendKeys(confirmpassword);
	   Registerbutton.click();
	      }
    
    public String getMismatchPasswordError() {
	   return errormsg_register.getText();
	     }
    
    public String getNumericPasswordError() {
	   return errormsg_register.getText();
	      }

    public void PasswordWithNumericdata(String username, String password,String confirmpassword) {
	    getUsername_field().sendKeys(username);
	    getPassword_field().sendKeys(password);
	    getConfirm_password().sendKeys(confirmpassword);
	       }
    
    public String getShortPasswordError() {
	   return errormsg_register.getText();
	     }
    
    public void registerWithPasswordlength(String username, String password,String confirmpassword) {
	   getUsername_field().sendKeys(username);
	   getPassword_field().sendKeys(password);
	   getConfirm_password().sendKeys(confirmpassword);
	     }
    
    public String userId() {
    	return loggedInUserElement.getText();
	      }
    
    public String getAlertMessage() {
	 try {
	   WebElement alertMessage = null;
       wait.until(ExpectedConditions.visibilityOf(alertMessage));
	   return alertMessage.getText();
	      } catch (Exception e) {
	      return "alert message found";
	         }
	     }
 
    public boolean isAccountCreatedMessageDisplayed() {
	   return NewAccountCreated.isDisplayed();
	     }

    public WebElement getPassword_field() {
	   return Password_field;
	     }

    public WebElement getUsername_field() {
	    return Username_field;
	       }

    public WebElement getConfirm_password() {
	   return Confirm_password;
		  }
    
    public boolean isAlertForEmptyPasswordDisplayed() {
	   return Password_field.getDomAttribute("required") !=null;
		  }
    
	public String getEmptyPasswordAlertMsg() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
         String validationMsg = (String) js.executeScript(
         "return arguments[0].validationMessage;", Password_field);
             return validationMsg;
                }
	
	public boolean isAlertForEmptyUsernameDisplayed() {
		return Username_field.getDomAttribute("required") != null;
		   }
	
	public String getEmptyUsernameAlertMsg() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String validationMsg = (String) js.executeScript(
	     "return arguments[0].validationMessage;", Username_field);
	       return validationMsg;
		      }
	
	public boolean isAlertForEmptyConfirmPasswordDisplayed() {
	   return Confirm_password.getDomAttribute("required") != null;
		  }
	
	public String getEmptyConfirmPasswordAlertMsg() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String validationMsg = (String) js.executeScript(
	    "return arguments[0].validationMessage;", Confirm_password);
	     return validationMsg;
	          }
	
     public String getsuccessmsg() {
		return NewAccountCreated.getText();
		}

   }


