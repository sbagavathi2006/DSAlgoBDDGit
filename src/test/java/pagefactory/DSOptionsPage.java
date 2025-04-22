package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DSOptionsPage {
	
private WebDriver driver;
	@FindBy(css = "ul > a:nth-child(2)")
	private WebElement loggedInUserName;	
	@FindBy(xpath = "//a[contains(text(), 'Sign out')]") 
	private WebElement signout;	
	@FindBy(xpath = "//div[contains(text(), 'You are logged in')]") 
	private WebElement loginSuccessAlert;	
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	private WebElement dsDropdown;
	@FindBy (xpath ="//div[@class='dropdown-menu show']//a[text()='Arrays']")
	private WebElement ddArraysOpt;	
	@FindBy (xpath ="//div[@class='dropdown-menu show']//a[text()='Linked List']")
	private WebElement ddLinkedListOpt;	
	@FindBy (xpath ="//div[@class='dropdown-menu show']//a[text()='Stack']")
	private WebElement ddStackOpt;	
	@FindBy (xpath ="//div[@class='dropdown-menu show']//a[text()='Queue']")
	private WebElement ddQueueOpt;
	@FindBy (xpath ="//div[@class='dropdown-menu show']//a[text()='Tree']")
	private WebElement ddTreeOpt;
	@FindBy (xpath ="//div[@class='dropdown-menu show']//a[text()='Graph']")
	private WebElement ddGraphOpt;	
	@FindBy(xpath = "//a[@href='data-structures-introduction']") 
	private WebElement dsIntroGetStartBtn;	
	@FindBy(xpath = "//a[@href='array']") 
	private WebElement arrayGetStartBtn;	
	@FindBy(xpath = "//a[@href='linked-list']") 
	private WebElement linkedListGetStartBtn;	
	@FindBy(xpath = "//a[@href='stack']") 
	private WebElement stackGetStartBtn;	
	@FindBy(xpath = "//a[@href='queue']") 
	private WebElement queueGetStartBtn;	
	@FindBy(xpath = "//a[@href='tree']") 
	private WebElement treeGetStartBtn;	
	@FindBy(xpath = "//a[@href='graph']") 
	private WebElement graphGetStartBtn;
	
	public DSOptionsPage (WebDriver driver) {
		this.driver = driver; // Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); //initialize all the WebElements that are annotated with @FindBy
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean getLoginSuccessMsg() {
		return loginSuccessAlert.isDisplayed();
	}
	
	
	public String loggedInUser() {		
		return loggedInUserName.getText().trim();
	}
	
	public boolean signoutLinkDisplayed() {
		return signout.isDisplayed();
	}
	
	public void selectDropdownOptions() {
		dsDropdown.click();
	}
	public void clickDropdownList(String panelName) {
		switch (panelName.trim().toLowerCase()) {
			case "arrays":
				ddArraysOpt.click();
				break;
			case "linked-list":
				ddLinkedListOpt.click();
				break;
			case "stack":
				ddStackOpt.click();
				break;
			case "queue":
				ddQueueOpt.click();
				break;
			case "tree":
				ddTreeOpt.click();
				break;
			case "graph":
				ddGraphOpt.click();
				break;
			default:
				throw new IllegalArgumentException("Invalid options name: " + panelName);
		}
	}
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
	
	public DataStructurePage dsIntroGetStartBtnClick() {
		dsIntroGetStartBtn.click();
		return new DataStructurePage(driver);
	}
	
	public ArrayPage arrayGetStartBtnClick() {
		arrayGetStartBtn.click();
		return new ArrayPage(driver);
	}
	
	public LinkedListPage linkedListGetStartBtnClick() {
		linkedListGetStartBtn.click();
		return new LinkedListPage(driver);
	}
	
	public StackPage stackGetStartBtnClick() {
		stackGetStartBtn.click();
		return new StackPage(driver);
	}
	
	public QueuePage queueGetStartBtnClick() {
		queueGetStartBtn.click();
		return new QueuePage(driver);
	}
	
	public TreePage treeGetStartBtnClick() {
		treeGetStartBtn.click();
		return new TreePage(driver);
	}
	
	public GraphPage graphGetStartBtnClick() {
		graphGetStartBtn.click();
		return new GraphPage(driver);
	}
	
	
	//Important: add getTitle method for each page for page-redirection validation.
}
