package SeleniumTopics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_011_HandlingWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver; 
		driver = new ChromeDriver();
		driver.get("https://www.example.com"); 

		//1: Handling Multiple Windows
		// Find and click the link to open a new window
		driver.findElement(By.linkText("Visit W3Schools.com")).click();
		// Get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		// Create an iterator to traverse through the window handles
		Iterator<String> iterator = windowHandles.iterator();
		// Get the main window handle
		String mainWindow = iterator.next(); 
		// Get the second window handle (popup or new tab)
		String newWindow = iterator.next();
		// Switch to the new window (popup)
		driver.switchTo().window(newWindow);
		// Perform actions on the new window (e.g., get the title of the new window)
		System.out.println("Title of the new window: " + driver.getTitle());
		// Close the new window
		driver.close();
		// Switch back to the main window
		driver.switchTo().window(mainWindow);        
		// Perform actions on the main window (e.g., get the title of the main window)
		System.out.println("Title of the main window: " + driver.getTitle());


		//2: Handling Multiple Windows with Dynamic Window Handles
		// Click on a link that opens a new window (Modify this part based on your use case)
		driver.findElement(By.linkText("Job Categories")).click();

		// Get all window handles
		Set<String> windowHand = driver.getWindowHandles();

		// Iterate through all window handles
		Iterator<String> itera = windowHand.iterator();

		// Iterate over all windows
		while (itera.hasNext()) {
			String handle = itera.next();
			driver.switchTo().window(handle);

			// Check the title of each window
			System.out.println("Title of the current window: " + driver.getTitle());
		}

		//3: Switch Between Parent and Child Windows
		// Click on a link that opens in a new window
		driver.findElement(By.linkText("Getting Started")).click();

		// Get the parent window handle
		String parentWindow = driver.getWindowHandle();

		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Switch to the child window
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				break;  // Switch to the first child window
			}
		}
		// Perform actions in the child window (e.g., getting the title)
		System.out.println("Child Window Title: " + driver.getTitle());
		 // Close the child window
        driver.close();
        // Switch back to the parent window
        driver.switchTo().window(parentWindow);
        // Perform actions in the parent window (e.g., getting the title)
        System.out.println("Parent Window Title: " + driver.getTitle());
        
     // Suppose there is a button or link to open new windows/tabs
        for (int i = 0; i < 10; i++) {
            // Locate the link or button that opens a new window and click on it
            driver.findElement(By.xpath("//button[@id='openWindow" + i + "']")).click();  // Example XPath, update based on actual page
            Thread.sleep(1000);  // Adding some delay to simulate waiting for new windows to open
        }
        
        
//Handling 10 Windows in Selenium
        // Get all window handles
        Set<String> tenwindowHandles = driver.getWindowHandles();

        // Create an iterator to iterate over the window handles
        Iterator<String> iterat = tenwindowHandles.iterator();

        // Switch between windows
        int windowCount = 1;
        while (iterat.hasNext()) {
            // Get the next window handle
            String windowHandle = iterat.next();
            driver.switchTo().window(windowHandle);
            
            // Perform actions on each window
            System.out.println("Switching to Window " + windowCount);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            // You can perform actions on the window, for example:
            // driver.findElement(By.id("someElement")).click();  // Example action

            // Close the current window after actions are done
            driver.close();

            windowCount++;
        }

        // Switch back to the original window (if needed)
        driver.switchTo().window(windowHandles.iterator().next());
        System.out.println("Back to original window with URL: " + driver.getCurrentUrl());

        // Close the original window
        driver.quit();


	}

}
