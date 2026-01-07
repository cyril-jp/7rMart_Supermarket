package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	
	public void browserInitialization(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else 
		{
			throw new Exception("invalid browser");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITEWAIT));
		driver.manage().window().maximize();
		
		
	
	}
//	@AfterMethod
//	public void browserclose()
//	{
//		driver.close();
//	    driver.quit();
//	}

	



}

