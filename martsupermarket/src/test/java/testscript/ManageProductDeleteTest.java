//PASSED
package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageProductDelete;
import pages.ManageProductSearch;
import utilities.ExcelUtility;

public class ManageProductDeleteTest extends BaseMart {
	@Test
	public void manageProductDelete() throws IOException {

		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		ManageProductDelete delete = new ManageProductDelete(driver);
		delete.selectDashboard();
		delete.clickOnManageProduct();
		delete.deletebutton();
		boolean isSuccessAlertdisplayed = delete.isAlertdisplayed();
		assertTrue(isSuccessAlertdisplayed, Constants.ERRORFORMANAGEPRODUCTDELETE);
	}
}
