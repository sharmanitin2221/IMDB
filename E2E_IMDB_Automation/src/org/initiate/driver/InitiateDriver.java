package org.initiate.driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.library.PropertyReader;
import org.account.creation.RegistrationPage_Handling_Exception;

public class InitiateDriver {

    public WebDriver driver;
	public RegistrationPage_Handling_Exception registration;
    
	@BeforeMethod
	
	public void StartBrowser() throws InterruptedException, IOException {	
		
		if(PropertyReader.applicationconfigReader("BrowserName").equalsIgnoreCase("Chrome"))
		{
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe"); //Relative path
				driver = new ChromeDriver(); //Browser will start
			}
		
		else if(PropertyReader.applicationconfigReader("BrowserName").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe"); //Relative path
			driver = new FirefoxDriver(); //Browser will start
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe"); //Relative path
			driver = new ChromeDriver(); //Browser will start
		}
		
		
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().window().maximize(); // maximizing browser window
		driver.get(PropertyReader.applicationconfigReader("Application_URL"));
		registration = new RegistrationPage_Handling_Exception(driver);

	}
		
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
