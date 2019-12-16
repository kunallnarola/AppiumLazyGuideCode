package appiumlazyguide;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeAction {
	
	AppiumDriver<MobileElement> driver;
	 Dimension size;
	 WebDriverWait wait;
	 
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
					caps.setCapability("appPackage", "com.android.vending");
					caps.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");
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
					
		}
	     public void scrollUsingTouchActions_ByElements(WebElement startElement , WebElement endElement)
	       {
		 TouchAction action = new TouchAction(driver);
		 action.longPress(ElementOption.element(startElement)).moveTo(ElementOption.element(endElement)).release().perform();
		 
	       }
				@Test (priority=1)
				
				public void scroll() throws InterruptedException
				{
					WebElement topChart = driver.findElement(By.xpath("//android.widget.TextView[@text='Top charts']"));
					WebElement categories = driver.findElement(By.xpath("//android.widget.TextView[@text='Categories']"));
					

					scrollUsingTouchActions_ByElements(categories, topChart);
					Thread.sleep(8000);
					WebElement editors = driver.findElement(By.xpath("//android.widget.TextView[@text='Family']"));
					scrollUsingTouchActions_ByElements(editors, categories);
				}
					
				/*	WebElement topCharts = driver.findElement(By.xpath("//android.widget.TextView[@text='Top charts']"));
					Point point = topCharts.getLocation();
					int startY = point.y;
					int endY = point.y;
					int startX = (int) ((driver.manage().window().getSize().getWidth())*0.80);
					int endX = (int)  ((driver.manage().window().getSize().getWidth()*0.20));
					TouchAction action  = new TouchAction(driver);
					action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX,endY)).release().perform();*/
		
						
}