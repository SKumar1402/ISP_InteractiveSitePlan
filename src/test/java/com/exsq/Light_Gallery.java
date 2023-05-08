package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Light_Gallery extends TestBase{
	String ISP_Type = prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {
		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	 @Test(priority=1) 
	 public void Select_PlanFrom_Listing() throws InterruptedException {
		 Thread.sleep(5000);
		 if(ISP_Type.contains("Overview")) {
		 Overview.First_Plan_in_Listing();
		 Assert.assertTrue(Overview.First_Listing_LightGallery_Image());
		 System.out.println("Passed : Plan detail card gets displayed.");
		 }else {
		    Assert.assertFalse(Overview.Right_Panel_hide());
	    	System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		 }			
	}
	 
	 @Test(priority=2) 
	 public void Open_Light_Gallery () throws InterruptedException {
		 if(ISP_Type.contains("Overview")) {
		 Overview.First_Listing_LightGallery_Image_Click();
		 Thread.sleep(2000);
		 Assert.assertTrue(Overview.Light_Gallery_Image());
		 System.out.println("Passed : Light Gallery image and thumbnail image has been verified.");
		 }else {
			Assert.assertFalse(Overview.Right_Panel_hide());
		    System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");
		 }
	}
	 
	@Test(priority=3)
	public void Close_LightGallery() throws InterruptedException {
		if(ISP_Type.contains("Overview")) {
		Overview.Light_Gallery_CloseIcon();
		Thread.sleep(2000);
		Assert.assertFalse(Overview.Light_Gallery_Image());
		System.out.println("Passed : Light Gallery has been closed.");
		}else {
			Assert.assertFalse(Overview.Right_Panel_hide());
	    	System.out.println("Skipped : Plan Listing (Right Panel) is not showing.");

		}
	}
	 
	 @AfterClass
	 public void CloseBrowser() {
		driver.close();
	 }
	 
}
