package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class SVGZoom extends TestBase {
	AbstractComponents abc;
	String ISP_Type = prop.getProperty("ISP_Type");
	String url = prop.getProperty("url");
	

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}
	
	@Test(priority=1) 
	  public void SVG_Zoom_Slider() throws InterruptedException {
		abc.Overview.waitToHideSkeleton();
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
