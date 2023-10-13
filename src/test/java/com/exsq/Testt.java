package com.exsq;

import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Testt extends TestBase {
	String url=prop.getProperty("url");
	
	@Test(priority = 1)
	public void Select_PlanFrom_Listing() throws InterruptedException {
		String planName=prop.getProperty("planname");
		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
		abc.Overview.selectPlanFromListing(planName);
	}
}
