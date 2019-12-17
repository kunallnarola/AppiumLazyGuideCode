package appiumlazyguide;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//Parallel execution for two devices
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class ParallelExecution {
	AppiumDriver<MobileElement> driver;

	@Parameters({ "deviceName_", "UDID_", "platformName_", "platformVersion_", "URL_", "UserName", "UserEmail" })

	@Test

	public void signUp(String deviceName, String udid, String platformName, String platformVersion, String Url,
			String uName, String email) throws InterruptedException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceName);
		caps.setCapability("udid", udid);
		caps.setCapability("platformName", platformName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("noReset", true);
		caps.setCapability("appPackage", "io.selendroid.testapp");
		caps.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		caps.setCapability("adbExecTimeout", "50000");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		caps.setCapability("autoAcceptAlerts", "true");
		caps.setCapability("unicodeKeyboard", true);
		caps.setCapability("resetKeybord", true);
		System.out.println("11");
		try {

			driver = new AndroidDriver<MobileElement>(new URL("http://" + Url + "/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("111");
		driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
		driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys(uName);
		driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys(email);
		driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("password123");
		driver.findElement(By.id("io.selendroid.testapp:id/inputName")).clear();
		driver.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys("Testing");
		driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();
		driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();

	}

}
