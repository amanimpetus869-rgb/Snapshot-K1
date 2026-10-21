package CT.Snapshot_K1;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.HomePage;
import page.LoginPage;
import utils.LoggerUtil;

public class NavigationTest extends BaseTest {

	private static final Logger log = LoggerUtil.getLogger(NavigationTest.class);

	@Test(groups={"auditor"})
	public void verifyAdminUserFieldAuditorPersonaMenuNavigation() throws InterruptedException {

		log.info("Starting 'Admin' User and 'Field Auditor' Persona's Menu Navigation Validation");

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginWithPersona("Field Auditor");
		log.info("Login Successful with 'Admin' user and 'Field Auditor' persona");

		homePage.clickSnapshots();
		Assert.assertEquals(homePage.getPageTitle(), "Snapshots");
		log.info("Navigated to Snapshots page");

		homePage.clickCommandCenter();
		Assert.assertEquals(homePage.getPageTitle(), "Command Center");
		log.info("Navigated to Command Center page");

		homePage.clickImpactedAssets();
		Assert.assertEquals(homePage.getPageTitle(), "Impacted Assets");
		log.info("Navigated to Impacted Assets page");

		homePage.clickEvents();
		Assert.assertEquals(homePage.getPageTitle(), "Events");
		log.info("Navigated to Events page");

		homePage.clickHosts();
		Assert.assertEquals(homePage.getPageTitle(), "Hosts");
		log.info("Navigated to Hosts page");

		homePage.clickSignatures();
		Assert.assertEquals(homePage.getPageTitle(), "Signatures");
		log.info("Navigated to Signatures page");

		homePage.clickDashboards();
		Assert.assertEquals(homePage.getPageTitle(), "Dashboards");
		log.info("Navigated to Dashboards page");

		homePage.clickYaraInsights();
		Assert.assertEquals(homePage.getPageTitle(), "YARA Insights");
		log.info("Navigated to YARA Insights page");

		Thread.sleep(1000);
		log.info("TEST PASSED- 'Admin' User and 'Field Auditor' Persona's Menu Navigation Validation");
	}

	@Test(groups={"administrator"})
	public void verifyAdminUserAdministratorPersonaMenuNavigation() throws InterruptedException {

		log.info("Starting 'Admin' User and 'Administrator' Persona's Menu Navigation Validation");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = loginpage.loginWithPersona("Administrator");
		log.info("Login Successful with 'Admin' user and 'Administrator' persona");
		
		Thread.sleep(1000);

		homepage.clickSnapshots();
		Assert.assertEquals(homepage.getPageTitle(), "Snapshots");
		log.info("Navigated to Snapshots page");

		homepage.clickCommandCenter();
		Assert.assertEquals(homepage.getPageTitle(), "Command Center");
		log.info("Navigated to Command Center page");

		homepage.clickImpactedAssets();
		Assert.assertEquals(homepage.getPageTitle(), "Impacted Assets");
		log.info("Navigated to Impacted Assets page");

		homepage.clickEvents();
		Assert.assertEquals(homepage.getPageTitle(), "Events");
		log.info("Navigated to Events page");

		homepage.clickHosts();
		Assert.assertEquals(homepage.getPageTitle(), "Hosts");
		log.info("Navigated to Hosts page");

		homepage.clickSignatures();
		Assert.assertEquals(homepage.getPageTitle(), "Signatures");
		log.info("Navigated to Signatures page");

		homepage.clickDashboards();
		Assert.assertEquals(homepage.getPageTitle(), "Dashboards");
		log.info("Navigated to Dashboards page");

		homepage.clickYaraInsights();
		Assert.assertEquals(homepage.getPageTitle(), "YARA Insights");
		log.info("Navigated to YARA Insights page");
		
		homepage.clickSourceManagement();
		Assert.assertEquals(homepage.getPageTitle(), "Source Management", "Source Management page navigation failed");
		log.info("Navigated to Source Management page");
		
		homepage.clickYaraManagement();
		Assert.assertEquals(homepage.getPageTitle(), "YARA Management");
		log.info("Navigated to YARA Management page");
		
		homepage.clickSystemManagement();
		Assert.assertEquals(homepage.getPageTitle(), "System Management");
		log.info("Navigated to System Management page");

		Thread.sleep(1000);
		log.info("TEST PASSED- 'Admin' User and 'Administrator' Persona's Menu Navigation Validation");
//		System.out.println(driver.getTitle());
	}
	
	@Test
	public void verifyAnalystUserMenuNavigation() throws InterruptedException {

		log.info("Starting 'Analyst' User Menu Navigation Validation");

		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = loginpage.login("Analyst");
		log.info("Login Successful with 'Analyst' user");
		
		Thread.sleep(1000);

		homepage.clickSnapshots();
		Assert.assertEquals(homepage.getPageTitle(), "Snapshots");
		log.info("Navigated to Snapshots page");

		homepage.clickCommandCenter();
		Assert.assertEquals(homepage.getPageTitle(), "Command Center");
		log.info("Navigated to Command Center page");

		homepage.clickImpactedAssets();
		Assert.assertEquals(homepage.getPageTitle(), "Impacted Assets");
		log.info("Navigated to Impacted Assets page");

		homepage.clickEvents();
		Assert.assertEquals(homepage.getPageTitle(), "Events");
		log.info("Navigated to Events page");

		homepage.clickHosts();
		Assert.assertEquals(homepage.getPageTitle(), "Hosts");
		log.info("Navigated to Hosts page");

		homepage.clickSignatures();
		Assert.assertEquals(homepage.getPageTitle(), "Signatures");
		log.info("Navigated to Signatures page");

		homepage.clickDashboards();
		Assert.assertEquals(homepage.getPageTitle(), "Dashboards");
		log.info("Navigated to Dashboards page");

		Thread.sleep(1000);
		log.info("TEST PASSED- Analyst' User Menu Navigation Validation");
//		System.out.println(driver.getTitle());
	}
}
