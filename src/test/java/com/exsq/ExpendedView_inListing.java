package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class ExpendedView_inListing extends TestBase {
	String url = prop.getProperty("url");
	String ISP_Type=prop.getProperty("ISP_Type");

	@Test(priority = 0)
	public void RequestInfoVisiblityListing() throws InterruptedException {
		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
		String planName=prop.getProperty("planname");
		//Thread.sleep(4000);
		if (ISP_Type.contains("Overview")) {
			abc.Overview.selectPlanFromListing(planName);
			Assert.assertTrue(abc.Overview.RequestInfoLinkInListingVisibility(planName));
			System.out.println("Passed : Request Info button is showing in the expended view in listing.");
		} else {
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}

		// ExpendView Request Info visibility in Listing
		if (ISP_Type.equals("Overview_2") || ISP_Type.equals("Overview_3")) {
			Assert.assertTrue(abc.Overview.ExpendedViewLinkInListingVisibility(planName));
			System.out.println("Expend View link is showing in the listing.");
		} else {
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}

}
