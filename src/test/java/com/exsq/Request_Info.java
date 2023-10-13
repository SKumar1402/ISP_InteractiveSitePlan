package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Request_Info extends TestBase {
	String url = prop.getProperty("url");

	@Test(priority=0)
	public void Request_Info_Btn_Visiblity() throws InterruptedException {
		String planName= prop.getProperty("planname");
		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
		Assert.assertTrue(abc.Overview.request_info_btn());
		System.out.println("Passed : Request Info button is showing in the footer.");
		//Open Request Info Form
		abc.Overview.request_info_btn_click();
		Assert.assertTrue(abc.Overview.Request_Info_Visible());
		System.out.println("Passed : Requet Info button is clickable and Request Info form is visible.");
	
		//Fill_Request_Info_Form(String firstName, String lastName, String eMail, String phone, String zipCode, String Comments_Overview_Two) {
		String firstName=prop.getProperty("First_Name");
		String lastName=prop.getProperty("Browser");
		String eMail=prop.getProperty("email");
		String phone=prop.getProperty("Phone");;
		String zipCode=prop.getProperty("ZipCode");
		String Comments_Overview_Two=prop.getProperty("Comments_Overview_Two");
		System.out.println("First Name is : "+firstName);
		abc.Overview.Fill_Request_Info_Form(firstName, lastName, eMail, phone, zipCode, Comments_Overview_Two);
		System.out.println("Passed : Request Info has been filled.");
		//Submit_Request_Info() {
		abc.Overview.Send_Request_Click();
		System.out.println("Passed : 'Send Request' button has been clicked.");
		//Loader Visibility
		Assert.assertTrue(abc.Overview.Loading_Loader());
		System.out.println("Passed : After Submit the 'Request Info' form, Loader is showing.");
		
		//Success Pop up Visibility
		Assert.assertTrue(abc.Overview.ri_Success_Popup_hide());
		System.out.println("Passed : Request Info success pop up has been verified..");
		
		//Success Pop Up Close
		abc.Overview.Great_Lets_Continue_btn_click();
		System.out.println("******453464***************");
		Thread.sleep(2000);
		Assert.assertFalse(abc.Overview.ri_Success_Popup_hide());
		System.out.println("Passed : Request Info success pop up has been closed.");
		
		//Request Info Visibility Expend View in Listing
		String ISP_Type = prop.getProperty("ISP_Type");
		if (ISP_Type.equals("Overview_2") || ISP_Type.equals("Overview_3")) {
			abc.Overview.selectPlanFromListing(planName);
			Assert.assertTrue(abc.Overview.Request_Info_FirstListing());
			System.out.println("Passed : Request Info button is showing in the expended view in listing.");
		} else {
			System.out.println("Plan Listing (Right Panel) is not showing.");
		}
	}	 
}
