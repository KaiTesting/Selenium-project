package learning_selenium_2017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSS_ElementLocater {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
		WebDriver driver= new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input#u_0_2")).sendKeys("kevser");
		driver.findElement(By.cssSelector("input[id*='0_4']")).sendKeys("kaysar");
		driver.findElement(By.cssSelector("input[name^='reg'][name$='email__']")).sendKeys("789456123");
		
		
		
	}

}
