package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {

		public static FileInputStream f;
		public static XSSFWorkbook w;
		public static XSSFSheet s;

	  public static String getStringData(int a,int b,String sheet) throws IOException {
		String filePath=Constants.TESTDATAFILE;
		f=new FileInputStream(filePath);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		Row r=s.getRow(a);     //row&cell are interface
		Cell c=r.getCell(b);
		return c.getStringCellValue();//method for returning cell value
	}
	  
	  public static String getIntegerData(int a,int b,String sheet) throws IOException {
		    String filePath=Constants.TESTDATAFILE;
			f=new FileInputStream(filePath);
			w=new XSSFWorkbook(f);
			s=w.getSheet(sheet);
			Row r=s.getRow(a);     //row&cell are interface
			Cell c=r.getCell(b);
			
			int x=(int) c.getNumericCellValue();    //to change integer to string(type casting)
			return String.valueOf(x);         
	 }
	  
	  
	  }
	
