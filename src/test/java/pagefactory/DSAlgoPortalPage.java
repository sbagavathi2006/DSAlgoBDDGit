package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

public class DSAlgoPortalPage {
	
	private WebDriver driver; 	//instance variable
	
	@FindBy(className = "btn" ) 
	private WebElement getStartedBtn;
	
	public DSAlgoPortalPage(WebDriver driver) {
		this.driver = driver; 	//driver is passed from hooks class which is assigned with page class driver 
        PageFactory.initElements(driver, this);
	}
	
	public void getStartedBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, getStartedBtn);
		getStartedBtn.click();
	}

	public HomePage doGetStart() {
        CommonMethods.waitForElementToBeVisible(driver, getStartedBtn);
		getStartedBtn.click();
		return new HomePage(driver); 	//Passing the driver to HomePage as part of redirection
	}
}
