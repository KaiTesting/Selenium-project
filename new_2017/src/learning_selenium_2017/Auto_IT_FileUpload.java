package learning_selenium_2017;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Auto_IT_FileUpload {

	public static void main(String[] args) throws IOException, InterruptedException {
System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
        //lanch firefox then facebook
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	    driver.get("‪C:\\Users\\kevser\\Desktop\\FileUpload.html");
	    
	    driver.findElement(By.xpath("html/body/input"));
	    
	    Thread.sleep(5000);
	    Runtime.getRuntime().exec("C:\\Users\\kevser\\Desktop\\AUTO_IT\\UploadFile_001.exe");
	    

	}

}
