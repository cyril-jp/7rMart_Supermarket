package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base 
{
	@Test(priority=1)
	public void verifyLogout() throws IOException
	{
		String user=ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignin();
		
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.clickAdmin();
	    logoutpage.logOut();
//		logoutpage.verifySuccessfullyLoggedOut();
		boolean alert=logoutpage.verifySuccessfullyLoggedOut();
		Assert.assertTrue(alert,"Error occured :Not able to log out");
	}
}

