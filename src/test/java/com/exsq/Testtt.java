package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.base.TestBase.PageType;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class Testtt extends TestBase {

	String ISP_Type = prop.getProperty("ISP_Type");
	String url = prop.getProperty("url");

	@Test()
	public void PrintButtonVisiblity() {
		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
		Assert.assertTrue(abc.Overview.print_btn());
		System.out.println("Passed : Print button is showing in the footer.");
		
		//PrintModalWindowVisibility() {
		abc.Overview.print_btn_click();
		if (ISP_Type.contains("2")) {
			Assert.assertTrue(abc.Overview.print_modal_window());
			System.out.println("Passed : ISP 2.0 Print modal window is showing.");
		} else {
			abc.Overview.Generate_PDF_Btn_Clicked();
			Assert.assertTrue(abc.Overview.print_modal_window());
			System.out.println("Passed : ISP 3.0 GeoSpatial Print modal window is showing.");
		}
		//ClosePrintModalWindow() {
		abc.Overview.print_modal_Cancel_btn_Click();
		Assert.assertFalse(abc.Overview.print_modal_window());
		System.out.println("Passed : Print Modal window has been closed.");
	}
}
