package pagefactory;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	

public class StackPage {
	private WebDriver driver; //instance variable
	@FindBy(className = "list-group-item")
	private List<WebElement> StackPageLinks;	
	

	public StackPage(WebDriver driver) {
		this.driver = driver; //driver is passed from hooks class which is assigned with page class driver 
        PageFactory.initElements(driver, this);	}
	
	public String getStackPageTitle() {
		return driver.getTitle();
	}
	
	public void clickStackPageLinks(String linkText) {
		for(WebElement e: StackPageLinks) {
			if(e.getText().trim().equalsIgnoreCase(linkText)) {
				e.click();
				return;
			}
		}
		throw new RuntimeException("Link not found: " + linkText);
	}

}
