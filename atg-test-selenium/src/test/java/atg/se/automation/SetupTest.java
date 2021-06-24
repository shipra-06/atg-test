package atg.se.automation;

import org.junit.After;


import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class SetupTest implements Constants {
	

	public WebDriver driver;
	
	JavascriptExecutor js;

	@Before
	public void setUp() {
		String driverType = System.getProperty(DRIVER_TYPE);
		
		if(driverType == null || driverType.equalsIgnoreCase(CHROME)) {
			WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
			driver = new ChromeDriver();
		}
		if(driverType!= null && driverType.equalsIgnoreCase(FIREFOX)) {
			WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			driver = new FirefoxDriver();
		}
		if(driverType!= null && driverType.equalsIgnoreCase(SAFARI)) {
			WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
			driver = new SafariDriver();
		}
		js = (JavascriptExecutor) driver;
	}

	@After
	public void tearDown() {
		if (null != driver) {
			System.out.println("Closing Browser");
			driver.close();
		}
	}
}
