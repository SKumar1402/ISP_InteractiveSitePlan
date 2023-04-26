package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Home_Status_Filter extends TestBase {
	String ISP_Type = prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}

	@Test(priority = 1)
	public void Homesite_Status_Filter_Visibility() throws Throwable {
		if(ISP_Type.contains("2")) {
		Assert.assertTrue(!Overview.Homesite_StatusFilter_Dropdown_ISP2());
		System.out.println("Passed : Default Homesite Status Filter list for ISP 2.0 is showing as closed.");
		}else {
			Thread.sleep(1000);
			Assert.assertTrue(Overview.Homesite_StatusFilter_Dropdown_ISP3());
			System.out.println("Passed : Default Homesite Status Filter list for ISP 3.0 GeoSpatial is showing as opened.");
		}
	}
	
	@Test (priority=2)
	public void Homesite_Status_Btn_click() throws InterruptedException {
		Thread.sleep(1000);
		if(ISP_Type.contains("2")) {
			Overview.Homesite_Status_button_ISP2_Click();
			Assert.assertTrue(Overview.Homesite_StatusFilter_Dropdown_ISP2());
			System.out.println("Passed : After click on Homesite Status Filter button list for ISP 2.0 is showing as opened.");
			}else {
				Overview.Homesite_Status_button_ISP3_Click();
				Assert.assertFalse(Overview.Homesite_StatusFilter_Dropdown_ISP3());
				System.out.println("Passed : After click on Homesite Status Filter button list for ISP 3.0 GeoSpatial has been closed.");
			}
	}
	
	@Test (priority=3)
	public void Close_Homesite_Status_List() throws InterruptedException{
		Thread.sleep(1000);
		if(ISP_Type.contains("2")) {
			Overview.Homesite_Status_Close_btn_ISP2_click();
			Assert.assertTrue(!Overview.Homesite_StatusFilter_Dropdown_ISP2());
			System.out.println("Passed : After click on Homesite Status Filter close button list for ISP 2.0 has been closed.");
			}else {
				Overview.Homesite_Status_button_ISP3_Click();
				Thread.sleep(1000);
				Overview.Homesite_Status_Close_btn_ISP3_click();
				Assert.assertTrue(!Overview.Homesite_StatusFilter_Dropdown_ISP3());
				System.out.println("Passed : After click on Homesite Status Filter close button list for ISP 3.0 GeoSpatial has been closed");
			}
	}
}
