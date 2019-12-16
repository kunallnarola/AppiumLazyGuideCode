package appiumlazyguide;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.awt.AWTException;	
import java.awt.Robot;	
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;	

public class AA {
	
WebDriver driver;
	
String destDir;
DateFormat dateFormat;
	@Test
	
	public void userTabFirst() throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\D\\d1\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        driver = new ChromeDriver(options);
       
        driver.get("http://rowbet.com/");
        System.out.println("title is: " + driver.getTitle());
        takeScreenShot();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBoxLoginName")));
		WebElement element = driver.findElement(By.id("loginBoxLoginName"));
		element.sendKeys("demos1");
		 takeScreenShot();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBoxPassword")));
		driver.findElement(By.id("loginBoxPassword")).sendKeys("Abc@123");
		
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBoxLoginBtn")));
			driver.findElement(By.id("loginBoxLoginBtn")).click();
			
			 takeScreenShot();
	}	
			 public void takeScreenShot() {
		    	  // Set folder name to store screenshots.
		    	  destDir = "screenshots";
		    	  // Capture screenshot.
		    	  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    	  // Set date format to set It as screenshot file name.
		    	  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		    	  // Create folder under project with name "screenshots" provided to destDir.
		    	  new File(destDir).mkdirs();
		    	  // Set file name using current date time.
		    	  String destFile = dateFormat.format(new Date()) + ".png";

		    	  try {
		    	   // Copy paste file at destination folder location
		    	   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		    	  } catch (IOException e) {
		    	   e.printStackTrace();
		    	  }
		
		/*	driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rowbet.com/"); */
		
	/*	 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBoxLoginName")));
		WebElement element = driver.findElement(By.id("loginBoxLoginName"));
		element.sendKeys("demos1"); */
		/* new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBoxPassword")));
		driver.findElement(By.id("loginBoxPassword")).sendKeys("Abc@123");
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBoxLoginBtn")));
		driver.findElement(By.id("loginBoxLoginBtn")).click();
		Thread.sleep(10000);
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='×']")));
		 
		driver.findElement(By.xpath("//span[text()='×']")).click();
		//driver.navigate().refresh();
		Thread.sleep(12000);
		driver.findElement(By.xpath("(//a[@id='vsName'])[1]")).click();
		
		Thread.sleep(12000);
		driver.findElement(By.xpath("(//a[@id='runsInfo'])[3]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//button[@type='button']//i)[2]")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//a[@class='btn-send'])[1]")).click();
		Thread.sleep(10000);
		 Robot r = new Robot();
	        r.keyPress(KeyEvent.VK_CONTROL);
	        r.keyPress(KeyEvent.VK_T);
	        driver.get("http://rowbet.com/");
		String parent=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator(); */
		 
	/*	while(I1.hasNext())
		{
		 
		   String child_window=I1.next();
		   if(!parent.equals(child_window))
		   {
		   driver.switchTo().window(child_window);
		    
		   System.out.println(driver.switchTo().window(child_window).getTitle());
		  */
			
		/*	 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBoxLoginName")));
			WebElement element1 = driver.findElement(By.id("loginBoxLoginName"));
			element1.sendKeys("demos1");
			 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBoxPassword")));
			driver.findElement(By.id("loginBoxPassword")).sendKeys("Abc@123");
			 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("loginBoxLoginBtn")));
			driver.findElement(By.id("loginBoxLoginBtn")).click();
			Thread.sleep(10000);
			 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='×']")));
			 
			driver.findElement(By.xpath("//span[text()='×']")).click();
			//driver.navigate().refresh();
			Thread.sleep(12000);
			driver.findElement(By.xpath("(//a[@id='vsName'])[1]")).click();
			
			Thread.sleep(12000);
			driver.findElement(By.xpath("(//a[@id='runsInfo'])[3]")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//button[@type='button']//i)[2]")).click();
			
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//a[@class='btn-send'])[1]")).click();
			Thread.sleep(10000);
		} 
		
	/*	new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@id='runsInfo'])[3]")));
		driver.findElement(By.xpath("(//a[@id='runsInfo'])[3]")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button']//i)[2]")));
		driver.findElement(By.xpath("(//button[@type='button']//i)[2]")).click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='btn-send'])[1]")));
		driver.findElement(By.xpath("(//a[@class='btn-send'])[1]")).click();*/
		
		}

}
