package CT.Snapshot_K1;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.HomePage;
import page.LoginPage;
import page.OperatorProfilePage;
import utils.ConfigReader;
import utils.LoggerUtil;

public class LoginTest extends BaseTest {

	private static final Logger log = LoggerUtil.getLogger(LoginTest.class);
	

	@Test
	public void loginWithAdminUser() throws InterruptedException {

		log.info(">>>>Starting login validation with valid Admin credentials<<<<");
		
		LoginPage loginPage = new LoginPage(driver);
		OperatorProfilePage operatorPage = loginPage.login();
		operatorPage.isAuditorOperatorProfileDisplayed();
		operatorPage.isAdminOperatorProfileDisplayed();
		log.info("TEST PASSED- Login Successful with User- ADMIN");
		Thread.sleep(1000);
	}
	
	@Test
	public void loginWithAdminUserAdministratorPersona() throws InterruptedException {

		log.info(">>>>Starting login validation with valid credentials for Admin user and Administrator persona <<<<");
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginWithPersona("Administrator");
		Thread.sleep(1000);
		String actualPersona = homePage.getLoggedInUser();
		log.info("Login Successful with Admin user and Administrator persona");
		String expectedPersona = "admin";
		Assert.assertEquals(
				expectedPersona.toLowerCase(), 
				actualPersona.toLowerCase(), 
				"Displaying incorrect persona :");
		log.info("TEST PASSED- login validation with valid credentials for Admin user and Administrator persona");
	}
	
	@Test
	public void loginWithAdminUserAuditorPersona() throws InterruptedException {

		log.info(">>>>Starting login validation with valid credentials for Admin user and Auditor persona<<<<");
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginWithPersona("Field Auditor");
		String actualPersona = homePage.getLoggedInUser();
		log.info("Login Successful with Admin user and Field Auditor persona");
		String expectedPersona = "Expert";
		Assert.assertEquals(expectedPersona.toLowerCase(), actualPersona.toLowerCase());
		log.info("TEST PASSED- login validation with valid credentials for Admin user and Auditor persona");
		Thread.sleep(1000);
	}	
	
	@Test
	public void loginWithAnalystUser() throws InterruptedException {

		log.info(">>>>Starting login validation with valid Analyst credentials <<<<");
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("analyst");
		
		String actualUser = homePage.getLoggedInUser();
		log.info("Login Successful with User-" + actualUser);
		String expectedUser = "analyst";
		Assert.assertEquals(expectedUser, actualUser.toLowerCase());
		log.info("TEST PASSED- login validation with valid Analyst credentials");
		Thread.sleep(1000);
	}
	
	public void loginWithIncorrectUsername() throws InterruptedException {

		log.info(">>>> STARTING LOGIN VALIDATION WITH INCORRECT USERNAME <<<<");
		
//		LoginPage loginPage = new LoginPage(driver);
//		HomePage homePage= loginPage.login();
//		String actualUser = homePage.getLoggedInUser();
//		log.info("Login Successful with User-" + actualUser);
//		String expectedUser = ConfigReader.getProperty("persona").toLowerCase();
//		Assert.assertEquals(expectedUser, actualUser);
	}
}
