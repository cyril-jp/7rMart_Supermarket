package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	LogoutPage logoutpage;
	ManageNewsPage managenewspage;

	@Test(priority = 1, groups = { "regression" },description="Testcase to enter new product launch details")
	public void verifyManageNews() throws IOException {

		String user = ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(user).enterPassword(pin);
//		loginpage.enterPassword(pin);
		logoutpage = loginpage.clickSignin();

//managenews Test case

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		String news = ExcelUtility.readStringData(0, 0, "ManageNews");
		LogoutPage logoutpage = new LogoutPage(driver);
		managenewspage = logoutpage.clickManageNewsMoreInfo();
		managenewspage.clickNew().enterNews(news).clickSave();
//		managenewspage.enterNews(news);
//		managenewspage.clickSave();

		boolean alert = managenewspage.verifyManageNewsPageIsDisplayed();
		Assert.assertTrue(alert,Constant.MANAGENEWS);
	}
}
