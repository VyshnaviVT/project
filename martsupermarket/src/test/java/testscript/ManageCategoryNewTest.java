//not passed scroll issue
package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageCategoryNew;
import pages.ManageSubcategoryNew;
import utilities.ExcelUtility;

public class ManageCategoryNewTest extends BaseMart {
	@Test
	public void managecategoryNew() throws IOException {

		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		ManageCategoryNew category = new ManageCategoryNew(driver);
		String category1 = ExcelUtility.getStringData(1, 0, "Manage_category");
		//category.clickManageCategory();
		category.clickCategory();
		category.clicknewButton();
		category.entercategory(category1);
		category.clickSelectGroup();
		category.clickSaveButton();

		boolean isAlertLoaded = category.isAlertdisplayed();
		assertTrue(isAlertLoaded, Constants.ERRORFORMANAGECATEGORYALERT);
	}
}
