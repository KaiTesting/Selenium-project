package learning_selenium_2017;

public class Report {
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.List;

	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Rule;
	import org.openqa.selenium.WebDriver;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;

	public class BasePage {

	    public static String timeStamp;
	    public static WebDriver driver;
	    public static UtilityLibrary myLib;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	    public static String fileNameOfReport = "C:/report/TestResultReport" + getCurrentTimeForReport() + ".html";
	    
	    private static String browserType;
	    private static String isRemote;

	    @Before
	    public void beforeEachTest() throws Exception {
	        
	         myLib = new UtilityLibrary(driver);
	        myLib.setDemoMode(false);
	        driver = myLib.startLocalBrowser("firefox"); // ie, chrome, firefox
	        // internet explorer, chrome, firefox
	        // driver = myLib.startRemoteBrowser("http://192.168.1.6:5200/wd/hub",
	        // "internet explorer");
	        myscreenshotrule.setDriver(driver);
	        myscreenshotrule.setUtilityLibrary(myLib);
	        System.out.println("...test started...");

	    
	        /*myLib.setDemoMode(false);
	        if(browserType.contains("ie"))
	        {
	            browserType = "internet explorer";
	        }
	        
	        if(isRemote.contains("True"))
	        {
	            driver = myLib.startRemoteBrowser("http://192.168.192.236:4444/wd/hub",browserType);
	        }else
	        {
	            driver = myLib.startLocalBrowser(browserType); // ie, chrome, firefox
	        }
	        // internet explorer, chrome, firefox
	        // driver = myLib.startRemoteBrowser("http://192.168.1.6:5200/wd/hub"),
	        // "internet explorer");
	        myscreenshotrule.setDriver(driver);
	        myscreenshotrule.setUtilityLibrary(myLib);
	        System.out.println("...test started...");*/
	    }

	    @Rule
	    public ScreenshotRule myscreenshotrule = new ScreenshotRule(driver);

	    @After
	    public void afterEachTest() throws Exception {
	        myLib.customWait(5);
	        System.out.println("...test completed...");
	    }

	    @BeforeClass
	    public static void beforeAllTest() throws Exception {
	        autoTestConfig();
	        extent = new ExtentReports(fileNameOfReport, true);
	        myLib = new UtilityLibrary(driver);
	        JavaPropertiesManager propertyWriter = new JavaPropertiesManager("src/test/resources/data/data.properties");        
	        propertyWriter.setProperty("time", myLib.getCurrentTime());
	        myLib.customWait(1);
	        JavaPropertiesManager propertyReader = new JavaPropertiesManager("src/test/resources/data/data.properties");
	        timeStamp = propertyReader.readProperty("time");
	        System.out.println("time: " + timeStamp);
	        
	        
	    }

	    @AfterClass
	    public static void afterAllTest() throws Exception {        
	        ScreenshotRule.flushReports(extent);
	        killBrowser();
	    }

	    private static void killBrowser() throws IOException {
	        Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
	    }

	    private static String getCurrentTimeForReport() {
	        String finalTime = null;
	        finalTime = new SimpleDateFormat("yyyymmdd_HHmmss").format(Calendar.getInstance().getTime());
	        return finalTime;
	    }
	    
	    private static void autoTestConfig()
	    {
	        //Step1: read config file and load the class variables
	        TextFileManager reader = new TextFileManager("src/test/resources/AutomationConfig.txt");
	        String[] configData = reader.read().split(";");
	        browserType = configData[0];
	        isRemote = configData[1];        
	    }

}
