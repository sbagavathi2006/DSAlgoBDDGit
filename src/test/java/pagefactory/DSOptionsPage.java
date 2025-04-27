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
        CommonMethods.waitForElementToBeVisible(driver, loginSuccessAlert);
		return loginSuccessAlert.isDisplayed();
	}
	
	
	public String loggedInUser() {	
        CommonMethods.waitForElementToBeVisible(driver, loggedInUserName);
		return loggedInUserName.getText().trim();
	}
	
	public boolean signoutLinkDisplayed() {
        CommonMethods.waitForElementToBeVisible(driver, signout);
		return signout.isDisplayed();
	}
	
	public void selectDropdownOptions() {
        CommonMethods.waitForElementToBeVisible(driver, dsDropdown);
		dsDropdown.click();
	}
	
	public void clickDropdownList(String panelName) {
		switch (panelName.trim().toLowerCase()) {
			case "arrays":
		        CommonMethods.waitForElementToBeVisible(driver, ddArraysOpt);
				ddArraysOpt.click();
				break;
			case "linked-list":
		        CommonMethods.waitForElementToBeVisible(driver, ddLinkedListOpt);
				ddLinkedListOpt.click();
				break;
			case "stack":
		        CommonMethods.waitForElementToBeVisible(driver, ddStackOpt);
				ddStackOpt.click();
				break;
			case "queue":
		        CommonMethods.waitForElementToBeVisible(driver, ddQueueOpt);
				ddQueueOpt.click();
				break;
			case "tree":
		        CommonMethods.waitForElementToBeVisible(driver, ddTreeOpt);
				ddTreeOpt.click();
				break;
			case "graph":
		        CommonMethods.waitForElementToBeVisible(driver, ddGraphOpt);
				ddGraphOpt.click();
				break;
			default:
				throw new IllegalArgumentException("Invalid options name: " + panelName);
		}
	}
	public void clickGettingStartedForPanel(String panelName) {
			switch (panelName.trim().toLowerCase()) {
				case "data-structures-introduction":
			        CommonMethods.waitForElementToBeVisible(driver, dsIntroGetStartBtn);
					dsIntroGetStartBtn.click();
					break;
				case "array":
			        CommonMethods.waitForElementToBeVisible(driver, arrayGetStartBtn);
					arrayGetStartBtn.click();
					break;
				case "linked-list":
			        CommonMethods.waitForElementToBeVisible(driver, linkedListGetStartBtn);
					linkedListGetStartBtn.click();
					break;
				case "stack":
			        CommonMethods.waitForElementToBeVisible(driver, stackGetStartBtn);
					stackGetStartBtn.click();
					break;
				case "queue":
			        CommonMethods.waitForElementToBeVisible(driver, queueGetStartBtn);
					queueGetStartBtn.click();
					break;
				case "tree":
			        CommonMethods.waitForElementToBeVisible(driver, treeGetStartBtn);
					treeGetStartBtn.click();
					break;
				case "graph":
			        CommonMethods.waitForElementToBeVisible(driver, graphGetStartBtn);
					graphGetStartBtn.click();
					break;
				default:
					throw new IllegalArgumentException("Invalid panel name: " + panelName);
			}
		}
	
	public DataStructurePage dsIntroGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, dsIntroGetStartBtn);
		dsIntroGetStartBtn.click();
		return new DataStructurePage(driver);
	}
	
	public ArrayPage arrayGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, arrayGetStartBtn);
		arrayGetStartBtn.click();
		return new ArrayPage(driver);
	}
	
	public LinkedListPage linkedListGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, linkedListGetStartBtn);
		linkedListGetStartBtn.click();
		return new LinkedListPage(driver);
	}
	
	public StackPage stackGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, stackGetStartBtn);
		stackGetStartBtn.click();
		return new StackPage(driver);
	}
	
	public QueuePage queueGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, queueGetStartBtn);
		queueGetStartBtn.click();
		return new QueuePage(driver);
	}
	
	public TreePage treeGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, treeGetStartBtn);
		treeGetStartBtn.click();
		return new TreePage(driver);
	}
	
	public GraphPage graphGetStartBtnClick() {
        CommonMethods.waitForElementToBeVisible(driver, graphGetStartBtn);
		graphGetStartBtn.click();
		return new GraphPage(driver);
	}
}
