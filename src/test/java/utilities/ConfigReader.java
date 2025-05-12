package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	private static ThreadLocal<String> browserType = new ThreadLocal<String>();
	
	//this method is read the properties from config.properties file and return properties prop object
	
	public Properties init_prop() {  //initialize the properties
		prop = new Properties();		//object of properties class
		try {
			FileInputStream ip = new FileInputStream("src/test/resources/config/config.properties");		//configuration file path
			prop.load(ip);		//load the properties and file input stream(ip) pass here and prop is object
			ip.close();
		}
		catch (FileNotFoundException e) {  //here give try catch block otherwise it got error
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;		//return the prop
	}

	public static void setBrowserType(String browser) {
		browserType.set(browser);
	}
	
	public static String getBrowserType() {
		return browserType.get();
		 }
	}
