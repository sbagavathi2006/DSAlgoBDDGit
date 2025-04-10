package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DSAlgoPortalPage {
	
		String URL = "https://dsportalapp.herokuapp.com/";
	public void LaunchPortal() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
}
