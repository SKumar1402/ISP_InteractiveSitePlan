package com.exsq;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import AbstractComponents.AbstractComponents;

public class changeCommunityHeaderFooter extends TestBase {
	String url = prop.getProperty("url");
	AbstractComponents abc;

	@BeforeTest
	public void createObject() {
		abc = new AbstractComponents(driver);
		abc.Overview = (ISP_Overview) abc.navigateToURL(url, PageType.ISPOverview);
	}

	@Test(priority = 1)
	public void Verify_ChangeCommunityList() throws InterruptedException {
		abc.Overview.clickOnChangeCommunityLink();
		Assert.assertTrue(abc.Overview.changeCommunityListVisibility());
		System.out.println("Passed : Change Community list visiblity has been verified.");
	}
	
	@Test (priority=2)
	public void VerifyActiveCommunityList(){
	Assert.assertFalse(abc.Overview.checkCurrentCommunityNameInChangeCommunityList());
	System.out.println("Passed : Current selected community is not available in the change community list.");
}
	@Test(priority = 3)
	public void Verify_SelectCommunityFromList() throws InterruptedException {
		Thread.sleep(1000);
		String CommunityNameBeforeChange = abc.Overview.getFirstCommunityNameFromChangeCommunityList();
		abc.Overview.selectFirstCommunityfromChangeCommunityList();
		Assert.assertEquals(CommunityNameBeforeChange, abc.Overview.communityNameFromFooter());
		System.out.println("Passed : Community name after change the community has been verified.");
	}
}
