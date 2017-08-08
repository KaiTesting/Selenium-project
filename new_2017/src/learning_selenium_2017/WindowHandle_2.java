package learning_selenium_2017;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandle_2 {

	public static void main(String[] args) {
		
			
			System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
			// Open browser
			WebDriver driver=new FirefoxDriver();
			 
			// Maximize browser
			driver.manage().window().maximize();
			 
			// Load app
			driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
			
			String handle=driver.getWindowHandle();
			
			System.out.println("first browser name is: "+handle);
			
			driver.findElement(By.id("button1")).click();
			
			Set handles = driver.getWindowHandles();
			
			System.out.println("all browser name are: "+handles);
			
           for(String handle1:driver.getWindowHandles()){
	       System.out.println(handle1);
	       driver.switchTo().window(handle1);
}
			driver.close();
			
			
			
			
			 
	}

}
