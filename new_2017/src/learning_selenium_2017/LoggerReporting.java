package learning_selenium_2017;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoggerReporting {

	public static void main(String[] args) throws Exception {
		
		
		Logger logger = Logger.getLogger("devpinoyLogger");
		
		
				
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
        
		WebDriver driver = new FirefoxDriver();
		logger.debug("Firefox opened");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		logger.debug("Maximize browser");
		
	    driver.get("https://www.expedia.com/");
	    logger.debug("Launched Application");
	    
	    JavascriptExecutor js= (JavascriptExecutor )driver;
	    
	    //we can also use ("document.getElementByID('').value=''");if id attribute is working fine in xpath
	    js.executeScript("document.querySelector('#package-departing').value='02/28/2017'");
	    logger.debug("Click 28th date from calender");
	    
	    CaptureScreenShot capturePic = new CaptureScreenShot();
	    capturePic.takescreenshot(driver, "End of Fed");
	    logger.debug("Capture Screenshot");
	    System.out.println("Testing is completed");
	    
	   
	    //https://www.youtube.com/watch?v=-GkRuFU_sUg
	   
	    	}
	    	
	    
	    
	}


