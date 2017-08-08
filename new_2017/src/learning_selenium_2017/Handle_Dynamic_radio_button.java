package learning_selenium_2017;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handle_Dynamic_radio_button {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
		WebDriver driver= new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
		
		List<WebElement> radio=driver.findElements(By.xpath("//input[@type='radio']"));
		
		for(int i=0;i<radio.size();i++){
			WebElement local_radio=radio.get(i);
			String value=local_radio.getAttribute("value");
			
				System.out.println("radio value are  "+value);	
				
				if (value.equalsIgnoreCase("Java")){
					local_radio.click();
				}
		}
		
		

	}

}
