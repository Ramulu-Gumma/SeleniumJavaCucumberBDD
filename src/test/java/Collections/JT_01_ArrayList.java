package Collections;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JT_01_ArrayList {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://example.com");
        
        //Key Features of ArrayList
        //✅ Dynamic Sizing – No need to define a fixed size.
        //✅ Fast Retrieval – Uses indexing (O(1) time complexity).
        //✅ Ordered – Maintains insertion order.
        //✅ Allows Duplicates – Stores duplicate values.
        //✅ Not Thread-Safe – Use Vector or synchronizedList() for thread safety.
        //Use Case 1: Storing and Displaying Student Names (Educational System)
        //Use Case 2: Handling Dynamic Web Elements in Selenium
        //ArrayList stores multiple web elements.
        
        // Fetching multiple elements (links in a menu)
        
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Storing text of all links in an ArrayList
        ArrayList<String> linkTexts = new ArrayList<>();
        for (WebElement link : links) {
            linkTexts.add(link.getText());
        }

        // Printing the collected link texts
        System.out.println("Links on the page: " + linkTexts);

        // Closing the browser
        driver.quit();

	}
}
