package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.waitUtility;

public class ManageNewsEdit {
	WebDriver driver;

	public ManageNewsEdit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	FileUploadUtility fileUpload=new FileUploadUtility();
	waitUtility Wait = new waitUtility();
	
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[1]")
	WebElement manageNews;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/edit?edit=1705&page_ad=1']")
	WebElement editButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsField;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	public void clickManageNews() {
		manageNews.click();
	}
	
	public void clickEditButton() {
		editButton.click();
	}
	
	public void enterNews(String news) throws AWTException {
		
		newsField.click();
		fileUpload.selectAll();
		newsField.sendKeys(news);
	}
	
	public void clickUpdateButton() {
		Wait.waitManageNewEdit(updateButton);
		updateButton.click();
	}
	
	public boolean isAlertdisplayed()
	{
		return alert.isDisplayed();
	}
}
