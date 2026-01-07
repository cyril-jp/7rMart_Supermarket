package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
 public static final int IMPLICITEWAIT=5;
 public static final int EXPLICITEWAIT=10; 
 public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITEWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

 }
