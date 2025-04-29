package pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TreePage {
	private WebDriver driver; //instance variable

	public TreePage(WebDriver driver) {
		this.driver = driver; //driver is passed from hooks class which is assigned with page class driver 
        PageFactory.initElements(driver, this);	}

	@FindBy(xpath ="//a[@href='tree']")
	WebElement TreeGetStartedBtn;
	
	@FindBy(xpath = "//a[@href='overview-of-trees']" )
	private WebElement overviewOfTrees;
	
	@FindBy(xpath = "//a[@href='terminologies']")
	private WebElement terminologies;
	
	@FindBy(xpath ="//a[@href='types-of-trees']")
	private WebElement typesOfTrees;
	
	@FindBy(xpath ="//a[@href='tree-traversals']")
	private WebElement treeTraversals;
	
	@FindBy(xpath ="//a[@href='traversals-illustration']")
	private WebElement traversalsIllustration;
	
	@FindBy(xpath ="//a[@href='binary-trees']")
	private WebElement binaryTrees;
	
	@FindBy(xpath ="//a[@href='types-of-binary-trees']")
	private WebElement typesOfBinaryTrees;
	
	@FindBy(xpath ="//a[@href='implementation-in-python']")
	private WebElement implementationInPython;
	
	@FindBy(xpath ="//a[@href='binary-tree-traversals']")
	private WebElement binaryTreeTraversals;
	
	@FindBy(xpath ="//a[@href='implementation-of-binary-trees']")
	private WebElement implementationOfBinaryTrees;
	
	@FindBy(xpath ="//a[@href='applications-of-binary-trees']")
	private WebElement applicationsOfBinaryTrees;
	
	@FindBy(xpath ="//a[@href='binary-search-trees']")
	private WebElement binarySearchTrees;
	
	@FindBy(xpath ="//a[@href='implementation-of-bst']")
	private WebElement implementationOfBST;
	
	@FindBy(className = "list-group-item")
	private List<WebElement> treePageLinks;
	
	public TreePageTryEditorPage clickTreeSubLinks(String linkText) {
		
		switch (linkText) {
		case "overview of trees":
			overviewOfTrees.click();
			return new TreePageTryEditorPage(driver);
        case "terminologies":
        	terminologies.click(); 
			return new TreePageTryEditorPage(driver);
        case "types of trees":
        	 typesOfTrees.click();
        	 return new TreePageTryEditorPage(driver);
        case "tree traversals":
        	treeTraversals.click();
        	return new TreePageTryEditorPage(driver);
        case "traversals-illustration":
        	traversalsIllustration.click();
        	return new TreePageTryEditorPage(driver);
        case "binary trees":
        	binaryTrees.click();
        	return new TreePageTryEditorPage(driver);
        case "types of binary trees":
        	typesOfBinaryTrees.click();
        	return new TreePageTryEditorPage(driver);
        case "implementation in python":
        	implementationInPython.click();
        	return new TreePageTryEditorPage(driver);
        case "binary tree traversals":
        	binaryTreeTraversals.click();
        	return new TreePageTryEditorPage(driver);
        case "implementation of binary trees":
        	implementationOfBinaryTrees.click();
        	return new TreePageTryEditorPage(driver);
        case "applications of binary trees":
        	applicationsOfBinaryTrees.click();
        	return new TreePageTryEditorPage(driver);
        case "binary search trees":
        	binarySearchTrees.click();
        	return new TreePageTryEditorPage(driver);
        case "implementation of bst":
        	implementationOfBST.click();
        	return new TreePageTryEditorPage(driver);
        	}
		return null;
	}
}