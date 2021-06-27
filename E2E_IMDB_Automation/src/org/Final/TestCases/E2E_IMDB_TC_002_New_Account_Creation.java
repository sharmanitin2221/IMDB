package org.Final.TestCases;

import org.initiate.driver.InitiateDriver;
import org.library.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import org.compare.verification.*;

public class E2E_IMDB_TC_002_New_Account_Creation extends InitiateDriver{
	
	@Test
	public void newAccountCreation() {
		
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("signin_link_xpath"))).click();
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_create_account_button_xpath"))).click();
		String username = "IMDBTest" + new Random().nextInt(1000);
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_username_textbox_name"))).sendKeys(username);
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_email_textbox_name"))).sendKeys(username+"@yopmail.com");
		String password = "IMDBPassword" + new Random().nextInt(1000);
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_password_textbox_name"))).sendKeys(password);
	 	driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_re-enter_password_textbox_name"))).sendKeys(password);
		Assert.assertTrue(Compare.validateElementVisibility(driver, "xpath",PropertyReader.elementLocatorReader("registration_page_submit_button_name")),"[Error : Sign up button does not display on page");
		System.out.println("Test Case-2 Passed");
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_submit_button_name"))).click();
		
	 
	}

}
