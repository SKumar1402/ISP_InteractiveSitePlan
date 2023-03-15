package com.exsq;

import org.testng.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Sanity_Overview extends TestBase {
	String ISP_Type = prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}

	@Test(priority = 0)
	public void Verify_Request_Info() throws Throwable {
		Overview.request_info_btn_click();
		Overview.Fill_Request_Info_Form();
		Overview.Send_Request_Click();
		System.out.println("Request Info form has been submitted.");
		Assert.assertTrue(Overview.Loading_Loader());
		System.out.println("After Submit the form Loader is showing.");
		Assert.assertTrue(Overview.Great_Lets_Continue_btn());
		System.out.println("Request Info has been submitted successfully.");
		Overview.Great_Lets_Continue_btn_click();
		Thread.sleep(500);
		Assert.assertFalse(Overview.ri_Success_Popup_hide());
		System.out.println("Request Info success pop up has been closed.");
	}

	@Test(priority = 1)
	public void Verify_Print() throws InterruptedException {
		Overview.print_btn_click();
		System.out.println("Print button from footer is clickable.");
		Thread.sleep(1000);
		Assert.assertTrue(Overview.print_modal_window());
		System.out.println("Print Modal window is showing.");

		Overview.print_modal_Cancel_btn_Click();
		Assert.assertFalse(Overview.print_modal_window());
		System.out.println("Print Modal window has been closed.");
	}

	@Test(priority = 2)
	public void Verify_Community_Name() {
		Assert.assertTrue(Overview.Community_Name_Header());
		System.out.println("Passed : Community Name is showing in the header.");

		Assert.assertTrue(Overview.Community_Name_Footer());
		System.out.println("Passed : Community Name is showing in the footer.");
	}

	@Test(priority = 3)
	public void Verify_Homesite_Status_Filter() throws Throwable {
		Overview.Homesite_Status_Filter_button();
		Assert.assertTrue(Overview.Homesite_StatusFilter_Dropdown());
		System.out.println("Passed : Homesite Status Filter Dropdown/Pop up is showing.");
		Thread.sleep(2000);
		Overview.Homesite_Status_Close_btn_click();

		Assert.assertFalse(Overview.Homesite_StatusFilter_Dropdown());
		System.out.println("Passed : Homesite Status Filter Dropdown/Pop up is not showing.");
	}

	@Test(priority = 3)
	public void Verify_RequestInfo_ExpendView_Inlisting() {
		if (ISP_Type.equals("Overview_2") || ISP_Type.equals("Overview_3")) {
			Overview.First_Plan_in_Listing();
			Assert.assertTrue(Overview.Request_Info_FirstListing());
			System.out.println("Request Info is showing in the listing.");
			Assert.assertTrue(Overview.Expent_View_FirstListing());
			System.out.println("Expend View is showing in the listing.");
		} else {
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}

	@Test(priority = 4)
	public void Verify_PlanDetails_Slider_Minimum() {
		if (ISP_Type.equals("Overview_2") || ISP_Type.equals("Overview_3")) {
			Overview.Plan_details_Filter_btn_click();
			Assert.assertTrue(Overview.PlanDetails_Option_Section());
			System.out.println("Plan Details Filter options are showing.");
			Overview.PlanDetail_Slider_Min_Select();
			System.out.println("Minmum value is : " + Overview.PlanDetail_Slider_Min_value());
			Assert.assertEquals(Overview.PlanDetail_Slider_Minimum, Overview.PlanDetail_Slider_Min_value());
			System.out.println("Slider minimum values are verified.");
		} else {
			Assert.assertFalse(Overview.Right_Panel_hide());
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}

	@Test(priority = 5)
	public void Verify_PlanDetails_BedroomOption_Selection() {
		if (ISP_Type.equals("Overview_2") || ISP_Type.equals("Overview_3")) {
			Overview.PlanDetails_BedroomThree_Select();
			Assert.assertEquals(Overview.PlanDetails_BedroomThree_GetColor(), Overview.Filter_Option_BackgroundColor);
			System.out.println("Bedroom filter option has been selected.");
		} else {
			Assert.assertFalse(Overview.Right_Panel_hide());
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}

	
	  @Test(priority=6) public void Verify_SVG_Zoom_Slider() {
		  Overview.SVG_ZoomSlider_Click();
		  Assert.assertEquals(Overview.SVG_ZoomedSlider_Value(),Overview.SVG_Zoomed_in_Expected);
		  System.out.println("Actual Slider value is : " + Overview.SVG_ZoomedSlider_Value());
		  System.out.println("Expected Slider value is : " + Overview.SVG_Zoomed_in_Expected); 
	}
}
