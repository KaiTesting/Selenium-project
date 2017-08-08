package seleniumGoOverNew;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class HandleUntrustedCertificate {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "E:\\software\\Selenium3\\geckodriverNew\\geckodriver.exe");

		/*FirefoxProfile fpro=new FirefoxProfile();
		
		fpro.setAcceptUntrustedCertificates(true);
		
		fpro.setAssumeUntrustedCertificateIssuer(false);
		 
		WebDriver driver = new FirefoxDriver(fpro);
		
		driver.manage().window().maximize();
	
		driver.get("https://untrusted-root.badssl.com");
		*/
		

		ProfilesIni prof = new ProfilesIni();
		FirefoxProfile ffProfile = prof.getProfile("myProfile");

		ffProfile.setAcceptUntrustedCertificates(true);
		ffProfile.setAssumeUntrustedCertificateIssuer(false);

		WebDriver driver = new FirefoxDriver(ffProfile);

		driver.manage().window().maximize();

		driver.get("https://untrusted-root.badssl.com");
		
		System.out.print(driver.getTitle());

	}

}
