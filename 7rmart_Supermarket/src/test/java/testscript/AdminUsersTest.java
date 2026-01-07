package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base
{
	@Test(priority=1,retryAnalyzer=retry.Retry.class,groups= {"regression"})
	public void verifyAdminUser() throws IOException
	{
		
		String user=ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignin();
		
//Admin user Test case
		
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
//		String uname=ExcelUtility.readStringData(1, 0, "AdminUsers");
//		String password=ExcelUtility.readStringData(1, 1, "AdminUsers");
		FakerUtility fakerutility= new FakerUtility();
		String uname=fakerutility.creatARandomFirstName();
		String password=fakerutility.creatARandomFirstName();
		adminuserspage.clickAdminUserMoreInfo();
		adminuserspage.clickNew();
		adminuserspage.enterUsername(uname);
		adminuserspage.enterPassword(password);
		adminuserspage.eneterUserType();
		adminuserspage.clickSaveButton();
//		adminuserspage.verifyAdminAlertIsDisplayed();
		
		boolean alert=adminuserspage.verifyAdminAlertIsDisplayed();
		Assert.assertTrue(alert);
}
}
