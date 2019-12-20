package appiumlazyguide;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class TestSelendoidApp {
	AppiumDriver<MobileElement> driver;

	
@Test
	
	public void signUp() throws InterruptedException
	{
		
		        //Set the Desired Capabilities
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("deviceName", "My"); 
				caps.setCapability("udid", "emulator-5554");  
				caps.setCapability("platformName", "Android"); 
				caps.setCapability("platformVersion", "9.0");	
				caps.setCapability("noReset", true);				
				caps.setCapability("appPackage", "io.selendroid.testapp");
				caps.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
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
				System.out.println("111");
				driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();              
				driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("testing");            
				driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys("testnhuu2@gmail.com");    			
				driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("password123");       
				driver.findElement(By.id("io.selendroid.testapp:id/inputName")).clear(); 
				driver.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys("Testing");               
				driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();                         
				driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();                     
				

}
}