package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base
{
	@Test(priority=1,groups= {"regression"})
	public void verifyFooterText() throws IOException
	{
		
		String user=ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignin();
		
		//footer text Test case
		
		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
				String email=ExcelUtility.readStringData(1, 0, "ManageFooterText");
				String phone=ExcelUtility.readIntegerData(1, 1, "ManageFooterText");
				managefootertextpage.clickFooterTextMoreInfo();
				managefootertextpage.clickActionButton();
				managefootertextpage.enterEmail(email);
				managefootertextpage.enterPhoneNumber(phone);
				managefootertextpage.clickUpdateButton();
//				managefootertextpage.verifyFooterTextAlertIsDisplayed();
				boolean alert=managefootertextpage.verifyFooterTextAlertIsDisplayed();
				Assert.assertTrue(alert);
		
	}
}
