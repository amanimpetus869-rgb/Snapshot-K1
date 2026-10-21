package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CommandCenterPage extends BasePage{

	public CommandCenterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[text()='Active Snapshot']/following-sibling::div")
	private WebElement activeSnapshotName;
	
	@FindBy(xpath = "//div[contains(text(),'Start Date')]/following-sibling::div")
	private WebElement activeSnapshotStartDate;
	
	@FindBy(xpath = "//div[contains(text(),'End Date')]/following-sibling::div")
	private WebElement activeSnapshotEndDate;
	
	public String getActiveSnapshotName() {
		wait.waitForVisibility(activeSnapshotName);
		String activeSnapshot = activeSnapshotName.getText();
		return activeSnapshot;
	}
	
	public String getActiveSnapshotStartDate() {
		wait.waitForVisibility(activeSnapshotStartDate);
		return activeSnapshotStartDate.getText();
	}
}
