package com.selenium.java;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AumationPractice {

	WebDriver driver;
	
	@Test
	public void login(){
		
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");

		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		System.out.println(System.getProperty("user.dir"));
		
		driver.get("http://www.automationpractice.com/");
		
		driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("Test@gmail.com");

		driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("4564564679");
		
		driver.findElement(By.xpath(".//*[@id='SubmitLogin']")).click();
		
		Assert.assertEquals("Authentication failed.", driver.findElement(By.xpath(".//*[@id='center_column']/div[1]/ol/li")).getText());
		
		
	}
}
