package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Lot_Selection_and_Listing extends TestBase {
	
	String ISP_Type=prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	 @Test(priority=1) public void Verify_Lot_Detail_Pop_Up() throws InterruptedException {
		 Thread.sleep(5000);
		 Overview.Select_SinglePlanAssigned_Lot();
		 Assert.assertTrue(Overview.LotDetailPopUp());
		 System.out.println("Passed : Lot Detail Pop up has been verified.");
	}

	 @Test(priority=2) 
	 public void Verify_SelectedLot_OutlineAndColor() throws InterruptedException {
		Thread.sleep(8000);
		Overview.Select_SinglePlanAssigned_Lot();
		Assert.assertEquals(Overview.SinglePlanAssigned_2_GetCSS(), prop.getProperty("SelectedLot_Outline"));
		System.out.println("Passed : Selected Lot outline and outline color has been verified.");
	}	
	 
	 @Test(priority=3) 
	 public void Verify_HoldALot_Button_InsidePopup() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(Overview.Hold_A_Lot_btn());
		System.out.println("Passed : Hold a lot button visiblity has been verified.");
	}	
	 
	 @Test(priority=4) 
	 public void Verify_LotDetails_from_Popup() throws InterruptedException {
		Overview.Select_SinglePlanAssigned_Lot();
		Assert.assertEquals(Overview.Actual_LotDetailsValues(), Overview.Expected_LotDetailsValues());
		System.out.println("Passed : Lot detail values are verified.");
	}	
	 
	 @Test(priority=5) public void Verify_AvailablePlanOnLot() throws InterruptedException {
		 Thread.sleep(2000);
		 Assert.assertEquals(Overview.Available_Plan_on_Lot(), Overview.SinglePlanAssigned);
		 System.out.println("Passed : Lot has only one plan assigned and Available Plan on this Lot header text has been verified.");
	}
	 
	 @Test(priority=6) public void Verify_OtherPlansOnLot() throws InterruptedException {
		 Thread.sleep(2000);
		 Assert.assertEquals(Overview.All_Available_Plan(), Overview.OthersPlanInThisCommunity);
		 System.out.println("Passed : Other Plans in this community header text has been verified.");
	}
	 
	 @Test(priority=7) public void Verify_AvailablePlansOnLot() throws InterruptedException {
		 Thread.sleep(2000);
		 Overview.LotDetailPopUp_Close_icon();
		 Overview.Select_TwoPlansAssigned_Lot();
		 Assert.assertEquals(Overview.Available_Plan_on_Lot(), Overview.MultiPlanAssigned);
		 System.out.println("Passed : Lot has more then one plan assigned and Available Plans on this Lot header text has been verified.");
	}
	 
	 @Test(priority=8) 
	 public void Verify_HoldALot_Btn_Invisiblity() throws InterruptedException {
		 Thread.sleep(5000);
		 Overview.Select_TwoPlansAssigned_Lot();
		 Assert.assertFalse(Overview.Hold_A_Lot_btn());
		 System.out.println("Passed : Hold a Lot button invisiblity has been verified.");
	}

}
