package com.exsq;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Community_Name_Visibility extends TestBase {
	String url = prop.getProperty("url");
	
	@Test(priority = 1)
	public void CommunityNameVisibilityInHeaderAndFooter() {
		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
		Assert.assertTrue(abc.Overview.Community_Name_Header());
		System.out.println("Passed : Community Name visibility has been verified in the Header.");
	
		//Community name visibility Footer
		Assert.assertTrue(abc.Overview.Community_Name_Footer());
		System.out.println("Passed : Community Name visibility has been verified in the Footer.");
	}

}
