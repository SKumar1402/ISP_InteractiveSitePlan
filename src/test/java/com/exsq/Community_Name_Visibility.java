package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Community_Name_Visibility extends TestBase {
	AbstractComponents abc;
	String url = prop.getProperty("url");
	
	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
	}
	
	@Test(priority = 1)
	public void CommunityNameVisibilityInHeaderAndFooter() {
		Assert.assertTrue(abc.Overview.Community_Name_Header());
		System.out.println("Passed : Community Name visibility has been verified in the Header.");
	}
	
	@Test(priority=2)
	public void VerifyCommunityNameVisibilityFooter() {
			Assert.assertTrue(abc.Overview.Community_Name_Footer());
			System.out.println("Passed : Community Name visibility has been verified in the Footer.");
	}
}
