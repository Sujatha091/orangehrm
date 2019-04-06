package com.hrmapp.orange.orangehrm;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import com.hrmapp.orange.orangehrm.Util.PropertyReader;

public class Browser {

//	public static ExtentReports report;
//	public static ExtentTest test;
	private static WebDriver driver; 
	private static Properties prop;
	public static void setDriver(String browser){
		
		if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "././drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}			
	}
	
	public static void initializeReports(){
	//	ereport=new ExtentReports("././TestReport.htm");
//	report=new ExtentReports("TestReport.html");
//		etest=ereport.startTest("Regresssion Tests");
	}
	
	public static WebDriver getDriver(){
		return driver;
	}
	
	public static void launch(){
		prop=PropertyReader.readData();
		initializeReports();
		setDriver(prop.getProperty("browser"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
	}
	
	public static void killBrowser(){
		if (driver!=null)
			driver.close();
	}
	
}
