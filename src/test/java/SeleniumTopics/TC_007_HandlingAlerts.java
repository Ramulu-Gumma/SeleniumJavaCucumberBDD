package SeleniumTopics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_007_HandlingAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver; 
		driver = new ChromeDriver();
		driver.get("https://www.example.com");  // Replace with the actual URL

		// Trigger the alert (e.g., by clicking a button)
		driver.findElement(By.id("simpleAlertButton")).click();

		// Switch to the alert
		Alert alert = driver.switchTo().alert();

		// Get the alert text
		String alertText = alert.getText();
		System.out.println("Alert Text: " + alertText);

		// Enter text into the prompt field
		alert.sendKeys("Test User");
		// Accept the alert (click "OK")
		alert.accept();
		// Get the alert text and accept it
		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
		// Or click "Cancel" to dismiss the alert
		alert.dismiss();
		
		 // Trigger the first alert
        driver.findElement(By.id("firstAlertButton")).click();
        Alert firstAlert = driver.switchTo().alert();
        System.out.println("First Alert Text: " + firstAlert.getText());
        firstAlert.accept();

        // Trigger the second alert
        driver.findElement(By.id("secondAlertButton")).click();
        Alert secondAlert = driver.switchTo().alert();
        System.out.println("Second Alert Text: " + secondAlert.getText());
        secondAlert.accept();

	}

}
