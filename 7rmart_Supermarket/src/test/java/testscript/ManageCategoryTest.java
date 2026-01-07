package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;

public class ManageCategoryTest extends Base
{
	@Test(priority=1,retryAnalyzer=retry.Retry.class)
	public void verifyContact() throws IOException
	{
		
		String user=ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignin();
		
//Category Test case
		
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		String categoryname=ExcelUtility.readStringData(1, 0, "ManageCategory");
		managecategorypage.clickCategoryMoreInfo();
		managecategorypage.clickNew();
		managecategorypage.enterCategoryname(categoryname);
		FileUploadUtility.fileUploadUsingSendkeys(managecategorypage.getChooseFileElement(),Constant.IMAGEDATAFILE);
		managecategorypage.clickSaveButton();
//		managecategorypage.verifyCategoryAlertIsDisplayed();
		boolean alert=managecategorypage.verifyCategoryAlertIsDisplayed();
		Assert.assertTrue(alert);
}
}
