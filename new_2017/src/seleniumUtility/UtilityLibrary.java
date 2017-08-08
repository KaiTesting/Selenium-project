
package seleniumUtility;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import static org.junit.Assert.*;

public class UtilityLibrary {

	private WebDriver driver;
	private boolean isDemoMode = false;

	public void setDemoMode(boolean isDemoMode) {
		this.isDemoMode = isDemoMode;
	}

	/***
	 * Constructor of UtilityLibrary class
	 * 
	 * @param _driver
	 */
	public UtilityLibrary(WebDriver _driver) {
		this.driver = _driver;
	}

	/***
	 * Setter for driver
	 * 
	 * @param _driver
	 */
	public void setDriver(WebDriver _driver) {
		this.driver = _driver;
	}

	/***
	 * This method starts local Firefox browser
	 * 
	 * @return WebDriver
	 */
	public WebDriver startFirefoxBrowser() {
		try {
			driver = new FirefoxDriver();
			driver.manage().window().maximize(); // maximize the browser window
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // wait
																				// for
																				// driver
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); // wait
																				// for
																				// page
																				// load
		} catch (Exception e) {
			//System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			//throw new NullPointerException();
			//assertTrue("startFirefoxBrowser method failed", false);
			assertTrue("["+ e.getMessage() +"]", false);
		}
		return driver;
	}

	/***
	 * This method starts IE browser
	 * 
	 * @return
	 */
	private WebDriver startIEBrowser() {
		try {
			System.setProperty("webdriver.ie.driver", "C:/Users/pulatiy/Selenium Drivers/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true); // clear
																								// browser
																								// cache
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize(); // maximize the browser window
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // wait
																				// for
																				// driver
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);

		}
		return driver;
	}

	/***
	 * This method starts remote browser
	 * 
	 * @param hubRUL
	 * @param browserName
	 * @return
	 * @throws Exception
	 */
	public WebDriver startRemoteBrowser(String hubRUL, String browserName) throws Exception {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(browserName);
			driver = new RemoteWebDriver(new URL(hubRUL), capabilities);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);

		}
		return driver;
	}

	/***
	 * This method starts local browser for given browser types Example: ie,
	 * firefox, chrome
	 * 
	 * @param browserName
	 * @return
	 */
	public WebDriver startLocalBrowser(String browserName) {
		try {
			if (browserName.contains("ie")) {
				driver = startIEBrowser();
			} else if (browserName.contains("firefox")) {
				driver = startFirefoxBrowser();
			} else if (browserName.contains("chrome")) {
				driver = startChromeBrowser();
			} else {
				throw new Exception(
						"Utility Library not supporting the browser you choose yet. \n Utility Library class currently supports: 'Chrome, IE & Firefox' browsers.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
		return driver;
	}

	public WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:/Users/pulatiy/Selenium Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // wait
																				// for
																				// driver
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
		return driver;
	}

	/***
	 * This method enter text field
	 * 
	 * @param by
	 * @param textValue
	 */
	public void enterTextField(By by, String textValue) {
		try {
			WebElement targetTextField = driver.findElement(by);
			targetTextField.clear();
			targetTextField.sendKeys(textValue);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
	}

	// This method used only for select and option html tags
	public void selectDropDown(By by, String targetValue) {
		WebElement dropDownElem = null;
		try {
			dropDownElem = driver.findElement(by);
			Select selectList = new Select(dropDownElem);
			selectList.selectByVisibleText(targetValue);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	/***
	 * This method captures screenshot using Selenium library
	 * 
	 * @param screenShotName
	 * @param saveLocationPath
	 * @return String location of the screenshot
	 */
	public String takeScreenShot(String screenShotName, String saveLocationPath) {
		String screenshotFileLocation = saveLocationPath + screenShotName + "_" + getCurrentTime() + ".png";
		try {
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File(screenshotFileLocation));
			System.out.println("Screenshot taken, located: '" + screenshotFileLocation + "'");
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
		return screenshotFileLocation;
	}

	// This method generates current time-stamp 'yyyyMMdd_HHmmss' format
	public String getCurrentTime() {
		String timeStamp = null;
		try {
			timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(Calendar.getInstance().getTime());
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
		return timeStamp;
	}
	
	// This method generates current time-stamp 'yyyyMMdd_HHmmss' format
		public String getCurrentTime(String dateFormat) {
			String timeStamp = null;
			try {
				timeStamp = new SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime());
			} catch (Exception e) {
				e.printStackTrace();
				assertTrue("["+ e.getMessage() +"]", false);
			}
			return timeStamp;
		}
	// This method generates current time-stamp 'MM/dd/yyyy/hh' format
		public String getCurrentTimeToHour() {
			String timeStamp = null;
			try {
				timeStamp = new SimpleDateFormat("MM/dd/yyyy/hh").format(Calendar.getInstance().getTime());
			} catch (Exception e) {
				e.printStackTrace();
				assertTrue("["+ e.getMessage() +"]", false);
			}
			return timeStamp;
		}
		// This method generates current time-stamp 'MM/dd/yyyy/' format
				public String getCurrentTimeToDay() {
					String timeStamp = null;
					try {
						timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
					} catch (Exception e) {
						e.printStackTrace();
						assertTrue("["+ e.getMessage() +"]", false);
					}
					return timeStamp;
				}
	
	/***
	 * This method used for dynamic element search
	 * 
	 * @param by
	 * @return WebElement
	 */
	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				// @Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
		return targetElem;
	}

	// This method stops the thread for given second
	public void customWait(int inSeconds) throws Exception {
		try{
		Thread.sleep(inSeconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	// This method prints the given string in the console
	public void print(String stringValue) {
		System.out.println(stringValue);
	}

	/***
	 * This method clicks the given WebElement
	 * 
	 * @param by
	 */
	public void clickButton(By by) {
		try {
			WebElement btnElem = driver.findElement(by);
			btnElem.click();
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	/***
	 * This method clicks the given hyper link
	 * 
	 * @param by
	 */
	public void clickHyperLink(By by) {
		try {
			WebElement btnElem = driver.findElement(by);
			btnElem.click();
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	/***
	 * This method clicks for any hidden element
	 * 
	 * @param by
	 */
	public void clickOnHiddenElement(By by) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(by));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	/***
	 * This method moves the mouse pointer to the given WebElement
	 * 
	 * @param toElement
	 */

	public void moveMouseToElement(WebElement toElement) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(toElement).build().perform();
			customWait(1);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	/***
	 * This method move mouse to first given WebElement then to second
	 * WebElement
	 * 
	 * @param toFirstElement
	 * @param toSecondElement
	 */
	public void moveMouseToElement(WebElement toFirstElement, WebElement toSecondElement) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(toFirstElement).build().perform();
			customWait(1);
			action.moveToElement(toSecondElement).build().perform();
			customWait(1);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	/***
	 * This method uploads given file Note*: for windows test execution
	 * environment, please use "\\" for the file path for other environment (Mac
	 * OS, Linux), please use "/" for the file path
	 * 
	 * @param by
	 * @param absulatePathForFile
	 */

	public void uploadFile(By by, String absulatePathForFile) {
		try {
			WebElement fileUploadElem = driver.findElement(by);
			fileUploadElem.sendKeys(absulatePathForFile);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	/***
	 * This method search data from table
	 * 
	 * @param tableID
	 * @param Row_Num
	 * @param Col_Num
	 * @return
	 */
	public String tableSearch(By tableID, int Row_Num, int Col_Num) {
		String result = null;
		try {
			WebElement table = driver.findElement(tableID);
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			int i_row = 1;
			for (WebElement temp : rows) {
				if (i_row == Row_Num) {
					List<WebElement> cols = temp.findElements(By.tagName("td"));
					int i_col = 1;
					for (WebElement temp2 : cols) {
						if (i_col == Col_Num) {
							return result = temp2.getText();
						}
						i_col++;
						// System.out.println("Row: "+ i_row+", col: "+ i_col+",
						// Data: "+ temp2.getText());
					}

				}
				i_row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
		return result;
	}

	/***
	 * This method dynamically waits for the Visibility condition of given
	 * 
	 * @param by
	 * @return
	 */
	public WebElement waitForConditionVisibility(By by) {
		WebElement temp = null;
		try {
			WebDriverWait pageWait = new WebDriverWait(driver, 30);
			temp = pageWait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
		return temp;
	}

	/***
	 * This method dynamically waits for the Presence condition of given element
	 * 
	 * @param by
	 * @return
	 */
	public WebElement waitForConditionPresense(By by) {
		WebElement temp = null;
		try {
			WebDriverWait pageWait = new WebDriverWait(driver, 30);
			temp = pageWait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
		return temp;
	}

	/***
	 * This method switch back to original html content from iFrame section
	 */
	public void switchToDefault() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	/***
	 * This method switch the driver to iFrame section of the html source
	 * 
	 * @param by
	 */
	public void switchToIframe(By by) {
		try {
			WebElement iFrameElem = driver.findElement(by);
			driver.switchTo().frame(iFrameElem);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
	}

	public void highlightElement(WebElement element) {
		if (isDemoMode == true) {
			try {
				for (int i = 0; i < 10; i++) {
					WrapsDriver wrappedElement = (WrapsDriver) element;
					JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
					Thread.sleep((500));
					driver.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
							"color: red; border: 2px solid yellow;");
					Thread.sleep((500));
					driver.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
				}
			} catch (Exception e) {
				e.printStackTrace();
				assertTrue("["+ e.getMessage() +"]", false);
				throw new NullPointerException();
			}
		}
	}

	public void switchWindow(int windowindex) {
		try{
		String windowHandle = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window(tabs.get(windowindex));
		}catch (Exception e)
		{
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
	}

	public void clickOnHiddenElement(WebElement tagAElem) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", tagAElem);
		} catch (Exception e) {
			//print("Error: " + e.getMessage());
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
	}
	
	public void verifyText(By by, String expectedText)
	{
		try {
			String actualText = driver.findElement(by).getText();
			if(actualText.equals(expectedText))
			{
				System.out.println("Text is as expected");
			}
		} catch (Exception e) {
			//System.out.println("Text is not as expected");
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
		}
	}

	/***
	 * This method switch the driver to iFrame section of the html source
	 * 
	 * @param by
	 */
	public void switchToIframe(WebElement webElement) {
		try {			
			driver.switchTo().frame(webElement);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("["+ e.getMessage() +"]", false);
			throw new NullPointerException();
		}
		
	}
}
