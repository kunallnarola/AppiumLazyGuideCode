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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class StitchOnOff {
	AppiumDriver<MobileElement> driver;

	@Test
	public void testSeekBar() throws InterruptedException {
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
		// Scroll till element which contains "Switches" text If It Is not visible on
		// screen.
		listitem = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Switches\"));"));
		// Click on Switches.
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Switches\"]")).click();
		// Get status of switch using it's text.
		WebElement switchStatus = driver.findElementById("io.appium.android.apis:id/monitored_switch");
		String switchStatus1 = switchStatus.getText();
		System.out.println(switchStatus1);
		if (switchStatus.getText().equals("Monitored switch OFF")) {
			System.out.println("Doing Monitored switch ON");
			// Tap on switch button "Monitored switch OFF" to make it ON.
			switchStatus.click();
			System.out.println("Monitored switch is ON now.");

		}
		// Pause test for 8 seconds to put switch ON for 5 seconds.
		Thread.sleep(8000);
		WebElement switchStatus2 = driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));
		System.out.println(switchStatus2.getText());
		if (switchStatus2.getText().equals("Monitored switch ON")) {
			// Tap on switch button "Monitored switch OFF" to make it OFF.
			switchStatus2.click();
			System.out.println("Monitored switch is OFF now.");

		}

	}
}
