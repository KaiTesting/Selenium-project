package learning_selenium_2017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basic_facebook {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
        //lanch firefox then facebook
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.facebook.com/");
	    
	 // It will return the parent window name as a String
		String parent=driver.getWindowHandle();
		
		System.out.println(parent);
		 
	    
	    
	    //first name enter
	    //WebElement ele=driver.findElement(By.xpath(".//*[@id='u_0_2']"));
	    
	    WebDriverWait wait = new WebDriverWait(driver,20);
	    
	    WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='u_0_2']")));
	    
	    		boolean status= element.isDisplayed();
	    		
	    		System.out.println("Status of the object "+status);
	    		
	    //mm/dd/year enter
	    Select sel1=new Select(driver.findElement(By.xpath(".//*[@id='month']")));
	    sel1.selectByVisibleText("Feb");
	    
	    Select sel2= new Select(driver.findElement(By.xpath(".//*[@id='day']")));
	    sel2.selectByValue("3");
	    
	    Select sel3=new Select(driver.findElement(By.xpath(".//*[@id='year']")));
	    sel3.selectByIndex(5);
	    
	    //gander selection
	    driver.findElement(By.xpath(".//*[@id='u_0_k']")).click();
	    
	    //create new page
	    driver.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();
	    
	    
	    //navigate back first page 
	    driver.navigate().back();
	    
	    
	    
	    
	    
		

	}

}
