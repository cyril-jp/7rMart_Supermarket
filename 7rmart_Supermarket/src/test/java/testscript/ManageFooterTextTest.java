package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
//	LogoutPage logoutpage;
	ManageFooterTextPage managefootertextpage;

	@Test(priority = 1, groups = { "regression" },description="Testcase to update user email and phone number")
	public void verifyFooterText() throws IOException {

		String user = ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignin();

		// footer text Test case

		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		String email = ExcelUtility.readStringData(1, 0, "ManageFooterText");
		String phone = ExcelUtility.readIntegerData(1, 1, "ManageFooterText");
		LogoutPage logoutpage = new LogoutPage(driver);
		managefootertextpage = logoutpage.clickFooterTextMoreInfo();
		managefootertextpage.clickActionButton().enterEmail(email).enterPhoneNumber(phone).clickUpdateButton();
//				managefootertextpage.enterEmail(email);
//				managefootertextpage.enterPhoneNumber(phone);
//				managefootertextpage.clickUpdateButton();
//				managefootertextpage.verifyFooterTextAlertIsDisplayed();
		boolean alert = managefootertextpage.verifyFooterTextAlertIsDisplayed();
		Assert.assertTrue(alert,Constant.MANAGEFOOTERTEXT);

	}
}
