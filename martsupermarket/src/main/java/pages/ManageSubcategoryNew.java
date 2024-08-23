package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class ManageSubcategoryNew {
	WebDriver driver;

	public ManageSubcategoryNew(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//i[@class='nav-icon fas fa-list-alt']") WebElement manageCategory;  //site has removed manage category
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[1]")
	WebElement subCategory;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement categoryDropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageUpload;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	PageUtility category=new PageUtility();

	/*public void clickManageCategory() {
		manageCategory.click();
	}*/
	
	public void clickSubCategory() {
		subCategory.click();
	}
	
	public void clicknewButton() {
		newButton.click();
	}
	
	public void selectcategoryfromDropdown() {
		category.selectCategoryDropDown(categoryDropdown);
		//Select dropdown1 = new Select(categoryDropdown);
		//dropdown1.selectByIndex(2);
	}
	
	public void enterSubcategory(String subcategory) {
		subCategoryfield.sendKeys(subcategory);
	}
	
	public void imageUpload() {
		
	imageUpload.sendKeys("C:\\Users\\vyshnavi\\Downloads\\chips.jpeg");
	}

	public void clickSaveButton() {
		saveButton.click();
	}
	
	public boolean isAlertdisplayed()
	{
		return alert.isDisplayed();
	}

}
