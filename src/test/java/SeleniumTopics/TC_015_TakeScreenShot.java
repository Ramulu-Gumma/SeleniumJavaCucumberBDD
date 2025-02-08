package SeleniumTopics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TC_015_TakeScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		//Launch chrome Browser
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "chromedriverpath");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//Take Screenshot
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File scrFile = screenShot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File desFile = new File("screenshotpath: "+timeStamp+ ".png");
		FileUtils.copyFile(scrFile, desFile);

			}

}
