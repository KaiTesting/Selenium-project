package com.selenium.java;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class MyUtility {

	private WebDriver driver;

	/***
	 * This method starts local Firefox browser
	 * 
	 * @return WebDriver
	 */
	public WebDriver startFirefoxBrowser_2() {

		try {
			System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize(); // maximize window
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);// wait
																			// for
																			// driver

			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);// wait
																				// for
																				// page
																				// load
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue("[" + e.getMessage() + "]", false);
		}
		return driver;
	}

	/* This method enter text in text filed */

	public void enterTextField_2(By by, String textValue) {

		try {
			WebElement targetText = driver.findElement(by);
			targetText.clear();
			targetText.sendKeys(textValue);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue("[" + e.getMessage() + "]", false);
		}
	}

	public void selectDropDown_2(By by, String targetValue) {

		WebElement dropDownElem = null;
		try {
			dropDownElem = driver.findElement(by);
			Select selectList = new Select(dropDownElem);
			selectList.selectByVisibleText(targetValue);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("[" + e.getMessage() + "]", false);
			throw new NullPointerException();
		}
	}

	// click button
	public void clickButton_2(By by) {
		try {
			WebElement btnElem = driver.findElement(by);
			btnElem.click();
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("[" + e.getMessage() + "]", false);
			throw new NullPointerException();
		}
	}

	// take screen shot
	public String takeScreenShot_2(String screenShotName, String saveLocationPath) {
		String screenshotFileLocation = saveLocationPath + screenShotName + "_" + getCurrentTime_2() + ".png";
		try {
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File(screenshotFileLocation));
			System.out.println("Screenshot taken, located: '" + screenshotFileLocation + "'");
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("[" + e.getMessage() + "]", false);
			throw new NullPointerException();
		}
		return screenshotFileLocation;
	}

	public static void captureScreenShot_simpleWay(WebDriver driver, String name) {
		try {
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenShot, new File("./ScreenShot/" + name + ".png"));

			System.out.println("Screenshot Taken");
		} catch (Exception e) {

			e.printStackTrace();

			assertTrue("[" + e.getMessage() + "]", false);
		}
	}

	// This method generates current time-stamp 'yyyyMMdd_HHmmss' format
	public String getCurrentTime_2() {
		String timeStamp = null;
		try {
			timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(Calendar.getInstance().getTime());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("[" + e.getMessage() + "]", false);
		}
		return timeStamp;
	}

	// Find broken links
	public static void verifyLinkActive_2(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("[" + e.getMessage() + "]", false);
		}
	}

	// FluentWait

	public static void FluentWait(WebDriver driver, By by) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

					.withTimeout(30, TimeUnit.SECONDS)

					.pollingEvery(1, TimeUnit.SECONDS)

					.ignoring(NoSuchElementException.class);

			WebElement ele = wait.until(new Function<WebDriver, WebElement>() {

				public WebElement apply(WebDriver driver) {

					return driver.findElement(by);

				}
			});
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue("[" + e.getMessage() + "]", false);
		}
	}

	// Scroll into view, get object xpath which you want to work with

	public static void scrollIntoView_2(By by, WebDriver driver) {

		try {
			WebElement ele = driver.findElement(by);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView(true)", ele);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue("[" + e.getMessage() + "]", false);
		}
	}
	

	//Read excel
	
	public static void readExcel(String excelPath, String sheetName) {

		try {
			File scr = new File(excelPath);

			FileInputStream opt = new FileInputStream(scr);

			XSSFWorkbook wb = new XSSFWorkbook(opt);

			XSSFSheet sheet1 = wb.getSheet(sheetName);

			Iterator<Row> rowIterator = sheet1.iterator();

			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();

				Iterator<Cell> cellIterator = nextRow.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType())

					{
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue());
						break;
					}
					System.out.print(" - ");
				}
				System.out.println();
			}

			wb.close();
			opt.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("[ " + e.getMessage() + " ]");
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("[ " + e.getMessage() + " ]");
		}

	}
}
