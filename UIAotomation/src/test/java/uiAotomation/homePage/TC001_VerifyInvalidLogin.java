package uiAotomation.homePage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import uiAutomation.testBase.TestBase;
import uiAutomation.ui.HomePage;

public class TC001_VerifyInvalidLogin extends TestBase {

	
	public static final Logger log = Logger.getLogger(TC001_VerifyInvalidLogin.class.getName());
	HomePage homepage;
	@BeforeTest
	public void setup() {

		init();

	}

	@Test
	public void VerifyInvalidLogin() {

		log.info("===Start VerifyInvalidLogin  test===");
		homepage = new HomePage(driver);

		
		homepage.loginToApplication("test@gmail.com", "password678");

		/*log.info("Verify signUpForFacebook is displayed on the page");
		Assert.assertEquals(homepage.getsignUpForFacebookText(), "Sign up for Facebook");*/
		
		log.info("===Finshed VerifyInvalidLogin test====");
	}

	@AfterClass
	public void endTest() {

		driver.close();
	}
}
