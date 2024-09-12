package testscript;

import org.testng.annotations.Test;

import constants.Constants;
import utilities.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseMart {
	WebDriver driver;
	public Properties properties;
	public FileInputStream fis;
	ScreenshotUtility scrshot;

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")   //crossbroser testing
	public void initializeMethod(String browser) throws Exception {  //for crossbrowser testing changed method name and pass parameters
		try {
			properties = new Properties();
			fis = new FileInputStream(Constants.CONFIGFILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		
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
	//	driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("url"));
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
