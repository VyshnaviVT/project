package testscript;

import org.testng.annotations.Test;

import utilities.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseMart {
	WebDriver driver;
	ScreenshotUtility scrshot;

	@BeforeMethod
	@Parameters("Browser")   //crossbroser testing
	public void initializeMethod(String browser) throws Exception {  //for crossbrowser testing changed method name and pass parameters
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
		//driver = new ChromeDriver();
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}

	@AfterMethod
	 public void browserQuit(ITestResult itestresult) throws IOException 
 	 {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenshotUtility();
			scrshot.captureFailureScreenShot(driver, itestresult.getName());
			driver.quit();

		}
 	}
}
