package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
@Test(priority=1)
public void verifyTheUserIsAbleToLoginWithValidCredentials() throws IOException
{
//	String user="admin";
//	String pin="admin";
	String user=ExcelUtility.readStringData(1, 0, "LoginPage");
	String pin=ExcelUtility.readStringData(1, 1, "LoginPage");
//	String news=ExcelUtility.readStringData(0, 0, "ManageNews");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(user);
	loginpage.enterPassword(pin);
	loginpage.clickSignin();
	boolean homepage=loginpage.verifyHomePageIsDisplayed();
	Assert.assertTrue(homepage);
}
//@Test(priority=2)
//public void verifyTheUserIsAbleToLoginWithIncorrectUsernameCorrectPin() throws IOException
//{
////	String user="cyril";
////	String pin="admin";
//	String user=ExcelUtility.readStringData(2, 0, "LoginPage");
//	String pin=ExcelUtility.readStringData(2, 1, "LoginPage");
//	LoginPage loginpage=new LoginPage(driver);
//	loginpage.enterUserName(user);
//	loginpage.enterPassword(pin);
//	loginpage.clickSignin();
//	boolean alert=loginpage.verifyAlertIsDisplayed();
//	Assert.assertTrue(alert);
//}
//@Test(priority=3)
//public void verifyTheUserIsAbleToLoginWithCorrectUsernameIncorrectPin() throws IOException
//{
////	String user="admin";
////	String pin="cyril";
//	String user=ExcelUtility.readStringData(3, 0, "LoginPage");
//	String pin=ExcelUtility.readStringData(3, 1, "LoginPage");
//	LoginPage loginpage=new LoginPage(driver);
//	loginpage.enterUserName(user);
//	loginpage.enterPassword(pin);
//	loginpage.clickSignin();
//	boolean alert=loginpage.verifyAlertIsDisplayed();
//	Assert.assertTrue(alert);
//}
//@Test(priority=4)
//public void verifyTheUserIsAbleToLoginWithIncorrectUsernameIncorrectPin() throws IOException
//{
////	String user="cyril";
////	String pin="alan";
//	String user=ExcelUtility.readStringData(4, 0, "LoginPage");
//	String pin=ExcelUtility.readStringData(4, 1, "LoginPage");
//	LoginPage loginpage=new LoginPage(driver);
//	loginpage.enterUserName(user);
//	loginpage.enterPassword(pin);
//	loginpage.clickSignin();
//	boolean alert=loginpage.verifyAlertIsDisplayed();
//	Assert.assertTrue(alert);
//}
	
}

