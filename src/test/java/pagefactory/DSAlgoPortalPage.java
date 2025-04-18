package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DSAlgoPortalPage {
	
	private WebDriver driver; //instance variable
	
	@FindBy(className = "btn" ) WebElement getStartedBtn;
	
	//class constructor
	public DSAlgoPortalPage(WebDriver driver) {
		this.driver = driver; //driver is passed from hooks class which is assigned with page class driver 
        PageFactory.initElements(driver, this);
	}
	
	public void getStartedBtnClick() {
		getStartedBtn.click();
	}

}
