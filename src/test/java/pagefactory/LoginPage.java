package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(id = "id_username") WebElement userNameSignIn;
	@FindBy(id = "id_password") WebElement pwdSignIn;
	@FindBy(xpath = "//input[@value=\"Login\"]") WebElement loginBtnClick;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver; // Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); //initialize all the WebElements that are annotated with @FindBy
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUserName() {
		userNameSignIn.clear();
		userNameSignIn.sendKeys("asxcvb");
	}
	
	public void enterPwd() {
		pwdSignIn.clear();
		pwdSignIn.sendKeys("greenHorn@2024");
	}
	
	public void loginBtnClick() {
		loginBtnClick.click();
	}
}
