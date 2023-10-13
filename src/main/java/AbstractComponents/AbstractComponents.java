package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.exsq.isp_plugin.pageObjects.ISP_Overview;

public class AbstractComponents {
	WebDriver driver;
	
	public ISP_Overview Overview;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}
	public void waitForWebElementToAppear(WebElement findby) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby ));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf((ele)));
	}
	
	public ISP_Overview navigateToURL(String url) {
		driver.get(url);
		return new ISP_Overview(driver);
	}
}


