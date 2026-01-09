package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	public WebDriver driver;
//	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")WebElement FooterTextMoreInfo;
	@FindBy(xpath = "//a[@role='button' and @href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
	WebElement ActionButton;
	@FindBy(xpath = "//input[@id='email']")
	WebElement EmailInputField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement PhoneInputField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement UpdateButton;
	@FindBy(xpath = "//div[contains(@class,' alert-success')]")
	WebElement AlertFooterText;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

//	public void clickFooterTextMoreInfo()
//	{
//		FooterTextMoreInfo.click();
//	}
	public ManageFooterTextPage clickActionButton() {
		ActionButton.click();
		return this;

	}

	public ManageFooterTextPage enterEmail(String email) {
		EmailInputField.clear();
		EmailInputField.sendKeys(email);
		return this;
	}

	public ManageFooterTextPage enterPhoneNumber(String phone) {

		PhoneInputField.clear();
		PhoneInputField.sendKeys(phone);
		return this;

	}

//	public Boolean verifyFooterTextPageIsDisplayed()
//	{
//		return AdminUsersPage.isDisplayed();
//		
//	}
	public ManageFooterTextPage clickUpdateButton() {
		UpdateButton.click();
		return this;
	}

	public Boolean verifyFooterTextAlertIsDisplayed() {
		return AlertFooterText.isDisplayed();

	}
}
