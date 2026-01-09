package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	LogoutPage logoutpage;
	AdminUsersPage adminuserspage;

	@Test(priority = 1, retryAnalyzer = retry.Retry.class, groups = { "regression" },description="Testcase to add new user credentials")
	public void verifyAdminUser() throws IOException {

		String user = ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(user).enterPassword(pin);
//		loginpage.enterPassword(pin);
		logoutpage = loginpage.clickSignin();

//Admin user Test case

//		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
//		String uname=ExcelUtility.readStringData(1, 0, "AdminUsers");
//		String password=ExcelUtility.readStringData(1, 1, "AdminUsers");
		FakerUtility fakerutility = new FakerUtility();
		String uname = fakerutility.creatARandomFirstName();
		String password = fakerutility.creatARandomFirstName();
		LogoutPage logoutpage = new LogoutPage(driver);
		adminuserspage = logoutpage.clickAdminUserMoreInfo();
		adminuserspage.clickNew().enterUsername(uname).enterPassword(password).eneterUserType().clickSaveButton();
//		adminuserspage.enterUsername(uname);
//		adminuserspage.enterPassword(password);
//		adminuserspage.eneterUserType();
//		adminuserspage.clickSaveButton();
//		adminuserspage.verifyAdminAlertIsDisplayed();

		boolean alert = adminuserspage.verifyAdminAlertIsDisplayed();
		Assert.assertTrue(alert,"Error occured:not able to add new user");
	}
}
