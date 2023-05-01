package com.exsq;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
	
	 @Test(priority=0) 
	 public void Verify_LotOutlined_AfterSelectPlanFromListing() throws InterruptedException {
		 wait.until(ExpectedConditions.visibilityOf(Overview.print_btn));
		 Overview.First_Plan_in_Listing();
		 System.out.println("Available Lots count is : "+ Overview.All_Highlighted_Lots());
		 Assert.assertEquals(Overview.All_Highlighted_Lots(), Overview.AvailableLots_Count);
		 System.out.println("Passed : Available Lots are showing hightlighted and lot's count on selected plan has been verified.");
	}
	
	 @Test(priority=2) 
	 public void Verify_SelectedLot_OutlineAndColor() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(Overview.SinglePlanAssigned_2_GetCSS(), Overview.Expected_SelectedLot_outlined());
		System.out.println("Passed : Selected Lot outline and outline color has been verified.");
	}	
	 
	 @Test(priority=5) 
	 public void Verify_AvailablePlanOnLot() throws InterruptedException {
		 Thread.sleep(1000);
		 Assert.assertEquals(Overview.Available_Plan_on_Lot(), Overview.SinglePlanAssigned);
		 System.out.println("Passed : Lot has only one plan assigned and Available Plan on this Lot header text has been verified.");
	}
	 
	 @Test(priority=6) public void Verify_OtherPlansOnLot() throws InterruptedException {
		 Thread.sleep(1000);
		 Assert.assertEquals(Overview.All_Available_Plan(), Overview.OthersPlanInThisCommunity);
		 System.out.println("Passed : Other Plans in this community header text has been verified.");
	}
	 
	 @Test(priority=7) public void Verify_AvailablePlansOnLot() throws InterruptedException {
		 Thread.sleep(2000);
		 Overview.LotDetailPopUp_Close_icon();
		 Thread.sleep(1000);
		 Overview.Select_TwoPlansAssigned_Lot();
		 Assert.assertEquals(Overview.Available_Plan_on_Lot(), Overview.MultiPlanAssigned);
		 System.out.println("Passed : Lot has more then one plan assigned and Available Plans on this Lot header text has been verified.");
	}
	 
	 @Test(priority=8) 
	 public void Verify_HoldALot_Btn_Invisiblity() throws InterruptedException {
		 Thread.sleep(2000);
		 Overview.Select_TwoPlansAssigned_Lot();
		 Assert.assertFalse(Overview.Hold_A_Lot_btn());
		 System.out.println("Passed : Hold a Lot button invisiblity has been verified.");
	}

	 @AfterClass
	 public void CloseBrowser() {
		 driver.close();
	 }
	 
}
