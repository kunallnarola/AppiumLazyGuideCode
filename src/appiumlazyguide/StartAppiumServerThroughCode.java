package appiumlazyguide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class StartAppiumServerThroughCode {

	AppiumDriver<MobileElement> driver;
	 AppiumDriverLocalService service;
	 	public AppiumServiceBuilder builder;
		 static String nodePath = "C:\\Program Files\\nodejs\\node.exe";
			static String appiumpath ="C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\lib\\main.js";
	

	@Test(priority=1)
	@Parameters({ "deviceName_", "UDID_", "platformName_", "platformVersion_", "URL_", "UserName", "UserEmail","port_" })
	public void signUp(String deviceName,String udid,String paltformName,String platformVersion,String url ,String uname,String uemail,int port) throws InterruptedException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceName);
		caps.setCapability("udid", udid);
		caps.setCapability("platformName", paltformName);
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
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()             
                .usingDriverExecutable( new File( nodePath))
                .withAppiumJS( new File(appiumpath))
                .usingPort(port)
                .withIPAddress("0.0.0.0")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, nextFreePort().toString())
                .withArgument(GeneralServerFlag.LOG_LEVEL,"error")              
            );
		System.out.println("Mode");
		Thread.sleep(15000);
		
				service.start();
		    System.out.println(" Appium Server Address [Local]: " + service.getUrl() );
		    Thread.sleep(15000);
		try {

			driver = new AndroidDriver<MobileElement>(new URL("http://"+url + port + "/wd/hub"), caps);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("111");
		driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
		driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys(uname);
		driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys(uemail);
		driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("password123");
		driver.findElement(By.id("io.selendroid.testapp:id/inputName")).clear();
		driver.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys("Testing");
		driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();
		driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
	}
	@Test(priority=2)
	public void closeServer()
	{
		service.stop();
   	 System.out.println("Server closed successfully");
   	 WindowsUtils.killByName("node.exe");
	   System.out.println("Done");
		
	}
	 public static final int HIGHEST_PORT = 65535;
     public static final int LEAST_PORT = 1024;
     public static Integer nextFreePort() {
     Integer port = (int)( Math.random() * 8000 ) + LEAST_PORT;
    while (true) {
     try ( ServerSocket endpoint = new ServerSocket(port) ) {
        System.out.println("Local Port on which this socket is listening :"+port);
        return port;
    } catch (IOException e) {
        port = ThreadLocalRandom.current().nextInt(port);
    }
}
}
      public static void systemConsole2File( File logFile ) {
       try ( FileOutputStream fos = new FileOutputStream( logFile );
      PrintStream system_console = new PrintStream( fos )
    ) {
       System.setOut( system_console ); // output stream.
       System.setErr( system_console ); // error output stream.
     } catch (IOException e) { 
      e.printStackTrace(); 
}
}
}