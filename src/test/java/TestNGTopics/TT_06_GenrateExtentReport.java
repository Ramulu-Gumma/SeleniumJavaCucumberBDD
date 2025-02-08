package TestNGTopics;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class TT_06_GenrateExtentReport {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser", "Chrome");
	}

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testLogin() {
		test = extent.createTest("Login Test", "Verifies login functionality");

		try {
			driver.get("https://example.com/login");
			test.info("Navigated to login page");

			driver.findElement(By.id("username")).sendKeys("testuser");
			test.pass("Entered username");

			driver.findElement(By.id("password")).sendKeys("password");
			test.pass("Entered password");

			driver.findElement(By.id("loginButton")).click();
			test.pass("Clicked login button");

			String expectedUrl = "https://example.com/home";
			if (driver.getCurrentUrl().equals(expectedUrl)) {
				test.pass("Login successful, redirected to home page");
			} else {
				test.fail("Login failed, incorrect redirection");
				captureScreenshot(driver, "loginFailure");
			}
		} catch (Exception e) {
			test.fail("Test failed: " + e.getMessage());
			captureScreenshot(driver, "exception");
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}

	public void captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = "test-output/screenshots/" + screenshotName + ".png";
			FileUtils.copyFile(src, new File(path));
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			test.fail("Failed to capture screenshot: " + e.getMessage());
		}
	}
}


