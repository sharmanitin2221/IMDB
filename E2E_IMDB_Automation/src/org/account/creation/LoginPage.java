package org.account.creation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.library.PageActions;
import org.library.PropertyReader;

public class LoginPage {
	
	WebDriver driver = null;
	PageActions action;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		action = new PageActions(driver);
	}
	
	public void clickSignin() throws IOException 
	{
		action.clickLink(driver.findElement(By.xpath(PropertyReader.elementLocatorReader("signin_link_xpath"))));
		
	}
	
	public void clickCreateAccount() throws IOException 
	{
		action.clickButton(driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_create_account_button_xpath"))));
		
	}
	
	public void enterYourName() throws IOException 
	{
		
		action.enterDataIntoTextBox(driver.findElement(By.name(PropertyReader.elementLocatorReader("registration_page_username_textbox_name"))), 
				PropertyReader.applicationconfigReader("Application_Username"));
			}
	
	public void enterEmail() throws IOException 
	{
		action.enterDataIntoTextBox(driver.findElement(By.name(PropertyReader.elementLocatorReader("registration_page_email_textbox_name"))),
				PropertyReader.applicationconfigReader("Application_Email"));
	}

	public void enterPassword() throws IOException 
	{
		action.enterDataIntoTextBox(driver.findElement(By.name(PropertyReader.elementLocatorReader("registration_page_password_textbox_name"))),
				PropertyReader.applicationconfigReader("Application_Password"));
	}
	
	public void enterReEnterPassword() throws IOException 
	{
		action.enterDataIntoTextBox(driver.findElement(By.name(PropertyReader.elementLocatorReader("registration_page_re-enter_password_textbox_name"))),
				PropertyReader.applicationconfigReader("Application_RePassword"));
	}
	
	public void clickCreateAccountContinue() throws IOException 
	{
		action.clickButton(driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_submit_button_name"))));
		
	}
		
	
	public void clickLoginTab() throws IOException 
	{
		action.clickButton(driver.findElement(By.xpath(PropertyReader.elementLocatorReader("login_page_tab_xpath"))));
	}
}
