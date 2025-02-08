package TestNGTopics;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TT_03_Grouping {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(groups = {"smoke", "sanity"})
	public void testLogin() {
		driver.get("https://example.com/login");
		driver.findElement(By.id("username")).sendKeys("testuser");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("loginButton")).click();
		System.out.println("Login test passed.");
	}

	@Test(groups = {"regression"})
	public void testAddToCart() {
		driver.get("https://example.com/product");
		driver.findElement(By.id("addToCart")).click();
		System.out.println("Add to cart test passed.");
	}

	@Test(groups = {"smoke", "regression"})
	public void testCheckout() {
		driver.get("https://example.com/checkout");
		driver.findElement(By.id("checkoutButton")).click();
		System.out.println("Checkout test passed.");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}


