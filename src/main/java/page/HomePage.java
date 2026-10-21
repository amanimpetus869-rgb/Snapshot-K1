package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='nav-avatar-menu-role']")
	private WebElement loggedInUser;
	
	@FindBy(xpath="//span[text()='Snapshots']")
	WebElement snapshots;
	
	@FindBy(xpath="//span[text()='Command Center']")
	WebElement commandCenter;
	
	@FindBy(xpath="//span[text()='Impacted Assets']")
	WebElement impactedAssets;
	
	@FindBy(xpath="//span[text()='Events']")
	WebElement events;
	
	@FindBy(xpath="//span[text()='Hosts']")
	WebElement hosts;
	
	@FindBy(xpath="//span[text()='Signatures']")
	WebElement signatures;
	
	@FindBy(xpath="//span[text()='Dashboards']")
	WebElement dashboards;
	
	@FindBy(xpath="//span[text()='YARA Insights']")
	WebElement yaraInsights;
	
	@FindBy(xpath="//span[text()='Source Management']")
	WebElement sourceManagement;
	
	@FindBy(xpath="//span[text()='YARA Management']")
	WebElement yaraManagement;
	
	@FindBy(xpath="//span[text()='System Management']")
	WebElement systemManagement;
	
	@FindBy(xpath="//div[@class='page-title']")
	WebElement pageTitle;
	
	@FindBy(xpath="//div[@title='Account menu']")
	WebElement accountMenu;

	public String getLoggedInUser() throws InterruptedException {
//		wait.waitForVisibility(loggedInUser);
//		String loggedUser = loggedInUser.getText().toLowerCase();
//		return loggedUser;
		
		wait.waitForVisibility(accountMenu);
		click(accountMenu);
		String loggedUser = loggedInUser.getText().toLowerCase();
		return loggedUser;
	}

	public void clickSnapshots() {
		wait.waitForClickable(snapshots);
		click(snapshots);
	}
	
	public void clickCommandCenter() {
		wait.waitForClickable(commandCenter);
		click(commandCenter);
	}
	
	public void clickImpactedAssets() {
		wait.waitForClickable(impactedAssets);
		click(impactedAssets);
	}
	
	public void clickEvents() {
		wait.waitForClickable(events);
		click(events);
	}
	
	public void clickHosts() {
		wait.waitForClickable(hosts);
		click(hosts);
	}
	
	public void clickSignatures() {
		wait.waitForClickable(signatures);
		click(signatures);
	}
	
	public void clickDashboards() {
		wait.waitForClickable(dashboards);
		click(dashboards);
	}
	
	public void clickYaraInsights() {
		wait.waitForClickable(yaraInsights);
		click(yaraInsights);
	}
	
	public void clickSourceManagement() {
		wait.waitForClickable(sourceManagement);
		click(sourceManagement);
	}
	
	public void clickYaraManagement() {
		wait.waitForClickable(yaraManagement);
		click(yaraManagement);
	}
	
	public void clickSystemManagement() {
		wait.waitForClickable(systemManagement);
		click(systemManagement);
	}
	
	public String getPageTitle() {
		wait.waitForVisibility(pageTitle);
		return pageTitle.getText();
	}
	
	public boolean isMenuPresent(String menuName) {
		
		wait.waitForVisibility(By.xpath("//span[text()='"+menuName+"']"));
		WebElement menu = driver.findElement(By.xpath("//span[text()='"+menuName+"']"));
		return menu.isDisplayed();
		
	}
	
	public List<String> getMenus() {

		List<String> menus = new ArrayList<>();
		wait.waitForVisibility(By.xpath("//div[contains(@class,'side-item')]/span"));
		List<WebElement> menuElements = driver.findElements(By.xpath("//div[contains(@class,'side-item')]/span"));

		for (WebElement menu : menuElements) {
			menus.add(menu.getText().trim());
		}
 
		return menus;
	}
	
}
