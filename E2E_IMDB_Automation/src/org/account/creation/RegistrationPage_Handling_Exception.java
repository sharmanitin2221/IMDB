package org.account.creation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.library.CaptureScreenshot;
import org.library.PageActions;
import org.library.PropertyReader;

	public class RegistrationPage_Handling_Exception {
		
		WebDriver driver = null;
		PageActions action;
		public RegistrationPage_Handling_Exception(WebDriver driver) {
			this.driver=driver;
			action = new PageActions(driver);
		}
	
	public void enterUserName(String username)  {
		try {
		action.enterDataIntoTextBox
		(driver.findElement(By.name(PropertyReader.elementLocatorReader("registration_page_username_textbox_name"))), username);
		}catch(Exception e) {
			System.out.println("**Exception**");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");
			Assert.fail();
	}
}
		
	public void enterEmailAddress(String email)  {
		try
		{
		action.enterDataIntoTextBox
		(driver.findElement(By.name(PropertyReader.elementLocatorReader("registration_page_email_textbox_name"))),email);
		}catch(Exception e) {
			System.out.println("**Exception**");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");
			Assert.fail();
	}
}
	

	public void enterSignButton() {
		try {
		action.clickButton(driver.findElement(By.xpath(PropertyReader.elementLocatorReader("registration_page_signup_button_xpath"))));
		}catch(Exception e) {
			System.out.println("**Exception**");
			CaptureScreenshot.takeScreenshot(driver, "Click button failed");
			e.printStackTrace();
			Assert.fail();
	}
}	
		

	public void enterCountryDropdown(String countryName)  {
		try
		{
		Select country = new Select(driver.findElement(By.id(PropertyReader.elementLocatorReader("registration_page_country_dropdown_id"))));
		country.selectByVisibleText(countryName);
		}catch(Exception e) {
			System.out.println("**Exception**");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "EnterDataFailed");
			Assert.fail();
	}
}

}
