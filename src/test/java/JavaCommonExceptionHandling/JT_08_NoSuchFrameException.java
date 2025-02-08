package JavaCommonExceptionHandling;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
//What is NoSuchFrameException in Selenium?
//NoSuchFrameException occurs when Selenium WebDriver fails to switch to a frame because:
//
//The frame does not exist.
//The frame is not yet loaded.
//The frame locator is incorrect.
//The frame is inside another frame (nested frames).
//How to Handle NoSuchFrameException?
//✅ Solutions:
//
//Use WebDriverWait — Wait for the frame to load before switching.
//Verify the frame locator — Ensure the frame’s ID, name, or index is correct.
//Check for nested frames — If inside another frame, switch to the parent first.
//Use JavaScript execution — Get frames dynamically if standard methods fail.
//Real-Time Scenario:
//🔹 Scenario: Suppose you are automating a banking application where the login form is inside an iframe. If the iframe takes time to load, Selenium might throw NoSuchFrameException.

public class JT_08_NoSuchFrameException {
	public static void main(String[] args) {
		// Set up WebDriver
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://example.com/banking");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			try {
				// Wait until the frame is available
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("loginFrame")));

				// Now interact with elements inside the frame
				WebElement usernameField = driver.findElement(By.id("username"));
				usernameField.sendKeys("testuser");

				System.out.println("Successfully switched to the frame and entered username.");

			} catch (NoSuchFrameException e) {
				System.out.println("NoSuchFrameException: Frame not found! Retrying...");

				// Option 1: Try switching by index
				driver.switchTo().frame(0);

				// Option 2: Use JavaScript to locate frames
				JavascriptExecutor js = (JavascriptExecutor) driver;
				int frameCount = ((Long) js.executeScript("return window.frames.length;")).intValue();
				System.out.println("Number of frames found: " + frameCount);
			}

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
