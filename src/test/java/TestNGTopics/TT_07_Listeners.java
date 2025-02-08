package TestNGTopics;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.io.IOException;

public class TT_07_Listeners implements ITestListener {
	ExtentReports extent;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail("Test Failed: " + result.getThrowable().getMessage());
		WebDriver driver = ((TT_07_BaseListener) result.getInstance()).driver; // Get WebDriver from test class
		String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test Skipped: " + result.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = "test-output/screenshots/" + screenshotName + ".png";
			FileHandler.copy(src, new File(path));
			return path;
		} catch (IOException e) {
			return "Failed to capture screenshot: " + e.getMessage();
		}
	}
}


