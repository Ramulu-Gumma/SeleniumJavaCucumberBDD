package TestNGTopics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class TT_09_RetryFailedTests {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class) // Apply retry to this test
	public void testInvalidLogin() {
		driver.get("https://example.com/login");
		driver.findElement(By.id("username")).sendKeys("wronguser");
		driver.findElement(By.id("password")).sendKeys("wrongpassword");
		driver.findElement(By.id("loginButton")).click();

		boolean errorDisplayed = driver.findElement(By.id("errorMessage")).isDisplayed();
		Assert.assertTrue(errorDisplayed, "Error message not displayed!"); // Assertion for failure
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	// Inner Class for Retry Logic
	public static class RetryAnalyzer implements IRetryAnalyzer {
		private int retryCount = 0;
		private static final int maxRetryCount = 2; // Retry failed test up to 2 times

		@Override
		public boolean retry(ITestResult result) {
			if (retryCount < maxRetryCount) {
				retryCount++;
				System.out.println("Retrying " + result.getName() + " (Attempt " + (retryCount + 1) + ")");
				return true; // Retry the test
			}
			return false; // Stop retrying after max retries
		}
	}
}

