/**
 * 
 */
package com.selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author kevser
 *
 */
public class LoginPage2_PageFactory {

	WebDriver driver;
	

//Constructor	
public LoginPage2_PageFactory(WebDriver driver){
		this.driver=driver;
	}
	


@FindBy(how=How.XPATH,using=".//*[@id='txtUsername']")
WebElement username;

@FindBy(how=How.XPATH,using=".//*[@id='txtPassword']")
WebElement password;

@FindBy(how=How.XPATH,using=".//*[@id='btnLogin']")
WebElement Login_button;


public void Login_orangeHRM_2(String userID,String userPass){
	username.sendKeys(userID);
	password.sendKeys(userPass);
	Login_button.click();
}





}
