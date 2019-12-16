package appiumlazyguide;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class SeekBar {
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void testSeekBar() {
	DesiredCapabilities caps  = new DesiredCapabilities();
	caps.setCapability("deviceName", "My");
	caps.setCapability("udid", "bd40918");
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
     // Click on Views.
     driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
  // Scroll till element which contains "Seek Bar" text If It Is not visible on screen.
     listitem = (MobileElement) driver.findElement(
             MobileBy.AndroidUIAutomator(
                     "new UiScrollable(new UiSelector()).scrollIntoView("
                             + "new UiSelector().text(\"Seek Bar\"));"));
     // Click on Seek Bar.
     driver.findElement(By.xpath("	//android.widget.TextView[@content-desc=\"Seek Bar\"]")).click();
   //Locate SeekBar element.
     WebElement seekBar=driver.findElementById("io.appium.android.apis:id/seek");
   //Get start point of seekbar.
     int startX = seekBar.getLocation().getX();
     System.out.println(startX);
     //Get end point of seekbar.
     int endX = seekBar.getSize().getWidth();
     System.out.println(endX);
     //Get vertical location of seekbar.
     int yAxis = seekBar.getLocation().getY();
     //Set sllebar move to position. 
     //endX * 0.9 means at 80% of seek bar width.
     int moveToXDirectionAt = (int) (endX * 0.9);
     System.out.println("Moving seek bar at " + moveToXDirectionAt+" In X direction.");
     //Moving seekbar using TouchAction class.
     TouchAction act=new TouchAction(driver);  
     act.press(PointOption.point(startX,yAxis)).moveTo(PointOption.point(moveToXDirectionAt,yAxis)).release().perform();
    
	}
	

}
