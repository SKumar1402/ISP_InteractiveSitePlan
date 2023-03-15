package com.exsq;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Sanity_Preview extends TestBase {
	@BeforeClass
	public void setup() {

		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	@Test(priority=1)
	public void Check_Test() throws Throwable
	{
		
	}

}
