package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	private WebDriver driver; //instance variable
	
	 @FindBy(xpath = "//a[@href='/logout']")
     private WebElement signoutBtn;	

	public LogoutPage(WebDriver driver) {
		this.driver = driver; //driver is passed from hooks class which is assigned with page class driver 
        PageFactory.initElements(driver, this);	

}

 
   public void signoutBtnclick() {
      signoutBtn.click();
  }


public String getHomePageTitle() {
	return driver.getTitle();
}

}
