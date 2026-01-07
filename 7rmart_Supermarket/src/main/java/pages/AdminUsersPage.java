package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage 
{
	public WebDriver driver;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement AdminUsersMoreInfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement NewButton;
	@FindBy(xpath="//input[@id='username']")WebElement UsernameField;
	@FindBy(xpath="//input[@id='password']")WebElement PasswordField;
	@FindBy(xpath="//select[@id='user_type']")WebElement UserTypeField;
	@FindBy(xpath="//button[@type='submit' and @name='Create']")WebElement SaveButton;
	@FindBy(xpath="//div[contains(@class,' alert-success')]")WebElement AlertAdminUser;

	
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public void clickAdminUserMoreInfo()
	{
		AdminUsersMoreInfo.click();
	}
	public void clickNew()
	{
		NewButton.click();
		
	}
	public void enterUsername(String uname)
	{
		UsernameField.sendKeys(uname);	
	}
	public void enterPassword(String password)
	{
		PasswordField.sendKeys(password);
		
	}
	public void eneterUserType()
	{
		Select select=new Select(UserTypeField);
		select.selectByValue("partner");
	}
//	public Boolean verifyAdminUserPageIsDisplayed()
//	{
//		return AdminUsersPage.isDisplayed();
//		
//	}
	public void clickSaveButton()
	{
		SaveButton.click();
	}
	
	public Boolean verifyAdminAlertIsDisplayed()
	{
		return AlertAdminUser.isDisplayed();
		
	}
}
