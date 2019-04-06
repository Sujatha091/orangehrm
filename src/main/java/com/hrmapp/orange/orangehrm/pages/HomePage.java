package com.hrmapp.orange.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrmapp.orange.orangehrm.Exceptions.ExplicitAssertionError;
import com.hrmapp.orange.orangehrm.Util.DBUtils;
//import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class HomePage extends LoginApp{

	@Override
	public void waitForPageToLoad(WebElement we) {
		WebDriverWait wait=new WebDriverWait(getDriver(), 10);
		we=getDriver().findElement(By.xpath("//div/h1[contains(.,'Dashboard')]"));
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public HomePage assertLoginSuccessful(boolean flag, String name) throws ExplicitAssertionError{
		waitForPageToLoad();
		String xpath="//a[@id='welcome'][contains(.,'Welcome "+name+"')]";
//		WebDriverWait wait=new WebDriverWait(getDriver(), 10);
//		WebElement we=getDriver().findElement(By.xpath(xpath));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		if (flag){
				List<WebElement> list=getDriver().findElements(By.xpath(xpath));
				if (list.size()==0){
//					etest.log(LogStatus.FAIL, "User name "+name+" not found");
					throw new ExplicitAssertionError("User name"+name+" not found hence login not successful");
				}
		}
		return this;
	}
	
}
