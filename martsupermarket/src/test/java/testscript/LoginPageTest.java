package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends BaseMart {
	
	@DataProvider(name="credentials")
	public Object[][] testData() {        // data provider
		Object[][] input = new Object[2][2];
		input[0][0] = "admin";
		input[0][1] = "admin";
		input[1][0] = "admin@123";
		input[1][1] = "admin123";
		return input;
		}
	@Test(priority = 1,retryAnalyzer = retry.Retry.class, dataProvider = "credentials",groups={"Smoke"})
	public void verifyValidUsernameandPassword(String userNameField,String passWord) throws IOException {
	//	String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");// row,column
	//	String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		// assertion
		boolean isDashBoardisLoaded = login.isDashboardDisplayed();
		assertTrue(isDashBoardisLoaded, Constants.ERRORMESSAGEFORLOGIN);
	}

	@Test(priority = 2)
	@Parameters({"Username","Password"})
	public void verifyInValidUsernameandValidPassword(String userNameField,String passWord) throws IOException {
	//	String userNameField = ExcelUtility.getStringData(2, 0, "Login_data");
	//	String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		boolean invalidPasswordAlert = login.isAlertforInvalidUsernameORPasswordAvailable();
		assertTrue(invalidPasswordAlert, Constants.ERRORMESSAGEFORINVALIDUSERNAME);
	}

	@Test(priority = 3)
	public void verifyValidUsernameandInValidPassword() throws IOException {
		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(2, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		boolean invalidPasswordAlert = login.isAlertforInvalidUsernameORPasswordAvailable();
		assertTrue(invalidPasswordAlert, Constants.ERRORMESSAGEFORINVALIDPASSWORD);
	}

	@Test(priority = 4)
	public void verifyInValidUsernameandInValidPassword() throws IOException {
		String userNameField = ExcelUtility.getStringData(2, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(2, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		boolean invalidPasswordAlert = login.isAlertforInvalidUsernameORPasswordAvailable();
		assertTrue(invalidPasswordAlert, Constants.ERRORMESSAGEFORINVALIDUSER);
	}

}
