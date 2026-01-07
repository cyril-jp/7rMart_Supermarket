package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base
{
	@Test(priority=1,groups= {"regression"})
	public void verifyContact() throws IOException
	{
		
		String user=ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignin();
		
		//Contact text Test case
		
		ManageContactPage managecontactpage = new ManageContactPage(driver);
				String email=ExcelUtility.readStringData(1, 0, "ManageContact");
				String phone=ExcelUtility.readIntegerData(1, 1, "ManageContact");
				String time=ExcelUtility.readIntegerData(1, 2, "ManageContact");
				managecontactpage.clickContactMoreInfo();
				managecontactpage.clickActionButton();
				managecontactpage.enterEmail(email);
				managecontactpage.enterPhoneNumber(phone);
				managecontactpage.enterDeliveryTime(time);
				managecontactpage.clickUpdateButton();
//				managecontactpage.verifyContactAlertIsDisplayed();
				
				boolean alert=managecontactpage.verifyContactAlertIsDisplayed();
				Assert.assertTrue(alert);
		
	}
}
