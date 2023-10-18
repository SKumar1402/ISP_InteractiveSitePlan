package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Light_Gallery extends TestBase {
	AbstractComponents abc;
	String ISP_Type = prop.getProperty("ISP_Type");
	String url = prop.getProperty("url");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
	}

	@Test(priority = 0)
	public void Select_PlanFrom_Listing() throws InterruptedException {
		AbstractComponents abc = new AbstractComponents(driver);
		String planName = prop.getProperty("planname");
		abc.Overview = abc.navigateToURL(url);
		if (ISP_Type.contains("Overview")) {
			abc.Overview.selectPlanFromListing(planName);
			Assert.assertTrue(abc.Overview.First_Listing_LightGallery_Image());
			System.out.println("Passed : Plan detail card gets displayed.");
		} else {
			Assert.assertFalse(abc.Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
	}

	@Test(priority = 1)
	public void OpenLightGallery() {
		if (ISP_Type.contains("Overview")) {
			abc.Overview.First_Listing_LightGallery_Image_Click();
			Assert.assertTrue(abc.Overview.Light_Gallery_Image());
			System.out.println("Passed : Light Gallery image and thumbnail image has been verified.");
		} else {
			Assert.assertFalse(abc.Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
	}

	@Test(priority = 2)
	public void CloseLightGallery() throws InterruptedException {
		if (ISP_Type.contains("Overview")) {
			abc.Overview.Light_Gallery_CloseIcon();
			Thread.sleep(1000);
			Assert.assertFalse(abc.Overview.Light_Gallery_Image());
			System.out.println("Passed : Light Gallery has been closed.");
		} else {
			Assert.assertFalse(abc.Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");

		}
	}
}
