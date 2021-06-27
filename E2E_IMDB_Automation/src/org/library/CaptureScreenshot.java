package org.library;

import java.io.File;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CaptureScreenshot {
		static String filename=null;
	public static void takeScreenshot(WebDriver driver, String name) {
		try 
		{
		Calendar c = Calendar.getInstance();
		//System.out.println(c.getTime());
		
		TakesScreenshot sreenshot = (TakesScreenshot) driver;// type casting. creating a reference/object of screenshot
		filename = "./Screenshot/"+name+c.getTime().toString().replace(":","").replace(" ", "")+ ".png";
		File f = sreenshot.getScreenshotAs(OutputType.FILE); // it will return a file class object, storing into file class object
		File fd = new File(filename); //fd= file destination  and saving the file/snapshot 
        FileUtils.copyFile(f, fd);
		
		}catch(Exception e) {
		 System.out.println("Not able to take screenshot*");
		
		}
		}
	 public static void attachScreenshottoReport() {
		 try {
			 System.setProperty("org.uncommons.reportng.escape-output","false");
			 File f = new File(filename);
			 Reporter.log(
					 "<a title= \"Snapshot\" href=\"" +f.getAbsolutePath() + "\">"+
							 "<img width=\"419\" height=\"248\" alt=\"alternativeName\" title=\"title\" src=\"../surefire-reports/html/screenshot/"+filename);
		 }catch(Exception e) {
			 System.out.println("Not able to take screenshot");
		 }
	 }
	
	
	
	
}
