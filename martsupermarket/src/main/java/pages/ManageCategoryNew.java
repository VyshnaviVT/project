package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.waitUtility;

public class ManageCategoryNew {
	WebDriver driver;

	public ManageCategoryNew(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	FileUploadUtility file=new FileUploadUtility();
	waitUtility Wait = new waitUtility();
	
	//@FindBy(xpath = "//i[@class='nav-icon fas fa-list-alt']") WebElement manageCategory; //site has removed manage category
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'][1]")
	WebElement category;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryfield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectGroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageUpload;
	@FindBy(xpath = "(//input[@name='top_menu'])[2]")
	WebElement showOnTopMenu;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	/*public void clickManageCategory() {
		manageCategory.click();
	}*/

	public void clickCategory() {
		category.click();
	}

	public void clicknewButton() {
		newButton.click();
	}

	public void entercategory(String category) {
		categoryfield.sendKeys(category);
	}

	public void clickSelectGroup() {
		selectGroup.click();
	}

	public void imageUpload() {
		file.imageUploadForManageCategory(imageUpload,Constants.IMAGEUPLOAD);
		
	}

	public void clickSaveButton() {
		Wait.categoryWait(saveButton);
		saveButton.click();
		
	}
	
	public boolean isAlertdisplayed()
	{
		return alert.isDisplayed();
	}

}
