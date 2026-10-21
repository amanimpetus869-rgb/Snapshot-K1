package CT.Snapshot_K1;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.HomePage;
import page.LoginPage;
import utils.ExcelUtil;
import utils.LoggerUtil;

public class RoleAccessTest extends BaseTest {

	private static final Logger log = LoggerUtil.getLogger(RoleAccessTest.class);

	@Test(groups = { "administrator" })
	public void verifyAdministratorPersonaMenuAccess() throws InterruptedException {
		log.info(">>>>> Starting Administrator Persona Menu Access Validation <<<<<");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginWithPersona("Administrator");
		log.info("Login Successfull");

		List<String> actualMenus = homePage.getMenus();
//		System.out.println("actualMenus"+actualMenus);

		ExcelUtil excelUtil = new ExcelUtil("src/test/resources/TestData.xlsx", "MenuAccess");
		List<String> expectedMenus = excelUtil.getMenusByRole("Administrator");
//		System.out.println("expectedMenus"+expectedMenus);

		Assert.assertEquals(actualMenus, expectedMenus, "Displayed menus do not match expected menus from Excel");

		log.info(">>>>> TEST PASSED- Administrator Menu Access Validation Completed <<<<<");
		Thread.sleep(1000);

//		Assert.assertTrue(homepage.isMenuPresent("Snapshots"));
//		log.info("Snapshots menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Command Center"));
//		log.info("Command Center menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Impacted Assets"));
//		log.info("Impacted Assets menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Events"));
//		log.info("Events menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Hosts"));
//		log.info("Hosts menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Signatures"));
//		log.info("Signatures menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Dashboards"));
//		log.info("Dashboards menu present");
//		Assert.assertTrue(homepage.isMenuPresent("YARA Insights"));
//		log.info("YARA Insights menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Source Management"));
//		log.info("Source Management menu present");
//		Assert.assertTrue(homepage.isMenuPresent("YARA Management"));
//		log.info("YARA Management menu present");
//		Assert.assertTrue(homepage.isMenuPresent("System Management"));
//		log.info("System Management menu present");

	}

	@Test(groups = { "auditor" })
	public void verifyAuditorPersonaMenuAccess() {
		log.info(">>>>> Starting Auditor Persona Menu Access Validation <<<<<");

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginWithPersona("Auditor");
		log.info("Login Successfull");

		List<String> actualMenus = homePage.getMenus();
		System.out.println("actualMenus" + actualMenus);

		ExcelUtil excelUtil = new ExcelUtil("src/test/resources/TestData.xlsx", "MenuAccess");
		List<String> expectedMenus = excelUtil.getMenusByRole("Auditor");
		System.out.println("expectedMenus" + expectedMenus);
		
		Assert.assertEquals(actualMenus, expectedMenus, "Displayed menus do not match expected menus from Excel");

//		Assert.assertTrue(homepage.isMenuPresent("Snapshots"));
//		log.info("Snapshots menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Command Center"));
//		log.info("Command Center menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Impacted Assets"));
//		log.info("Impacted Assets menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Events"));
//		log.info("Events menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Hosts"));
//		log.info("Hosts menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Signatures"));
//		log.info("Signatures menu present");
//		Assert.assertTrue(homepage.isMenuPresent("Dashboards"));
//		log.info("Dashboards menu present");
//		Assert.assertTrue(homepage.isMenuPresent("YARA Insights"));
//		log.info("YARA Insights menu present");
		log.info("Auditor Menu Validation Completed");
	}

	@Test
	public void verifyAnalystUserMenuAccess() {
		log.info(">>>>> Starting Analyst User Menu Access Validation <<<<<");

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("Analyst");
		log.info("Login Successfull");
		
		List<String> actualMenus = homePage.getMenus();
		System.out.println("actualMenus" + actualMenus);

		ExcelUtil excelUtil = new ExcelUtil("src/test/resources/TestData.xlsx", "MenuAccess");
		List<String> expectedMenus = excelUtil.getMenusByRole("Analyst");
		System.out.println("expectedMenus" + expectedMenus);

		Assert.assertEquals(actualMenus, expectedMenus, "Displayed menus do not match expected menus from Excel");
	}
}
