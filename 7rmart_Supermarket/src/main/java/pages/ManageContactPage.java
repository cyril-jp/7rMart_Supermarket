package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
//	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement ContactMoreInfo;
	@FindBy(xpath = "//a[@role='button' and @href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement ActionButton;
	@FindBy(xpath = "//input[@id='email']")
	WebElement EmailInputField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement PhoneInputField;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement DeliveryTimeField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement UpdateButton;
	@FindBy(xpath = "//div[contains(@class,' alert-success')]")
	WebElement AlertContact;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

//	public void clickContactMoreInfo()
//	{
//		ContactMoreInfo.click();
//	}
	public ManageContactPage clickActionButton() {
		ActionButton.click();
		return this;

	}

	public ManageContactPage enterEmail(String email) {
		EmailInputField.clear();
		EmailInputField.sendKeys(email);
		return this;
	}

	public ManageContactPage enterPhoneNumber(String phone) {

		PhoneInputField.clear();
		PhoneInputField.sendKeys(phone);
		return this;

	}

	public ManageContactPage enterDeliveryTime(String time) {

		DeliveryTimeField.clear();
		DeliveryTimeField.sendKeys(time);
		return this;

	}

//	public Boolean verifyFooterTextPageIsDisplayed()
//	{
//		return AdminUsersPage.isDisplayed();
//		
//	}
	public ManageContactPage clickUpdateButton() {
		UpdateButton.click();
//		pageutility.ClickMethod(UpdateButton);
		return this;
	}

	public Boolean verifyContactAlertIsDisplayed() {
		return AlertContact.isDisplayed();

	}
}
