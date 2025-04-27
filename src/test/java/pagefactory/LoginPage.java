package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(id = "id_username") 
	private WebElement userNameSignIn;
	@FindBy(id = "id_password") 
	private WebElement pwdSignIn;
	@FindBy(xpath = "//input[@value='Login']") 
	private WebElement loginBtnClick;
	@FindBy(xpath = "//div[contains(text(), 'Invalid Username and Password')]") 
	private WebElement loginErrMsg;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver; // Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); //initialize all the WebElements that are annotated with @FindBy
	}
	
	public void enterUserName(String userName) {
		userNameSignIn.clear();
		userNameSignIn.sendKeys(userName);
	}
	
	public void enterPwd(String password) {
		pwdSignIn.clear();
		pwdSignIn.sendKeys(password);
	}
	
	public DSOptionsPage loginBtnClick() {
		loginBtnClick.click();
		return new DSOptionsPage(driver);
	}
	
	public String getErrMsg() {
		return loginErrMsg.getText();
	}
	
	public boolean getAlertForEmptyUsernameField() {
		return userNameSignIn.getDomAttribute("required") != null;
	}
	
	public boolean getAlertForEmptyPasswordField() {
		return pwdSignIn.getDomAttribute("required") != null;
	}
}
