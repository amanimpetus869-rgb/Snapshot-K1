package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverManager {

	private static WebDriver driver;

	private DriverManager() {
	}

	public static WebDriver getDriver() {

		String driverPath = System.getProperty("user.dir")
		        + "\\drivers\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}