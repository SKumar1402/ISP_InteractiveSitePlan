package com.exsq;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class Change_Community extends TestBase {
	String url = prop.getProperty("url");

	@Test(priority = 1)
	public void Verify_ChangeCommunityList() throws InterruptedException {

		AbstractComponents abc = new AbstractComponents(driver);
		abc.Overview = abc.navigateToURL(url);
		abc.Overview.clickOnChangeCommunityLink();
		Assert.assertTrue(abc.Overview.changeCommunityListVisibility());
		System.out.println("Passed : Change Community list visiblity has been verified.");

		// Verify_ActiveCommunity_List
		Assert.assertFalse(abc.Overview.checkCurrentCommunityNameInChangeCommunityList());
		System.out.println("Passed : Current selected community is not available in the change community list.");

		// Verify_SelectCommunityFromList
		Thread.sleep(1000);
		String CommunityNameBeforeChange = abc.Overview.getFirstCommunityNameFromChangeCommunityList();
		abc.Overview.selectFirstCommunityfromChangeCommunityList();
		Assert.assertEquals(CommunityNameBeforeChange, abc.Overview.communityNameFromFooter());
		System.out.println("Passed : Community name after change the community has been verified.");

	}

}
