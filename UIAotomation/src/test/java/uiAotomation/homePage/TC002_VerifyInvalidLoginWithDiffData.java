package uiAotomation.homePage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import uiAutomation.testBase.TestBase;
import uiAutomation.ui.HomePage;

public class TC002_VerifyInvalidLoginWithDiffData extends TestBase {

	HomePage homepage;
	public static final  Logger log=Logger.getLogger(TestBase.class);

	@BeforeTest
	public void setup() {

		init();

	}
	
	@DataProvider(name="loginData")
	public String [][] getData(){
		String [][] testRecords=getExcelDate("TestData.xlsx","Sheet1");
		return testRecords;
	}

	@Test(dataProvider="loginData")
	public void VerifyInvalidLogin(String username,String password) {

		//log.info("===Start VerifyInvalidLogin  test===");
		homepage = new HomePage(driver);

		//log.info("Enter email and password");
		homepage.loginToApplication(username, password);

		//log.info("===Finshed VerifyInvalidLogin test====");
	}

	@AfterClass
	public void endTest() {

		driver.close();
	}
}
