package learning_selenium_2017;



	import java.awt.Robot;
	import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.Test;
	 
	@SuppressWarnings("unused")
	public class RobotClass {
	 
	 @Test
	 public void TestRobo()throws Exception
	 {
	  // Open Firefox
		 
	/*  System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
	  
	  WebDriver driver=new FirefoxDriver();
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	                
	  // Maximize the window
	  driver.manage().window().maximize();
	 
	  // Open facebook
	  driver.get("https://online.citi.com/US/login.do");
	 
	  // Enter Username
	  driver.findElement(By.xpath(".//*[@id='usernameMasked']")).sendKeys("kikikik");
	 
	  // Enter password
	  driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("789456123");
	 */
	  // Create object of Robot class
	 Robot r = new Robot();

	 r.mouseMove(630, 420);
		
		
	}
	 
	}

