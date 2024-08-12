package pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
    @FindBy(xpath="//p[text()='Dashboard']") WebElement dashBoard;
	public void entervalidUsername(String username) {
		userName.sendKeys(username);
	}

	public void entervalidPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void clickOnSigninbutton() {
		signInButton.click();
	}
	public boolean isDashboardDisplayed() {
		return dashBoard.isDisplayed();
	}
}
