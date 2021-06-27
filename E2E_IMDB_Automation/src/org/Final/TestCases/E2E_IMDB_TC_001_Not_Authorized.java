package org.Final.TestCases;

import org.compare.verification.Compare;
import org.initiate.driver.InitiateDriver;
import org.library.PropertyReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2E_IMDB_TC_001_Not_Authorized extends InitiateDriver {

	@Test
	public void unathorizedUser() {
		
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("signin_link_xpath"))).click();
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_Signin_with_IMDB_button_xpath"))).click();
		driver.findElement(By.cssSelector(PropertyReader.elementLocatorReader("registration_page_Incorrect_login_username_textbox_name"))).sendKeys("Test@yopmail.com");
		driver.findElement(By.cssSelector(PropertyReader.elementLocatorReader("registration_page_Incorrect_login_password_textbox_name"))).sendKeys("abcd123456");	
		driver.findElement(By.cssSelector(PropertyReader.elementLocatorReader("registration_page_SignIN_button_name"))).click();
		Assert.assertFalse(Compare.validateElementVisibility(driver, "xpath",PropertyReader.elementLocatorReader("registration_page_SignIN_button_name")),"[Error : Sign up button does not display on page");	
		System.out.println("Test Case-1 Passed");
		
	}
}
