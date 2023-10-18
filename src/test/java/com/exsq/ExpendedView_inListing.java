package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class ExpendedView_inListing extends TestBase {
	AbstractComponents abc;
	String url = prop.getProperty("url");
	String ISP_Type=prop.getProperty("ISP_Type");
	String planName=prop.getProperty("planname");
	
	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
	}

	@Test(priority = 0)
	public void RequestInfoVisiblityListing() throws InterruptedException {
		if (ISP_Type.contains("Overview")) {
			abc.Overview.selectPlanFromListing(planName);
			Assert.assertTrue(abc.Overview.RequestInfoLinkInListingVisibility(planName));
			System.out.println("Passed : Request Info button is showing in the expended view in listing.");
		} else {
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}
	
	@Test(priority=1)
	public void ExpendViewRequestInfoVisibilityInListing() {
			if (ISP_Type.equals("Overview_2") || ISP_Type.equals("Overview_3")) {
				Assert.assertTrue(abc.Overview.ExpendedViewLinkInListingVisibility(planName));
				System.out.println("Passed : Expend View link is showing in the listing.");
			} else {
				System.out.println("Plan Listing (Right Panel) is not showing.");
			}
	}
}
