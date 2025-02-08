package JavaCommonExceptionHandling;


//	What is WebDriverException in Selenium?
//	WebDriverException is a generic exception in Selenium WebDriver that occurs when there is an issue interacting with the WebDriver or browser. It is the parent class of many Selenium exceptions.
//
//	Common Causes of WebDriverException
//	Browser closed unexpectedly – If WebDriver tries to interact with a closed or crashed browser.
//	WebDriver version mismatch – Incompatible browser and WebDriver versions.
//	Session timeout – If WebDriver loses the connection to the browser.
//	Invalid WebDriver commands – Trying to interact with an element in an invalid state.
//	Network issues – If the browser cannot communicate with the WebDriver.
//	How to Handle WebDriverException?
//	✅ Solutions:
//
//	Use try-catch block – Catch WebDriverException and handle it.
//	Validate WebDriver setup – Ensure WebDriver is compatible with the browser version.
//	Check browser status before executing commands – Avoid interacting with a closed browser.
//	Use WebDriverWait for stability – Ensure elements are ready before interacting.
//	Restart WebDriver in case of failure – If the WebDriver session crashes, restart it.
//	Real-Time Scenario:
//	🔹 Scenario: You are running Selenium tests, but sometimes the browser crashes or the WebDriver loses connection. Instead of failing immediately, we handle the WebDriverException and restart the browser.
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class JT_06_WebDriverException {
	public static void main(String[] args) {
		WebDriver driver = null;

		try {
			// Set up WebDriver
			System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get("https://example.com");

			try {
				// Attempt to find and interact with an element
				WebElement loginButton = driver.findElement(By.id("loginBtn"));
				loginButton.click();
			} catch (WebDriverException e) {
				System.out.println("WebDriverException occurred: " + e.getMessage());

				// Restart WebDriver if session is lost
				if (driver != null) {
					driver.quit();
				}
				driver = new ChromeDriver();
				driver.get("https://example.com");
			}

			System.out.println("Test execution continued...");

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
}

