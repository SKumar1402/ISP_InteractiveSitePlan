package com.exsq.isp_plugin.pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exsq.isp_plugin.base.TestBase;

public class ISP_Overview extends TestBase {
	
	public ISP_Overview(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	Actions action = new Actions(driver);
	
	String element="";
	String First_Name=prop.getProperty("First_Name");
	String Last_Name=prop.getProperty("Browser");
	String Email=prop.getProperty("Email");
	String Phone=prop.getProperty("Phone");
	String ZipCode=prop.getProperty("ZipCode");
	String Card_Number=prop.getProperty("Card_Number");
	String Comments_Overview_Two=prop.getProperty("Comments_Overview_Two");
	String Comments_Overview_Three=prop.getProperty("Comments_Overview_Three");
	String Comments_Preview_Two=prop.getProperty("Comments_Preview_Two");
	String Comments_Preview_Three=prop.getProperty("Comments_Preview_Three");
	String Config=prop.getProperty("Config");
	public String PlanDetail_Slider_Minimum=prop.getProperty("Slider_Min");
	public String Filter_Option_BackgroundColor=prop.getProperty("Filter_Option_BackgroundColor");
	public String SVG_Zoomed_in_Expected=prop.getProperty("SVG_Zoomed_in");
	public String SinglePlanAssigned=prop.getProperty("SinglePlanAssigned");
	public String MultiPlanAssigned=prop.getProperty("MultiPlanAssigned");
	public String OthersPlanInThisCommunity=prop.getProperty("OthersPlanInThisCommunity");
		
	//*****************Kenley community************
	//Lot has lot Id
	
	@FindBy (css="path#Lot_168")
	public WebElement SinglePlanAssigned_2;
	
	//Lot has lot address
	@FindBy (css="path#Lot_169")
	public WebElement TwoPlansAssignedLot_2;
	
	//*****************King's Grant community************
	//Lot has lot Id
	@FindBy (css="path#Lot_13")
	public WebElement SinglePlanAssigned_3;
	
	//Lot has lot address
	@FindBy (css="path#Lot_14")
	public WebElement TwoPlansAssignedLot_3;

	//*********************************************
	
	@FindBy (css="div#isp-skeleton")
	public WebElement ISP_Skeleton;
	
	@FindBy (css="section.isp-top-bar:not(.isp-hide) div.logo")
	private WebElement Builder_Logo;
	
	//Spec Home Key
	@FindBy (css="span.isp-key-icon:not(.isp-hide)")
	private WebElement Spec_Home_Key;
	
	//List of total selected lots after click on plan from listing
	@FindBy (css="[style=\"cursor: pointer; stroke-width: 5; stroke: rgb(255, 0, 51);")
	private WebElement Total_Seleted_Lots;
	
	//1st Plan in the listing
	@FindBy (css="section#ispallplanslist div.isp-plan-card:nth-child(1)")
	private WebElement First_Plan_in_Listing;
	
	//Plan detail card > Light Gallery Image 
	@FindBy (css="section#ispallplanslist div.isp-plan-card:nth-child(1) figure.galleryEffect")
	private WebElement First_Listing_LightGallery_Image;
	
	//Light Gallery > 1st Image from the light gallery listing
	@FindBy (css="div.lg-thumb-item.active")
	private WebElement Light_Gallery_Image;
	
	//Light Gallery close icon
	@FindBy (css="span.lg-close.lg-icon")
	private WebElement Light_Gallery_CloseIcon;
	
	//Request Info Success pop up hide
	@FindBy (css="section#isp-request-info-success:not(.isp-hide)")
	private WebElement ri_Success_Popup_hide;
		
	//Request Info button from 1st listing
	@FindBy (css="section#ispallplanslist div.isp-plan-card:nth-child(1) a#isp-plan-request-info")
	private WebElement Request_Info_FirstListing;
	
	//Expend View  button from 1st listing
	@FindBy (css="section#ispallplanslist div.isp-plan-card:nth-child(1) a.exapnd-view")
	private WebElement Expent_View_FirstListing;
	
	//List of total specs available in the listing
	@FindBy (css="div.isp-plan-card span#isp-spec-Banner[style='background-color: rgb(128, 128, 128); color: rgb(255, 255, 255); opacity: 1;']")
	private WebElement Total_Spec_List;
	
	//List of community from Change Community list
	@FindBy (css="li.isp-otherCommunity")
	private WebElement Total_Other_Communities;
		
	//Master map button
	@FindBy (css="a#isp-master-plan-btn")
	private WebElement masterMap_btn;
	
	//Print button
	@FindBy (css="a#isp-print-btn")
	private WebElement print_btn;
	
	//Print modal window
	@FindBy (css="section#isp-print-modal:not(.isp-hide)>div.isp-modal-inner")
	private WebElement print_modal_window;
	
	//Print modal window Header
	@FindBy (css="section#isp-print-modal  div.isp-modal-header")
	private WebElement print_modal_Header;
	
	//print modal window body
	@FindBy (css="section#isp-print-modal  div.isp-modal-body")
	private WebElement print_modal_window_body;
	
	//Print modal window Cancel button
	@FindBy (css="section#isp-print-modal  div.isp-modal-footer button")
	private WebElement print_modal_Cancel_btn;
	
	//Request info button
	@FindBy (css="a#isp-request-info-btn")
	private WebElement request_info_btn_Footer;
	
	//Request info First Name text field
	@FindBy (css="input#isp-ri-fname")
	private WebElement Request_info_First_Name;
	
	//Request info Last Name text field
	@FindBy (css="input#isp-ri-lname")
	private WebElement Request_info_Last_Name;
	
	//Request info Email text field
	@FindBy (css="input#isp-ri-email")
	private WebElement Request_info_Email;
	
	//Request info Phone Number text field
	@FindBy (css="input#isp-ri-phone")
	private WebElement Request_info_Phone;
	
	//Request info Zipcode text field
	@FindBy (css="input#isp-ri-zip")
	private WebElement Request_info_Zip;
	
	//Request info Comments text field
	@FindBy (css="textarea#isp-ri-comments")
	private WebElement Request_info_Comments;
	
	//Request info Send Request button
	@FindBy (css="input#isp-ri-submit")
	private WebElement Send_Request;
	
	//*************************HOLD A LOT**********************
	//Hold a Lot > First Name text field
	@FindBy (css="input#isp-hold-lot-fname")
	private WebElement HL_FirstName;
	
	//Hold a Lot > Last Name text field
	@FindBy (css="input#isp-hold-lot-lname")
	private WebElement HL_LastName;
	
	//Hold a Lot > Phone Number text field
	@FindBy (css="input#isp-hold-lot-phone")
	private WebElement HL_PhoneNumber;
	
	//Hold a Lot > Email text field
	@FindBy (css="input#isp-hold-lot-email")
	private WebElement HL_Email;
	
	//Hold a Lot > Comments text field
	@FindBy (css="textarea#isp-hold-lot-comments")
	private WebElement HL_Comment;
	
	//Hold a Lot form cancel button
	@FindBy (css="a#isp-hold-lot-close")
	private WebElement HL_Cancel_btn;
	
	//Hold a Lot Form > Continue to Payment button
	@FindBy (css="input#isp-hold-lot-submit")
	private WebElement Continue_Payment_btn;
	
	//Checkout Form > Reservation for value
	@FindBy (css="div.lot-price-info div:nth-child(1) span")
	private WebElement Checkout_request_Lot;
	
	//Checkout Form > Reservation Fee Due 
	@FindBy (css="div.lot-price-info div:nth-child(2) span")
	private WebElement Checkout_ReservationFee;
	
	//Checkout Form > Card Number text field
	@FindBy (css="input#Field-numberInput")
	private WebElement Checkout_CardNumber;
	
	//Checkout Form > Expiration date
	@FindBy (css="input#Field-expiryInput")
	private WebElement Checkout_Expiration;
	
	//Checkout Form > CVC number text field
	@FindBy (css="input#Field-cvcInput")
	private WebElement Checkout_CVC;
	
	//Checkout Form > Terms and Conditions check box
	@FindBy (css="div.isp-hold-lot-payment-terms input")
	private WebElement Checkout_Checkbox;
	
	//Checkout Form > 'Submit Reservtion' disabled button
	@FindBy (css="button#paymentSubmit.disabled")
	private WebElement Checkout_Submit_Btn_disable;
	
	//Checkout Form > 'Submit Reservtion' active button
	@FindBy (css="button#paymentSubmit:not(.disabled)")
	private WebElement Checkout_Submit_Btn_active;
	
	//Checkout Form > Loader after submit the form
	@FindBy (css="div#loader-caption-message")
	private WebElement Checkout_Submit_Loader;
	
	//Payment Success pop up Status
	@FindBy (css="transaction-status-header")
	private WebElement Payment_Success_Status;
	
	//Payment Success pop up close button
	@FindBy (css="a#isp-hold-lot-close-btn")
	private WebElement Payment_Success_Popup_Close_btn;
	
	//Lot Detail pop up > Header > Homesite name
	@FindBy (css="h3#isp-homesite-name")
	private WebElement Detail_Popup_Homesite_Name;
	
	//Homesite Status button
	@FindBy (css="span#isp-homesite-filter-title")
	private WebElement Homesite_Status_Filter_button;
	
	//Homesite Status filter dropdown/pop up
	@FindBy (css="div#isp-status-dropdown")
	private WebElement Homesite_StatusFilter_Dropdown;
	
	//Homesite Status Filter Apply button
	
	@FindBy (css="div.isp-status-buttons a:nth-child(2)")
	private WebElement Homesite_Status_Apply_btn;
	
	//Homesite Status Filter Clear button
	@FindBy (css="div.isp-status-buttons a:nth-child(1)")
	private WebElement Homesite_Status_Clear_btn;
	
	//Homesite Status Filter pop up Close button 
	@FindBy (css="a#isp-close-refine-button")
	private WebElement Homesite_Status_Close_btn;
	
	//Loading... Loader 
	@FindBy (css="div.media-loader-outer div#loader-caption")
	public WebElement Loading_Loader;
	
	//Loading... Loader When Transaction gets completed.
	@FindBy (css="div.media-loader-outer div#loader-caption-message")
	private WebElement Loading_Loader_Transaction;
	
	//Request Info success pop up 'Great! Let's continue' button
	@FindBy (css="section.alert-modal:not(.isp-hide) a#isp-ri-success-btn")
	private WebElement Great_Lets_Continue_btn;
	
	//Homesite Status's dropdown list
	@FindBy (css="div.isp-refine-dropdown.show")
	private WebElement Homesite_Status_list;
	
	//Homesite status list filter reset button
	@FindBy (css="a#isp-reset-homesite-filter")
	private WebElement Homesite_Status_Filter_Reset;
	
	//Homesite status filter apply button
	@FindBy (css="a#isp-apply-homesite-filter")
	private WebElement Homesite_Status_Filter_Apply;
	
	//Homesite status dropdown close button
	@FindBy (css="a#isp-close-refine-button")
	private WebElement homesite_Status_dropdown_close_button;
	
	//Homesite status's name in the drop down list
	@FindBy (css="ul.isp-homesite-status li label span")
	private List<WebElement> Homesite_status_Name_List;
	
	//Homesite status's name checkbox list in the drop down
	@FindBy (css="ul.isp-homesite-status li label input")
	private List<WebElement> Homesite_status_checkbox_List;
	
	//Homesite status name's status colors list in the drop down
	@FindBy (css="span.isp-status-color")
	private List<WebElement> Homesite_status_colors_List;
	
	//Plan details filter button
	@FindBy (css="button#filter-btn")
	private WebElement Plan_details_Filter_btn;
	
	//Community from bottom
	@FindBy (css="h3#isp-community-name")
	private WebElement Community_Name_Bottom;
	
	//Community from bottom
	@FindBy (css="h3#ispCommName")
	private WebElement Community_Name_top;	
	
	//Available Home Site link from listing
	@FindBy (css="div#isp-lot-list-div:not(.isp-hide) div.isp-lot-list-toggle")
	private WebElement Available_HomeSite_Link;
	
	//Cypress Plan Request Info button
	@FindBy (css="div#isp-community-home_208667 a#isp-plan-request-info")
	private WebElement Cypress_Plan_RequestInfo_button;
	
	//Hold a Lot button from the lot details pop up
	@FindBy (css="a#isp-hold-lot-btn:not(.isp-hide)")
	private WebElement Hold_A_Lot_btn;
	
	//Community name from the header
	@FindBy (css="h3#ispCommName")
	private WebElement Community_Name_Header;
	
	//Community name from the footer
	@FindBy (css="div.isp-footer-community h3")
	public WebElement Community_Name_Footer;
	
	//ISP Plan Price List
	@FindBy (css="span#ispPrice")
	private List<WebElement> Plan_Price_List;
	
	//ISP Plan Listing Header text
	@FindBy (css="li#allPlansTabHead a")
	private WebElement Listing_Header_text;
	
	//Listing > Plan Names > Available Plans on this Homesite
	@FindBy (css="section#ispAvailablePlansList div.isp-plan-card h2")
	private List<WebElement> Listing_AvailablePlansOnThisHomesite;
	
	//Listing > Right Panel
	@FindBy (css="div#ispContainer aside.isp-right-sidebar")
	private WebElement Right_Panel;
	
	//Plan Details > Filter > Slider > Minimum
	@FindBy (css="div#slider-distance span:nth-child(4)")
	public WebElement PlanDetail_Slider_Min;
	
	//Plan Detail Filter Option section
	@FindBy (css="section#ispFilterOptions")
	private WebElement PlanDetails_Option_Section;
	
	//Plan Details > Bedroom Filter > Bedroom 3
	@FindBy (css="div.isp-form-group:nth-child(3) div.isp-select-options label:nth-child(2)")
	private WebElement PlanDetails_BedroomThree;
	
	//SVG Zoom slider
	@FindBy (css="div.isp-slidecontainer input")
	private WebElement SVG_ZoomSlider;
	
	//SVG 
	@FindBy (css="div#svgContainer svg")
	private WebElement SVG;
	
	//Available Plans on the selected Lot
	@FindBy (css="a#isp-tab1-header")
	private WebElement Available_Plan_on_Lot;
	
	//Others Plan in This Community
	@FindBy (css="li#allPlansTabHead a")
	private WebElement All_Available_Plan;
	
	//Lot Detail pop up close icon 'X'
	@FindBy (css="button#isp-closeModel")
	private WebElement LotDetailPopUp_Close_icon;
	
	//Lot Detail Pop Up
	@FindBy (css="div#isp-modaldialog")
	private WebElement LotDetailPopUp;
	
	// Lot Size Value
	@FindBy(css = "span#isp-size-val")
	public WebElement LotSize_Value;

	// Lot Block Value
	@FindBy(css = "span#isp-block-val")
	public WebElement LotBlock_Value;

	// Lot Face Value
	@FindBy(css = "span#isp-phase-val")
	public WebElement LotPhase_Value;

	// Lot Swing Value
	@FindBy(css = "span#isp-swing-val")
	public WebElement LotSwing_Value;

	// Lot Elevation Value
	@FindBy(css = "span#isp-elevation-val")
	public WebElement LotElevation_Value;

		
	public boolean masterMap_btn()
	{
		boolean elementStatus=masterMap_btn.isDisplayed();
		return elementStatus;
	}
	
	public void masterMap_btn_click()
	{
		masterMap_btn.click();
	}
	
	public boolean print_btn()
	{
		boolean elementStatus=print_btn.isDisplayed();
		return elementStatus;
	}
	
	public void print_btn_click()
	{
		print_btn.click();
	}
	
	public boolean request_info_btn()
	{
		boolean elementStatus=request_info_btn_Footer.isDisplayed();
		return elementStatus;
	}
	
	public void request_info_btn_click()
	{
		request_info_btn_Footer.click();
	}
	
	public void Request_info_First_Name_send() {
		Request_info_First_Name.sendKeys(First_Name);
	}
	
	public void Request_info_Last_Name_send() {
		if(Last_Name.equals("Chrome"))
		{
			Request_info_Last_Name.sendKeys(Last_Name);
		}else if(Last_Name.equals("FireFox"))
		{
			Request_info_Last_Name.sendKeys(Last_Name);
		}else if(Last_Name.equals("Edge"))
		{
			Request_info_Last_Name.sendKeys(Last_Name);
		}
	}
	
	public void Request_info_Email_send()
	{
		Request_info_Email.sendKeys(Email);
	}
	
	public void Request_info_Phone_Send()
	{
		Request_info_Phone.sendKeys(Phone);
	}
	
	public void Request_info_Zip_Send()
	{
		Request_info_Zip.sendKeys(ZipCode);
	}
	
	public void Request_info_Comments_Send()
	{
		String Type = prop.getProperty("ISP_Type");
		if(Type.equals("Overview_2"))
    	{
			Request_info_Comments.sendKeys(Comments_Overview_Two);
    	}else if(Type.equals("Preview_2")) 
    	{
    		Request_info_Comments.sendKeys(Comments_Preview_Two);
    	}else if(Type.equals("Overview_3")) 
    	{
    		Request_info_Comments.sendKeys(Comments_Overview_Three);
    	}else if(Type.equals("Preview_3")) 
    	{
    		Request_info_Comments.sendKeys(Comments_Preview_Three);
    	}
	}
	
	public void Send_Request_Click()
	{
		Send_Request.click();
	}
	
	public void Great_Lets_Continue_btn_click()
	{
		Great_Lets_Continue_btn.click();
	}
	
	public boolean Great_Lets_Continue_btn() {
		boolean elementStatus = Great_Lets_Continue_btn.isDisplayed();	
		return elementStatus;
	}
	
	public boolean print_modal_window()
	{
		try {
			print_modal_window.isDisplayed();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public boolean print_modal_Cancel_btn()
	{
		boolean elementStatus=print_modal_Cancel_btn.isDisplayed();
		return elementStatus;
	}
	
	public void print_modal_Cancel_btn_Click()
	{
		print_modal_Cancel_btn.click();
	}
	
	public void Homesite_Status_Filter_button()
	{
		Homesite_Status_Filter_button.click();
	}
	
	public boolean Homesite_StatusFilter_Dropdown()
	{
		boolean elementStatus=Homesite_StatusFilter_Dropdown.isDisplayed();
		return elementStatus;
	}
	
	public boolean Homesite_Status_Apply_btn_show()
	{
		boolean elementStatus=Homesite_StatusFilter_Dropdown.isDisplayed();
		return elementStatus;
	}
	
	public void Homesite_Status_Apply_btn_click()
	{
		Homesite_Status_Apply_btn.click();
	}
	
	public void Homesite_Status_Clear_btn_click()
	{
		Homesite_Status_Clear_btn.click();
	}
	
	public void Homesite_Status_Close_btn_click()
	{
		Homesite_Status_Close_btn.click();
	}
		
	public boolean Community_Name_Header()
	{
		boolean elementStatus=Community_Name_Header.isDisplayed();
		return elementStatus;
	}
	
	public boolean Community_Name_Footer()
	{
		boolean elementStatus=Community_Name_Footer.isDisplayed();
		return elementStatus;
	}
	
	public void HoldALot_First_Name_send() {
		HL_FirstName.sendKeys(First_Name);
	}
	
	public void HoldALot_Last_Name_send() {
		if(Last_Name.equals("Chrome"))
		{
			HL_LastName.sendKeys(Last_Name);
		}else if(Last_Name.equals("FireFox"))
		{
			HL_LastName.sendKeys(Last_Name);
		}else if(Last_Name.equals("Edge"))
		{
			HL_LastName.sendKeys(Last_Name);
		}
	}
	
	public void HoldALot_Phone_send()
	{
		HL_PhoneNumber.sendKeys(Phone);
	}
	
	public void HoldALot_Email_send()
	{
		HL_Email.sendKeys(Email);
	}
	
	public void HoldALot_ContinueToPayment()
	{
		Continue_Payment_btn.click();
	}
	
	
	public void Select_SinglePlanAssigned_Lot()
	{
		String Type=prop.getProperty("ISP_Type");
		if(Type.equals("Overview_2") || Type.equals("Preview_2"))
		{
			action.moveToElement(SinglePlanAssigned_2).click().perform();
		}else if(Type.equals("Preview_3") || Type.equals("Overview_3")) 
		{
			action.moveToElement(SinglePlanAssigned_3).click().perform();
		}
	}
	
	public void Select_TwoPlansAssigned_Lot()
	{
		String Type=prop.getProperty("ISP_Type");
		if(Type.equals("Overview_2") || Type.equals("Preview_2"))
		{
			action.moveToElement(TwoPlansAssignedLot_2).click().perform();
		}else if(Type.equals("Preview_3") || Type.equals("Overview_3")) 
		{
			action.moveToElement(TwoPlansAssignedLot_3).click().perform();
		}
	}
		
	public void HoldALot_btn_click()
	{
		Hold_A_Lot_btn.click();
	}
		
	public String Detail_Popup_Header() {
		String element=Detail_Popup_Homesite_Name.getText();
		return element;
	}
	
	public String Detail_Popup_Homesite_Name()
	{
		String[] Homesite_Status=Detail_Popup_Homesite_Name.getText().split("/");
		return Homesite_Status[1];
	}
	
	public String Lot_id()
	{
		String[] Homesite_Status=Detail_Popup_Homesite_Name.getText().split("/");
		String Lot_id=Homesite_Status[0];
		return Lot_id;
	}
	
	public String Lot_Number()
	{
		String[] Homesite_Status=Detail_Popup_Homesite_Name.getText().split("/");
		String Lot_id=Homesite_Status[0];
		String[] Lot_Number=Lot_id.split(" ");
		return Lot_Number[1];
	}
	
	public void Complete_ReservationRequest()
	{
		HoldALot_btn_click();
		HoldALot_First_Name_send();
		HoldALot_Last_Name_send();
		HoldALot_Phone_send();
		HoldALot_Email_send();
	}
	
	public boolean Loading_Loader()
	{
		boolean element=Loading_Loader.isDisplayed();
		return element;
	}
	
	public boolean Loading_Loader_Transaction()
	{
		boolean elementstatus=Loading_Loader_Transaction.isDisplayed();
		return elementstatus;
	}
	
	public void Checkout_CardNumber()
	{
		Checkout_CardNumber.sendKeys(Card_Number);
	}
	
	public boolean Plan_details_Filter_btn()
	{
		boolean element=Plan_details_Filter_btn.isDisplayed();
		return element;
	}
	
	public void Plan_details_Filter_btn_click()
	{
		Plan_details_Filter_btn.click();
	}
	
	public List<WebElement> Plan_Price_List()
	{
		List<WebElement> List=Plan_Price_List;
		for(WebElement Lists:List)
		{
			System.out.println(Lists.getText());
		}
		return List;
	}
	
	public String Listing_Header_text()
	{
		String element=Listing_Header_text.getText();
		return element;
	}
	
	public void First_Plan_in_Listing()
	{
		First_Plan_in_Listing.click();
	}
	
	public boolean Request_Info_FirstListing()
	{
		boolean element=Request_Info_FirstListing.isDisplayed();
		return element;
	}
	
	public boolean Expent_View_FirstListing()
	{
		boolean element=Expent_View_FirstListing.isDisplayed();
		return element;
	}
	
	public boolean Right_Panel_hide()
	{
		boolean element=false;
		try {
			element=Right_Panel.isDisplayed();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean Builder_Logo() { 
		try{
			Builder_Logo.isDisplayed();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public void Fill_Request_Info_Form() {
		Request_info_First_Name_send();
		Request_info_Last_Name_send();
		Request_info_Email_send();
		Request_info_Phone_Send();
		Request_info_Zip_Send();
		Request_info_Comments_Send();
	}
	
	public boolean ri_Success_Popup_hide() {
		try {
			ri_Success_Popup_hide.isDisplayed();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean PlanDetails_Option_Section() {
		boolean element=PlanDetails_Option_Section.isDisplayed();
		return element;
	}
		
	public void PlanDetail_Slider_Min_Select() {
		action.dragAndDropBy(PlanDetail_Slider_Min, 30, 0).build().perform();
	}
	
	public String PlanDetail_Slider_Min_value() {
		String element=PlanDetail_Slider_Min.getAttribute("Style");
		return element;
	}
	
	public void PlanDetails_BedroomThree_Select() {
		PlanDetails_BedroomThree.click();
	}
	
	public String PlanDetails_BedroomThree_GetColor(){
		String Color_rgb=PlanDetails_BedroomThree.getCssValue("background-color");
		String Color_Hex=Color.fromString(Color_rgb).asHex();
		return Color_Hex;
	}
	public void SVG_ZoomSlider_Click() {
		//action.dragAndDropBy(SVG_ZoomSlider, 30, 0).build().perform();
		action.clickAndHold(SVG_ZoomSlider);
		action.moveByOffset(1, 0).release().build().perform();
	}
	
	public String SVG_ZoomedSlider_Value() {
		String element=SVG.getCssValue("transform");
		return element;
	}
	
	public String Available_Plan_on_Lot() {
		String element=Available_Plan_on_Lot.getText();
		return element;
	}
	
	public String All_Available_Plan() {
		String element=All_Available_Plan.getText();
		return element;
	}
	
	public void LotDetailPopUp_Close_icon() {
		LotDetailPopUp_Close_icon.click();
	}
	
	public boolean LotDetailPopUp() {
		boolean element=LotDetailPopUp.isDisplayed();
		return element;
	}
	
	public boolean First_Listing_LightGallery_Image() {
		boolean element=First_Listing_LightGallery_Image.isDisplayed();
		return element;
	}
	
	public void First_Listing_LightGallery_Image_Click() {
		First_Listing_LightGallery_Image.click();
	}
	
	public boolean Light_Gallery_Image() {
		try {
			Light_Gallery_Image.isDisplayed();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public void Light_Gallery_CloseIcon() {
		Light_Gallery_CloseIcon.click();
	}
	
	// Get the Lot Size value method
	public String GetLotSize_Value() {
		return element = LotSize_Value.getText();
	}

	// Get Lot Block value method
	public String GetLotBlock_Value() {
		return element = LotBlock_Value.getText();
	}

	// Get Lot Face value method
	public String GetLotPhase_Value() {
		return element = LotPhase_Value.getText();
	}

	// Get Lot Swing Value method
	public String GetLotSwing_Value() {
		return element = LotSwing_Value.getText();
	}

	// Get Lot Elevation Value method
	public String GetLotElevation_Value() {
		return element = LotElevation_Value.getText();
	}	
	
	// Store lot details in HashMap from ISP
	public HashMap<String, String> Actual_LotDetailsValues() {
		HashMap<String, String> ISPLotDetails = new HashMap<String, String>();

		ISPLotDetails.put("Size", GetLotSize_Value());
		ISPLotDetails.put("Block", GetLotBlock_Value());
		ISPLotDetails.put("Phase", GetLotPhase_Value());
		ISPLotDetails.put("Swing", GetLotSwing_Value());
		ISPLotDetails.put("Elevation", GetLotElevation_Value());
		return ISPLotDetails;
	}
	
	// Store lot details in HashMap from ISP
	public HashMap<String, String> Expected_LotDetailsValues() {
		HashMap<String, String> ISPLotDetails = new HashMap<String, String>();

		ISPLotDetails.put("Size", prop.getProperty("Lot_Size"));
		ISPLotDetails.put("Block", prop.getProperty("Lot_Block"));
		ISPLotDetails.put("Phase", prop.getProperty("Lot_Phase"));
		ISPLotDetails.put("Swing", prop.getProperty("Lot_Swing"));
		ISPLotDetails.put("Elevation", prop.getProperty("Lot_Elevation"));
		return ISPLotDetails;
	}
	
	public String SinglePlanAssigned_2_GetCSS() {
		return SinglePlanAssigned_2.getAttribute("style");
	}
	
	public boolean Hold_A_Lot_btn() {
		try {
			Hold_A_Lot_btn.isDisplayed();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
}
