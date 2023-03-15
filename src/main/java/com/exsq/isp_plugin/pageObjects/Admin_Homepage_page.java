package com.exsq.isp_plugin.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exsq.isp_plugin.base.TestBase;

public class Admin_Homepage_page extends TestBase{
	
	public Admin_Homepage_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="ul.header-nav li:nth-child(6) > a")
	public WebElement Help;
	
	@FindBy (css="ul.header-nav li:nth-child(5) > a")
	public WebElement New_Home_Navigator;
	
	@FindBy (css="ul.header-nav li:nth-child(4) > a")
	public WebElement Manage_Users;
	
	@FindBy (css="ul.header-nav li:nth-child(3) > a")
	public WebElement Partner_Configuration;
	
	@FindBy (css="ul.header-nav li:nth-child(2) > a")
	public WebElement Manage_Partner_Users;
	
	@FindBy (css="ul.header-nav li:nth-child(1) >form > a")
	public WebElement Log_off;
	
	@FindBy (css="button[data-target='#partnerClientKeyModal']")
	public WebElement API_Key;
	
	@FindBy (css="div.page-header-btn-group button:nth-child(1)")
	public WebElement Manage_Communities;
	
	@FindBy (css="div.page-header-btn-group button:nth-child(2)")
	public WebElement Manage_Prospects;
	
	@FindBy (css="div.page-header-btn-group button:nth-child(3)")
	public WebElement Manage_Apps;
	
	@FindBy (css="div.page-header-btn-group button:nth-child(4)")
	public WebElement Navigator_Reports;
	
	@FindBy (css="select.community-status-filter")
	public WebElement Community_status_Filter_dropdown;
	
	@FindBy (css="div.searchbox input")
	public WebElement Community_Search_Box;
	
	@FindBy (css="div.search a.clear.disable")
	public WebElement Clear_Search_bth_disable;
	
	@FindBy (css="div.search a.clear:not(.disable)")
	public WebElement Clear_Search_bth_active;
	
	//********** Upload Section ***************************
	@FindBy (css="div.span3.nav-community-new:nth-child(1)  ul.nav-community li:nth-child(1) a")
	public WebElement Upload_SVGSitePlan_Link;
	
	@FindBy (css="div.span3.nav-community-new:nth-child(1)  ul.nav-community li:nth-child(2) a")
	public WebElement Upload_SitePlanData;
	
	@FindBy (css="div.span3.nav-community-new:nth-child(1)  ul.nav-community li:nth-child(3) a")
	public WebElement Upload_GeoJsonSitePlan;
	
	//********** Master Maps Section **********************
	
	@FindBy (css="div.span3.nav-community-new:nth-child(2)  ul.nav-community li:nth-child(1) a")
	public WebElement MasterMaps_UploadSVGMasterPlan;

	@FindBy (css="div.span3.nav-community-new:nth-child(2)  ul.nav-community li:nth-child(2) a")
	public WebElement MasterMaps_AssociateSVGMasterPlan;
	
	//*********** Preview Section ************************
	
	@FindBy (css="div.span3.nav-community-new:nth-child(3)  ul.nav-community li:nth-child(1) a")
	public WebElement Preview_SVGSiteOverview;
	
	@FindBy (css="div.span3.nav-community-new:nth-child(3)  ul.nav-community li:nth-child(2) a")
	public WebElement Preview_SVGSitePlan;
	
	
	@FindBy (css="div.span3.nav-community-new:nth-child(3)  ul.nav-community li:nth-child(3) a")
	public WebElement Preview_GeoSpatialSitePlan;
	
	//************* Action Section ***************************
	
	@FindBy (css="a#ActivevateCommunity[onclick='ActiveInactive(14088, 1);']")
	public WebElement Action_ActivateCommunity_link;
	
	@FindBy (css="a#ActivevateCommunity[onclick='ActiveInactive(14088, 2);']")
	public WebElement Action_InactivateCommunity_link;
	
	@FindBy (css="a#LockCommunity[onclick='LockUnlockCommunity(18122, true);']")
	public WebElement Action_LockCommunity_Link;
	
	@FindBy (css="a#LockCommunity[onclick=\"$('#lockModal').modal('show');")
	public WebElement Action_UnlockCommunity_Link;
	
	@FindBy (css="a[onclick='ExportlotData()']")
	public WebElement Action_ExportLotData_Link;
	
	//************************************************
	
	@FindBy (css="ul#optionsSelectTabs.nav-tabs:nth-child(3) li.active:nth-child(1) a")
	public WebElement ManageLot_active;
	
	@FindBy (css="ul#optionsSelectTabs.nav-tabs:nth-child(3) li:nth-child(2) a")
	public WebElement ISP_Configuration;
}
