package SeleniumTopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_016_HandleBrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com");  // Replace with the actual URL you want to test

        // Check anchor links (<a>)
        checkLinks(driver, "a");

        // Check image links (<img>)
        checkLinks(driver, "img");

        // Check script links (<script>)
        checkLinks(driver, "script");

        // Close the browser
        driver.quit();
    }

    // Method to check all links of a given tag
    public static void checkLinks(WebDriver driver, String tagName) {
        // Fetch all elements by tagName (e.g., "a", "img", "script")
        List<WebElement> elements = driver.findElements(By.tagName(tagName));

        // Iterate through each element and extract the href or src attribute
        for (WebElement element : elements) {
            String url = element.getAttribute("href") != null ? element.getAttribute("href") : element.getAttribute("src");
            
            // Check if the URL is not null or empty
            if (url != null && !url.isEmpty()) {
                checkLink(url);
            }
        }
    }

    // Method to check the link status using HTTP connection
    public static void checkLink(String linkUrl) {
        try {
            // Create a HttpURLConnection object to get the status of the link
            HttpURLConnection connection = (HttpURLConnection) new URL(linkUrl).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            
            // Get the HTTP status code
            int responseCode = connection.getResponseCode();
            if (responseCode >= 400) {
                System.out.println("Broken link: " + linkUrl + " | Response Code: " + responseCode);
            } else {
                System.out.println("Valid link: " + linkUrl + " | Response Code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Error checking link: " + linkUrl + " | Exception: " + e.getMessage());
        }
    }
}