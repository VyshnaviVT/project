package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductDelete {

	WebDriver driver;

	public ManageProductDelete(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-th-large']")
	WebElement dashboard;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[1]")
	WebElement manageProduct;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/delete?del=941&page_ad=1']")
	WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement Alert;
	

	public void selectDashboard() {
		dashboard.click();
	}

	public void clickOnManageProduct() {
		manageProduct.click();
	}

	public void deletebutton() {
		deleteButton.click();
		driver.switchTo().alert().accept(); // alert handling
	}

	public boolean isAlertdisplayed() {
		return Alert.isDisplayed();
	}

}
