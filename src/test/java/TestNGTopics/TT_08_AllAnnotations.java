package TestNGTopics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

public class TT_08_AllAnnotations {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Initializing Test Suite...");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.example.com");
    }

    @Test(priority = 1, groups = "smoke")
    public void loginTest() {
        driver.findElement(By.id("username")).sendKeys("validUser");
        driver.findElement(By.id("password")).sendKeys("validPass");
        driver.findElement(By.id("loginButton")).click();
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void addItemToCartTest() {
        driver.findElement(By.id("addToCartButton")).click();
        Assert.assertTrue(driver.findElement(By.id("cart")).getText().contains("Item"));
    }

    @Test(dataProvider = "searchData")
    public void searchTest(String searchKeyword) {
        driver.findElement(By.id("searchBox")).sendKeys(searchKeyword);
        driver.findElement(By.id("searchButton")).click();
        Assert.assertTrue(driver.getTitle().contains(searchKeyword));
    }

    @DataProvider(name = "searchData")
    public Object[][] provideSearchData() {
        return new Object[][] {
            {"Laptop"},
            {"Mobile"}
        };
    }

    @AfterMethod
    public void afterMethod() {
        driver.findElement(By.id("logoutButton")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Cleaning up after tests...");
    }
}


