package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

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
        CommonMethods.waitForElementToBeVisible(driver, loginSuccessAlert, CommonMethods.DEFAULT_TIMEOUT);
		return loginSuccessAlert.isDisplayed();
	}
	
	
	public String loggedInUser() {	
        CommonMethods.waitForElementToBeVisible(driver, loggedInUserName, CommonMethods.DEFAULT_TIMEOUT);
		return loggedInUserName.getText().trim();
	}
	
	public boolean signoutLinkDisplayed() {
        CommonMethods.waitForElementToBeVisible(driver, signout, CommonMethods.DEFAULT_TIMEOUT);
		return signout.isDisplayed();
	}
	
	public void selectDropdownOptions() {
        CommonMethods.waitForElementToBeVisible(driver, dsDropdown, CommonMethods.DEFAULT_TIMEOUT);
		dsDropdown.click();
	}
	
	public void clickDropdownList(String panelName) {
		switch (panelName.trim().toLowerCase()) {
			case "arrays":
		        CommonMethods.waitForElementToBeVisible(driver, ddArraysOpt, CommonMethods.DEFAULT_TIMEOUT);
				ddArraysOpt.click();
				break;
			case "linked-list":
		        CommonMethods.waitForElementToBeVisible(driver, ddLinkedListOpt, CommonMethods.DEFAULT_TIMEOUT);
				ddLinkedListOpt.click();
				break;
			case "stack":
		        CommonMethods.waitForElementToBeVisible(driver, ddStackOpt, CommonMethods.DEFAULT_TIMEOUT);
				ddStackOpt.click();
				break;
			case "queue":
		        CommonMethods.waitForElementToBeVisible(driver, ddQueueOpt, CommonMethods.DEFAULT_TIMEOUT);
				ddQueueOpt.click();
				break;
			case "tree":
		        CommonMethods.waitForElementToBeVisible(driver, ddTreeOpt, CommonMethods.DEFAULT_TIMEOUT);
				ddTreeOpt.click();
				break;
			case "graph":
		        CommonMethods.waitForElementToBeVisible(driver, ddGraphOpt, CommonMethods.DEFAULT_TIMEOUT);
				ddGraphOpt.click();
				break;
			default:
				throw new IllegalArgumentException("Invalid options name: " + panelName);
		}
	}
	public void clickGettingStartedForPanel(String panelName) {
			switch (panelName.trim().toLowerCase()) {
				case "data-structures-introduction":
			        CommonMethods.waitForElementToBeVisible(driver, dsIntroGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
					dsIntroGetStartBtn.click();
					break;
				case "array":
			        CommonMethods.waitForElementToBeVisible(driver, arrayGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
					arrayGetStartBtn.click();
					break;
				case "linked-list":
			        CommonMethods.waitForElementToBeVisible(driver, linkedListGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
					linkedListGetStartBtn.click();
					break;
				case "stack":
			        CommonMethods.waitForElementToBeVisible(driver, stackGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
					stackGetStartBtn.click();
					break;
				case "queue":
			        CommonMethods.waitForElementToBeVisible(driver, queueGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
					queueGetStartBtn.click();
					break;
				case "tree":
			        CommonMethods.waitForElementToBeVisible(driver, treeGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
					treeGetStartBtn.click();
					break;
				case "graph":
			        CommonMethods.waitForElementToBeVisible(driver, graphGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
					graphGetStartBtn.click();
					break;
				default:
					throw new IllegalArgumentException("Invalid panel name: " + panelName);
			}
		}
	
	public DataStructurePage dsIntroGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, dsIntroGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
		dsIntroGetStartBtn.click();
		return new DataStructurePage(driver);
	}
	
	public ArrayPage arrayGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, arrayGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
		arrayGetStartBtn.click();
		return new ArrayPage(driver);
	}
	
	public LinkedListPage linkedListGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, linkedListGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
		linkedListGetStartBtn.click();
		return new LinkedListPage(driver);
	}
	
	public StackPage stackGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, stackGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
		stackGetStartBtn.click();
		return new StackPage(driver);
	}
	
	public QueuePage queueGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, queueGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
		queueGetStartBtn.click();
		return new QueuePage(driver);
	}
	
	public TreePage treeGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, treeGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
		treeGetStartBtn.click();
		return new TreePage(driver);
	}
	
	public GraphPage graphGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, graphGetStartBtn, CommonMethods.DEFAULT_TIMEOUT);
		graphGetStartBtn.click();
		return new GraphPage(driver);
	}
}
