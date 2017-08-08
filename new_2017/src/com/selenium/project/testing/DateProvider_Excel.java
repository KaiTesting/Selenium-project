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
public class DateProvider_Excel {

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

		
		
		GetData_project.excelConfig("C:/Users/kevser/workspace/new_2017/TestDate_ORG_Login/Login.xlsx");
		
		int rows=GetData_project.getRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0;i<rows;i++){
			
			if(GetData_project.getData(0, i, 0).equalsIgnoreCase("user")&&GetData_project.getData(0, i, 0)==null){
				continue;
			}
			
			data[i][0]=GetData_project.getData(0, i, 0);
			data[i][1]=GetData_project.getData(0, i, 1);
		}

		
		return data;
	}
}
