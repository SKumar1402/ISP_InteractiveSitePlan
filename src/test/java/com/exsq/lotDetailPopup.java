package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.base.TestBase.PageType;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class lotDetailPopup extends TestBase {
	AbstractComponents abc;
	String ISP_Type = prop.getProperty("ISP_Type");
	String url = prop.getProperty("url");
	String Lot1=prop.getProperty("Lot1");
	String Lot2=prop.getProperty("Lot2");
	

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}

	@Test(priority = 1)
	public void Select_Lot_Popup_Visiblity() throws InterruptedException {
		abc.Overview.waitToHideSkeleton();
		abc.Overview.clickOnLotId(Lot1);
		Assert.assertTrue(abc.Overview.LotDetailPopUp_Visibility());
		System.out.println("Passed : Lot detail pop visiblity has been verified.");
	}

	@Test(priority = 2)
	public void MatchLotData() {
		String size = prop.getProperty("Lot_Size");
		String block = prop.getProperty("Lot_Block");
		String phase = prop.getProperty("Lot_Phase");
		String swing = prop.getProperty("Lot_Swing");
		String elevation = prop.getProperty("Lot_Elevation");
		Assert.assertEquals(abc.Overview.Actual_LotDetailsValues(),
				abc.Overview.Expected_LotDetailsValues(size, block, phase, swing, elevation));
		System.out.println("Passed : Lot data has been verified.");
	}

	@Test(priority = 3)
	public void HoldALotButtonVisibility() {
		Assert.assertTrue(abc.Overview.Hold_A_Lot_btn());
		System.out.println("Passed : Hold a Lot button visiblity has been verified.");
		abc.Overview.LotDetailPopUp_Close_icon();
	}

	@Test(priority = 4)
	public void HoldALotButtonInvisibility() throws InterruptedException {
		abc.Overview.clickOnLotId(Lot2);
		Assert.assertFalse(abc.Overview.Hold_A_Lot_btn());
		System.out.println("Passed : Hold a Lot button invisiblity has been verified.");
	}
}