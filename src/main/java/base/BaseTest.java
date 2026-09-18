package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseTest 
{
	 protected WebDriver driver;

	    @BeforeMethod
	    public void setUp() {

	        ConfigReader config = new ConfigReader();
	        String browser = config.getProperty("browser");
	        
	        if (browser.equalsIgnoreCase("chrome")) 
	         {
	            driver = new ChromeDriver();

	        }  else if (browser.equalsIgnoreCase("edge")) 
	        {
	            driver = new EdgeDriver();
	        }

	        driver.manage().window().maximize();

	        driver.get(config.getProperty("url"));
	    }

	    @AfterMethod
	    public void tearDown() {

	        driver.quit();
	    }
}

