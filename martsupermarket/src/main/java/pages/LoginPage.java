package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);  //Page factory defined
	}

	@FindBy(xpath = "//input[@name='username']") WebElement userName;
	@FindBy(xpath = "//input[@name='password']") WebElement password;
	@FindBy(xpath = "//button[@type='submit']") WebElement signInButton;
	@FindBy(xpath = "//p[text()='Dashboard']") WebElement dashBoard;
	@FindBy(xpath="//i[@class='icon fas fa-ban']") WebElement alertSymbol;

	public LoginPage entervalidUsername(String username) {
		userName.sendKeys(username);
		return this;
	}

	public LoginPage  entervalidPassword(String passWord) {
		password.sendKeys(passWord);
		return this;
	}

	public AdminUsersNew clickOnSigninbutton() {
		signInButton.click();
		return new AdminUsersNew(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashBoard.isDisplayed();
	}
	
	public boolean isAlertforInvalidUsernameORPasswordAvailable()
	{
		return alertSymbol.isDisplayed();
	}
	
}


