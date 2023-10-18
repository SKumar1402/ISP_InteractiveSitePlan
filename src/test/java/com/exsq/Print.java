package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Print extends TestBase {
	AbstractComponents abc;
	String ISP_Type = prop.getProperty("ISP_Type");
	String url = prop.getProperty("url");

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
	}

	@Test(priority = 0)
	public void Print_Btn_Visiblity() {
		Assert.assertTrue(abc.Overview.print_btn());
		System.out.println("Passed : Print button is showing in the footer.");
	}

	@Test(priority = 1)
	public void PrintModalWindowVisibility() {
		abc.Overview.print_btn_click();
		if (ISP_Type.contains("2")) {
			Assert.assertTrue(abc.Overview.print_modal_window());
			System.out.println("Passed : ISP 2.0 Print modal window is showing.");
		} else {
			abc.Overview.Generate_PDF_Btn_Clicked();
			Assert.assertTrue(abc.Overview.print_modal_window());
			System.out.println("Passed : ISP 3.0 GeoSpatial Print modal window is showing.");
		}
	}

	@Test(priority = 2)
	public void ClosePrintModalWindow() {
		abc.Overview.print_modal_Cancel_btn_Click();
		Assert.assertFalse(abc.Overview.print_modal_window());
		System.out.println("Passed : Print Modal window has been closed.");
	}
}
