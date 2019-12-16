package appiumlazyguide;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class GetDropDownList {
	AppiumDriver<MobileElement> driver;

	@Test
	public void testGetDropDownList() throws InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
		caps.setCapability("appPackage", "io.appium.android.apis");
		caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		caps.setCapability("noReset", true);
		caps.setCapability("adbExecTimeout", "50000");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		caps.setCapability("autoAcceptAlerts", "true");
		caps.setCapability("unicodeKeyboard", true);
		caps.setCapability("resetKeybord", true);
		try {

			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		// Scroll till element which contains "Views" text If It Is not visible on
		// screen.
		MobileElement listitem = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Views\"));"));
		// Click on Views.
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		// Click on Controls.
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();
		// Click on 2. Dark Theme.
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"2. Dark Theme\"]")).click();
		// Click on dropdown to open list.
		driver.findElement(By.id("android:id/text1")).click();
		// Locate all drop down list elements
		List<MobileElement> listDropDown = driver.findElements(By.id("android:id/text1"));
		// Extract text from each element of drop down list one by one.
		for (int i = 0; i < listDropDown.size(); i++) {
			System.out.println(listDropDown.get(i).getText());
		}

	}
}
