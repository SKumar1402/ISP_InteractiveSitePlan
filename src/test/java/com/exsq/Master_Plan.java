package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Master_Plan extends TestBase{
	
	String ISP_Type = prop.getProperty("ISP_Type");
	String expectedMasterMapName2=prop.getProperty("MasterMap_Name_2");
	String expectedMasterMapName3=prop.getProperty("MasterMap_Name_3");
	String url = prop.getProperty("url");
	
	 @Test(priority=1) 
	 public void Verify_MasterMap_Name_Header() throws InterruptedException {
		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
		abc. Overview.masterMap_btn_click();
		 if(ISP_Type.contains("2")) {
		 Assert.assertEquals(abc.Overview.Community_Name_Header_GetText(), expectedMasterMapName2);
		 System.out.println("Passed : Master Map name for ISP 2.0 has been verified in header after redirect to the Master Map.");
		 }else {
			 Assert.assertEquals(abc.Overview.Community_Name_Header_GetText(), expectedMasterMapName3);
			 System.out.println("Passed : Master Map name for ISP 3.0 has been verified in header after redirect to the Master Map.");
		 }
		 
		 //Verify MasterMap Name Footer
		 if(ISP_Type.contains("2")) {
		 Assert.assertEquals(abc.Overview.communityNameFromFooter(), expectedMasterMapName2);
		 System.out.println("Passed : Master Map name for ISP 2.0 has been verified in footer after redirect to the Master Map.");
		 }else {
			 Assert.assertEquals(abc.Overview.communityNameFromFooter(), expectedMasterMapName3);
			 System.out.println("Passed : Master Map name for ISP 3.0 has been verified in footer after redirect to the Master Map.");
		 }
		 //Verify Plan Listing
	 
		Assert.assertFalse(abc.Overview.Right_Panel_hide());
		System.out.println("Passed: Right Plan invisiblity has been verified.");
	 }
 
}
