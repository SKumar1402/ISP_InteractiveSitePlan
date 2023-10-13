package com.exsq;

import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Android1 extends TestBase{
	
	@Test
	public void TestChrome() throws InterruptedException {

		Thread.sleep(20000);
		System.out.println("ISP plugin loaded.");
		//driver.findElement(By.cssSelector("aside[style=\"bottom: -203px;\"] a.isp-arrowslide-up")).click();
		Overview.Select_SinglePlanAssigned_Lot();
}	
}
