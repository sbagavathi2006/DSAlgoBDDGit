package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CommonMethods {
	
    public static final int DEFAULT_TIMEOUT = 5;

	  // Wait for element visibility to avoid StaleElementReferenceException explicit wait
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String getAlertText(WebDriver driver, int timeout) {
    	try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMsg;
    	} catch (Exception e) {
            System.out.println("No alert found within timeout: " + timeout + " seconds");
            return null;
        }
    }
 
}
