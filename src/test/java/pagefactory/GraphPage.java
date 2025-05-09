package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GraphPage {
	private WebDriver driver;
	
	@FindBy(className = "list-group-item") 
	private List<WebElement> graphPageLinks;	
	
	public GraphPage (WebDriver driver) {
		this.driver = driver; 
        PageFactory.initElements(driver, this); 
	}
	
	public String getGraphPageTitle() {
		return driver.getTitle();
	}
	
	public GraphPageTryEditorPage clickGraphPageLinks(String linkText) {
		for(WebElement e: graphPageLinks) {
			if(e.getText().trim().equalsIgnoreCase(linkText)) {
				e.click();
				return new GraphPageTryEditorPage(driver); 		//Initialize tryEditor
			}
		}
		throw new RuntimeException("Link not found: " + linkText);

	}

}