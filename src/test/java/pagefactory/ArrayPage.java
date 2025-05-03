package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrayPage {
	
private WebDriver driver;

	@FindBy(className = "list-group-item") 
	private List<WebElement> arrayPageLinks;	
	@FindBy(xpath = "//a[@href='arrays-in-python']") 
	private WebElement arraysInPython;
	
	public ArrayPage (WebDriver driver) {
		this.driver = driver; 
        PageFactory.initElements(driver, this); 
	}
	
	public String getArrayPageTitle() {
		return driver.getTitle();
	}
	
	public ArrayPageTryEditorPage clickArrayPageLinks(String linkText) {
		for(WebElement e: arrayPageLinks) {
			if(e.getText().trim().equalsIgnoreCase(linkText)) {
				e.click();
				return new ArrayPageTryEditorPage(driver); 		//Initialize tryEditor
			}
		}
		throw new RuntimeException("Link not found: " + linkText);
	}	
	
	public void clickArraysInPython() {
		arraysInPython.click();
	}
}
