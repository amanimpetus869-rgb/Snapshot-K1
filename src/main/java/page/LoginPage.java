package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
import utils.ConfigReader;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	String persona = ConfigReader.getConfigProperty("persona");
//	String username = ConfigReader.getCredential("admin.username");
//	String password = ConfigReader.getCredential("admin.password");

	@FindBy(id = "login-username")
	private WebElement txtUsername;

	@FindBy(id = "login-password")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[@Type='submit']")
	private WebElement signInBtn;

	public OperatorProfilePage login() {

		wait.waitForVisibility(txtUsername).sendKeys(ConfigReader.getCredential("admin.username"));
		wait.waitForVisibility(txtPassword).sendKeys(ConfigReader.getCredential("admin.password"));

		click(signInBtn);
		return new OperatorProfilePage(driver);

	}

	public HomePage login(String user) {

		wait.waitForVisibility(txtUsername).sendKeys(ConfigReader.getCredential("analyst.username"));
		wait.waitForVisibility(txtPassword).sendKeys(ConfigReader.getCredential("analyst.password"));
		click(signInBtn);
//		wait.waitForClickable(By.xpath("//div[contains(text(),'" + user + "')]"));
//		WebElement loginUser = driver.findElement(By.xpath("//div[contains(text(),'" + user + "')]"));
//		click(loginUser);
		return new HomePage(driver);

	}

	public HomePage loginWithPersona(String persona) {

		wait.waitForVisibility(txtUsername).sendKeys(ConfigReader.getCredential("admin.username"));
		wait.waitForVisibility(txtPassword).sendKeys(ConfigReader.getCredential("admin.password"));

		click(signInBtn);

		wait.waitForClickable(By.xpath("//div[contains(text(),'" + persona + "')]"));
		WebElement loginUser = driver.findElement(By.xpath("//div[contains(text(),'" + persona + "')]"));
		click(loginUser);
		return new HomePage(driver);

	}

}