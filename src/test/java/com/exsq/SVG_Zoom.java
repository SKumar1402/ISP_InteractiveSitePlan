package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class SVG_Zoom extends TestBase {
	String ISP_Type = prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	@Test(priority=9) 
	  public void SVG_Zoom_Slider() throws InterruptedException {
		  Thread.sleep(5000);
		  String Slider_Value=Overview.SVG_ZoomedSlider_Value();
		  if(ISP_Type.contains("2")) {
		  Overview.SVG_ZoomSlider_Click();
		  Assert.assertNotEquals(Slider_Value, Overview.SVG_ZoomedSlider_Value());
		  System.out.println("Passed : SVG slider has been verified.");
		  }else {
			  System.out.println("This is only for ISP 2.0 and not applicable in ISP 3.0.");
		  }
	}
	
	 @AfterClass
	 public void CloseBrowser() {
		 //driver.close();
	 }
	 
}
