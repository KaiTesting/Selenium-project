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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.selenium.project.LoginPage;
import com.selenium.project.LoginPage2_PageFactory;

/**
 * @author kevser
 *
 */
public class VerifyOrangeHRM2_PageFatory {

	@Test
	public void verifyLogin(){
		
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get("https://enterprise-demo.orangehrmlive.com/auth/login");
		
		LoginPage2_PageFactory login_page=PageFactory.initElements(driver, LoginPage2_PageFactory.class);
		
		login_page.Login_orangeHRM_2("Admin", "admin");
		
		System.out.println(driver.getTitle());
		
	}
}
