package com.exsq;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.exsq.isp_plugin.base.TestBase;

public class Change_Community extends TestBase {
	
	@BeforeClass
	public void setup() {
		LaunchBrowser();
		open_URL();
		Initialization();
	}
	
	 @Test(priority=1) 
	 public void Verify_ChangeCommunityList() throws InterruptedException {
		 Thread.sleep(5000);
		 Overview.Change_Community();
		 Assert.assertTrue(Overview.Change_Community_List());
		 System.out.println("Passed : Change Community list has been verified.");
	}
	 
	 @Test(priority=2) 
	 public void Verify_ActiveCommunity_List() throws InterruptedException {
		 Assert.assertFalse(Overview.Check_ChangeCommunity_List());
		 System.out.println("Passed : Current selectec community name is not available in the list.");
	}
	 
	 @Test(priority=3) 
	 public void Verify_SelectCommunityFromList() throws InterruptedException {
		 Thread.sleep(1000);
		 String FirstCommunity_Text=Overview.ChangeCommunity_FirstCommunity_GetText();
		 Overview.ChangeCommunity_FirstCommunity();
		 Assert.assertEquals(FirstCommunity_Text, Overview.Community_Name_Footer_GetText());
		 System.out.println("Passed : Community name after change the community has been verified.");
	}
	 @AfterClass
	 public void CloseBrowser() {
		 driver.close();
	 }
	 
}
