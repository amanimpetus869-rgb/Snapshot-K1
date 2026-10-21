package CT.Snapshot_K1;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.CommandCenterPage;
import page.HomePage;
import page.LoginPage;
import page.SnapshotsPage;
import utils.ConfigReader;
import utils.LoggerUtil;

public class SnapshotsTest extends BaseTest{
	
	private static final Logger log = LoggerUtil.getLogger(RoleAccessTest.class);

	@Test(groups= {"smoke"})
	public void verifyViewSnapshotInCommandCenter() throws InterruptedException {
		log.info("Viewing Provided Snapshot In Command Center");

		LoginPage loginPage = new LoginPage(driver);
		HomePage homepage = loginPage.loginWithPersona("Administrator");
		log.info("Login Successfull");
		
		homepage.clickSnapshots();
		log.info("Navigated to Snapshots page");
		
		SnapshotsPage snapshotsPage = new SnapshotsPage(driver);
		snapshotsPage.searchSnapshot();
//		Thread.sleep(2000);
		snapshotsPage.openSnapshotInCommandCenter();
		log.info("Provided Snapshot is viewed In Command Center");
		
		CommandCenterPage commandCenterPage= new CommandCenterPage(driver);
		String activeSnapshot = commandCenterPage.getActiveSnapshotName();
		log.info("Active snapshot name from command center is-"+ activeSnapshot);
		Assert.assertEquals(activeSnapshot, ConfigReader.getConfigProperty("snapshotname"));
		log.info("Snapshot name from config file is-"+ ConfigReader.getConfigProperty("snapshotname"));
		
		log.info("Test PASSED- Snapshot names matched");
		Thread.sleep(2000);
	}
	
	@Test
	public void verifySnapshotStartDate() {
		log.info(">>>>> Viewing given Snapshot In Command Center and verifying its Start Date from Snapshots page <<<<<");
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homepage = loginPage.loginWithPersona("Administrator");
		log.info("Login Successfull");
		
		homepage.clickSnapshots();
		log.info("Navigated to Snapshots page");
		
		SnapshotsPage snapshotsPage = new SnapshotsPage(driver);
		
		String firstPacketTime = snapshotsPage.getFirstPacketTime();
		System.out.println("firstPacketTime"+firstPacketTime);
		
		snapshotsPage.openSnapshotInCommandCenter();
		log.info("Provided Snapshot is viewed In Command Center");
		
		CommandCenterPage commandCenterPage= new CommandCenterPage(driver);
		String activeSnapshotStartTime = commandCenterPage.getActiveSnapshotStartDate();
		System.out.println("activeSnapshotStartTime"+activeSnapshotStartTime);
	}
}
