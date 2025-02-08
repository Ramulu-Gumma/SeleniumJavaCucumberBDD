package TestNGTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//BeforeSuite: Start the test environment, initialize any test data or start the server.
//BeforeClass: Open the browser (initialize WebDriver).
//BeforeMethod: Navigate to the homepage of the website.
//Test: Execute individual test cases like logging in, adding items to the cart, or checking out.
//AfterMethod: Log out and clean up session.
//AfterClass: Close the browser.
//AfterSuite: Close the test environment (like stopping the server).
//DataProvider:Use it when you want to run the same test with multiple sets of data (data-driven testing).
//Parameters:Use it when you want to parameterize test data and pass values from the XML configuration file.
//Factory:Use when you need to run tests with different configurations or parameters.
//dependsOnMethods:Use it when the execution of one test depends on the success of another.
//enabled:Use it when you want to disable specific tests temporarily.
//priority:Use when you need to specify the order in which tests should run.
//groups:Use it to organize tests into logical groups (e.g., functional, regression) and execute a specific group.
//timeOut:Use it to ensure that tests complete within a certain time frame, especially for performance tests.

public class TT_01_Annotations {

    WebDriver driver;

    // Before Suite: Executed before the entire test suite begins
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Initializing Test Suite...");
        // Perform initial setup such as starting test server or database connection
    }

    // Before Class: Executed before any test methods in the class
    @BeforeClass
    public void beforeClass() {
        System.out.println("Setting up the WebDriver...");
        // Set up WebDriver for the entire class (e.g., ChromeDriver)
        driver = new ChromeDriver();
    }

    // Before Method: Executed before each individual test method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Opening the website...");
        driver.get("https://www.example.com"); // Navigate to the website before each test
    }

    // Test Method 1: Test for valid login scenario
    @Test(priority = 1, dataProvider = "loginData")
    public void validLoginTest(String username, String password) {
        System.out.println("Running valid login test...");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        Assert.assertTrue(driver.getTitle().contains("Dashboard")); // Assert login success
    }

    // Test Method 2: Test for invalid login scenario
    @Test(priority = 2)
    public void invalidLoginTest() {
        System.out.println("Running invalid login test...");
        driver.findElement(By.id("username")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("invalid_pass");
        driver.findElement(By.id("loginButton")).click();
        Assert.assertTrue(driver.getTitle().contains("Login Failed")); // Assert login failure
    }

    // Test Method 3: Test for forgotten password scenario
    @Test(priority = 3)
    public void forgottenPasswordTest() {
        System.out.println("Running forgotten password test...");
        driver.findElement(By.linkText("Forgot Password?")).click();
        driver.findElement(By.id("email")).sendKeys("user@example.com");
        driver.findElement(By.id("resetButton")).click();
        Assert.assertTrue(driver.getTitle().contains("Password Reset"));
    }

    // After Method: Executed after each individual test method
    @AfterMethod
    public void afterMethod() {
        System.out.println("Logging out...");
        // Code to log out after each test, if necessary
        driver.findElement(By.id("logoutButton")).click();
    }

    // After Class: Executed after all test methods in the class have been executed
    @AfterClass
    public void afterClass() {
        System.out.println("Closing the WebDriver...");
        // Close the browser after all tests in the class have run
        driver.quit();
    }

    // After Suite: Executed after the entire test suite has finished
    @AfterSuite
    public void afterSuite() {
        System.out.println("Cleaning up resources...");
        // Code for cleanup, such as stopping servers or releasing global resources
    }

    // Data Provider: Provide data for valid login tests
    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][] {
            { "valid_user1", "valid_pass1" },
            { "valid_user2", "valid_pass2" }
        };
    }
}

