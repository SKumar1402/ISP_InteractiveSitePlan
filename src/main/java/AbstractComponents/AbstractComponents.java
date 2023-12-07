package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.exsq.isp_plugin.base.TestBase.PageType;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;
import com.exsq.isp_plugin.pageObjects.UUPLoginSignUp;

public class AbstractComponents {
	WebDriver driver;
	
	public ISP_Overview Overview;
	public UUPLoginSignUp UUP;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
	}
	public void waitForWebElementToAppear(WebElement findby) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(findby ));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf((ele)));
	}
	
	public Object navigateToURL(String url, PageType pageType) {
		
		Object obj = null;
		driver.get(url);
		
		switch (pageType) {
		case ISPOverview:	
			obj = new ISP_Overview(driver);
			break;

		case UUPPage:
			obj = new UUPLoginSignUp(driver);
			break;
		}
		return obj;
	}
}


