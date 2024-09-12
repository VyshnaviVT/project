package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.waitUtility;

public class ManageFooterText {
	WebDriver driver;

	public ManageFooterText(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	FileUploadUtility fileUpload=new FileUploadUtility();
	waitUtility Wait = new waitUtility();

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'][1]")
	WebElement manageFooterText;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2']")
	WebElement editButton;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement addressField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneField;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertVisible;

	public void clickManageFooterText() {
		manageFooterText.click();
	}

	public void clickEditButton() {
		editButton.click();
	}

	public void enterAddressField(String address) throws AWTException {
		addressField.click();
		fileUpload.selectAll();
		addressField.sendKeys(address);
	}

	public void enterEmailField(String email) throws AWTException {
		emailField.click();
		fileUpload.selectAll();
		emailField.sendKeys(email);
	}

	public void enterPhoneField(String phone) throws AWTException {
		phoneField.click();
		fileUpload.selectAll();
		phoneField.sendKeys(phone);
	}

	public void clickUpdateButton() {
		Wait.waitManageFooter(updateButton);
		updateButton.click();
	}
	
	public boolean isFooterDisplayedSuccessfullydisplayed()
	{
		return alertVisible.isDisplayed();
	}
}
