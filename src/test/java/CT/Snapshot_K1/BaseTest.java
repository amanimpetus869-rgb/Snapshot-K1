package CT.Snapshot_K1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.DriverManager;
import utils.ConfigReader;
import utils.ExcelUtil;

public class BaseTest {

	protected WebDriver driver;
//	protected ExcelUtil excelUtil;

	@BeforeMethod
	public void setup() {
		System.out.println(">>>> BASE TEST SETUP STARTED <<<<");
		driver = DriverManager.getDriver();
		driver.get(ConfigReader.getConfigProperty("url"));
//		excelUtil = new ExcelUtil("src/test/resources/TestData.xlsx", "MenuAccess");
		System.out.println(">>>> DRIVER CREATED: " + driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}