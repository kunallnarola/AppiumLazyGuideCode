package appiumlazyguide;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class Scroll {
	AppiumDriver<MobileElement> driver;
	@Test
		
		public void signUp() throws InterruptedException
		{
			
			        //Set the Desired Capabilities
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability("deviceName", "My"); 
					caps.setCapability("udid", "bd40918");  
					caps.setCapability("platformName", "Android"); 
					caps.setCapability("platformVersion", "9.0");	
					caps.setCapability("noReset", true);				
					caps.setCapability("appPackage", "com.android.settings");
					caps.setCapability("appActivity", "com.android.settings.Settings");
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
					Thread.sleep(8000);
					
					 ((FindsByAndroidUIAutomator<MobileElement>) driver)
					 .findElementByAndroidUIAutomator(
							 "new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"Apps\"));");								
					driver.findElement(By.xpath("//android.widget.TextView[@text='Apps']")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='Manage apps']")).click();			
					 ((FindsByAndroidUIAutomator<MobileElement>) driver)
					 .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())"
					 		+ ".scrollIntoView("+ "new UiSelector().text(\"Firefox\"));").click();				 
						driver.findElement(By.xpath("//android.widget.TextView[@text='Storage']")).click();
						Thread.sleep(10000);
						driver.findElement(By.xpath("//android.widget.Button[@text='Clear all data']")).click();
						Thread.sleep(5000);
						//driver.findElement(By.id("android:id/text1")).click();
						//Thread.sleep(5000);
						//driver.findElement(By.id("android:id/text1")).click();
						Thread.sleep(5000);
						driver.findElement(By.id("android:id/button1")).click();
						
	}

}
