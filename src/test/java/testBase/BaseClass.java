package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.*;

public class BaseClass {

    protected WebDriver driver;
    protected Properties prop;
    protected Logger logg;

    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) throws IOException {

        // Logger init
        logg = LogManager.getLogger(this.getClass());
        logg.info("===== Test Execution Started =====");

        // Load config file
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        String url = prop.getProperty("url");
        int wait = Integer.parseInt(prop.getProperty("implicitWait"));

        logg.info("URL Loaded: " + url);
        logg.info("Browser Selected: " + browser);

        // Browser launch
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            logg.info("Chrome browser launched");
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            logg.info("Edge browser launched");
        } 
        else {
            logg.warn("Invalid browser given. Defaulting to Chrome");
            driver = new ChromeDriver();
        }

        // Common setup
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

        driver.get(url);
        logg.info("Application opened successfully");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            logg.info("Browser closed");
        }

        logg.info("===== Test Execution Finished =====");
    }
}