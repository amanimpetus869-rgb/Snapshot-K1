package CT.Snapshot_K1;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import page.SourceManagementPage;
import utils.ExcelUtil;
import utils.LoggerUtil;

public class SourceManagementTest extends BaseTest {

	private static final Logger log = LoggerUtil.getLogger(RoleAccessTest.class);

	@Test
	public void verifySourcesDisplayedOnUIMatchExcelData() {

		log.info(">>>> Verifying all sources displayed on Source Management UI are present in the Excel test data <<<<");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithPersona("Administrator");

		ExcelUtil excelUtil = new ExcelUtil("src/test/resources/TestData.xlsx", "Sources");
		List<String> excelSources = excelUtil.getColumnData(0);
//		System.out.println(excelSources);

		SourceManagementPage sourceManagementPage = new SourceManagementPage(driver);
		List<String> UISources = sourceManagementPage.getSources();
//		System.out.println(UISources);

		List<String> missingSourcesFromExcel = new ArrayList<>(UISources);
		missingSourcesFromExcel.removeAll(excelSources);
		
		System.out.println(excelSources.containsAll(UISources));

//		Assert.assertEquals(actualSources, expectedSources);
//		Assert.assertTrue(excelSources.containsAll(UISources), "Sources present on UI but not displayed in Excel: "
//				    + missingSourcesFromExcel);
		Assert.assertTrue(excelSources.containsAll(UISources), "Sources present on UI but not displayed in Excel: "
			    + missingSourcesFromExcel);
	}


	@Test
	public void verifySourcesDisplayedInExcelMatchUISources() {
		log.info(">>>> Verifying all sources defined in Excel are displayed on the Source Management UI <<<<");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithPersona("Administrator");

		ExcelUtil excelUtil = new ExcelUtil("src/test/resources/TestData.xlsx", "Sources");
		List<String> excelSources = excelUtil.getColumnData(0);

		SourceManagementPage sourceManagementPage = new SourceManagementPage(driver);
		List<String> UISources = sourceManagementPage.getSources();
		
		List<String> missingSourcesFromUI = new ArrayList<>(excelSources);
		missingSourcesFromUI.removeAll(UISources);
		
		Assert.assertTrue(UISources.containsAll(excelSources), "<<<<< Sources present in Excel but not displayed on UI: "
			    + missingSourcesFromUI);
	}
	
	@Test
	public void verifyAllSourcesAreEnabled() {

		log.info(">>>> Verifying Sources displayed on UI are Enabled <<<<");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithPersona("Administrator");

		SourceManagementPage sourceManagementPage = new SourceManagementPage(driver);
		List<String> disabledSources = sourceManagementPage.getDisabledSources();

		Assert.assertTrue(disabledSources.isEmpty(), "Disabled Sources from UI: " + disabledSources);
//		Assert.assertTrue(disabledSources.isEmpty());
	}
	
}
