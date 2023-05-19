package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Request_Info extends TestBase {
	String ISP_Type = prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}

	@Test(priority=0)
	public void Request_Info_Btn_Visiblity() {
		Assert.assertTrue(Overview.request_info_btn());
		System.out.println("Passed : Request Info button is showing in the footer.");
	}
	
	@Test(priority=1)
	public void Open_RequestInfo_Form() {
		Overview.request_info_btn_click();
		Assert.assertTrue(Overview.Request_Info_Visible());
		System.out.println("Passed : Requet Info button is clickable and Request Info form is visible.");
	}
	
	
	@Test(priority=2)
	public void Fill_Request_Info_Form() {
		Overview.Fill_Request_Info_Form();
		System.out.println("Passed : Request Info has been filled.");
	}
	
	@Test(priority=3)
	public void Submit_Request_Info() {
		Overview.Send_Request_Click();
		System.out.println("Passed : 'Send Request' button has been clicked.");
	}
	
	@Test(priority=4)
	public void Loader_Visiblity() {
		Assert.assertTrue(Overview.Loading_Loader());
		System.out.println("Passed : After Submit the 'Request Info' form, Loader is showing.");
	}
	
	@Test(priority=5)
	public void Success_Popup_Visibility() {
		Assert.assertTrue(Overview.ri_Success_Popup_hide());
		System.out.println("Passed : Request Info success pop up has been verified..");
	}
	
	@Test(priority = 6)
	public void Success_PopUp_Close() throws Throwable {
		Overview.Great_Lets_Continue_btn_click();
		Thread.sleep(2000);
		Assert.assertFalse(Overview.ri_Success_Popup_hide());
		System.out.println("Passed : Request Info success pop up has been closed.");
	}
	
	@Test(priority = 7)
	public void RequestInfo_Visiblity_ExpendView_inListing() {
		if (ISP_Type.equals("Overview_2") || ISP_Type.equals("Overview_3")) {
			Overview.First_Plan_in_Listing();
			Assert.assertTrue(Overview.Request_Info_FirstListing());
			System.out.println("Passed : Request Info button is showing in the expended view in listing.");
		} else {
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}
	
	 @AfterClass
	 public void CloseBrowser() {
		 driver.close();
	 }
	 
}
