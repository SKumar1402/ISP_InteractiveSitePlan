package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.base.TestBase.PageType;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class lightGallery extends TestBase {
	AbstractComponents abc;
	String ISP_Type = prop.getProperty("ISP_Type");
	String url = prop.getProperty("url");
	String planName = prop.getProperty("planname");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}

	@Test(priority = 1)
	public void Select_PlanFrom_Listing() throws InterruptedException {
		if (ISP_Type.contains("Overview")) {
			abc.Overview.selectPlanFromListing(planName);
			Assert.assertTrue(abc.Overview.First_Listing_LightGallery_Image());
			System.out.println("Passed : Plan detail card gets displayed.");
		} else {
			Assert.assertFalse(abc.Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
	}

	@Test(priority = 2)
	public void OpenLightGallery() throws InterruptedException {
		if (ISP_Type.contains("Overview")) {
			abc.Overview.clickOnLightGallery(planName);
			Thread.sleep(2000);
			Assert.assertTrue(abc.Overview.Light_Gallery_Image());
			System.out.println("Passed : Light Gallery image and thumbnail image has been verified.");
		} else {
			Assert.assertFalse(abc.Overview.Right_Panel_hide());
			System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		}
	}

	@Test(priority = 3)
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
