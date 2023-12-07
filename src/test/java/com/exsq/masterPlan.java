package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.base.TestBase.PageType;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class masterPlan extends TestBase {
	AbstractComponents abc;
	String ISP_Type = prop.getProperty("ISP_Type");
	String expectedMasterMapName2 = prop.getProperty("MasterMap_Name_2");
	String expectedMasterMapName3 = prop.getProperty("MasterMap_Name_3");
	String url = prop.getProperty("url");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}

	@Test(priority=1)
	public void Verify_MasterMap_Name_Header() throws InterruptedException {
		abc.Overview.masterMap_btn_click();
		if (ISP_Type.contains("2")) {
			Assert.assertEquals(abc.Overview.Community_Name_Header_GetText(), expectedMasterMapName2);
			System.out.println("Passed : Master Map name for ISP 2.0 has been verified in header after redirect to the Master Map.");
		} else {
			Assert.assertEquals(abc.Overview.Community_Name_Header_GetText(), expectedMasterMapName3);
			System.out.println("Passed : Master Map name for ISP 3.0 has been verified in header after redirect to the Master Map.");
		}
	}

	@Test(priority=2)
	public void VerifyMasterMapNameFooter() {
		if (ISP_Type.contains("2")) {
			Assert.assertEquals(abc.Overview.communityNameFromFooter(), expectedMasterMapName2);
			System.out.println("Passed : Master Map name for ISP 2.0 has been verified in footer after redirect to the Master Map.");
		} else {
			Assert.assertEquals(abc.Overview.communityNameFromFooter(), expectedMasterMapName3);
			System.out.println("Passed : Master Map name for ISP 3.0 has been verified in footer after redirect to the Master Map.");
		}
	}

	@Test(priority=3)
	public void VerifyPlanListing() {
		Assert.assertFalse(abc.Overview.Right_Panel_hide());
		System.out.println("Passed: Right Plan invisiblity has been verified.");
	}
}
