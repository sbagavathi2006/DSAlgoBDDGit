package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='NumpyNinja']")
	private WebElement numpyNinjaLink;
	@FindBy(xpath = "//a[contains(text(), 'Sign in')]") 
	private WebElement signInLink;
	@FindBy(xpath = "//a[text()='NumpyNinja' or text()='Data Structures' or normalize-space(text())='Register' or text()='Sign in']")
	private List<WebElement> homeHeaderLinks;
	@FindBy(xpath = "//a[contains(text(), 'Register')]") 
	private WebElement registerLink;
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement dsDropdown;
	@FindBy (xpath = "//div[@class='dropdown-menu show']//a")
	private List<WebElement> dsDropdownOptions;
	@FindBy (xpath = "//div[contains(text(),'You are not logged in')]")
	private WebElement msg;
	
	public HomePage (WebDriver driver) {
		this.driver = driver; // Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); //initialize all the WebElements that are annotated with @FindBy
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickNumpyNinja() {
        CommonMethods.waitForElementToBeVisible(driver, numpyNinjaLink, CommonMethods.DEFAULT_TIMEOUT);
	    numpyNinjaLink.click();
	}

	public void signInLinkClick() {
        CommonMethods.waitForElementToBeVisible(driver, signInLink, CommonMethods.DEFAULT_TIMEOUT);
		signInLink.click();
	}
	
	public boolean isHomeHeaderLinksDisplayed(String headerlink) {
		
		for(WebElement e : homeHeaderLinks) {
	        CommonMethods.waitForElementToBeVisible(driver, e, CommonMethods.DEFAULT_TIMEOUT);
			if(e.getText().trim().equalsIgnoreCase(headerlink)) {
				return e.isDisplayed();
			}
		}
		return false;
	}
			
	public void clickHeaderLink(String linkText) {
		    for (WebElement link : homeHeaderLinks) {
		        CommonMethods.waitForElementToBeVisible(driver, link, CommonMethods.DEFAULT_TIMEOUT);
		        if (link.getText().trim().equalsIgnoreCase(linkText)) {
		            link.click();
		            return;
		        }
		    }
		    throw new RuntimeException("Link text not found: " + linkText);
		}

	public void clickDataStructuresDropdown() {
        CommonMethods.waitForElementToBeVisible(driver, dsDropdown, CommonMethods.DEFAULT_TIMEOUT);
	    dsDropdown.click();
	}
	
	
	public boolean areDropdownOptionsVisible(List<String> expectedOptions) {
	    for (String expected : expectedOptions) {
	        boolean found = false;
	        for(WebElement option : dsDropdownOptions) {
	            CommonMethods.waitForElementToBeVisible(driver, option, CommonMethods.DEFAULT_TIMEOUT);
	        	String actualText = option.getText().trim();
	        	if(actualText.equalsIgnoreCase(expected)) {
	        		found = true;
	        		break;
	        	}
	        }
	        if (!found) return false; // One of the expected options was not found
	    }
	    return true; // All expected options were found
	}
	
	public void selectFromDropdown(String optionText) {
	    for (WebElement e : dsDropdownOptions) {
	        CommonMethods.waitForElementToBeVisible(driver, e, CommonMethods.DEFAULT_TIMEOUT);
	        if (e.getText().trim().equalsIgnoreCase(optionText)) {
	            e.click();
	            return;
	        }
	    }
	    throw new RuntimeException("Dropdown option not found: " + optionText);
	}
	
	public boolean getAlertText() {
        CommonMethods.waitForElementToBeVisible(driver, msg, CommonMethods.DEFAULT_TIMEOUT);
	    return msg.isDisplayed();
	}
  
    
	public void clickFlexGetStarted(String flexTitle) {
	    String xpath = "//a[@href= '"+flexTitle+"']";
	    WebElement getStartedBtn = driver.findElement(By.xpath(xpath));
        CommonMethods.waitForElementToBeVisible(driver, getStartedBtn, CommonMethods.DEFAULT_TIMEOUT);
	    getStartedBtn.click();
	}

}
