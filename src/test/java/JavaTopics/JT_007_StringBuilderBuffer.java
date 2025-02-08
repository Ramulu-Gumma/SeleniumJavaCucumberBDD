package JavaTopics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JT_007_StringBuilderBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. String (Immutable)
        String baseUrl = "https://example.com/";

        // 2. StringBuilder (Mutable, efficient for multiple changes)
        StringBuilder dynamicUrlBuilder = new StringBuilder(baseUrl);
        dynamicUrlBuilder.append("search?q=selenium");
        System.out.println("Dynamic URL: " + dynamicUrlBuilder.toString());

        // 3. StringBuffer (Thread-safe, used in a multi-threaded context)
        StringBuffer safeUrlBuffer = new StringBuffer(baseUrl);
        safeUrlBuffer.append("login?username=admin");
        System.out.println("Safe URL: " + safeUrlBuffer.toString());

        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get(dynamicUrlBuilder.toString());  // Use dynamic URL
        driver.quit();


	}

}
