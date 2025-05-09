package SeleniumTopics;

import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_005_NavigationMethods {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();

		//2. setSize()-Resizes the browser window to a specific size.
		driver.manage().window().setSize(new Dimension(1024, 768));

		//2.1 navigate().to(String url)--Navigates to the specified URL.
		driver.navigate().to("https://www.example.com");  // Navigate to Example site

		//2.2 navigate().back()--Navigates to the previous page in the browser's history.
		driver.navigate().back();

		//2.3 navigate().forward()--Navigates to the next page in the browser's history (if any).
		driver.navigate().forward();

		//2.4 navigate().refresh()--Refreshes the current page.
		driver.navigate().refresh();

		// Wait for the next page to load
		driver.navigate().to("https://www.example.com/dashboard");
		// Verify if the dashboard page URL is correct
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

	}

}
