package com.exsq.ispwithuuplogin;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class UUPLogin extends TestBase {
	AbstractComponents abc;
	String url = prop.getProperty("Overview_2_UUP");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}
	
	@Test (priority=1)
	public void validLogin() throws InterruptedException {
		String email=prop.getProperty("LoginEmail");
		String password=prop.getProperty("LoginPassword");
		String UserName=prop.getProperty("UserName");
		abc.UUP=abc.Overview.clickOnLoginLink();
		Thread.sleep(3000);
		abc.Overview=abc.UUP.Login(email, password);
		Thread.sleep(5000);
		Assert.assertEquals(abc.Overview.userName(), UserName);
		System.out.println("Passed : Logged in user name has been verified.");
	}
	
	@Test (priority=2)
	public void userDashboard()  {
		abc.Overview.clickOnUserMenu();
		Assert.assertTrue(abc.Overview.ViewsavedlotsButton());
		System.out.println("Passed : 'View Saved Lots' link is showing in the user menu.");
		
		Assert.assertTrue(abc.Overview.logoutButton());
		System.out.println("Passed : 'Logout' link is showing in the user menu.");
	}
	
	
	
}
