//Failed save button is not clicking
package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageSubcategoryNew;
import utilities.ExcelUtility;

public class ManageSubcategoryNewTest extends BaseMart {
	@Test
	public void manageSubcategoryNew() throws IOException {

		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();
		
		ManageSubcategoryNew newsub=new ManageSubcategoryNew(driver);
		String subcategory = ExcelUtility.getStringData(1, 0, "manage_subcategory");
	//	newsub.clickManageCategory();
		newsub.clickSubCategory();
		newsub.clicknewButton();
		newsub.selectcategoryfromDropdown();
		newsub.enterSubcategory(subcategory);
		newsub.imageUpload();
		newsub.clickSaveButton();
		
		boolean isAlertLoaded = newsub.isAlertdisplayed();
		assertTrue(isAlertLoaded, Constants.ERRORFORMANAGESUBCATEGORYALERT);
		
	}
}
