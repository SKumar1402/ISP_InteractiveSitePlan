package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Community_Name_Visibility extends TestBase {
	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}

	@Test(priority = 1)
	public void Community_Name_Visibility_Header() {
		Assert.assertTrue(Overview.Community_Name_Header());
		System.out.println("Passed : Community Name has been verified in the Header.");
	}
	
	@Test(priority = 2)
	public void Community_Name_Visiblity_Footer() {
		Assert.assertTrue(Overview.Community_Name_Footer());
		System.out.println("Passed : Community Name has been verified in the Footer.");
	}
	
	 @AfterClass
	 public void CloseBrowser() {
		 driver.close();
	 }
	 
}
