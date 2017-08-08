package seleniumGoOverNew;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestFFonWindon {

	static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		
	//E:\software\Selenium3\ChromeDriver\new chrome driver\chromedriver.exe
	//E:\software\Selenium3\ChromeDriver\chromedriver.exe
		
	//System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
	
	DesiredCapabilities cap=DesiredCapabilities.firefox();
	
	cap.setBrowserName("firefox");
	
	cap.setPlatform(Platform.WIN10);
	
	//URL url=new URL("http://localhost:4444/wb/hub");
	
	driver = new RemoteWebDriver(new URL("http://192.168.1.100:5555"),cap);
	
	driver.get("https://www.facebook.com");
	
	System.out.println(driver.getTitle());
	

	}
	
}
