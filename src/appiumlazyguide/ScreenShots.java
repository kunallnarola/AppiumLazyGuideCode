package appiumlazyguide;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class ScreenShots {
	AppiumDriver<MobileElement> driver;	
	 Dimension size;
	 String destDir;
	 DateFormat dateFormat;
	@Test
	public void testScreenShots() throws InterruptedException {
	DesiredCapabilities caps  = new DesiredCapabilities();
	caps.setCapability("deviceName", "My");
	caps.setCapability("udid", "emulator-5554");
	caps.setCapability("platformName", "Android");
	caps.setCapability("platformVersion", "9.0");
	caps.setCapability("appPackage", "io.appium.android.apis");
	caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	caps.setCapability("noReset", true);
	caps.setCapability("adbExecTimeout", "50000");
	caps.setCapability("autoGrantPermissions", "true");
	caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
	caps.setCapability("autoAcceptAlerts","true");
	caps.setCapability("unicodeKeyboard", true);
    caps.setCapability("resetKeybord", true);	
     try {
			
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
  // Scroll till element which contains "Views" text If It Is not visible on screen.
     MobileElement listitem = (MobileElement) driver.findElement(
             MobileBy.AndroidUIAutomator(
                     "new UiScrollable(new UiSelector()).scrollIntoView("
                             + "new UiSelector().text(\"Views\"));"));
   //Call takeScreenShot() function to capture screenshot of android screen.
     takeScreenShot();
  // Click on Views.
     driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
     
  // Scroll till element which contains "Tabs" text If It Is not visible on screen.
      listitem = (MobileElement) driver.findElement(
             MobileBy.AndroidUIAutomator(
                     "new UiScrollable(new UiSelector()).scrollIntoView("
                             + "new UiSelector().text(\"Tabs\"));"));
    //Call takeScreenShot() function to capture screenshot of android screen.
      takeScreenShot();
	}
      public void takeScreenShot() {
    	  // Set folder name to store screenshots.
    	  destDir = "screenshots";
    	  // Capture screenshot.
    	  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	  // Set date format to set It as screenshot file name.
    	  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
    	  // Create folder under project with name "screenshots" provided to destDir.
    	  new File(destDir).mkdirs();
    	  // Set file name using current date time.
    	  String destFile = dateFormat.format(new Date()) + ".png";

    	  try {
    	   // Copy paste file at destination folder location
    	   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
    	  } catch (IOException e) {
    	   e.printStackTrace();
    	  }
    	 }
     
	
}
