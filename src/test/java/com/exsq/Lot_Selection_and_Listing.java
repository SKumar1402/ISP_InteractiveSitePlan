package com.exsq;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Lot_Selection_and_Listing extends TestBase {
	String url = prop.getProperty("url");

	 @Test(priority=0) 
	 public void Verify_LotOutlined_AfterSelectPlanFromListing() throws InterruptedException {
		 String planName=prop.getProperty("planname");
		 AbstractComponents abc = new AbstractComponents(driver);
		 abc.Overview = abc.navigateToURL(url);
		 int AvailableLots_Count=Integer.parseInt(prop.getProperty("AvailableLots_Count"));
		 abc.Overview.waitToHideSkeleton();
		 abc.Overview.selectPlanFromListing(planName);
		 System.out.println("Available Lots count is : "+ abc.Overview.All_Highlighted_Lots());
		 Assert.assertEquals(abc.Overview.All_Highlighted_Lots(), AvailableLots_Count);
		 System.out.println("Passed : Available Lots are showing hightlighted and lot's count on selected plan has been verified.");
		 
		 //Verify Selected Lot Outline and Color
		Thread.sleep(2000);
		String expectedSelectedLotOutlined=prop.getProperty("SelectedLot_Outline");
		Assert.assertEquals(abc.Overview.SinglePlanAssigned_2_GetCSS(), expectedSelectedLotOutlined);
		System.out.println("Passed : Selected Lot outline and outline color has been verified.");
		
		//Verify Available Plan On Lot
		 Thread.sleep(1000);
		 abc.Overview.Select_SinglePlanAssigned_Lot();
		 String SinglePlanAssigned=prop.getProperty("SinglePlanAssigned");
		 Assert.assertEquals(abc.Overview.Available_Plan_on_Lot(), SinglePlanAssigned);
		 System.out.println("Passed : Lot has only one plan assigned and Available Plan on this Lot header text has been verified.");
		 
		 //Verify Other Plans On Lot
		 String OthersPlanInThisCommunity=prop.getProperty("OthersPlanInThisCommunity");
		 Assert.assertEquals(abc.Overview.All_Available_Plan(), OthersPlanInThisCommunity);
		 System.out.println("Passed : Other Plans in this community header text has been verified.");
		 
		 //Verify Available Plans On Lot
		 String MultiPlanAssigned=prop.getProperty("MultiPlanAssigned");
		 Thread.sleep(2000);
		 abc.Overview.LotDetailPopUp_Close_icon();
		 Thread.sleep(1000);
		 abc.Overview.Select_TwoPlansAssigned_Lot();
		 Assert.assertEquals(abc.Overview.Available_Plan_on_Lot(), MultiPlanAssigned);
		 System.out.println("Passed : Lot has more then one plan assigned and Available Plans on this Lot header text has been verified.");
		 
		 //Verify HoldALot Button Invisibility
		 Thread.sleep(2000);
		 abc.Overview.Select_TwoPlansAssigned_Lot();
		 Assert.assertFalse(abc.Overview.Hold_A_Lot_btn());
		 System.out.println("Passed : Hold a Lot button invisiblity has been verified.");
	}	 
}
