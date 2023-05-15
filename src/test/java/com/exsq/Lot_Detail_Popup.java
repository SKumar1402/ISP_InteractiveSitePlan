package com.exsq;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Lot_Detail_Popup extends TestBase {
	String ISP_Type=prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {
		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	 @Test(priority=1) 
	 public void Select_Lot_Popup_Visiblity() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(Overview.print_btn));
		System.out.println("Session started");
		Overview.Select_SinglePlanAssigned_Lot();
		Assert.assertTrue(Overview.LotDetailPopUp_Visibility());
		System.out.println("Passed : Lot detail pop visiblity has been verified.");
		
	 }
	 
	 @Test(priority=2)
	 public void Match_Lot_Data() {
		 Assert.assertEquals(Overview.Actual_LotDetailsValues(), Overview.Expected_LotDetailsValues());
		 System.out.println("Passed : Lot data has been verified.");
	 }
	 
	 @Test(priority=3)
	 public void Hold_A_Lot_Btn_Visiblity() {
		 Assert.assertTrue(Overview.Hold_A_Lot_btn());
		 System.out.println("Passed : Hold a Lot button visiblity has been verified.");
		 Overview.LotDetailPopUp_Close_icon();
	 }
	 
	 @Test(priority=8) 
	 public void HoldALot_Btn_Invisiblity() throws InterruptedException {
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
  