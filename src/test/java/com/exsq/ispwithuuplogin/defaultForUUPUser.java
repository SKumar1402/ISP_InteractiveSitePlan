package com.exsq.ispwithuuplogin;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class defaultForUUPUser extends TestBase{
	AbstractComponents abc;
	String url = prop.getProperty("Overview_2_UUP");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}
	
	@Test (priority=1)
	public void verifyLoginOrCreateAccountLink()
	{
		Assert.assertTrue(abc.Overview.LoginButtonVisibility());
		System.out.println("Passed : Login or Create Account Link is showing.");
		}
	
	@Test (priority=2)
	public void SaveButtonInactive() {
		Assert.assertTrue(abc.Overview.saveButtonInactive());
		System.out.println("Passed : Save button is showing as Inactive or disabled.");
	}

}
