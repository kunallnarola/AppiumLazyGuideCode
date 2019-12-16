package appiumlazyguide;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
public class LaunchFirefoxApp {
	AndroidDriver<MobileElement> driver;
	@Test
	
	public void launchFireFoxAppBrowser() throws InterruptedException
	{
		
		        //Set the Desired Capabilities
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("deviceName", "My"); 
				caps.setCapability("udid", "emulator-5554");  
				caps.setCapability("platformName", "Android"); 
				caps.setCapability("platformVersion", "9.0");	
				caps.setCapability("noReset", true);				
				caps.setCapability("appPackage", "org.mozilla.firefox");
				caps.setCapability("appActivity", "org.mozilla.gecko.BrowserApp");
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
			   driver.get("https://www.instagram.com/");
			   Thread.sleep(15000);
			   WebElement log = driver.findElement(By.xpath("//android.widget.Button[@text='Log In']"));
			   log.click();
			   Thread.sleep(3000);
			   List<MobileElement> login = driver.findElementsByClassName("android.widget.EditText");
			   login.get(0).sendKeys("abcd@gmail.com");
			   Thread.sleep(3000);
			   login.get(1).sendKeys("invalidpassword");
			   Thread.sleep(10000);
			   log.click();
			   
			
			   

}
}