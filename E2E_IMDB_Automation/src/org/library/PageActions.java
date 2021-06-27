package org.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageActions {
	WebDriver num = null;
	WebDriver driver = null;
	WebDriverWait wait;
	public PageActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	public void clickLink(WebElement element) {
		try {
	 	wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();	
		}catch(Exception e) {
			System.out.println("**Exception**");
			CaptureScreenshot.takeScreenshot(driver,"Click Link failed");
			e.printStackTrace();			
			Assert.fail();
		}
	}
	
	public void clickButton(WebElement element) {
		try {
	 	wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();	
		}catch(Exception e) {
			System.out.println("**Exception**");
			CaptureScreenshot.takeScreenshot(driver,"Click button failed");
			e.printStackTrace();			
			Assert.fail();
		}
	}
	
	public void enterDataIntoTextBox(WebElement element, String text) {
		try {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
		
		}catch(Exception e) {
			System.out.println("**Exception**");
			CaptureScreenshot.takeScreenshot(driver,"EnterTextNotvisible");
			e.printStackTrace();			
			Assert.fail();
		}
		}
	public void selectVisibleTestintoDropdown(WebElement element,String text) {
		try {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		Select s = new Select(element);
		s.selectByVisibleText(text);		
		}catch(Exception e) {
			System.out.println("**Exception**");
			CaptureScreenshot.takeScreenshot(driver, "EnterDataNotvisible");
			e.printStackTrace();
			Assert.fail();
		}
		}
}
