package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class SVG_Zoom extends TestBase {
	String ISP_Type = prop.getProperty("ISP_Type");
	String url = prop.getProperty("url");
	
	@Test(priority=9) 
	  public void SVG_Zoom_Slider() throws InterruptedException {
		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
		  Thread.sleep(5000);
		  if(ISP_Type.contains("2")) {
		  String Slider_Value=abc.Overview.SVG_ZoomedSlider_Value();
		  abc.Overview.SVG_ZoomSlider_Click();
		  Assert.assertNotEquals(Slider_Value, abc.Overview.SVG_ZoomedSlider_Value());
		  System.out.println("Passed : SVG slider has been verified.");
		  }else {
			  System.out.println("This is only for ISP 2.0 and not applicable in ISP 3.0.");
		  }
	}
}
