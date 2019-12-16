package appiumlazyguide;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CromeBrowserMobile {
	
		AppiumDriver<MobileElement> driver;	
		@Test
		public void launchChromeBrowser() throws InterruptedException {
		DesiredCapabilities caps  = new DesiredCapabilities();
		caps.setCapability("deviceName", "My");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
		caps.setCapability("browserName", "chrome");
		caps.setCapability("noReset", true);
		caps.setCapability("adbExecTimeout", "50000");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
		caps.setCapability("autoAcceptAlerts","true");
		caps.setCapability("unicodeKeyboard", true);
	    caps.setCapability("resetKeybord", true);	
	    
	    caps.setCapability("chromedriverExecutable","E:\\Appium lazy guide\\chrome\\chromedriver.exe");
	  
	     try {
				
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
	     driver.get("https://demos2.softaculous.com/WordPresswmcwk0u9qe/wp-login.php?redirect_to=https%3A%2F%2Fdemos2.softaculous.com%2FWordPresswmcwk0u9qe%2Fwp-admin%2F&reauth=1");
		driver.findElement(By.id("user_login")).sendKeys("admin");  
	
		driver.findElement(By.id("user_pass")).sendKeys("pass");   
		
		driver.findElement(By.id("wp-submit")).click();  
		
		}
		}
