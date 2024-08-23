//passed
package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsNew;
import utilities.ExcelUtility;

public class ManageNewsNewTest extends BaseMart {
	@Test
	public void manageNewsNew() throws IOException {
		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		ManageNewsNew news = new ManageNewsNew(driver);
		String newsField = ExcelUtility.getStringData(1, 0, "Manage_newsNew");
		news.clickManageNews();
		news.clickNewButton();
		news.enterNews(newsField);
		news.clickSaveButton();
		
		boolean isSuccessAlertdisplayed = news.isAlertdisplayed();
		assertTrue(isSuccessAlertdisplayed, Constants.ERRORFORMANAGENEWSNEW);
	}

}
