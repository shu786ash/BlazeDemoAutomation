package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;
import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Base {

    public static WebDriver driver;

    @BeforeMethod
    public void setup() {

        //driver = new ChromeDriver();
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	//options.addArguments("--headless=new");
    	options.addArguments("--no-sandbox");
    	options.addArguments("--disable-dev-shm-usage");

    	driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}