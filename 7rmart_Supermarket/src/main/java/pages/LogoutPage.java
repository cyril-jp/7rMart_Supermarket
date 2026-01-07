package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	public WebDriver driver;
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement AdminClick;
	@FindBy(xpath="//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement AdminLogOut;
	@FindBy(xpath="//button[@type='submit']")WebElement SignInEnabled;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public void clickAdmin()
	{
		AdminClick.click();
	}
	public void logOut()
	{
		AdminLogOut.click();
	
	}
	public Boolean verifySuccessfullyLoggedOut()
	{
		return SignInEnabled.isEnabled();
		
	}

}
