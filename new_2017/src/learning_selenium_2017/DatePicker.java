package learning_selenium_2017;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePicker {

	public static void main(String[] args) throws Exception {
		
	System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
        
		WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
	    driver.get("https://www.expedia.com/");
	    
	    JavascriptExecutor js= (JavascriptExecutor )driver;
	    
	    //we can also use ("document.getElementByID('').value=''");if id attribute is working fine in xpath
	    js.executeScript("document.querySelector('#package-departing').value='02/28/2017'");
	    
	    CaptureScreenShot capturePic = new CaptureScreenShot();
	    capturePic.takescreenshot(driver, "End of Fed");
	    System.out.println("Testing is completed");
	    
	   
	    
	   
	    	}
	    	
	    
	    
	}


