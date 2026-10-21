package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SourceManagementPage extends BasePage {

	public SourceManagementPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(xpath="//table[@class='sources-table']/tbody/tr/td[@class='name-cell']/span")
//	WebElement sources;

	public List<String> getSources() {
		wait.waitForVisibility(By.xpath("//table[@class='sources-table']/tbody/tr/td[@class='name-cell']/span"));
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@class='sources-table']/tbody/tr/td[@class='name-cell']/span"));

		List<String> sourceNameList = new ArrayList<>();

		for (WebElement row : rows) {
			String sourceName = row.getText();
			sourceNameList.add(sourceName);
		}
		return sourceNameList;
	}

	public List<String> getDisabledSources() {
		wait.waitForVisibility(By.xpath("//table[@class='sources-table']/tbody/tr"));

		List<String> disabledSources = new ArrayList<>();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='sources-table']/tbody/tr"));

		for (WebElement row : rows) {
			String sourceName = row.findElement(By.xpath("./td[@class='name-cell']/span")).getText();

			String status = row.findElement(By.xpath("./td[@class='action-cell']/button")).getAttribute("aria-checked");

			if(status.equals("false")) {
				disabledSources.add(sourceName);
			}
		}
		return disabledSources;
	}
}
