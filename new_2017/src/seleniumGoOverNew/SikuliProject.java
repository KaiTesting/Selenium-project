package seleniumGoOverNew;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliProject {

	WebDriver driver;
	Screen myScreen;
	
	public void invokeBroswerAndLaunchApp() {
		
		try {
			System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");

			driver = new FirefoxDriver();
			
			driver.manage().deleteAllCookies();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.get("https://www.facebook.com");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void loginFacebook(){
		
		Pattern userName=new Pattern("E:\\software\\Selenium3\\sikuli_jar\\Image\\facebook_username.PNG");
		Pattern login=new Pattern("E:\\software\\Selenium3\\sikuli_jar\\Image\\facebook_login.PNG");
		Pattern logo=new Pattern("E:\\software\\Selenium3\\sikuli_jar\\Image\\facebook_logo.PNG");
		try {
			/*myScreen.wait(userName,5);
			myScreen.type(userName,"kevser");*/
			myScreen.wait(logo,5);
		   // myScreen.click(login);
		     if (myScreen.exists(logo) != null){
		    	 System.out.println("login button is exists");
		     };
		} catch (FindFailed e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		SikuliProject myobj=new SikuliProject();
		
		myobj.invokeBroswerAndLaunchApp();
		myobj.loginFacebook();
		
	}

}
