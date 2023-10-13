package com.exsq.isp_plugin.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exsq.isp_plugin.base.TestBase;

public class UUPLoginSignUp extends TestBase{

	public UUPLoginSignUp(WebDriver driver)
	{
		TestBase.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Login button from header 
	@FindBy (css="div#isp-login-btn-div a#isp-account-login")
	private WebElement Login_btn;
	
	@FindBy (css="div#isp-login-btn-div a#isp-create-account")
	private WebElement Signup_btn;
	
	@FindBy (css="a#isp-profile-drpdwn span#firstName")
	private WebElement Logged_in_username;
	
	@FindBy (css="a#viewSavedLotsBtn")
	private WebElement Viewsavedlots_btn;
	
	@FindBy (css="isp-account-logout")
	private WebElement Logout_btn;
	
	@FindBy (css="a#isp-save-btn.disabled")
	private WebElement Savelot_btn_inactive;
	
	@FindBy (css="a#isp-save-btn:not(.disabled)")
	private WebElement Savelot_btn_active;
	
	@FindBy (css="button#isp-ok-btn")
	private WebElement LotSavedsuccesspopup_Ok_btn;
	
	@FindBy (css="input#ispSaveLotText")  
	private WebElement Savelotnametextfield;
	
	@FindBy (css="button#isp-save-lot-btn")
	private WebElement LotSave_btn;
	
	@FindBy (css="section#isp-saved-homesite:not(.isp-hide) div.isp-saved-home-inner")
	private WebElement Savedlotsection;
	
	@FindBy (css="a#isp-ri-cross")
	private WebElement Savedlotsection_closeicon;
	
	@FindBy (css="section.isp-lot-card a.isp-delete-saved")
	private WebElement Savedlotdeleteicon;
	
	@FindBy (css="div#isp-delete-lot-modal div.isp-save-lot-inner")
	private WebElement Deletethislotpopup ;
	
	@FindBy (css="div#isp-delete-lot-modal button#isp-delete-cancel")
	private WebElement Deletethislotpopup_cancelbtn ;
	
	@FindBy (css="div#isp-delete-lot-modal button#isp-delete-ok")
	private WebElement Deletelotbtn ;
	
	public boolean Login_btn() {
		return Login_btn.isDisplayed();
	}
		
}

