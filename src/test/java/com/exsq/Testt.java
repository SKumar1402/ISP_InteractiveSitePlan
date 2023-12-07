package com.exsq;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.base.TestBase.PageType;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class Testt extends TestBase {
	
	AbstractComponents abc;
	String url = prop.getProperty("url");
	String Lot1=prop.getProperty("Lot1");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview =(ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}
	
	@Test(priority = 1)
	public void Request_Info_Btn_Visiblity() throws InterruptedException {
		abc.Overview.clickOnLotId(Lot1);
		System.out.println("*************Passed************");
		Thread.sleep(50000);
	}

}
