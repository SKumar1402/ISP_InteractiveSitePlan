package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.base.TestBase.PageType;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;
import com.exsq.isp_plugin.base.Listeners;
import AbstractComponents.AbstractComponents;

public class expendedViewinListing extends TestBase {
	AbstractComponents abc;
	String url = prop.getProperty("url");
	String ISP_Type=prop.getProperty("ISP_Type");
	String planName=prop.getProperty("planname");
	public Listeners li=new Listeners();
	
	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview =(ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}

	@Test(priority = 1)
	public void RequestInfoVisiblityListing() throws InterruptedException {
		if (ISP_Type.contains("Overview")) {
			abc.Overview.selectPlanFromListing(planName);
			Assert.assertTrue(abc.Overview.RequestInfoLinkInListingVisibility(planName));
			System.out.println("Passed : Request Info button is showing in the expended view in listing.");
		} else {
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}
	
	@Test(priority=2)
	public void ExpendViewRequestInfoVisibilityInListing() throws InterruptedException {
			if (ISP_Type.equals("Overview_2") || ISP_Type.equals("Overview_3")) {
				Assert.assertTrue(abc.Overview.ExpendedViewLinkInListingVisibility(planName));
				System.out.println("Passed : Expend View link is showing in the listing.");
			} else {
				System.out.println("Plan Listing (Right Panel) is not showing.");
			}
	}
}
