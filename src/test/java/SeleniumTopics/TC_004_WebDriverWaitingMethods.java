package SeleniumTopics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_004_WebDriverWaitingMethods {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();
		
		//1. Implicit Wait--The Implicit Wait is used to specify the maximum time selenium should wait for an element to appear before throwing a NoSuchElementException. 
		//It is set once and applies to all elements in the test.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//2. Explicit Wait--An Explicit Wait is used to pause the execution of the test until a specific condition is met, 
		//such as an element becoming visible, clickable, or present in the DOM. Explicit waits give you more control over the timing and the condition you're waiting for.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
	}
	

}
