package appiumlazyguide;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class ScrollToText {
	
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
					caps.setCapability("appPackage", "io.appium.android.apis");
					caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
					caps.setCapability("adbExecTimeout", "50000");
					caps.setCapability("autoGrantPermissions", "true");
					caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
					caps.setCapability("autoAcceptAlerts","true");
					caps.setCapability("unicodeKeyboard", true);
				     caps.setCapability("resetKeybord", true);
				System.out.println("11");
					try {
						
						driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
						
					} catch (MalformedURLException e) {
						System.out.println(e.getMessage());
					}
					driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
					
					  MobileElement listitem = (MobileElement) driver.findElement(
				                MobileBy.AndroidUIAutomator(
				                        "new UiScrollable(new UiSelector()).scrollIntoView("
				                                + "new UiSelector().text(\"Tabs\"));"));

}
}