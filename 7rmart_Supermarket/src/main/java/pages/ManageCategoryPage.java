package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {
	public WebDriver driver;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement CategoryMoreInfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement NewButton;
	@FindBy(xpath="//input[@id='category']")WebElement CategoryField;
	@FindBy(xpath="//input[@id='main_img']")WebElement ChooseFile;
	@FindBy(xpath="//button[text()='Save']")WebElement SaveButton;
	@FindBy(xpath="//div[contains(@class,' alert-success')]")WebElement AlertCategory;

	
	

	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public void clickCategoryMoreInfo()
	{
		CategoryMoreInfo.click();
	}
	public void clickNew()
	{
		NewButton.click();
		
	}
	public void enterCategoryname(String categoryname)
	{
		CategoryField.sendKeys(categoryname);	
	}
	
	 public WebElement getChooseFileElement() 
	 {
	        return ChooseFile;
	    }
//	public Boolean verifyAdminUserPageIsDisplayed()
//	{
//		return AdminUsersPage.isDisplayed();
//		
//	}
	public void clickSaveButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SaveButton);
	}
	
	public Boolean verifyCategoryAlertIsDisplayed()
	{
		return AlertCategory.isDisplayed();
		
	}
}