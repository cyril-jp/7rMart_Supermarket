package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
//	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement CategoryMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement NewButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement CategoryField;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement DiscountField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement ChooseFile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SaveButton;
	@FindBy(xpath = "//div[contains(@class,' alert-success')]")
	WebElement AlertCategory;
	@FindBy(xpath = "//div[contains(@class,' alert-danger')]")
	WebElement AlertCategoryExisting;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
//	public void clickCategoryMoreInfo()
//	{
//		CategoryMoreInfo.click();
//	}

	public ManageCategoryPage clickNew() {
		pageutility.ClickMethod(NewButton, driver);
		return this;

	}

	public ManageCategoryPage enterCategoryname(String categoryname) {
		CategoryField.sendKeys(categoryname);
		return this;
	}

	public ManageCategoryPage clickDiscountOption() {
		DiscountField.click();
		return this;
	}
//	public WebElement getChooseFileElement() {
//		return ChooseFile;
//	}
	public ManageCategoryPage getChooseFileElement() {
		FileUploadUtility.fileUploadUsingSendkeys(ChooseFile, Constant.IMAGEDATAFILE);
		return this;
	}

	public ManageCategoryPage clickSaveButton() {
//		pageutility.javaScriptExecutorMethod(SaveButton,driver);

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", SaveButton);

//		Actions actions = new Actions(driver);
//		actions.click(SaveButton).perform();

		pageutility.ClickMethod(SaveButton, driver);
		return this;

	}


	public Boolean verifyCategoryAlertIsDisplayed() {
	    try {
	        // First check success alert
	        if (AlertCategory.isDisplayed()) {
	            System.out.println("Success Alert displayed – Category added");
	            return true;
	        }
	    } catch (Exception e) {
	        // Ignore – success alert not present
	    }

	    try {
	        // Then check danger alert (already exists)
	        if (AlertCategoryExisting.isDisplayed()) {
	            System.out.println("Danger Alert displayed – Category already exists");
	            return true;
	        }
	    } catch (Exception e) {
	        // Ignore – danger alert not present
	    }

	    System.out.println("No alert displayed");
	    return false;
	}


	}

