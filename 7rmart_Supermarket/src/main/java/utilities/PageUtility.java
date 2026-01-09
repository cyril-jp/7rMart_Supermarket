package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public void selectByVisibleTextMethod(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	public void selectByValueMethod(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void selectByIndexMethod(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void dragAndDropMethod(WebElement source, WebElement destination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();
	}

	public void rightClickMethod(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void doubleClickMethod(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void mouseHoverMethod(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void ClickMethod(WebElement element) {
		Actions actions = new Actions(driver);
		actions.click(element).perform();
	}

	public void javaScriptExecutorMethod(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void javaScriptExecutorInputFieldMethod(WebElement inputfield) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='cyril';", inputfield);

	}
}
