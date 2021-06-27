package org.compare.verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {
	
	public static boolean validateURL(WebDriver driver, String exp_URL) {
	 
		boolean result = false;
		if(driver.getCurrentUrl().equals(exp_URL))
		{
			result = true;
		}
			return result;
	}
	
	public static boolean validatePageTitle(WebDriver driver, String expTitle) {
		boolean result = false;
		if(driver.getTitle().equalsIgnoreCase(expTitle))
		{
			result = true;
		}
		return result;
	}

	public static boolean validatElementExists(WebDriver driver, String locType, String locValue) {
		boolean result=false;
		try
		{
			if(locType.equalsIgnoreCase("xpath"))
			{
			driver.findElement(By.xpath(locValue));
			}
			else if (locType.equalsIgnoreCase("id"))
			{
			driver.findElement(By.id(locValue));
			}
			else if (locType.equalsIgnoreCase("name"))
			{
			driver.findElement(By.name(locValue));
			}
			result = true;
		}catch (Exception e) {
			 
		}
		
		return result;
	}
	
	public static boolean validateTextPresentOnElement(WebDriver driver, String locType, String locValue, String expText) {
		boolean result=false;
		String actValue ="";
		try
		{
			if(locType.equalsIgnoreCase("xpath"))
			{
				actValue = driver.findElement(By.xpath(locValue)).getText();
			}
			else if(locType.equalsIgnoreCase("id"))
			{
				actValue = driver.findElement(By.id(locValue)).getText();
			}
			else if(locType.equalsIgnoreCase("name"))
			{
				actValue = driver.findElement(By.name(locValue)).getText();
			}
			if(actValue.equals(expText))
			{
				result = true;				
			}
		}
	catch(Exception e)
		{
		
		}
		return result;
	}
	public static String validateTextPresentOnElement1(WebDriver driver, String locType, String locValue) {
		 
		String actValue ="";
		try
		{
			if(locType.equalsIgnoreCase("xpath"))
			{
				actValue = driver.findElement(By.xpath(locValue)).getText();
			}
			else if(locType.equalsIgnoreCase("id"))
			{
				actValue = driver.findElement(By.id(locValue)).getText();
			}
			else if(locType.equalsIgnoreCase("name"))
			{
				actValue = driver.findElement(By.name(locValue)).getText();
			}
		}catch(Exception e)
		{
		
		}
		return actValue;
	}
	
	public static boolean validateTextOnPage(WebDriver driver, String expValue)
	{
		boolean result =false;
		if(driver.getPageSource().contains(expValue))
		{
			result = true;
		}
		return result;
	}
	
	public static boolean validateAttribute(WebDriver driver, String locType, String locValue, String attributeName, String expValue)
	{
		boolean result = false;
		String  value="";
		try {
		if(locType.equalsIgnoreCase("xpath"))
		{
			value = driver.findElement(By.xpath(locValue)).getAttribute(attributeName);
		}
		else if(locType.equalsIgnoreCase("id"))
		{
			value = driver.findElement(By.id(locValue)).getAttribute(attributeName);
		}
		else if(locType.equalsIgnoreCase("name"))
		{
			value = driver.findElement(By.name(locValue)).getAttribute(attributeName);
		}
		if(value.equalsIgnoreCase(expValue)) {
			result = true;
		}
		
		}catch(Exception e){}
		return result;
	}
	
	public static boolean validateElementVisibility(WebDriver driver, String locType, String locValue)
	{
		boolean result = false;
		 
		try {
			if(locType.equalsIgnoreCase("xpath"))
			{
				result = driver.findElement(By.xpath(locValue)).isDisplayed();
			}
			else if(locType.equalsIgnoreCase("id"))
			{
				result = driver.findElement(By.id(locValue)).isDisplayed();
			}
			if(locType.equalsIgnoreCase("name"))
			{
				result = driver.findElement(By.name(locValue)).isDisplayed();
			}
		}
		catch(Exception e) {}
		return result;
	}
}