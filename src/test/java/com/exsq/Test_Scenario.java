package com.exsq;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Test_Scenario extends TestBase {
	String ISP_Type=prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	 @Test(priority=6) 
	 public void Verify_AvailablePlansOnLot() throws InterruptedException {
		 Thread.sleep(5000);
		 Overview.Select_TwoPlansAssigned_Lot();
		 Assert.assertFalse(Overview.Hold_A_Lot_btn());
		 System.out.println("Passed : Hold a Lot button invisiblity has been verified.");
	}
	
}
  