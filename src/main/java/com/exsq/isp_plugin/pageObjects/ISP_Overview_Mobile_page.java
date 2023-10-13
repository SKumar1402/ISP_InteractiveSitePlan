package com.exsq.isp_plugin.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exsq.isp_plugin.base.TestBase;

public class ISP_Overview_Mobile_page extends TestBase{
	
	public ISP_Overview_Mobile_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Listing expended in 2.0 ISP
	@FindBy (css="aside.isp-right-sidebar[style] a.isp-arrowslide-up")
	private WebElement Two_Listing_Expended;
	
	@FindBy (css="aside.isp-right-sidebar[style='z-index: 7;'] a.isp-arrowslide-down")
	private WebElement Two_LightGallery_Opened;
	
	@FindBy (css="section.isp-main-footer[style='bottom: 0px;']")
	private WebElement Three_Footer_Show;
	
	@FindBy (css="section.isp-main-footer[style='bottom: -6px;']")
	private WebElement Three_Footer_Hide;
	
	@FindBy (css="a#isp-listing-expand.isp-arrowslide.isp-arrowslide-up")
	private WebElement Three_Listing_Collapsed;
	
	@FindBy (css="a#isp-listing-expand.isp-arrowslide.isp-arrowslide-down")
	private WebElement Three_Listing_Expended;
	
	@FindBy (css="div#isp-print-mobile-div a#isp-open-pdf")
	private WebElement Open_Print_PDF;
	
	@FindBy (css="div.isp-modal-footer button#isp-print-close")
	private WebElement Print_Modal_Cancel_Btn;
	
	@FindBy (css="svg.print-btn-svg")
	private WebElement Print_Btn;
}
