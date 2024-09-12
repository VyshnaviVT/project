package constants;

import java.security.PublicKey;

import org.openqa.selenium.devtools.idealized.Network.UserAgent;

public class Constants {
	//all assertions are 
	//constant means unchangable values,like alert, filepaths
	
	public static final String ERRORMESSAGEFORLOGIN="Dashboard is not loaded";
	public static final String ERRORMESSAGEFORINVALIDPASSWORD="Enter valid Password";
	public static final String ERRORMESSAGEFORINVALIDUSERNAME="Enter valid UserName";
	public static final String ERRORMESSAGEFORINVALIDUSER="Enter valid values";
	
	public static final String ERRORFORMANAGEFOOTER="Success message displayed";
	
	public static final String ERRORFORADMINUSERSEARCH="User notfound";
	
	public static final String ERRORFORADMINUSERNEWUSER="Admin not available";
	
	public static final String ERRORFORMANAGENEWSNEW="Alert is not displayed";
	
	public static final String ERRORFORMANAGECATEGORYALERT="Alert not loaded";
	
	public static final String ERRORFORMANAGESUBCATEGORYALERT ="Alert not loaded";
	
	public static final String ERRORFORMANAGENEWSEDIT = "Alert not loaded";
	
	public static final String ERRORFORMANAGEPRODUCTDELETE = "Alert not loaded";
	
	public static final String ERRORFORMANAGEPRODUCTSEARCH = "Alert not loaded";
	
	public static final String TESTDATAFILE=System.getProperty("user.dir")+"\\src\\test\\resources\\Martsupermarket.xlsx";//"user.dir"- when we apply this half of path will we there
	
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
	
	public static final String IMAGEUPLOAD=System.getProperty("user.dir")+"\\src\\test\\resources\\chips.jpeg";
	
	
}
