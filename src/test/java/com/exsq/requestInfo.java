package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.base.TestBase.PageType;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class requestInfo extends TestBase {
	AbstractComponents abc;
	String url = prop.getProperty("url");
	String planName = prop.getProperty("planname");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}

	@Test(priority = 1)
	public void Request_Info_Btn_Visiblity() throws InterruptedException {
		Assert.assertTrue(abc.Overview.request_info_btn());
		System.out.println("Passed : Request Info button is showing in the footer.");
	}

	@Test(priority = 2)
	public void OpenRequestInfoForm() {
		abc.Overview.request_info_btn_click();
		Assert.assertTrue(abc.Overview.Request_Info_Visible());
		System.out.println("Passed : Requet Info button is clickable and Request Info form is visible.");
	}

	@Test(priority = 3)
	public void FillRequestInfoForm() {
		String firstName = prop.getProperty("First_Name");
		String lastName = prop.getProperty("Browser");
		String eMail = prop.getProperty("email");
		String phone = prop.getProperty("Phone");
		String zipCode = prop.getProperty("ZipCode");
		String Comments_Overview_Two = prop.getProperty("Comments_Overview_Two");
		abc.Overview.Fill_Request_Info_Form(firstName, lastName, eMail, phone, zipCode, Comments_Overview_Two);
		System.out.println("Passed : Request Info has been filled.");
	}

	@Test(priority = 4)
	public void SubmitRequestInfo() {
		abc.Overview.Send_Request_Click();
		System.out.println("Passed : 'Send Request' button has been clicked.");
	}

	@Test(priority = 5)
	public void LoaderVisibility() {
		Assert.assertTrue(abc.Overview.Loading_Loader());
		System.out.println("Passed : After Submit the 'Request Info' form, Loader is showing.");
	}

	@Test(priority = 6)
	public void SuccessPopupVisibility() {
		Assert.assertTrue(abc.Overview.ri_Success_Popup_hide());
		System.out.println("Passed : Request Info success pop up has been verified..");

	}

	@Test(priority = 7)
	public void SuccessPopUpClose() throws InterruptedException {
		abc.Overview.Great_Lets_Continue_btn_click();
		Thread.sleep(1000);
		Assert.assertFalse(abc.Overview.ri_Success_Popup_hide());
		System.out.println("Passed : Request Info success pop up has been closed.");
	}

}
