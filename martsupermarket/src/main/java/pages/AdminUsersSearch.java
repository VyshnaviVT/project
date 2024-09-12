package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.waitUtility;

public class AdminUsersSearch {
	WebDriver driver;

	public AdminUsersSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	PageUtility page=new PageUtility();
	waitUtility Wait = new waitUtility();

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	WebElement adminUsers;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[1]")
	WebElement manageUsers;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement usernameField;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement usertypeDropdown;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton2;
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']") WebElement alert;
	
	public void clickAdminUsers() {
		adminUsers.click();
	}

	public void clickManageUsers() {
		manageUsers.click();
	}
	
	public void clickSearchbutton() {
		searchButton.click();
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void selectUsertypefromDropdown() {
		
		page.selectUserType(usertypeDropdown);
		//Select dropdown1 = new Select(usertypeDropdown);
		//dropdown1.selectByIndex(2);
	}
	
	public void clickSearchButton2() {
		Wait.waitAdminSearch(searchButton2); 
		searchButton2.click();
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
