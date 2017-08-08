package uiAutomation.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	
/*	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;*/
	
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement emailAddress;
	
	
	@FindBy(xpath=".//*[@id='pass']")
	WebElement passWord;
	
	
	@FindBy(xpath=".//*[@id='u_0_r']")
	WebElement submitButton;
	
	
	@FindBy(xpath=".//*[@id='reg-link']")
	WebElement signUpForFacebook;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String email,String password){
		
		
		emailAddress.sendKeys(email);
		passWord.sendKeys(password);
		submitButton.click();	
	}
	
	public String getsignUpForFacebookText(){
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement text=wait.until(ExpectedConditions.visibilityOf(signUpForFacebook));
		return text.getText();
		
	}
}
