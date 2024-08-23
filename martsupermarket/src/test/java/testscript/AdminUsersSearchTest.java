//passed test

package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersSearch;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersSearchTest extends BaseMart {
	@Test
	public void adminUsersSearch() throws IOException {

		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		AdminUsersSearch search = new AdminUsersSearch(driver);
		String usernameField = ExcelUtility.getStringData(2,0,"Admin_UserSearch");
		search.clickAdminUsers();
		search.clickManageUsers();
		search.clickSearchbutton();
		search.enterUsername(usernameField);
		search.selectUsertypefromDropdown();
		search.clickSearchButton2();

		boolean isalertdisplayed = search.isAlertDisplayed();
		assertTrue(isalertdisplayed, Constants.ERRORFORADMINUSERSEARCH);
	}
}
