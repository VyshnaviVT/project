package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class ManageProductSearch {

	WebDriver driver;

	public ManageProductSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//i[@class='nav-icon fas fa-th-large']") WebElement dashboard;
    @FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[1]") WebElement manageProduct;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement titleField;
	@FindBy(xpath = "//input[@name='cd']")
	WebElement productCodeField;
	@FindBy(xpath = "//select[@name='cat_id']")
	WebElement categoryField;
	@FindBy(xpath = "//select[@name='sb']")
	WebElement subcategoryField;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement search;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']") WebElement alert;
	

	public void selectDashboard() {
	dashboard.click();
	}
	
	public void clickOnManageProduct() {
		manageProduct.click();
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void enterTitle(String title) {
		titleField.sendKeys(title);
	}

	public void enterProductCode(String productcode) {
		productCodeField.sendKeys(productcode);
	}

	public void selectCategoryfromDropdown() {
		Select dropdown1 = new Select(categoryField);
		dropdown1.selectByIndex(3);
	}

	public void selectSubCategoryfromDropDown() {
		//Select dropdown2 = new Select(subcategoryField);
    	//dropdown2.selectByIndex(4);
		
		PageUtility page=new PageUtility();
		page.selectIndex(categoryField);
	}

	public void clickOnSearch() {
		search.click();
	}
	
	public boolean isAlertdisplayed() {
		return alert.isDisplayed();
	}
}
