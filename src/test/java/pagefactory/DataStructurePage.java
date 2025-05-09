package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataStructurePage {
		
		private WebDriver driver; //instance variable
	@FindBy(className = "list-group-item") 
	private List<WebElement> DataStructurePageLinks;	
	
	public DataStructurePage (WebDriver driver) {
		this.driver = driver; 
        PageFactory.initElements(driver, this); 
	}

	public String getDataStructurePageTitle() {
		return driver.getTitle();
	}
	
	public DataStructurePageTryEditorPage clickDataStructurePageLinks(String linkText) {
		for(WebElement e: DataStructurePageLinks) {
			if(e.getText().trim().equalsIgnoreCase(linkText)) {
				e.click();
				return new DataStructurePageTryEditorPage(driver); 		//Initialize tryEditor
			}
		}
		throw new RuntimeException("Link not found: " + linkText);

	}

}