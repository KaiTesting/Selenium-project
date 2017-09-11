package uiAotomation.homePage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uiAutomation.testBase.TestBase;
import uiAutomation.ui.HomePage_facebook;

public class TC002_VerifyInvalidLoginWithDiffData extends TestBase {

	HomePage_facebook homepage;
	public static final Logger log = Logger.getLogger(TestBase.class);

	@BeforeTest
	public void setup() {

		init();

	}

	@DataProvider(name = "loginData")
	public String[][] getData() {
		String[][] testRecords = getExcelDate("TestData.xlsx", "Sheet1");
		return testRecords;
	}

	@Test(dataProvider = "loginData")
	public void VerifyInvalidLogin(String username, String password) {

		log.info("===Start VerifyInvalidLogin  test===");
		homepage = new HomePage_facebook(driver);

		log.info("Enter email and password");
		homepage.loginToApplication(username, password); 

		log.info("Verify <Not You> link displayed");
		boolean status = homepage.NotYouLink_Displayed();
		Assert.assertEquals(status, true);

		log.info("===Finshed VerifyInvalidLogin test====");
	}

	@AfterTest
	public void endTest() {

		driver.close();
	}
}
