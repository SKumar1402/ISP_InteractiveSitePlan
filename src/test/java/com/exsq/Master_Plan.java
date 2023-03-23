package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Master_Plan extends TestBase{
	@BeforeClass
	public void setup() {
		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	 @Test(priority=1) 
	 public void Verify_MasterMap_Name_Header() throws InterruptedException {
		 Thread.sleep(5000);
		 Overview.masterMap_btn_click();
		 Assert.assertEquals(Overview.Community_Name_Header_GetText(), Overview.Expected_MasterMap_Name);
		 System.out.println("Passed : Master Map name has been verified in header after redirect to the Master Map.");
	}
	 
	 @Test(priority=2) 
	 public void Verify_MasterMap_Name_Footer() throws InterruptedException {
		 Assert.assertEquals(Overview.Community_Name_Footer_GetText(), Overview.Expected_MasterMap_Name);
		 System.out.println("Passed : Master Map name has been verified in footer after redirect to the Master Map.");
	}
	
	 @Test(priority=3)
	 public void Verify_Plan_Listing()
	 {
		Assert.assertFalse(Overview.Right_Panel_hide());
		System.out.println("Passed: Right Plan invisiblity has been verified.");
	 }
}
