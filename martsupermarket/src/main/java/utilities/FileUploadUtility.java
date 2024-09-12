package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	
	//robots,sendkeys codes should be here
	public void selectAll() throws AWTException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
	}
	
	public void imageUploadForManageCategory(WebElement element,String FilePath)
	{
		element.sendKeys(FilePath);
	}
 
}
