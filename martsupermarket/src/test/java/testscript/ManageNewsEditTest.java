//passed
package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsEdit;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;

public class ManageNewsEditTest extends BaseMart {
	@Test
	public void manageNewsEdit() throws AWTException, IOException {
		
		FileUploadUtility fileUpload = new FileUploadUtility();
		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		ManageNewsEdit edit = new ManageNewsEdit(driver);
		String newsField = ExcelUtility.getStringData(1, 0, "Manage_newsEdit");
		edit.clickManageNews();
		edit.clickEditButton();
		edit.enterNews(newsField);
		edit.clickUpdateButton();

		boolean isSuccessAlertdisplayed = edit.isAlertdisplayed();
		assertTrue(isSuccessAlertdisplayed, Constants.ERRORFORMANAGENEWSEDIT);

	}
}
