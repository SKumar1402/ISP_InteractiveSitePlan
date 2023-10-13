package com.exsq;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Home_Status_Filter extends TestBase {
	String ISP_Type = prop.getProperty("ISP_Type");
	String url = prop.getProperty("url");

	@Test(priority = 1)
	public void Homesite_Status_Filter_Visibility() throws Throwable {
		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
		if(ISP_Type.contains("2")) {
		Assert.assertTrue(!abc.Overview.Homesite_StatusFilter_Dropdown_ISP2());
		System.out.println("Passed : Default Homesite Status Filter list for ISP 2.0 is showing as closed.");
		}else {
			Thread.sleep(1000);
			Assert.assertTrue(abc.Overview.Homesite_StatusFilter_Dropdown_ISP3());
			System.out.println("Passed : Default Homesite Status Filter list for ISP 3.0 GeoSpatial is showing as opened.");
		}
		
		//Homesite Status Button click 
		Thread.sleep(1000);
		if(ISP_Type.contains("2")) {
			abc.Overview.Homesite_Status_button_ISP2_Click();
			Assert.assertTrue(abc.Overview.Homesite_StatusFilter_Dropdown_ISP2());
			System.out.println("Passed : After click on Homesite Status Filter button list for ISP 2.0 is showing as opened.");
			}else {
				abc.Overview.Homesite_Status_button_ISP3_Click();
				Assert.assertFalse(abc.Overview.Homesite_StatusFilter_Dropdown_ISP3());
				System.out.println("Passed : After click on Homesite Status Filter button list for ISP 3.0 GeoSpatial has been closed.");
			}
		
		//Close Homesite Status List
		Thread.sleep(1000);
		if(ISP_Type.contains("2")) {
			abc.Overview.Homesite_Status_Close_btn_ISP2_click();
			Assert.assertTrue(!abc.Overview.Homesite_StatusFilter_Dropdown_ISP2());
			System.out.println("Passed : After click on Homesite Status Filter close button list for ISP 2.0 has been closed.");
			}else {
				abc.Overview.Homesite_Status_button_ISP3_Click();
				Thread.sleep(1000);
				abc.Overview.Homesite_Status_Close_btn_ISP3_click();
				Assert.assertTrue(!abc.Overview.Homesite_StatusFilter_Dropdown_ISP3());
				System.out.println("Passed : After click on Homesite Status Filter close button list for ISP 3.0 GeoSpatial has been closed");
			}
	}
		 
}
