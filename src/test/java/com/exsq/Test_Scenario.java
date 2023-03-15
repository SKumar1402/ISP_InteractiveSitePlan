package com.exsq;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Test_Scenario extends TestBase {
	String ISP_Type=prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	 @Test(priority=6) public void Verify_SVG_Zoom_Slider() throws InterruptedException {
		 Thread.sleep(5000);
		 Overview.SVG_ZoomSlider_Click(); 
		 Assert.assertEquals(Overview.SVG_ZoomedSlider_Value(),Overview.SVG_Zoomed_in_Expected);
		 System.out.println("Actual Slider value is : " + Overview.SVG_ZoomedSlider_Value());
		 System.out.println("Expected Slider value is : " + Overview.SVG_Zoomed_in_Expected); 
	}
}
