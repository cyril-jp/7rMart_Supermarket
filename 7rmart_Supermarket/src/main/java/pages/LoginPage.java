package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	public WebDriver driver;

	
@FindBy(xpath="//input[@name='username']")WebElement username;
@FindBy(xpath="//input[@type='password']")WebElement password;
@FindBy(xpath="//button[@type='submit']")WebElement signin;
@FindBy(xpath="//p[text()='Dashboard']")WebElement homepage ;
@FindBy(xpath="//div[contains(@class,'alert-danger')]")WebElement Alertlogin ;


public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void enterUserName(String user)
{
  username.sendKeys(user);	
}
public void enterPassword(String pin)	
{
	password.sendKeys(pin);
}
public void clickSignin()
{
	signin.click();
}

public Boolean verifyHomePageIsDisplayed()
{
	return homepage.isDisplayed();
	
}
public Boolean verifyAlertIsDisplayed()
{
	return Alertlogin.isDisplayed();
	
}

}
