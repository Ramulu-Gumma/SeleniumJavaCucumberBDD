package JavaTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JT_011_Constructor {
	//Real-Time Example: Using Methods and Constructors in a Selenium Test
	//Let’s combine methods and constructors in a real-world Selenium test case, where we have a class that represents a login page. 
	//The constructor will initialize the elements (username, password, and login button), and a method will perform the login action.
	
	
	WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;

    // Constructor: Initialize WebDriver and elements
    public JT_011_Constructor(WebDriver driver) {
        this.driver = driver;
        this.usernameField = driver.findElement(By.id("username"));
        this.passwordField = driver.findElement(By.id("password"));
        this.loginButton = driver.findElement(By.id("login"));
    }

    // Method: Perform login action
    public void login(String username, String password) {
        usernameField.sendKeys(username);  // Set username
        passwordField.sendKeys(password);  // Set password
        loginButton.click();               // Click login button
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");

        // Create an instance of LoginPage
        JT_011_Constructor loginPage = new JT_011_Constructor(driver);

        // Perform login using the login method
        loginPage.login("testuser", "password123");

        driver.quit();  // Close the browser

	}

}
