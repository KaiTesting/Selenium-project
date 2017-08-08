package seleniumGoOverNew;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakingScreenShot {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
	
		driver.get("https://www.facebook.com/");
		
		File sc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(sc, new File("C:\\Users\\kevser\\workspace\\new_2017\\ScreenShot\\facebook.png"));
		
		System.out.println("test completed");

	}

}
