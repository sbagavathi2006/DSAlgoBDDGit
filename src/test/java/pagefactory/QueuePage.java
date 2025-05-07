package pagefactory;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class QueuePage {
	
private WebDriver driver;
	@FindBy(xpath = "//a[@href='implementation-lists']")
    private WebElement ImplementationofQueueinPythonLink;
	@FindBy(xpath = "//a[@href='queue/implementation-collections']")
	private WebElement ImplementationUsingCollectionsLink;
	@FindBy(xpath = "//a[@href='queue/Implementation-array']")
	private WebElement ImplementationUsingArrayLink;
	@FindBy(xpath = "//a[@href='queue/QueueOp']")
	private WebElement QueueOperationsLink;
	@FindBy(className = "list-group-item")
	private List<WebElement> QueuePageLinks;	
	
	public QueuePage (WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public String getQueuePageTitle() {
		return driver.getTitle();
	}
	
	public QueuePageTryEditorPage clickQueuePageLinks(String linkText) {
		for(WebElement e: QueuePageLinks) {
			if(e.getText().trim().equalsIgnoreCase(linkText)) {
				e.click();
				return new QueuePageTryEditorPage(driver);
			}
		}
		throw new RuntimeException("Link not found: " + linkText);
	}
}
