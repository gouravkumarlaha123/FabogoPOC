package com.fabogo.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

class BaseLib {
	public static WebDriver driver;
	@BeforeMethod
	public void setUp(){
		try{
		if(GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",GenericLib.sDirPath+"\\resources\\jars\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",GenericLib.sDirPath+"\\resources\\jars\\geckodriver.exe");
			driver = new FirefoxDriver();
		
		}
		}
		catch(Exception e){
			System.out.println("Problem in launching driver");
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
