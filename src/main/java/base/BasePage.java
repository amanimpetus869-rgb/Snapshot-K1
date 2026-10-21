package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.ExcelUtil;
import utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;
	protected WaitUtils wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver);
    }
    
    public void click(WebElement element) {
    	wait.waitForClickable(element);
    	element.click();
    }
}