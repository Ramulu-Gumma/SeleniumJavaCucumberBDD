package TestNGTopics;

	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class TT_04_DataProviders {
	    WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    // Define DataProvider
	    @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return new Object[][] {
	            {"user1", "pass123"},  // First set of credentials
	            {"user2", "pass456"},  // Second set of credentials
	            {"user3", "pass789"}   // Third set of credentials
	        };
	    }

	    // Test method using DataProvider
	    @Test(dataProvider = "loginData")
	    public void testLogin(String username, String password) {
	        driver.get("https://example.com/login");

	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.id("loginButton")).click();

	        System.out.println("Login attempted with: " + username + " / " + password);
	    }

	    @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
	}
