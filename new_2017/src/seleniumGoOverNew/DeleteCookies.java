package seleniumGoOverNew;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DeleteCookies {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
	
		driver.get("https://www.facebook.com/");
		
		Set<Cookie>abd=driver.manage().getCookies();
		
		System.out.println(abd.size());
		
		driver.manage().deleteAllCookies();
		
		Set<Cookie>abd2=driver.manage().getCookies();
		
		System.out.println(abd2.size());
		
		

	}

}
