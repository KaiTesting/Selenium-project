/**
 * 
 */
package com.selenium.project.testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.project.LoginPage;

/**
 * @author kevser
 *
 */
public class VerifyOrangeHRM {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger; 
	
	@Test
	public void verifyLogin(){
		
		report= new ExtentReports("E:\\software\\Selenium3\\Report\\VerifyORGLogin.html");
		
	    logger=report.startTest("Verify login with admin");
	    
	    
		
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		logger.log(LogStatus.INFO, "Browser start");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get("https://enterprise-demo.orangehrmlive.com/auth/login");
		
		LoginPage login=new LoginPage(driver);
		
		login.orangeHRMLogin("Admin","admin");
		
		logger.log(LogStatus.INFO, "Login with admin account");
		
		List<WebElement> DbList=driver.findElements(By.xpath("//fieldset [@id='panel_resizable_0_6']//table/tbody/tr/td"));
		
		for(int i=0;i<DbList.size();i++){
			
			String tblistName=DbList.get(i).getText();
			
			if(tblistName.contains("Timesheets")){
				
				DbList.get(i).click();
			}
			
		}
		
		driver.findElement(By.xpath("//input[@id='x_report_employeeId_empName']")).sendKeys("Linda Anderson");
		
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

		logger.log(LogStatus.INFO, "Search person from timesheet list");
		
		String text = driver.findElement(By.xpath(".//*[@id='startDates']")).getText();

		System.out.println("Timesheet for week from " + text);

		String serachResult = driver.findElement(By.xpath(".//*[@id='noRecordsColumn']")).getText();

		if (serachResult.equalsIgnoreCase("No Records Found")) {
			System.out.println("This person has not submitted any timesheet");
		}
		
		report.endTest(logger);
		report.flush();
		
		driver.quit();
	}
}
