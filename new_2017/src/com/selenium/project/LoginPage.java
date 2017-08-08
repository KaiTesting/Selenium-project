/**
 * 
 */
package com.selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author kevser
 *
 */
public class LoginPage {

	WebDriver driver;
	

		
	By username= By.xpath(".//*[@id='txtUsername']");
	
	By password= By.xpath(".//*[@id='txtPassword']");
	
	By login=By.xpath(".//*[@id='btnLogin']");
	
	
	
public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
public void orangeHRMLogin(String user,String pass){
	
	driver.findElement(username).sendKeys(user);
	driver.findElement(password).sendKeys(pass);
	driver.findElement(login).click();
	
}

public void typeUserName(String user){
	
	driver.findElement(username).sendKeys(user);
}


public void typePassWord(String pass){
	driver.findElement(password).sendKeys(pass);
}

public void ClickLoginButton(){
	driver.findElement(login).click();
}







}
