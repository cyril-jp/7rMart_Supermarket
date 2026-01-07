package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManageFooterTextPage 
{
	public WebDriver driver;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")WebElement FooterTextMoreInfo;
	@FindBy(xpath="//a[@role='button' and @href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement ActionButton;
	@FindBy(xpath="//input[@id='email']")WebElement EmailInputField;
	@FindBy(xpath="//input[@id='phone']")WebElement PhoneInputField;
	@FindBy(xpath="//button[@type='submit']")WebElement UpdateButton;
	@FindBy(xpath="//div[contains(@class,' alert-success')]")WebElement AlertFooterText;

	
	
	public ManageFooterTextPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void clickFooterTextMoreInfo()
	{
		FooterTextMoreInfo.click();
	}
	public void clickActionButton()
	{
		ActionButton.click();
		
	}
	public void enterEmail(String email)
	{
		EmailInputField.clear();
		EmailInputField.sendKeys(email);	
	}
	public void enterPhoneNumber(String phone) 
	{

		PhoneInputField.clear();
		PhoneInputField.sendKeys(phone);
		
	}

//	public Boolean verifyFooterTextPageIsDisplayed()
//	{
//		return AdminUsersPage.isDisplayed();
//		
//	}
	public void clickUpdateButton()
	{
		UpdateButton.click();
	}
	
	public Boolean verifyFooterTextAlertIsDisplayed()
	{
		return AlertFooterText.isDisplayed();
		
	}
}

