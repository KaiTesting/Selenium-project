/**
 * 
 */
package cucumberTestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author kevser
 *
 */
public class TestFacebook_Login {

	WebDriver driver;
	
	@Given("^Open Firefox and start application$")
	public void Open_Firefox_and_start_application() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		
	}

	@When("^Enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void Enter_valid_username_and_password(String uname,String pass) throws Throwable {
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(uname);
	    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
	}

	@Then("^User should able to login successfully$")
	public void User_should_able_to_login_successfully() throws Throwable {
	   driver.findElement(By.xpath(".//*[@id='u_0_q']")).click();
	}
}
