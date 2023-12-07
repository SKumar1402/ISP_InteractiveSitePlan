package com.exsq.ispwithuuplogin;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class savedLots extends TestBase{
	AbstractComponents abc;
	String url = prop.getProperty("Overview_2_UUP");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}
	
	@Test (priority=1)
	public void saveLot() throws InterruptedException {
		String email=prop.getProperty("LoginEmail");
		String password=prop.getProperty("LoginPassword");
		String Lot1=prop.getProperty("Lot1");
		abc.UUP=abc.Overview.clickOnLoginLink();
		Thread.sleep(3000);
		abc.Overview=abc.UUP.Login(email, password);
		Thread.sleep(5000);
		abc.Overview.clickOnLotId(Lot1);
	}
}
