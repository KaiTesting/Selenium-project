package seleniumUtility;

import java.util.Set;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenshotRule extends TestWatcher {

	public WebDriver driver;
	public UtilityLibrary myLib;
	public ExtentReports extent;
	public static ExtentTest test;
	private String fileNameOfReport = "";

	public ScreenshotRule(WebDriver _driver) {
		this.driver = _driver;
		fileNameOfReport = "C:/report/TestResultReport.html"; // "+myLib.getCurrentTime()+"
	}

	public void setDriver(WebDriver _driver) {
		this.driver = _driver;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void setUtilityLibrary(UtilityLibrary lib) {
		myLib = lib;
	}
	
	public void setExtentReport(ExtentReports extentReport) {
		extent = extentReport;
	}

	private String creatScreenshotName(Description des) {
		String finalScreenshotName = null;
		// String timeStamp = myLib.getCurrentTime();
		try {
			String temp = des.getDisplayName();
			finalScreenshotName = temp.replace('(', '_').replace(')', '_').replace(".", "_"); // +
																								// timeStamp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalScreenshotName;
	}

	@Override
	public void failed(Throwable t, Description des) {
		myLib = new UtilityLibrary(driver);
		String newScreenShotName = creatScreenshotName(des);
		String finalScreenPath = myLib.takeScreenShot(newScreenShotName, "C:/Users/pulatiy/Desktop/SourcePass.ScreentShot/");

		//ExtentReports extent = createReport();
		//test = extent.startTest(des.getDisplayName(), "Test failed, click here for further details");
		test = BasePage.test;
		// step log
		test.log(LogStatus.FAIL, "Failure trace Selenium:  " + t.toString());
		// adding error screenshot to the report
		test.log(LogStatus.FAIL, "Failure Screenshot: " + test.addScreenCapture(finalScreenPath));
		// adding failing test execution video to the report
		//test.log(LogStatus.FAIL, "Failure Video: " + test.addScreencast(("C:/Error_Videos/test1_Failed.mp4")));
		
		//test.log(test.setEndedTime(myLib.getCurrentTime()), details);
		//extent.endTest(test);
		//flushReports(extent, test);
		if (driver != null) {
			closeAllBrowsers();
			//driver.quit();
		}
	}

	@Override
	protected void succeeded(Description des) {
		//ExtentReports extent = createReport();
		//test = extent.startTest(des.getDisplayName(), "-");
		test = BasePage.test;

		// test log
		test.log(LogStatus.PASS, "Test Passed");
		//extent.endTest(test);
		//flushReports(extent, test);
		if (driver != null) {
			closeAllBrowsers();			
		}
	}

	private void closeAllBrowsers()
	{
		Set<String> allWindows = driver.getWindowHandles();
		for(String temp: allWindows)
		{
			driver.switchTo().window(temp).close();
		}
	}
	
	/*private ExtentReports createReport() {
		// if value = false, it will append to the existing report
		// if value = true, it will create new report for each test
		ExtentReports extent = new ExtentReports(fileNameOfReport, false); 
		//extent.config().reportName("Selenium Test Automation Report");
		//extent.config().reportHeadline("This is a suite of Automated Regression Tests");
		return extent;
	}*/

	//public static void flushReports(ExtentReports extent, ExtentTest test) {
	public static void flushReports(ExtentReports extent) {
		// ending Test
		extent.endTest(test);
		// writing everything to document
		extent.flush();
	}

}
