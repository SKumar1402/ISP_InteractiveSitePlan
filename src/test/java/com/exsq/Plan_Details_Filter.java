package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Plan_Details_Filter extends TestBase {
	String ISP_Type = prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}

	@Test(priority = 1)
	public void PlanDetails_Filter_Button() {
		if (ISP_Type.contains("Overview")) {
			Overview.Plan_details_Filter_btn_click();
			Assert.assertTrue(Overview.PlanDetails_Option_Section());
			System.out.println("Passed : Plan Details Filter button is clickable and options are showing.");
		} else {
			Assert.assertFalse(Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
	}
	
	
	@Test(priority = 2)
	public void Select_PlanDetailsFilter_MinimumBtn_Slider() {
		if (ISP_Type.contains("Overview")) {
			Overview.PlanDetail_Slider_Min_Select();
			Assert.assertEquals(Overview.PlanDetail_Slider_Minimum, Overview.PlanDetail_Slider_Min_value());
			System.out.println("Passed : Slider minimum button is clickable and values has been verified.");
		} else {
			Assert.assertFalse(Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
	}
	
	@Test(priority = 3)
	public void Verify_PlanDetails_BedroomOption_Selection() {
		if (ISP_Type.contains("Overview")) {
			Overview.PlanDetails_BedroomThree_Select();
			Assert.assertEquals(Overview.PlanDetails_BedroomThree_GetColor(), Overview.Filter_Option_BackgroundColor);
			System.out.println("Passed : Bedroom filter option has been selected.");
		} else {
			Assert.assertFalse(Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
	}
	
	 @AfterClass
	 public void CloseBrowser() {
		 driver.close();
	 }
	 
}
