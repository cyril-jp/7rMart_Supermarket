package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	LogoutPage logoutpage;
@Test(priority=1,description="Testcase to check user is login with valid username and password")
public void verifyTheUserIsAbleToLoginWithValidCredentials() throws IOException
{
//	String user="admin";
//	String pin="admin";
	String user=ExcelUtility.readStringData(1, 0, "LoginPage");
	String pin=ExcelUtility.readStringData(1, 1, "LoginPage");
//	String news=ExcelUtility.readStringData(0, 0, "ManageNews");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(user).enterPassword(pin);
//	loginpage.enterPassword(pin);
//	loginpage.clickSignin();
	logoutpage = loginpage.clickSignin();
	boolean homepage=loginpage.verifyHomePageIsDisplayed();
	Assert.assertTrue(homepage,Constant.LOGINVALIDCREDENTIALS);
}
@Test(priority=2,description="Testcase to check user is login with invalid username and valid password")
public void verifyTheUserIsAbleToLoginWithIncorrectUsernameCorrectPin() throws IOException
{
//	String user="cyril";
//	String pin="admin";
	String user=ExcelUtility.readStringData(2, 0, "LoginPage");
	String pin=ExcelUtility.readStringData(2, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(user).enterPassword(pin);
//	loginpage.enterPassword(pin);
//	loginpage.clickSignin();
	logoutpage = loginpage.clickSignin();
	boolean alert=loginpage.verifyAlertIsDisplayed();
	Assert.assertTrue(alert,Constant.LOGININVALIDUSERNAME);
}
@Test(priority=3,description="Testcase to check user is login with valid username and invalid password")
public void verifyTheUserIsAbleToLoginWithCorrectUsernameIncorrectPin() throws IOException
{
//	String user="admin";
//	String pin="cyril";
	String user=ExcelUtility.readStringData(3, 0, "LoginPage");
	String pin=ExcelUtility.readStringData(3, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(user).enterPassword(pin);
//	loginpage.enterPassword(pin);
//	loginpage.clickSignin();
	logoutpage = loginpage.clickSignin();
	boolean alert=loginpage.verifyAlertIsDisplayed();
	Assert.assertTrue(alert,Constant.LOGININVALIDPIN);
}
@Test(priority=4,description="Testcase to check user is login with invalid username and invalid password",dataProvider="LoginProvider")
public void verifyTheUserIsAbleToLoginWithIncorrectUsernameIncorrectPin(String user,String pin) throws IOException
{
//	String user="cyril";
//	String pin="alan";
//	String user=ExcelUtility.readStringData(4, 0, "LoginPage");
//	String pin=ExcelUtility.readStringData(4, 1, "LoginPage");
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(user).enterPassword(pin);
//	loginpage.enterPassword(pin);
//	loginpage.clickSignin();
	logoutpage = loginpage.clickSignin();
	boolean alert=loginpage.verifyAlertIsDisplayed();
	Assert.assertTrue(alert,Constant.LOGININVALIDCREDENTIALS);
}
@DataProvider(name="LoginProvider")
public Object[][] getDataFromTestData() throws IOException{
	return new Object[][] {{ExcelUtility.readStringData(4, 0,"loginpage"),ExcelUtility.readStringData(4,1,"loginpage")}};	
}
}

