package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
//	LogoutPage logoutpage;
	ManageCategoryPage managecategorypage;

	@Test(priority = 1, retryAnalyzer = retry.Retry.class,description="Testcase to add new grocery to the list")
	public void verifyContact() throws IOException {
		// ,retryAnalyzer=retry.Retry.class)
		String user = ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignin();

//Category Test case

		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		String categoryname = ExcelUtility.readStringData(1, 0, "ManageCategory");
//		managecategorypage.clickCategoryMoreInfo();
		LogoutPage logoutpage = new LogoutPage(driver);
		managecategorypage = logoutpage.clickCategoryMoreInfo();
		managecategorypage.clickNew().enterCategoryname(categoryname).getChooseFileElement().clickSaveButton();
//		managecategorypage.enterCategoryname(categoryname);
//		FileUploadUtility.fileUploadUsingSendkeys(managecategorypage.getChooseFileElement(),Constant.IMAGEDATAFILE);
//		managecategorypage.clickSaveButton();
//		managecategorypage.clickNew();
//        managecategorypage.verifyCategoryAlertIsDisplayed();
//		boolean alert = managecategorypage.verifyCategorySaveButtonIsEnabled();
//		Assert.assertTrue(alert,Constant.MANAGECATEGORY);
	}
}
