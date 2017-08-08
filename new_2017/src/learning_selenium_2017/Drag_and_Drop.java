package learning_selenium_2017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_and_Drop {
	

	WebDriver driver = new FirefoxDriver();
	
	public String baseUrl="http://jqueryui.com/resources/demos/droppable/default.html";
	
	public void openUrl(){
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	public void Action_01(){
		driver.findElement(By.xpath(".//*[@id='draggable']")).click();
		WebElement dragme=driver.findElement(By.xpath(".//*[@id='draggable']"));
		WebElement dropme=driver.findElement(By.xpath(".//*[@id='droppable']"));
		
		Actions bulider=new Actions(driver);
		
		bulider.dragAndDrop(dragme, dropme).perform();
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
		Drag_and_Drop test = new Drag_and_Drop();
		
		test.openUrl();
		Thread.sleep(5000);
		test.Action_01();
		
	}

}
