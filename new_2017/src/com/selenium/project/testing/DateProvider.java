/**
 * 
 */
package com.selenium.project.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author kevser
 *
 */
public class DateProvider {

	@Test(dataProvider = "orgLoginData")
	public void OrgLogin(String username, String password) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://enterprise-demo.orangehrmlive.com/auth/login");

		driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys(username);

		driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys(password);

		driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
		
		Thread.sleep(5000);

		System.out.println(driver.getTitle());

		driver.quit();
	}

	@DataProvider(name = "orgLoginData")
	public Object[][] passDate() {

		Object[][] data = new Object[2][2];

		data[0][0] = "anthony.nolan";
		data[0][1] = "anthony.nolan";

		data[1][0] = "peter.mac";
		data[1][1] = "peter.mac";

		return data;
	}
}
