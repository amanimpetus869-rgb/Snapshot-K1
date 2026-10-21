package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.ConfigReader;

public class SnapshotsPage extends BasePage{

	public SnapshotsPage(WebDriver driver) {
		super(driver);
	}
	
	String snapshotName = ConfigReader.getConfigProperty("snapshotname");
	
//	@Findby(xpath= "")
//	WebElement viewSnapshot;
	
	@FindBy(xpath="//div[@class='search-field']/input")
	WebElement searchSnapshot;
	
	@FindBy(xpath="//tr[@class='recording-row']/td[2]/following-sibling::td[2]")
	WebElement firstPacketTime;
	
	public void openSnapshotInCommandCenter() {
		
		wait.waitForClickable(By.xpath("//tr[td[@title='"+snapshotName+"']]//button[@title='Open in Command Center']"));
		WebElement viewSnapshot = driver.findElement(
				By.xpath("//tr[td[@title='"+snapshotName+"']]//button[@title='Open in Command Center']"));
		click(viewSnapshot);
	}
	
	public void searchSnapshot() {
		wait.waitForVisibility(searchSnapshot);
		searchSnapshot.sendKeys(snapshotName);
	}
	
	public String getFirstPacketTime() {
		wait.waitForVisibility(searchSnapshot);
		searchSnapshot.sendKeys(snapshotName);
		
		wait.waitForVisibility(firstPacketTime);
		return firstPacketTime.getText();
	}
}
