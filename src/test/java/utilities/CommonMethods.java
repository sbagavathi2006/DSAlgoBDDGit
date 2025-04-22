package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CommonMethods {
	
	  // Wait for element visibility to avoid StaleElementReferenceException explicit wait
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Handle StaleElementReferenceException by retrying
//    public static WebElement retryElementUntilVisible(WebDriver driver, By locator, int retries) {
//        WebElement retryElement = null;
//        int attempt = 0;
//        while (attempt < retries) {
//            try {
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
//                retryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 
//                break;
//            } catch (StaleElementReferenceException e) {
//                attempt++;
//                if (attempt >= retries) {
//                    throw e;  
//                }
//            }
//        }
//        return retryElement;
//    }

    public static String getAlertText(WebDriver driver, int timeout) {
    	try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    	} catch (Exception e) {
            System.out.println("No alert found within timeout: " + timeout + " seconds");
            return null;
        }
    }
}
