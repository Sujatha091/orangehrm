package com.hrmapp.orange.orangehrm.pages;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrmapp.orange.orangehrm.Browser;
import com.hrmapp.orange.orangehrm.Exceptions.ExplicitAssertionError;
import com.hrmapp.orange.orangehrm.Util.DBUtils;
//import com.relevantcodes.extentreports.LogStatus;

public abstract class LoginApp extends Browser {
	
	public abstract void waitForPageToLoad(WebElement we);
	
	public LoginApp waitForPageToLoad(){
		WebDriverWait wait=new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'OrangeHRM')]")));
		getDriver().findElement(By.xpath("//a[contains(.,'OrangeHRM')]"));
//		etest.log(LogStatus.INFO, "hello");
				
		return this;
	}
	
	public LoginApp enterUserName(String userName){
		getDriver().findElement(By.id("txtUsername")).sendKeys(userName);
		return this;
	}
	
	public LoginApp enterPassword(String password){
		getDriver().findElement(By.id("txtPassword")).sendKeys(password);
		return this;
	}
	
	public HomePage login(){
		getDriver().findElement(By.id("btnLogin")).click();
		return new HomePage();
	}
	
	public LoginApp assertUserExists(String user) throws ClassNotFoundException, SQLException, ExplicitAssertionError {

		DBUtils.loadDatabase();
		boolean b = DBUtils.getResult(user);
		if (!b)
			throw new ExplicitAssertionError("User " + user + " does not exist");

		return this;
	}


}
