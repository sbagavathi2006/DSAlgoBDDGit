package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(), \"Sign in\")]") WebElement signInLink;
	
	public HomePage (WebDriver driver) {
		this.driver = driver; // Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); //initialize all the WebElements that are annotated with @FindBy
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean isSignInLinkDisplayed() {
		return signInLink.isDisplayed();
	}
	
	public void signInLinkClick() {
		signInLink.click();
	}
	
	   // Method to click on any link by its text
    public void clickLink(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText)); // Find the link by its text
        link.click(); // Click the link
    }
	
}
