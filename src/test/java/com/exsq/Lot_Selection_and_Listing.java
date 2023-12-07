package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.base.TestBase.PageType;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class Lot_Selection_and_Listing extends TestBase {
	AbstractComponents abc;
	String url = prop.getProperty("url");
	String Lotid1=prop.getProperty("Lot1");
	String Lotid2=prop.getProperty("Lot2");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview =(ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}

	@Test(priority = 1)
	public void Verify_LotOutlined_AfterSelectPlanFromListing() throws InterruptedException {
		String planName = prop.getProperty("planname");
		int AvailableLots_Count = Integer.parseInt(prop.getProperty("AvailableLots_Count"));
		abc.Overview.waitToHideSkeleton();
		abc.Overview.selectPlanFromListing(planName);
		System.out.println("Available Lots count is : " + abc.Overview.All_Highlighted_Lots());
		Assert.assertEquals(abc.Overview.All_Highlighted_Lots(), AvailableLots_Count);
		System.out.println("Passed : Available Lots are showing hightlighted and lot's count on selected plan has been verified.");
	}

	@Test(priority = 2)
	public void VerifyAvailablePlanOnLot() throws InterruptedException {
		Thread.sleep(1000);
		abc.Overview.clickOnLotId(Lotid1);
		String SinglePlanAssigned = prop.getProperty("SinglePlanAssigned");
		Assert.assertEquals(abc.Overview.Available_Plan_on_Lot(), SinglePlanAssigned);
		System.out.println("Passed : Lot has only one plan assigned and Available Plan on this Lot header text has been verified.");
	}

	@Test(priority = 3)
	public void VerifyOtherPlansOnLot() {
		String OthersPlanInThisCommunity = prop.getProperty("OthersPlanInThisCommunity");
		Assert.assertEquals(abc.Overview.All_Available_Plan(), OthersPlanInThisCommunity);
		System.out.println("Passed : Other Plans in this community header text has been verified.");
	}

	@Test(priority = 4)
	public void VerifyAvailablePlansOnLot() throws InterruptedException {
		String MultiPlanAssigned = prop.getProperty("MultiPlanAssigned");
		Thread.sleep(2000);
		abc.Overview.LotDetailPopUp_Close_icon();
		Thread.sleep(1000);
		abc.Overview.clickOnLotId(Lotid2);
		Assert.assertEquals(abc.Overview.Available_Plan_on_Lot(), MultiPlanAssigned);
		System.out.println("Passed : Lot has more then one plan assigned and Available Plans on this Lot header text has been verified.");
	}

	@Test(priority = 5)
	public void VerifyHoldALotButtonInvisibility() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertFalse(abc.Overview.Hold_A_Lot_btn());
		System.out.println("Passed : Hold a Lot button invisibility has been verified.");
	}

}
