package org.Final.TestCases;

import org.compare.verification.Compare;
import org.initiate.driver.InitiateDriver;
import org.library.PropertyReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2E_IMDB_TC_004_Authorized_User extends InitiateDriver{
	
	@Test
	public void athorizedUser() {
	driver.findElement(By.xpath(PropertyReader.elementLocatorReader("signin_link_xpath"))).click();
	driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_Signin_with_IMDB_button_xpath"))).click();
	driver.findElement(By.cssSelector(PropertyReader.elementLocatorReader("registration_page_login_username_textbox_name"))).sendKeys("testuser131imdb@gmail.com");
	driver.findElement(By.cssSelector(PropertyReader.elementLocatorReader("registration_page_login_password_textbox_name"))).sendKeys("testuser131");	
	Assert.assertTrue(Compare.validateElementVisibility(driver, "xpath",PropertyReader.elementLocatorReader("registration_page_submit_button_name")),"[Error : Sign up button does not display on page");	
	driver.findElement(By.cssSelector(PropertyReader.elementLocatorReader("registration_page_SignIN_button_name"))).click();
	System.out.println("Test Case-4 Passed");
	}
}
