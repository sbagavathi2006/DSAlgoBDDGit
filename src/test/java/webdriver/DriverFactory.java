package webdriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	

		public WebDriver driver;
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
		/*This method is used to initialize the thread local driver on the basis of given browser
		 * this will reurn tldriver
		 anytime will execute the parallel test so will give threadlocal and initialize the webdriver it help of tl*/
		    
		public WebDriver init_driver(String browser) {//initialize the browser and this driver object calling from hooks
			System.out.println("browser value is :" + browser);
			
			if(browser.equals("chrome")) {
				 WebDriverManager.chromedriver().setup();
				 tlDriver.set(new ChromeDriver());//tl give the set method and get method, this is set method,here tl set the chromebrowser//whenever u set the chrome driver it automaticaly set the tl
			}
			
			else if(browser.equals("firefox")) {  //next browser
				 WebDriverManager.firefoxdriver().setup();
				 tlDriver.set(new FirefoxDriver());
			}
			
			else if(browser.equals("safari")) {
				 WebDriverManager.safaridriver().setup();
				 tlDriver.set(new SafariDriver());
			}
			
			else if(browser.equals("edge")) {
				 WebDriverManager.edgedriver().setup();
				 tlDriver.set(new EdgeDriver());
			}
			
			else {
				System.out.println("Please pass the correct browser");
			}
			
			getDriver().manage().deleteAllCookies();  
			getDriver().manage().window().maximize(); //return the driver giving webdriver
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			return getDriver();
		}
		
		//this is used to get the driver with thread local
		public static synchronized WebDriver getDriver() { //this getmethod is return getdriver
			return tlDriver.get();
			       /*some one calling the getdriver its return the tl instant ,tl instant is already initialize chrome,fire*/
			       /*in parallel time 5 browser is open side by side so we gave synchronize its esy*/
		}
	}



