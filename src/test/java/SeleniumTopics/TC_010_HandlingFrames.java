package SeleniumTopics;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_010_HandlingFrames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();

		//1. Switching to a Frame by Index
		// Switch to the first frame (index starts from 0)
		driver.switchTo().frame(0);
		// Perform operations inside the frame (e.g., find an element and click it)
		WebElement button = driver.findElement(By.id("frameButton"));
		button.click();
		// Switch back to the main page (default content)
		driver.switchTo().defaultContent();

		//2. Switching to a Frame by Name or ID
		// Switch to the frame using its name or ID
		driver.switchTo().frame("frameNameOrId");
		// Perform actions inside the frame
		WebElement name = driver.findElement(By.id("frameButton"));
		name.click();
		// Switch back to the main page (default content)
		driver.switchTo().defaultContent();

		//3. Switching to a Frame by WebElement
		// Locate the frame WebElement
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='frameId']"));
		// Switch to the frame using the WebElement
		driver.switchTo().frame(frameElement);
		// Perform actions inside the frame
		WebElement insideFrame = driver.findElement(By.id("frameButton"));
		insideFrame.click();
		// Switch back to the main page (default content)
		driver.switchTo().defaultContent();


		//4. Handling Nested Frames
		// Switch to the outer frame
		driver.switchTo().frame("outerFrame");
		// Switch to the nested frame inside the outer frame
		driver.switchTo().frame("innerFrame");
		// Perform actions inside the nested frame
		WebElement frame = driver.findElement(By.id("nestedButton"));
		frame.click();
		// Switch back to the outer frame
		driver.switchTo().parentFrame();
		// Switch back to the main page (default content)
		driver.switchTo().defaultContent();

	}

}

