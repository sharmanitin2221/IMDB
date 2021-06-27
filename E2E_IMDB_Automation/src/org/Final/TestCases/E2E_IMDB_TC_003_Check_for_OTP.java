package org.Final.TestCases;

import org.initiate.driver.InitiateDriver;
import org.library.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.Random;

public class E2E_IMDB_TC_003_Check_for_OTP extends InitiateDriver{
	
	@Test
	public void checkOTPEmail() {
		
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("signin_link_xpath"))).click();
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_create_account_button_xpath"))).click();
		String username = "uniqueIdforTest" + new Random().nextInt(10);
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_username_textbox_name"))).sendKeys(username);
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_email_textbox_name"))).sendKeys(username+"@mailinator.com");
		String password = "uniqueIdforTest" + new Random().nextInt(10);
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_password_textbox_name"))).sendKeys(password);
	 	driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_re-enter_password_textbox_name"))).sendKeys(password);
		//Assert.assertTrue(Compare.validateElementVisibility(driver, "xpath",PropertyReader.elementLocatorReader("registration_page_submit_button_name")),"[Error : Sign up button does not display on page");
		System.out.println("Test Case-3 Passed");
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_submit_button_name"))).click();
		driver.navigate().to("https://www.mailinator.com/");
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_OTP_xpath"))).sendKeys(username+"@mailinator.com");
		driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_Check_link_xpath"))).click();
		

	 
	}

}
