package uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import uiAutomation.excelReader.ReadExcel;

public class TestBase {

	public static final  Logger log=Logger.getLogger(TestBase.class);
	
	public WebDriver driver;
	String browser = "firefox";
	String url = "https://www.facebook.com/";
	ReadExcel excel;

	public void init() {
		try {
			selectBrowser(browser);
			getUrl(url);
			//String log4jConfigPath="log4j.properties";
			//PropertyConfigurator.configure(log4jConfigPath);
		} catch (Exception e) {
			System.out.println("The error is "+e.getMessage());
		}
	}

	public void selectBrowser(String browser) {
		
		
		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			//log.info("Createing object of "+browser);
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap.setBrowserName("internet explorer");
			driver = new InternetExplorerDriver(cap);
	}
	}

	public void getUrl(String url) {

		try {
			//log.info("Navigate to the "+url);
			driver.get(url);
			driver.manage().window().maximize();
		
		} catch (Exception e) {
			
			System.out.println("Find issue at location [TestBase.java line 32-42]--- "+e.getMessage());
		}
	}
	
	public String [][] getExcelDate(String excelName,String sheetName){
		String path=System.getProperty("user.dir")+"/src/main/java/uiAutomation/data/"+excelName;
		excel=new ReadExcel(path);
		String data[][]=excel.readAllDataFromSheet(sheetName, excelName);
		return data;
	}
}
