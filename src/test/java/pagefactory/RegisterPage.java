package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	@FindBy(xpath = " //*[@id=\"navbarCollapse\"]/div[2]/ul/a[2]")
	WebElement userId;
	
	@FindBy(xpath = "//div[contains(text(), 'New Account Created')]")
	WebElement NewAccountCreated;
	
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public void getStartedBtnclick() {
	        getStartedBtn.click();
	    }
	 
	 public void clickRegisterLink() {
		 RegisterLink.click();
	 }
	 
	 public void clickRegisterButton() {
		    Registerbutton.click();
		}
	 public void clickSignInButton() {
	    	Login_registration.click();
	    }

	    public String getSignInPageTitle() {
	    	//Login_registration.click();
	        return driver.getTitle();
	    }
		
        public void clickRegisterWithEmptyFields() {
	        Registerbutton.click();
	    }

	    public boolean isUsernameFieldRequired() {
	        return getUsername_field().getDomAttribute("required") != null;
	    }
	    public boolean getAlertForEmptyField() {
			return Registerbutton.getDomAttribute("required") != null;
		}
	    
	    public String getPasswordFieldValidationMessage() {
	        return getPassword_field().getAttribute("validationMessage");
	    }
	    public String getUsernameFieldValidationMessage() {
			return Username_field.getAttribute("getUsernameValidationMessage");
		}
	    public String getRegisterValidationMessage() {
	        return Registerbutton.getAttribute("getRegisterValidationMessage");
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

	    public String MismatchPasswordError() {
	       return errormsg_register.getText();
	    	
	    }

	    public void PasswordWithNumericdata(String username, String password,String confirmpassword) {
	        getUsername_field().sendKeys(username);
	        getPassword_field().sendKeys(password);
	        getConfirm_password().sendKeys(confirmpassword);
	    }

	    public void registerWithPasswordlength(String username, String password,String confirmpassword) {
	        getUsername_field().sendKeys(username);
	        getPassword_field().sendKeys(password);
	        getConfirm_password().sendKeys(confirmpassword);
	    }

	    public void enterInvalidUsername(String username) {
	        getUsername_field().sendKeys(username);
	    }

	    public void registerWithValidDetails() {
	        String dynamicUsername = "numpynin" + System.currentTimeMillis();
	        getUsername_field().sendKeys(dynamicUsername);
	        getPassword_field().sendKeys("Time4team$");
	        getConfirm_password().sendKeys("Time4team$");
	        Registerbutton.click();
	    }

	    public String getLoggedInUserId() {
	        return userId.getText();
	   }
	    public String userId() {
	    	return userId();
	    }

		public boolean getalertmessage() {
			WebElement usermsg=null;
			boolean isrequired = usermsg.getDomAttribute("required") != null;
			return isrequired;
		}
		
         public boolean isAccountCreatedMessageDisplayed() {
		    return NewAccountCreated.isDisplayed();
		}

		public String getErrorMessage() {
		 return errormsg_register.getText();
		}
		/*public String getSuccessRegistrationMessage() {
		    return errormsg_register.getText();
		}*/

		public String getsuccessmsg() {
			return getsuccessmsg() ;
			//return NewAccountCreated.getText();
		}

		public WebElement getPassword_field() {
			return Password_field;
		}

		public void setPassword_field(WebElement password_field) {
			Password_field = password_field;
		}

		public WebElement getUsername_field() {
			return Username_field;
		}

		public void setUsername_field(WebElement username_field) {
			Username_field = username_field;
		}

		public WebElement getConfirm_password() {
			return Confirm_password;
		}

		public void setConfirm_password(WebElement confirm_password) {
			Confirm_password = confirm_password;
		}

		public boolean getalertforemptypasswordfield() {
			return Registerbutton.getDomAttribute("required") != null;
		}

		public String getPasswordFieldErrorMessage() {
		
			return Password_field.getText();
		}

}
		


