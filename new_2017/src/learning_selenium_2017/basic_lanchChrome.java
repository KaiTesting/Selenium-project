package learning_selenium_2017;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic_lanchChrome {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\software\\Selenium3\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
	}

}
