package SeleniumTopics;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_002_FindAndFindElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();
		
		// Locate the Username field using findElement and enter text
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("myUser");

        // Locate the Password field and enter text
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("myPassword");

        // Locate the login button and click
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        
        // Locate all anchor tags on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        // Iterate through the list and print each link's text
        for (WebElement link : links) {
            System.out.println(link.getText());
        }

	}

}
