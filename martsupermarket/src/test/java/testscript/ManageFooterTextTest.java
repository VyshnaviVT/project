//may be failed due to scroll

package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageFooterText;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;

public class ManageFooterTextTest extends BaseMart {
	@Test
	public void manageFooterText() throws AWTException, IOException {

		FileUploadUtility fileUpload = new FileUploadUtility();
		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		ManageFooterText edit = new ManageFooterText(driver);
		String address = ExcelUtility.getStringData(1,0, "manage_footerText");
		String email = ExcelUtility.getStringData(1,1, "manage_footerText");
		String phone = ExcelUtility.getStringData(1,2, "manage_footerText");
	
		edit.clickManageFooterText();
		edit.clickEditButton();
		edit.enterAddressField(address);
		edit.enterEmailField(email);
		edit.enterPhoneField(phone);
		edit.clickUpdateButton();

		boolean isSuccessfullmesgdisplayed = edit.isFooterDisplayedSuccessfullydisplayed();
		assertTrue(isSuccessfullmesgdisplayed, Constants.ERRORFORMANAGEFOOTER);
	}

}