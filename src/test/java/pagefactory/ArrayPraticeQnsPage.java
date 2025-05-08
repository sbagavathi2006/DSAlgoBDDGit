package pagefactory;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonMethods;

public class ArrayPraticeQnsPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/question/1']") 
	private WebElement practiceQn1;	
	@FindBy(xpath = "//a[@href='/question/2']") 
	private WebElement practiceQn2;	
	@FindBy(xpath = "//a[@href='/question/3']") 
	private WebElement practiceQn3;		
	@FindBy(xpath = "//a[@href='/question/4']") 
	private WebElement practiceQn4;	
	@FindBy(className = "list-group-item") 
	private List<WebElement> practiceQns;
	@FindBy(xpath = "//button") 
	private WebElement btnRun;
	@FindBy(xpath = "//input[@class='button']") 
	private WebElement btnSubmit;
	@FindBy(css = ".CodeMirror.cm-s-default")
	private WebElement codeMirror;
	@FindBy(id = "output")
	private WebElement output;
	@FindBy(xpath = "//pre[@id='output']")
	private WebElement outputSubmit;
	
	public ArrayPraticeQnsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	public boolean isPraticeQnsLinksDisplayed() {
		try {
	        return practiceQn1.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }	}
	
	public void clickPracticeQns(String linkText) {
		switch (linkText.trim().toLowerCase()) {
		case "search the array":
			practiceQn1.click();
			break;
		case "max consecutive ones":
			practiceQn2.click();
			break;
		case "find numbers with even number of digits":
			practiceQn3.click();
			break;
		case "squares of  a sorted array":
			practiceQn4.click();
			break;
		default:
			throw new IllegalArgumentException("Invalid options name: " + linkText);
		}
	}
	
	public boolean isBtnDisplayed(String btn) {
		switch (btn) {
		case "run":
			return btnRun.isDisplayed();
		case "submit":
			return btnSubmit.isDisplayed();
		}
		return false;
	}
	
	public void writeCode(String code) {
        CommonMethods.waitForElementToBeVisible(driver, codeMirror);

        //	codeMirror.clear();
        
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
		 //get HTML element document.querySelector('.CodeMirror') & reference to the actual CodeMirror editor instance. Stores code-mirror editor instance to editor variable.
		
	    js.executeScript(
			"let editor = document.querySelector('.CodeMirror').CodeMirror;" +
			"editor.setValue(arguments[0]);", code);	//passing code as a parameter rather than hardcoding it inside the JS string.editor.setValue(code);	
	}
	
	public void clickRunBtn() {
		btnRun.click();
	}
	
	public void btnSubmit() {
		btnSubmit.click();
	}

	public boolean isOutputSuccess() {
		return output.isDisplayed();
	}
	
	public String getSubmitMsg() {
		CommonMethods.waitForElementToBeVisible(driver, outputSubmit);
		return outputSubmit.getText();
	}
}
