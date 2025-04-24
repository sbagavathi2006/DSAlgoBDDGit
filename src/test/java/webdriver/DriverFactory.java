package webdriver;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>(); //each thread gets its own instance for parallel testing
		   
		public WebDriver init_driver(String browser) { //Initializes the WebDriver based on the given browser name
			System.out.println("browser value is :" + browser);
			
			if(browser.equalsIgnoreCase("chrome")) {
				 tlDriver.set(new ChromeDriver());//Assign ChromeDriver to the current thread's WebDriver
			}
			
			else if(browser.equals("firefox")) {  
				 tlDriver.set(new FirefoxDriver());
			}
				
			else if(browser.equals("edge")) {
				 tlDriver.set(new EdgeDriver());
			}
			
			else {
				System.out.println("Please pass the correct browser");
			}
			
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize(); 
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			return getDriver(); // Return the initialized driver
		}
		
		public static WebDriver getDriver() { // Returns the WebDriver instance for the current thread
			return tlDriver.get();
		}
	}
