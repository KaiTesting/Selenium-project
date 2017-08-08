package seleniumUtility;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoverOverMouse {

	public static WebDriver driver;
	public static UtilityLibrary myLib;

	@Before
	public void beforeTest() {
		myLib = new UtilityLibrary(driver);
		driver = myLib.startFirefoxBrowser();
		driver.get("http://www.hdfcbank.com/");

	}

	@After
	public void afterTest() {
		try {
			myLib.customWait(3);
			System.out.println("Test completed...");
			driver.close(); // if you want to use screenshotRule, please
							// commented out this
			driver.quit();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void MoveMouse() {

		try {
			myLib.clickButton(By.id("cee_closeBtn"));

			WebElement makingPayment = driver.findElement(By.linkText("Making payments"));

			myLib.moveMouseToElement(makingPayment);

			driver.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
