package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class ExpendedView_inListing extends TestBase {
	String ISP_Type = prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	@Test(priority = 0)
	public void RequestInfo_Visiblity_inListing() {
		if (ISP_Type.contains("Overview")) {
			Overview.First_Plan_in_Listing();
			Assert.assertTrue(Overview.Request_Info_FirstListing());
			System.out.println("Passed : Request Info button is showing in the expended view in listing.");
		} else {
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}
	
	@Test(priority = 1)
	public void ExpendView_Visiblity_inListing() {
		if (ISP_Type.equals("Overview_2") || ISP_Type.equals("Overview_3")) {
			Assert.assertTrue(Overview.Expent_View_FirstListing());
			System.out.println("Expend View is showing in the listing.");
		} else {
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}
	
	 @AfterClass
	 public void CloseBrowser() {
		 driver.close();
	 }
	 
}
