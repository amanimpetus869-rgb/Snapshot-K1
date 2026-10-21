package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class OperatorProfilePage extends BasePage{

	public OperatorProfilePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[text()='Administrator']")
	private WebElement adminOperator;
	
	@FindBy(xpath="//div[text()='Field Auditor']")
	private WebElement auditorOperator;
	
	public boolean isAdminOperatorProfileDisplayed() {
		wait.waitForVisibility(adminOperator);
		return adminOperator.isDisplayed();
	}
	
	public boolean isAuditorOperatorProfileDisplayed() {
		wait.waitForVisibility(auditorOperator);
		return auditorOperator.isDisplayed();
	}
}
