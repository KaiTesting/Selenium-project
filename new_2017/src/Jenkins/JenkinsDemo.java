/**
 * 
 */
package Jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author kevser
 *
 */
public class JenkinsDemo {

	WebDriver driver;
	@Test
	public void testJenkins(){
		System.out.println("welcome to the jenkins world");
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		System.out.println("The page title is "+driver.getTitle());
		driver.quit();
	}
}
