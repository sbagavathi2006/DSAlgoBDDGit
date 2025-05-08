package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TreePageTryEditorPage {
		
	private WebDriver driver;
	@FindBy(css = ".CodeMirror.cm-s-default")
	private WebElement codeMirror;
	@FindBy(xpath ="//button")
	private WebElement btnRun;
	@FindBy(linkText = "Try here>>>") 
	private WebElement btnTryHere;
	@FindBy(id = "output")
	private WebElement output;	
	@FindBy(xpath = "//a[text()='Practice Questions']")
	private WebElement practiceQuestionsLink;

	public TreePageTryEditorPage(WebDriver driver) { 
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	}

	public boolean isPraticeQnsLinksDisplayed() {
		By practiceLinks = By.xpath("//a[contains(@href,'/question/')]");
        List<WebElement> elems = driver.findElements(practiceLinks);
        return !elems.isEmpty() && elems.get(0).isDisplayed();
	}
	
   public boolean isRunBtnDisplayed() {
	return btnRun.isDisplayed();
    }
		
  public boolean isTryHereBtnDisplayed() {
   return btnTryHere.isDisplayed();
   }
		
  public void clickTryHereBtn() {
    btnTryHere.click();
	}
		
  public void clickRunTryHere() {
    btnRun.click();
	}
  
  public void writeCode(String code) {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   //get HTML element document.querySelector('.CodeMirror') & reference to the actual CodeMirror editor instance. Stores code-mirror editor instance to editor variable.
	   js.executeScript(
	   "let editor = document.querySelector('.CodeMirror').CodeMirror;" +
	   "editor.setValue(arguments[0]);", code);	//passing code as a parameter rather than hardcoding it inside the JS string.editor.setValue(code);	
	   }

  public boolean isOutputSuccess() {
    return output.isDisplayed();
	}

  public void clickPracticeQnsLink() {
	practiceQuestionsLink.click();
	}

  public String getOutputText() {
    return output.getText();
    }
   }

