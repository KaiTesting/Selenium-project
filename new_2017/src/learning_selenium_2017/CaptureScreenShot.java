package learning_selenium_2017;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;


public class CaptureScreenShot {
    WebDriver driver;
    
    
    
	public void takescreenshot(WebDriver driver,String name) throws Exception{
		
		TakesScreenshot scrshot = (TakesScreenshot)driver;
		File src= scrshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File("./ScreenShot/"+name+".png"));
	}
}
