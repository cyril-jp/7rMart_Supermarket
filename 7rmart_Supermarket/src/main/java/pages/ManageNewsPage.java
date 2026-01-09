package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;

	WaitUtility waitutility = new WaitUtility();

//	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement ManageNewsMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement New;
	@FindBy(css = "textarea#news")
	WebElement Enternews;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Clicksave;
	@FindBy(xpath = "//h1[text()='Manage News']")
	WebElement ManageNewsPage;
	@FindBy(xpath = "//div[contains(@class,' alert-success')]")
	WebElement AlertManageNews;

//	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement AdminClick;
//	@FindBy(xpath="//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement AdminLogOut;
//	@FindBy(xpath="//button[@type='submit']")WebElement SignInEnabled;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public void clickManageNewsMoreInfo()
//	{
//	waitutility.waitForElementToBeClickable(driver, ManageNewsMoreInfo);
//	ManageNewsMoreInfo.click();
//	}
	public ManageNewsPage clickNew() {
		New.click();
		return this;

	}

	public ManageNewsPage enterNews(String news) {
		Enternews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSave() {
		Clicksave.click();
		return this;

	}

	public Boolean verifyManageNewsPageIsDisplayed() {
	    waitutility.waitForVisibility(driver, AlertManageNews);
	    return AlertManageNews.isDisplayed();
	}


}
