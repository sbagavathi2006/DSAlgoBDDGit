package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import webdriver.DriverFactory;

///public class Hooks {
	/*this is one base class becz every scenario frist it will execute @befrore and 
	//private DriverFactory driverFactory;//this three private becz this hooks only call this things
	//private WebDriver driver;
	//private ConfigReader configReader=new ConfigReader();
	//Properties prop;
	/*private DriverFactory driverFactory;//this three private becz this hooks only call this things
	private WebDriver driver;
	private ConfigReader configReader=new ConfigReader();
	Properties prop;
	
	//@Before(order =0)//browser is calling from config.propertis
	//public void getProperty() {
		//configReader=new ConfigReader();
		//prop =configReader.init_prop();//initialize the prop
	//}
	
	//@Before(order =1)//launch the browser
	//public void launchbrowser() {
		//String browsername=prop.getProperty("browser");//get browser name from confg.prop
		//String urlname=prop.getProperty("url");
		//driverFactory = new DriverFactory();//object for driver class
		//driver= driverFactory.init_driver(browsername);//object creation then call browser name
		//DriverFactory.getDriver().get(urlname);

//}
	//@After(order =0)//every scenario quit the browser
	//public void quitBrowser() {
		 //if (driver != null) {

		        //driver.quit(); // Quit the browser only if it's initialized
		    
		   // }
    //}
	
	//@After(order=1)
	//public void tearDown(Scenario scenario){
		//if(scenario.isFailed()) {//scenario is failed then its take a screen shorts
//			take screenshorts
			//String screenshotName = scenario.getName().replaceAll("", "_");
			//byte [] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);//takes the screen short it stored into under the source path
			//scenario.attach(sourcePath, "image/png", screenshotName);//screenshorts attetched in extend reports whatever reports
//}
	//}
//}
			String screenshotName = scenario.getName().replaceAll("", "_");
			byte [] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);//takes the screen short it stored into under the source path
			scenario.attach(sourcePath, "image/png", screenshotName);//screenshorts attetched in extend reports whatever reports
//}
	//}*/
//}
/*finally first before=0,will excute and next before=1 will execute  that is launch browser and next after=1 will execute (becz while execute the scenarios
first launch the browser and then some failed test cases take a screenshorts and after=0 will execute after=0 is quit browser)*/