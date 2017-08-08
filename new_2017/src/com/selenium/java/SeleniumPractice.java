package com.selenium.java;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;

import junit.framework.Assert;

public class SeleniumPractice extends MyUtility {

	public static WebDriver driver;
	public static String path=("C://Users//kevser//Desktop//Tools//matiriyal//Carefirst test case templete.xlsx");

	public void login(){

		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://http://www.automationpractice.com/");
		
		
		
		
		
		
		
		
		
		
		

		/*
		 * List<WebElement> links= driver.findElements(By.tagName("a"));
		 * 
		 * System.out.println("Totle links in the page "+links.size());
		 * 
		 * System.out.println();
		 * 
		 * for(int i=0;i<links.size();i++){ WebElement ele=links.get(i); String
		 * url=ele.getAttribute("href"); obj.verifyLinkActive(url); }
		 * 
		 * 
		 * System.out.println("Test completed");
		 */

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	void test1() {
		SoftAssert assertion = new SoftAssert();
		System.out.println("test 1 started");
		assertion.assertEquals(12, 3, "number is not match");
		System.out.println("test 1 completed");
		assertion.assertAll();
	}

	void test2() {
		SoftAssert assertion = new SoftAssert();
		System.out.println("test 2 started");
		assertion.assertEquals(22, 22, "number is not match");
		System.out.println("test 2 completed");
		assertion.assertAll();
	}

	void test3() {
		SoftAssert assertion = new SoftAssert();
		System.out.println("test 3 started");
		assertion.assertEquals(34, 33, "number is not match");
		System.out.println("test 3 completed");
		assertion.assertAll();

	}

	void test4() {
		System.out.println("test 4 started");
		Assert.assertEquals(13, 45);
		System.out.println("test 4 completed");
	}

	@Test
	void test5() {
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().window().maximize(); // maximize window

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.google.com");

		System.out.println("test started");

		String title = driver.getTitle();

		System.out.println("page title is " + title);

		// Assert.assertEquals("Google", "oogle");

		SoftAssert s_assert = new SoftAssert();

		s_assert.assertEquals("Google", title);
		s_assert.assertAll();

		String text = driver.findElement(By.xpath(".//*[@id='gbw']/div/div/div[1]/div[1]/a")).getAttribute("innerHTML");

		System.out.println("text from page :" + text);

		Assert.assertEquals(text, "Gmail");

		System.out.println("test completed");
	}

	void getScreenshot(WebDriver driver, String name) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShot/" + name + ".png"));

	}

	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url_1 = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url_1.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.setRequestMethod("GET");

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseCode());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(
						linkUrl + " - " + httpURLConnect.getResponseCode() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}

	public static void FluentWait(WebDriver driver, By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(30, TimeUnit.SECONDS)

				.pollingEvery(1, TimeUnit.SECONDS)

				.ignoring(NoSuchElementException.class);

		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(by);

			}
		});

	}

	public static void scrollIntoView(By by) {

		WebElement ele = driver.findElement(by);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
}