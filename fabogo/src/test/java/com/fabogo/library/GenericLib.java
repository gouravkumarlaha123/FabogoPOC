package com.fabogo.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericLib {
	static public String sDirPath = System.getProperty("user.dir");
	public static String sConfigFile = sDirPath+"\\Config.properties";
	
	public static String getCongigValue(String sFile, String sKey) {
		Properties prop = new Properties();
		String sValue = null;
		try {
			InputStream input = new FileInputStream(sFile);
			prop.load(input);
			sValue = prop.getProperty(sKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sValue;
	}
	public static String toReadExcelData(String filePath,String sheetName,int rowNum,int cellNum)
	 {
		 String dataNew=null;
		 try{
		 	FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			dataNew=sht.getRow(rowNum).getCell(cellNum).getStringCellValue();
		 }
		 catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	return dataNew ;
}

}
