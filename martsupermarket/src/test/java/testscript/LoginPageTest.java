package testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginPageTest extends NewTest {
	@Test
	public void verifyEnterValidUsernameandPassword() {
		String userNameField="admin";
		String passWord="admin";
		LoginPage login=new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();
		//assertion
		boolean isDashBoardisLoaded=login.isDashboardDisplayed();
		assertTrue(isDashBoardisLoaded,"Dashboard missing");
		
	}
}
