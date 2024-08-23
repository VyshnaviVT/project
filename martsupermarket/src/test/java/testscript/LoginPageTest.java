package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends BaseMart {
	@Test(priority = 1)
	public void verifyValidUsernameandPassword() throws IOException {
		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");// row,column
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		// assertion
		boolean isDashBoardisLoaded = login.isDashboardDisplayed();
		assertTrue(isDashBoardisLoaded, Constants.ERRORMESSAGEFORLOGIN);
	}

	@Test(priority = 2)
	public void verifyInValidUsernameandValidPassword() throws IOException {
		String userNameField = ExcelUtility.getStringData(2, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
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
