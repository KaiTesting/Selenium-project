package learning_selenium_2017;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handle_bootstrap_dropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='menu1']")).click();
		
		 List<WebElement> dd_manu=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
		 
		 for(int i=0;i<dd_manu.size();i++){
			 
			 WebElement element=dd_manu.get(i);
			 
			 String value=element.getAttribute("innerHTML");
			if(value.contentEquals("JavaScript")){
				element.click();
				break;
			}
				
			 System.out.println("Value from innerHTML are  "+ value);
		 }
		driver.quit();

	}

}
