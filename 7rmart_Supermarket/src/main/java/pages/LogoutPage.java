package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LogoutPage {
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement AdminClick;
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement AdminLogOut;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SignInEnabled;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement AdminUsersMoreInfo;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement ContactMoreInfo;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	WebElement FooterTextMoreInfo;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	WebElement CategoryMoreInfo;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement ManageNewsMoreInfo;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public AdminUsersPage clickAdminUserMoreInfo() {
		AdminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageContactPage clickContactMoreInfo() {
		ContactMoreInfo.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterTextPage clickFooterTextMoreInfo() {
		FooterTextMoreInfo.click();
		return new ManageFooterTextPage(driver);
	}

	public ManageCategoryPage clickCategoryMoreInfo() {
		CategoryMoreInfo.click();
		return new ManageCategoryPage(driver);
	}

	public ManageNewsPage clickManageNewsMoreInfo() {
		waitutility.waitForElementToBeClickable(driver, ManageNewsMoreInfo);
		ManageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}

	public void clickAdmin() {
		AdminClick.click();
	}

	public void logOut() {
		AdminLogOut.click();

	}

	public Boolean verifySuccessfullyLoggedOut() {
		return SignInEnabled.isEnabled();

	}

}
