package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsNew {
	WebDriver driver;

	public ManageNewsNew(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[1]")
	WebElement manageNews;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	public void clickManageNews() {
		manageNews.click();
	}
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void enterNews(String news) {
		newsField.sendKeys(news);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public boolean isAlertdisplayed()
	{
		return alert.isDisplayed();
	}
	
}
