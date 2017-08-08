package java_basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Switch_case {

	public static void main(String[] args) {
		String url="Chrome";
		
		 
		 
		
		
		switch (url){
		
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "E:\\software\\Selenium3\\ChromeDriver\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.facebook.com");
			System.out.println(driver.getTitle());
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
			
			
			WebDriver driver_1 = new FirefoxDriver();
			driver_1.manage().window().maximize();
			driver_1.get("http://www.google.com");
			System.out.println(driver_1.getTitle());
			break;
			
		default :
			System.out.println("not matching with any case");
			break;
			
		}

	}
}
