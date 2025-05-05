package SeleniumTopics;
		

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TC_015_TakeScreenShot {

	public static void main(String[] args) throws IOException {
        //Launch chrome Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
		driver.findElement(By.xpath(""));
		
		//Take Screenshot
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File scrFile = screenShot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File desFile = new File("screenshotpath: "+timeStamp+ ".png");
		FileUtils.copyFile(scrFile, desFile);

			}

}
