package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Print extends TestBase{
	String ISP_Type = prop.getProperty("ISP_Type");

	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	@Test(priority=0)
	public void Print_Btn_Visiblity() {
		Assert.assertTrue(Overview.print_btn());
		System.out.println("Passed : Print button is showing in the footer.");
	}
		
	@Test(priority=1)
	public void Print_ModalWindow_Visibility() {
		Overview.print_btn_click();
		if(ISP_Type.contains("2"))
		{
		Assert.assertTrue(Overview.print_modal_window());
		System.out.println("Passed : ISP 2.0 Print modal window is showing.");
		}else {
			Overview.Generate_PDF_Btn_Clicked();
			Assert.assertTrue(Overview.print_modal_window());
			System.out.println("Passed : ISP 3.0 GeoSpatial Print modal window is showing.");
		}
	}

	@Test(priority = 3)
	public void Close_Print_ModalWindow() throws InterruptedException {
		Thread.sleep(1000);
		Overview.print_modal_Cancel_btn_Click();
		Assert.assertFalse(Overview.print_modal_window());
		System.out.println("Passed : Print Modal window has been closed.");
	}
}
