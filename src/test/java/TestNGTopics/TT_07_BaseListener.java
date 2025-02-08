package TestNGTopics;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Listeners;

	@Listeners(TT_07_Listeners.class)
	public class TT_07_BaseListener {
	    public WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    @AfterClass
	    public void teardown() {
	        driver.quit();
	    }
	}
	
	

