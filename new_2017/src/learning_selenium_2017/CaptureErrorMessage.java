package learning_selenium_2017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class CaptureErrorMessage {

	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
    
	WebDriver driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	
    driver.get("https://www.bankofamerica.com/");
   
    driver.findElement(By.xpath(".//*[@id='hp-sign-in-btn']")).click();
    
    Thread.sleep(2000);
    
   String act_err= driver.findElement(By.xpath(".//*[@id='SI_online-id-missing']")).getText();
   
   String exp_err = "Your Online ID is missing. Please try again.";

    //Assert.assertEquals(act_err, exp_err);
    
   //getting error messagae, due to hard code invalid text
    Assert.assertTrue(act_err.contains(" Oline I1D is1"));
    
    System.out.println("Test completed");
	}

}

