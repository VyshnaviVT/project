package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageProductSearch;
import utilities.ExcelUtility;

public class ManageProductSearchTest extends BaseMart {
	@Test
	public void manageProductSearch() throws IOException {

		String userNameField = ExcelUtility.getStringData(1, 0, "Login_data");
		String passWord = ExcelUtility.getStringData(1, 1, "Login_data");
		LoginPage login = new LoginPage(driver);
		login.entervalidUsername(userNameField);
		login.entervalidPassword(passWord);
		login.clickOnSigninbutton();

		ManageProductSearch search = new ManageProductSearch(driver);
		search.selectDashboard();
		search.clickOnManageProduct();
		search.clickOnSearchButton();
		String title = ExcelUtility.getStringData(1, 0, "manageproduct_search");
		String productcode = ExcelUtility.getStringData(1, 1, "manageproduct_search");
		search.enterTitle(title);
		search.enterProductCode(productcode);
		search.selectCategoryfromDropdown();
		search.selectSubCategoryfromDropDown();
		search.clickOnSearch();
		
		boolean isSuccessAlertdisplayed = search.isAlertdisplayed();
		assertTrue(isSuccessAlertdisplayed, Constants.ERRORFORMANAGEPRODUCTSEARCH);
	}
}
