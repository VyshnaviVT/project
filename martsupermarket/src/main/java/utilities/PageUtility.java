package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
//dropdown,select,drag,scrolldown
	WebDriver driver;

	public void selectUserType(WebElement usertype) {
		Select select = new Select(usertype);
		select.selectByIndex(2);
	}

	public void selectIndex(WebElement elementIndex) {
		Select select = new Select(elementIndex);
		select.selectByIndex(0);
	}
	
	public void selectCategoryDropDown(WebElement element)
	{
		Select select=new Select(element);
		select.selectByValue("164");
	}
}
