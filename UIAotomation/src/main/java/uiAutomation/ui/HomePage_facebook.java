package uiAutomation.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uiAutomation.testBase.TestBase;

public class HomePage_facebook {
	public static final Logger log = Logger.getLogger(HomePage_facebook.class.getName());

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='email']")
	WebElement emailAddress;

	@FindBy(xpath = ".//*[@id='pass']")
	WebElement passWord;

	@FindBy(xpath = ".//*[@id='u_0_2']")
	WebElement submitButton;
	
	@FindBy(xpath=".//*[@id='not_me_link']")
	WebElement notYou_Link;

	public HomePage_facebook(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String email, String password) {

		emailAddress.sendKeys(email);
		log.info("Enter " + email);
		passWord.sendKeys(password);
		log.info("Enter " + password);
		submitButton.click();

	}

	public boolean NotYouLink_Displayed(){
		try {
			if(notYou_Link.isDisplayed());
			return true;
		} catch (Exception e) {
			return false;
		}
	
		
		
	}
}
