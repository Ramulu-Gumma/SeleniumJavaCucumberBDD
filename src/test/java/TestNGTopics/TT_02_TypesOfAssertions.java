package TestNGTopics;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TT_02_TypesOfAssertions {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void openApplication() {
        driver.get("https://www.example.com");
    }

    @Test
    public void validLoginTest() {
        driver.findElement(By.id("username")).sendKeys("validUser");
        driver.findElement(By.id("password")).sendKeys("validPass");
        driver.findElement(By.id("loginButton")).click();

        // Assert using assertTrue
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed!");

        // Soft assertion: Verify if login button is not visible after login
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        softAssert.assertNull(loginButton, "Login button is still visible after login");

        // Soft assertion: Verify if the logout button is visible
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        softAssert.assertNotNull(logoutButton, "Logout button is not visible");

        softAssert.assertAll(); // Collect and report all soft assertions
    }

    @Test
    public void invalidLoginTest() {
        driver.findElement(By.id("username")).sendKeys("invalidUser");
        driver.findElement(By.id("password")).sendKeys("invalidPass");
        driver.findElement(By.id("loginButton")).click();

        // Assert that login failed (page title does not contain "Dashboard")
        Assert.assertFalse(driver.getTitle().contains("Dashboard"), "Login succeeded with invalid credentials");

        // Assert the error message
        String actualMessage = driver.findElement(By.id("errorMessage")).getText();
        String expectedMessage = "Invalid username or password.";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch");
    }

    @AfterMethod
    public void logout() {
        driver.findElement(By.id("logoutButton")).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

