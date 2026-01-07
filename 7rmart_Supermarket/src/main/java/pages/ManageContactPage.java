package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage 
{
	public WebDriver driver;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement ContactMoreInfo;
	@FindBy(xpath="//a[@role='button' and @href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")WebElement ActionButton;
	@FindBy(xpath="//input[@id='email']")WebElement EmailInputField;
	@FindBy(xpath="//input[@id='phone']")WebElement PhoneInputField;
	@FindBy(xpath="//textarea[@name='del_time']")WebElement DeliveryTimeField;
	@FindBy(xpath="//button[@type='submit']")WebElement UpdateButton;
	@FindBy(xpath="//div[contains(@class,' alert-success')]")WebElement AlertContact;

	
	
	public ManageContactPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void clickContactMoreInfo()
	{
		ContactMoreInfo.click();
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
	public void enterDeliveryTime(String time) 
	{

		DeliveryTimeField.clear();
		DeliveryTimeField.sendKeys(time);
		
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
	
	public Boolean verifyContactAlertIsDisplayed()
	{
		return AlertContact.isDisplayed();
		
	}
}
