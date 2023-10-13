package com.exsq;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Plan_Details_Filter extends TestBase {
	String ISP_Type = prop.getProperty("ISP_Type");
	String url = prop.getProperty("url");

	@Test(priority = 1)
	public void PlanDetails_Filter_Button() {
		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
		if (ISP_Type.contains("Overview")) {
			abc.Overview.Plan_details_Filter_btn_click();
			Assert.assertTrue(abc.Overview.PlanDetails_Option_Section());
			System.out.println("Passed : Plan Details Filter button is clickable and options are showing.");
		} else {
			Assert.assertFalse(abc.Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
		
		//Select Plan Details Filter Minimum button slider
		if (ISP_Type.contains("Overview")) {
			String Before=abc.Overview.PlanDetail_Slider_Min_value1();
			abc.Overview.PlanDetail_Slider_Min_Select();
			Assert.assertNotEquals(Before, abc.Overview.PlanDetail_Slider_Min_value1());
			System.out.println("Passed : Slider minimum button is clickable and values has been verified.");
		} else {
			Assert.assertFalse(abc.Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
		
		//Verify Plan Details Bedroom Option Selection
		String Filter_Option_BackgroundColor=prop.getProperty("Filter_Option_BackgroundColor");
		if (ISP_Type.contains("Overview")) {
			abc.Overview.PlanDetails_BedroomThree_Select();
			Assert.assertEquals(abc.Overview.PlanDetails_BedroomThree_GetColor(), Filter_Option_BackgroundColor);
			System.out.println("Passed : Bedroom filter option has been selected.");
		} else {
			Assert.assertFalse(abc.Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
	}	 
}
