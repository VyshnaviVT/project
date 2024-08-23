//passed in normal case-failed after adding utilities

package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersNew;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersNewTest extends BaseMart {
	@Test
	public void adminUsersNew() throws IOException {

		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		AdminUsersNew usernew = new AdminUsersNew(driver);
		String adminusername = ExcelUtility.getStringData(1, 0, "AdminUserDetails");
		String adminpassword = ExcelUtility.getStringData(1, 1, "AdminUserDetails");
		usernew.clickAdminUsers();
		usernew.clickManageUsers();
		usernew.clickNewbutton();
		usernew.enterUsername(adminusername);
		usernew.enterPassword(adminpassword);
		usernew.selectUsertypefromDropdown();
		usernew.clickSave();

		boolean isAlertdisplayed = usernew.isAlertDisplayed();
		assertTrue(isAlertdisplayed, Constants.ERRORFORADMINUSERNEWUSER);
	}
}
