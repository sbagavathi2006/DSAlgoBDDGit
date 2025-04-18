package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrayPage {
	
private WebDriver driver;

	@FindBy(xpath = "//a[@href=\"arrays-in-python\"]") WebElement arrayInPythonLink;
	@FindBy(xpath = "//a[@href=\"arrays-using-list\"]") WebElement arrayUsingLink;
	@FindBy(xpath = "//a[@href=\"basic-operations-in-lists\"]") WebElement basicOperInListLink;
	@FindBy(xpath = "//a[@href=\"applications-of-array\"]") WebElement applnsOfArrayLink;
	
	public ArrayPage (WebDriver driver) {
		this.driver = driver; // Reuses the driver created in Hooks
        PageFactory.initElements(driver, this); //initialize all the WebElements that are annotated with @FindBy
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
