package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GraphPage {
	
	private WebDriver driver;
	WebDriverWait wait;//elements are ready for interaction before any operation is performed
	
	
	@FindBy(xpath = "//a[@href='graph']")
	WebElement Graphgetstarted;
	
	@FindBy(xpath = "//a[@href='graph']")
	WebElement Graph;
	
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryhere;
	
	@FindBy(xpath = ("CodeMirror"))
	WebElement tryeditor;
	
	@FindBy(xpath = "//button[@text='Run']")
	WebElement Run;
	
	@FindBy(xpath = "//a[text()='Graph Representations']")
	WebElement GraphRepresentations;
	
	//@FindBy(xpath = "//a[text()='Try here>>>']")
	//WebElement tryhere;
	
	//@FindBy(xpath = "//'CodeMirror']")
	//WebElement tryeditor;
	
	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement PracticeQuestions;
	
	public GraphPage(WebDriver driver) { //using constructor class and constructor name should be same
		this.driver = driver;
	}
	

}
