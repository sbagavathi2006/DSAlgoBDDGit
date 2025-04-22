package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GraphPage {
	private WebDriver driver; //instance variable

	public GraphPage(WebDriver driver) {
		this.driver = driver; //driver is passed from hooks class which is assigned with page class driver 
        PageFactory.initElements(driver, this);	}
}
