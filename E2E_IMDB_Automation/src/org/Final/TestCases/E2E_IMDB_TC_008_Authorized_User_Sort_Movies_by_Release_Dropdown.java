package org.Final.TestCases;

import java.util.concurrent.TimeUnit;

import org.compare.verification.Compare;
import org.initiate.driver.InitiateDriver;
import org.library.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2E_IMDB_TC_008_Authorized_User_Sort_Movies_by_Release_Dropdown extends InitiateDriver{
	
	@Test
	public void athorizedUser_Release_Dropdown() throws InterruptedException {
	driver.findElement(By.xpath(PropertyReader.elementLocatorReader("signin_link_xpath"))).click();
	driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_Signin_with_IMDB_button_xpath"))).click();
	driver.findElement(By.cssSelector(PropertyReader.elementLocatorReader("registration_page_login_username_textbox_name"))).sendKeys("testuser131imdb@gmail.com");
	driver.findElement(By.cssSelector(PropertyReader.elementLocatorReader("registration_page_login_password_textbox_name"))).sendKeys("testuser131");	
	Assert.assertTrue(Compare.validateElementVisibility(driver, "xpath",PropertyReader.elementLocatorReader("registration_page_submit_button_name")),"[Error : Sign up button does not display on page");	
	driver.findElement(By.cssSelector(PropertyReader.elementLocatorReader("registration_page_SignIN_button_name"))).click();
	
	
	driver.findElement(By.xpath(PropertyReader.elementLocatorReader("home_page_menu_xpath"))).click();
 	Thread.sleep(2000);
 	String string =driver.findElement(By.xpath(PropertyReader.elementLocatorReader("home_page_view_Top_Rated_Movies_xpath"))).getText();
	if(string.equalsIgnoreCase("Top Rated Movies")) {
		driver.navigate().to("https://www.imdb.com/chart/top/?ref_=nv_mv_250");
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Select release = new Select(driver.findElement(By.xpath("//*[@id='lister-sort-by-options']")));
	release.selectByVisibleText("Release Date");		
	System.out.println("Test Case-8 Passed");
	}
}
