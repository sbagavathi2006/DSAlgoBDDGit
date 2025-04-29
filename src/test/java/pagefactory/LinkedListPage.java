package pagefactory;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LinkedListPage {
	
private WebDriver driver;
	@FindBy(xpath = "//a[@href='introduction']")
	private WebElement IntroductionLink;
	@FindBy(xpath = "//a[@href='linked-list/creating-linked-list']")
	private WebElement CreatingLinkedLIstLink;
	@FindBy(xpath = "//a[@href='linked-list/types-of-linked-list']")
	private WebElement TypesofLinkedListLink;
	@FindBy(xpath = "//a[@href='linked-list/implement-linked-list-in-python']")
	private WebElement ImplementLinkedListinPythonLink;
	@FindBy(xpath = "//a[@href='linked-list/traversal']")
	private WebElement TraversalLink;
	@FindBy(xpath = "//a[@href='linked-list/insertion-in-linked-list']")
	private WebElement InsertionLink;
	@FindBy(xpath = "//a[@href='linked-list/deletion-in-linked-list']")
	private WebElement DeletionLink;
	@FindBy(className = "list-group-item")
	private List<WebElement> LinkedListPageLinks;	
	
	public LinkedListPage (WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public String getLinkedListPageTitle() {
		return driver.getTitle();
	}
	
	public void clickLinkedListPageLinks(String linkText) {
		for(WebElement e: LinkedListPageLinks) {
			if(e.getText().trim().equalsIgnoreCase(linkText)) {
				e.click();
				return;
			}
		}
		throw new RuntimeException("Link not found: " + linkText);
	}
}
