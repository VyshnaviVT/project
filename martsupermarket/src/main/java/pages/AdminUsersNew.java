package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.waitUtility;

public class AdminUsersNew {
	WebDriver driver;

	public AdminUsersNew(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	PageUtility page = new PageUtility();
	waitUtility Wait = new waitUtility();

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	WebElement adminUsers;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[1]")
	WebElement manageUsers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertypeDropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public AdminUsersNew clickAdminUsers() {
		adminUsers.click();
		return this;
	}

	public AdminUsersNew clickManageUsers() {
		manageUsers.click();
		return this;
	}

	public AdminUsersNew clickNewbutton() {
		newButton.click();
		return this;
	}

	public AdminUsersNew enterUsername(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public AdminUsersNew enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public AdminUsersNew selectUsertypefromDropdown() {

		page.selectUserType(usertypeDropdown);
		// Select dropdown1 = new Select(usertypeDropdown);
		// dropdown1.selectByIndex(2);
		return this;
	}

	public AdminUsersSearch clickSave() {
		Wait.waitAdmin(saveButton);
		saveButton.click();
		return new AdminUsersSearch(driver);
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
