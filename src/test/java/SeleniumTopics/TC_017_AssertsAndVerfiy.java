package SeleniumTopics;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC_017_AssertsAndVerfiy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Set up WebDriver
		WebDriver driver;
		driver  = new ChromeDriver();

		// Navigate to login page
		driver.get("https://www.example.com/login");
		//Hard Assertions are used to stop the test execution when the assertion fails. 
		//The test will terminate immediately, and the failure will be reported.
		//1.assertEquals(expected, actual): Verifies that the expected value is equal to the actual value.
		// Assert that the page title is correct
		String expectedTitle = "Example Domain";
		String actualTitle = driver.getTitle();
		// Hard assertion to check page title
		Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");


		//2. assertNotEquals(expected, actual): Verifies that the expected value is not equal to the actual value.
		// Hard assertion to ensure the user is not redirected to the login page
		String expectedURL = "https://www.example.com/login";
		String actualURL = driver.getCurrentUrl();
		Assert.assertNotEquals(actualURL, expectedURL, "User is redirected to the login page!");

		//3. assertTrue(condition): Verifies that the condition is true.
		// Hard assertion to check if a button is displayed
		boolean isButtonVisible = driver.findElement(By.id("login-button")).isDisplayed();
		Assert.assertTrue(isButtonVisible, "Login button is not visible.");

		//4.assertFalse(condition): Verifies that the condition is false.
		// Hard assertion to check if error message is not displayed
		boolean isErrorMessageVisible = driver.findElement(By.id("error-message")).isDisplayed();
		Assert.assertFalse(isErrorMessageVisible, "Error message should not be visible.");

		//5.assertNull(object): Verifies that the object is null.
		// Hard assertion to check if an element is not present
		WebElement nonExistentElement = driver.findElement(By.id("non-existent-element"));
		Assert.assertNull(nonExistentElement, "Element should not exist.");

		//6.assertNotNull(object): Verifies that the object is not null.
		// Hard assertion to check if the element is present
		WebElement loginButton = driver.findElement(By.id("login-button"));
		Assert.assertNotNull(loginButton, "Login button is not found!");

		//Soft assertions do not stop the test execution immediately if a failure occurs. 
		//They allow you to continue testing and collect all the assertion failures, which are reported later at the end of the test.	    
		// Create a SoftAssert object for verifying non-critical checks
		SoftAssert softAssert = new SoftAssert();

		// Soft assertion to check page title
		softAssert.assertEquals(driver.getTitle(), "Login - Example", "Page title is incorrect.");

		// Soft assertion to check if the login button is visible
		softAssert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed(), "Login button is not visible.");

		// Soft assertion to check if the login form exists
		softAssert.assertNotNull(driver.findElement(By.id("login-form")), "Login form is missing.");

		// Assert all soft assertions at the end
		softAssert.assertAll();
		// Verify if the login form is displayed
		boolean isFormDisplayed = driver.findElement(By.id("login-form")).isDisplayed();
		softAssert.assertTrue(isFormDisplayed, "Login form is not visible.");

		// Verify the presence of a specific button
		boolean isLoginButtonPresent = driver.findElement(By.id("login-button")).isDisplayed();
		softAssert.assertTrue(isLoginButtonPresent, "Login button is not visible.");

		// Call assertAll() to check the verify assertions
		softAssert.assertAll();


	}

}
