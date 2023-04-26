package com.exsq;

import org.testng.Assert;

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
		  if(ISP_Type.contains("2")) {
		  Overview.SVG_ZoomSlider_Click();
		  Assert.assertEquals(Overview.SVG_ZoomedSlider_Value(),Overview.SVG_Zoomed_in_Expected);
		  System.out.println("Actual Slider value is : " + Overview.SVG_ZoomedSlider_Value());
		  System.out.println("Expected Slider value is : " + Overview.SVG_Zoomed_in_Expected); 
		  }else {
			  System.out.println("This is only for ISP 2.0 and not applicable in ISP 3.0.");
		  }
	}
}
