package learning_selenium_2017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Xpath_InDetails {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
		//lanch Browser and URL,
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		//sign up by using different type of Xpath
		  //1."following" for username and password filed  
		driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/div/div/div[2]/div[1]//following::input[2]")).sendKeys("kevser");
		driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/div/div/div[2]/div[1]//following::input[3]")).sendKeys("kaysar");
		driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/div/div/div[2]/div[1]//following::input[4]")).sendKeys("9895623");
		driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/div/div/div[2]/div[1]//following::input[5]")).sendKeys("9895623");
		driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/div/div/div[2]/div[1]//following::input[6]")).sendKeys("123456789");
		
		Select sel_m=new Select(driver.findElement(By.xpath("//select[contains(@id,'month')]")));
		sel_m.selectByIndex(5);

	}

}
