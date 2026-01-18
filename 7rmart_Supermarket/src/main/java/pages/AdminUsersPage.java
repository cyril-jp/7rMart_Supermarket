package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;
//	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement AdminUsersMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement NewButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement UsernameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement PasswordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement UserTypeField;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	WebElement SaveButton;
	@FindBy(xpath = "//div[contains(@class,' alert-success')]")
	WebElement AlertAdminUser;
	@FindBy(xpath = "//div[contains(@class,' alert-danger')]")
	WebElement AlertAdminUserExisting;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

//	public void clickAdminUserMoreInfo()
//	{
//		AdminUsersMoreInfo.click();
//	}
	public AdminUsersPage clickNew() {
		NewButton.click();
		return this;

	}

	public AdminUsersPage enterUsername(String uname) {
		UsernameField.sendKeys(uname);
		return this;
	}

	public AdminUsersPage enterPassword(String password) {
		PasswordField.sendKeys(password);
		return this;

	}

	public AdminUsersPage eneterUserType() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByValueMethod(UserTypeField, "partner");
		return this;

//		Select select=new Select(UserTypeField);
//		select.selectByValue("partner");
	}


	public AdminUsersPage clickSaveButton() {
		SaveButton.click();
		return this;
	}

	public Boolean verifyAdminAlertIsDisplayed() {
		 try {
		        // First check success alert
		        if (AlertAdminUser.isDisplayed()) {
		            System.out.println("Success Alert displayed – Category added");
		            return true;
		        }
		    } catch (Exception e) {
		        // Ignore – success alert not present
		    }

		    try {
		        // Then check danger alert (already exists)
		        if (AlertAdminUserExisting.isDisplayed()) {
		            System.out.println("Danger Alert displayed – username and password already exists");
		            return true;
		        }
		    } catch (Exception e) {
		        // Ignore – danger alert not present
		    }

		    System.out.println("No alert displayed");
		    return false;
		}
//return AlertAdminUser.isDisplayed();
	}
