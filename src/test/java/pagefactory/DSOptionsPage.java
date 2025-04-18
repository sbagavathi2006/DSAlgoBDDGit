package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DSOptionsPage {
	
private WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(), \"Asxcvb\")]") 
	private WebElement loggedInUserName;
	
	@FindBy(xpath = "//a[contains(text(), \"Sign out\")]") 
	private WebElement signout;
	
	@FindBy(xpath = "//div[contains(text(), \"You are logged in\")]") 
	private WebElement loginSuccessAlert;
	
	@FindBy(xpath = "//a[@href=\"data-structures-introduction\"]") 
	private WebElement dsIntroGetStartBtn;
	
	@FindBy(xpath = "//a[@href=\"array\"]") 
	private WebElement arrayGetStartBtn;
	
	@FindBy(xpath = "//a[@href=\"linked-list\"]") 
	private WebElement linkedListGetStartBtn;
	
	@FindBy(xpath = "//a[@href=\"stack\"]") 
	private WebElement stackGetStartBtn;
	
	@FindBy(xpath = "//a[@href=\"queue\"]") 
	private WebElement queueGetStartBtn;
	
	@FindBy(xpath = "//a[@href=\"tree\"]") 
	private WebElement treeGetStartBtn;
	
	@FindBy(xpath = "//a[@href=\"graph\"]") 
	private WebElement graphGetStartBtn;
	
	public DSOptionsPage (WebDriver driver) {
		this.driver = driver; // Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); //initialize all the WebElements that are annotated with @FindBy
	}
	
	public boolean getLoginSuccessMsg() {
		return loginSuccessAlert.isDisplayed();
	}
	public String getNumpyNinjaPageTitle() {
		return driver.getTitle();
	}
	
	// Generic method to click on "Getting Started" button based on panel name
		public void clickGettingStartedForPanel(String panelName) {
			switch (panelName.trim().toLowerCase()) {
				case "data-structures-introduction":
					dsIntroGetStartBtn.click();
					break;
				case "array":
					arrayGetStartBtn.click();
					break;
				case "linked-list":
					linkedListGetStartBtn.click();
					break;
				case "stack":
					stackGetStartBtn.click();
					break;
				case "queue":
					queueGetStartBtn.click();
					break;
				case "tree":
					treeGetStartBtn.click();
					break;
				case "graph":
					graphGetStartBtn.click();
					break;
				default:
					throw new IllegalArgumentException("Invalid panel name: " + panelName);
			}
		}
	
	public void dsIntroGetStartBtnClick() {
		dsIntroGetStartBtn.click();
	}
	
	public void arrayGetStartBtnClick() {
		arrayGetStartBtn.click();
	}
	
	public void linkedListGetStartBtnClick() {
		linkedListGetStartBtn.click();
	}
	
	public void stackGetStartBtnClick() {
		stackGetStartBtn.click();
	}
	
	public void queueGetStartBtnClick() {
		queueGetStartBtn.click();
	}
	
	public void treeGetStartBtnClick() {
		treeGetStartBtn.click();
	}
	
	public void graphGetStartBtnClick() {
		graphGetStartBtn.click();
	}
	
	
	//Important: add getTitle method for each page for page-redirection validation.
}
