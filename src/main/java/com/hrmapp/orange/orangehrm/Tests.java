package com.hrmapp.orange.orangehrm;

import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hrmapp.orange.orangehrm.Exceptions.ExplicitAssertionError;
import com.hrmapp.orange.orangehrm.pages.LoginApp;

public class Tests extends LoginApp{
	
	@BeforeSuite
	public void setup(){
		launch();
	}
	
	@Test
	public void test1() throws ExplicitAssertionError{
		enterUserName("admin")//
		.enterPassword("M@r-2o19")//
		.login()//
		.assertLoginSuccessful(true, "Admin")//
		;
		
	}
	
	@Test
	public void test2() throws ClassNotFoundException, SQLException{
		try{
		assertUserExists("Nikhil");
		}
		catch (ExplicitAssertionError e){}
	}
	
	@AfterSuite
	
	public void shutdown(){
		killBrowser();
	}

	@Override
	public void waitForPageToLoad(WebElement we) {
	}
	
}
