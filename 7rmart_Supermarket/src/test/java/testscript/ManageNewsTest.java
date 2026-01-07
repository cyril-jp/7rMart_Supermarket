package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base 
{
	@Test(priority=1,groups= {"regression"})
	public void verifyManageNews() throws IOException
	{
		
		String user=ExcelUtility.readStringData(1, 0, "LoginPage");
		String pin=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(user);
		loginpage.enterPassword(pin);
		loginpage.clickSignin();
		
//managenews Test case
		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		String news=ExcelUtility.readStringData(0, 0, "ManageNews");
		managenewspage.clickManageNews();
		managenewspage.clickNew();
		managenewspage.enterNews(news);
		managenewspage.clickSave();
		
		
		
		boolean alert=managenewspage.verifyManageAlertIsDisplayed();
		Assert.assertTrue(alert);
	}
}
