package com.exsq.isp_plugin.pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class ISP_Overview extends AbstractComponents {
	WebDriver driver;

	public ISP_Overview(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Actions action;

	// *****************Kenley community************
	// Lot has lot Id

	@FindBy(css = "g#Lots path#Lot_5")
	public WebElement SinglePlanAssigned_2;

	// Lot has lot address
	@FindBy(css = "g#Lots path#Lot_10")
	public WebElement TwoPlansAssignedLot_2;

	// *****************King's Grant community************
	// Lot has lot Id
	@FindBy(css = "path#Lot_165")
	public WebElement SinglePlanAssigned_3;

	// Lot has lot address
	@FindBy(css = "path#Lot_168")
	public WebElement TwoPlansAssignedLot_3;

	// *********************************************

	@FindBy(css = "div#isp-skeleton")
	public WebElement ISP_Skeleton;

	@FindBy(css = "section.isp-top-bar:not(.isp-hide) div.logo")
	private WebElement Builder_Logo;
	
	@FindBy (css="div.isp-plan-card")
	private List<WebElement> planCard;

	// Spec Home Key
	@FindBy(css = "span.isp-key-icon:not(.isp-hide)")
	private WebElement Spec_Home_Key;

	// List of total selected lots after click on plan from listing
	@FindBy(css = "[style=\"cursor: pointer; stroke-width: 5; stroke: rgb(255, 0, 51);")
	private WebElement Total_Seleted_Lots;

	// 1st Plan in the listing
	@FindBy(css = "section#ispallplanslist div.isp-plan-card:nth-child(1) div.isp-plan-image")
	private WebElement First_Plan_in_Listing;

	// Plan detail card > Light Gallery Image
	@FindBy(css = "section#ispallplanslist div.isp-plan-card:nth-child(1) figure.galleryEffect")
	private WebElement First_Listing_LightGallery_Image;

	// Light Gallery > 1st Image from the light gallery listing
	@FindBy(css = "div.lg-thumb-item.active")
	private WebElement Light_Gallery_Image;

	// Light Gallery close icon
	@FindBy(css = "span.lg-close.lg-icon")
	private WebElement Light_Gallery_CloseIcon;

	// Request Info Success pop up hide
	@FindBy(css = "section#isp-request-info-success:not(.isp-hide)")
	private WebElement ri_Success_Popup_hide;

	// Request Info button from 1st listing
	@FindBy(css = "section#ispallplanslist div.isp-plan-card:nth-child(1) a#isp-plan-request-info")
	private WebElement Request_Info_FirstListing;

	// Expend View button from 1st listing
	@FindBy(css = "section#ispallplanslist div.isp-plan-card:nth-child(1) a.exapnd-view")
	private WebElement Expent_View_FirstListing;

	// List of total specs available in the listing
	@FindBy(css = "div.isp-plan-card span#isp-spec-Banner[style='background-color: rgb(128, 128, 128); color: rgb(255, 255, 255); opacity: 1;']")
	private WebElement Total_Spec_List;

	// List of community from Change Community list
	@FindBy(css = "ul#isp-community-dropdown.isp-tooltip-open li")
	private List<WebElement> Total_Other_Communities;

	// Master map button
	@FindBy(css = "a#isp-master-plan-btn")
	private WebElement masterMap_btn;

	// Print button
	@FindBy(css = "a#isp-print-btn")
	public WebElement print_btn;

	// Print > Generate PDF button
	@FindBy(css = "input#isp-print-option-submit")
	private WebElement Generate_PDF;

	// Print modal window
	@FindBy(css = "section#isp-print-modal:not(.isp-hide)>div.isp-modal-inner iframe")
	private WebElement print_modal_window;

	// Print modal window Header
	@FindBy(css = "section#isp-print-modal  div.isp-modal-header")
	private WebElement print_modal_Header;

	// print modal window body
	@FindBy(css = "section#isp-print-modal  div.isp-modal-body")
	private WebElement print_modal_window_body;

	// Print modal window Cancel button
	@FindBy(css = "section#isp-print-modal  div.isp-modal-footer button")
	public WebElement print_modal_Cancel_btn;

	// Request info button
	@FindBy(css = "a#isp-request-info-btn")
	private WebElement request_info_btn_Footer;

	// Request info Form visibility
	@FindBy(css = "form#isp-request-info-form")
	private WebElement Request_Info_Visible;

	// Request info First Name text field
	@FindBy(css = "input#isp-ri-fname")
	private WebElement Request_info_First_Name;

	// Request info Last Name text field
	@FindBy(css = "input#isp-ri-lname")
	private WebElement Request_info_Last_Name;

	// Request info Email text field
	@FindBy(css = "input#isp-ri-email")
	private WebElement Request_info_Email;

	// Request info Phone Number text field
	@FindBy(css = "input#isp-ri-phone")
	private WebElement Request_info_Phone;

	// Request info Zipcode text field
	@FindBy(css = "input#isp-ri-zip")
	private WebElement Request_info_Zip;

	// Request info Comments text field
	@FindBy(css = "textarea#isp-ri-comments")
	private WebElement Request_info_Comments;

	// Request info Send Request button
	@FindBy(css = "input#isp-ri-submit")
	private WebElement Send_Request;

	// *************************HOLD A LOT**********************
	// Hold a Lot > First Name text field
	@FindBy(css = "input#isp-hold-lot-fname")
	private WebElement HL_FirstName;

	// Hold a Lot > Last Name text field
	@FindBy(css = "input#isp-hold-lot-lname")
	private WebElement HL_LastName;

	// Hold a Lot > Phone Number text field
	@FindBy(css = "input#isp-hold-lot-phone")
	private WebElement HL_PhoneNumber;

	// Hold a Lot > Email text field
	@FindBy(css = "input#isp-hold-lot-email")
	private WebElement HL_Email;

	// Hold a Lot > Comments text field
	@FindBy(css = "textarea#isp-hold-lot-comments")
	private WebElement HL_Comment;

	// Hold a Lot form cancel button
	@FindBy(css = "a#isp-hold-lot-close")
	private WebElement HL_Cancel_btn;

	// Hold a Lot Form > Continue to Payment button
	@FindBy(css = "input#isp-hold-lot-submit")
	private WebElement Continue_Payment_btn;

	// Checkout Form > Reservation for value
	@FindBy(css = "div.lot-price-info div:nth-child(1) span")
	private WebElement Checkout_request_Lot;

	// Checkout Form > Reservation Fee Due
	@FindBy(css = "div.lot-price-info div:nth-child(2) span")
	private WebElement Checkout_ReservationFee;

	// Checkout Form > Card Number text field
	@FindBy(css = "input#Field-numberInput")
	private WebElement Checkout_CardNumber;

	// Checkout Form > Expiration date
	@FindBy(css = "input#Field-expiryInput")
	private WebElement Checkout_Expiration;

	// Checkout Form > CVC number text field
	@FindBy(css = "input#Field-cvcInput")
	private WebElement Checkout_CVC;

	// Checkout Form > Terms and Conditions check box
	@FindBy(css = "div.isp-hold-lot-payment-terms input")
	private WebElement Checkout_Checkbox;

	// Checkout Form > 'Submit Reservtion' disabled button
	@FindBy(css = "button#paymentSubmit.disabled")
	private WebElement Checkout_Submit_Btn_disable;

	// Checkout Form > 'Submit Reservtion' active button
	@FindBy(css = "button#paymentSubmit:not(.disabled)")
	private WebElement Checkout_Submit_Btn_active;

	// Checkout Form > Loader after submit the form
	@FindBy(css = "div#loader-caption-message")
	private WebElement Checkout_Submit_Loader;

	// Payment Success pop up Status
	@FindBy(css = "transaction-status-header")
	private WebElement Payment_Success_Status;

	// Payment Success pop up close button
	@FindBy(css = "a#isp-hold-lot-close-btn")
	private WebElement Payment_Success_Popup_Close_btn;

	// Lot Detail pop up > Header > Homesite name
	@FindBy(css = "h3#isp-homesite-name")
	private WebElement Detail_Popup_Homesite_Name;

	// Homesite Status button for ISP 2.0
	@FindBy(css = "span#isp-homesite-filter-title")
	private WebElement Homesite_Status_Filter_button_2;

	// Homesite Status button for ISP 3.0
	@FindBy(css = "button#legends-btn")
	private WebElement Homesite_Status_Filter_button_3;

	// Homesite Status filter dropdown/pop up for ISP 2.0
	@FindBy(css = "div#isp-status-dropdown.show")
	private WebElement Homesite_StatusFilter_Dropdown_2;

	// Homesite Status filter dropdown/pop up for ISP 3.0
	@FindBy(css = "div#openLegends[style='display: block;']>div.Status_open")
	private WebElement Homesite_StatusFilter_Dropdown_3;

	// Homesite Status Filter Apply button

	@FindBy(css = "div.isp-status-buttons a:nth-child(2)")
	private WebElement Homesite_Status_Apply_btn;

	// Homesite Status Filter Clear button
	@FindBy(css = "div.isp-status-buttons a:nth-child(1)")
	private WebElement Homesite_Status_Clear_btn;

	// Homesite Status Filter pop up Close button for ISP 2.0
	@FindBy(css = "a#isp-close-refine-button")
	private WebElement Homesite_Status_Close_btn_ISP2;

	// Homesite Status Filter pop up Close button for ISP 3.0
	@FindBy(css = "a#close-refine-button")
	private WebElement Homesite_Status_Close_btn_ISP3;

	// Loading... Loader
	@FindBy(css = "div.media-loader-outer div#loader-caption")
	public WebElement Loading_Loader;

	// Loading... Loader When Transaction gets completed.
	@FindBy(css = "div.media-loader-outer div#loader-caption-message")
	private WebElement Loading_Loader_Transaction;

	// Request Info success pop up 'Great! Let's continue' button
	@FindBy(css = "section.alert-modal:not(.isp-hide) a#isp-ri-success-btn")
	private WebElement Great_Lets_Continue_btn;

	// Homesite Status's dropdown list
	@FindBy(css = "div.isp-refine-dropdown.show")
	private WebElement Homesite_Status_list;

	// Homesite status list filter reset button
	@FindBy(css = "a#isp-reset-homesite-filter")
	private WebElement Homesite_Status_Filter_Reset;

	// Homesite status filter apply button
	@FindBy(css = "a#isp-apply-homesite-filter")
	private WebElement Homesite_Status_Filter_Apply;

	// Homesite status dropdown close button
	@FindBy(css = "a#isp-close-refine-button")
	private WebElement homesite_Status_dropdown_close_button;

	// Homesite status's name in the drop down list
	@FindBy(css = "ul.isp-homesite-status li label span")
	private List<WebElement> Homesite_status_Name_List;

	// Homesite status's name checkbox list in the drop down
	@FindBy(css = "ul.isp-homesite-status li label input")
	private List<WebElement> Homesite_status_checkbox_List;

	// Homesite status name's status colors list in the drop down
	@FindBy(css = "span.isp-status-color")
	private List<WebElement> Homesite_status_colors_List;

	// Plan details filter button
	@FindBy(css = "button#filter-btn")
	private WebElement Plan_details_Filter_btn;

	// Community from bottom
	@FindBy(css = "h3#ispCommName")
	private WebElement Community_Name_top;

	// Available Home Site link from listing
	@FindBy(css = "div#isp-lot-list-div:not(.isp-hide) div.isp-lot-list-toggle")
	private WebElement Available_HomeSite_Link;

	// Cypress Plan Request Info button
	@FindBy(css = "div#isp-community-home_208667 a#isp-plan-request-info")
	private WebElement Cypress_Plan_RequestInfo_button;

	// Hold a Lot button from the lot details pop up
	@FindBy(css = "a#isp-hold-lot-btn:not(.isp-hide)")
	private WebElement Hold_A_Lot_btn;

	// Community name from the header
	@FindBy(css = "h3#ispCommName")
	private WebElement Community_Name_Header;

	// Community name from the footer
	@FindBy(css = "div.isp-footer-community h3")
	public WebElement Community_Name_Footer;

	// ISP Plan Price List
	@FindBy(css = "span#ispPrice")
	private List<WebElement> Plan_Price_List;

	// ISP Plan Listing Header text
	@FindBy(css = "li#allPlansTabHead a")
	private WebElement Listing_Header_text;

	// Listing > Plan Names > Available Plans on this Homesite
	@FindBy(css = "section#ispAvailablePlansList div.isp-plan-card h2")
	private List<WebElement> Listing_AvailablePlansOnThisHomesite;

	// Listing > Right Panel
	@FindBy(css = "div#ispContainer aside.isp-right-sidebar")
	private WebElement Right_Panel;

	// Plan Details > Filter > Slider > Minimum
	@FindBy(css = "div#slider-distance span:nth-child(4)")
	public WebElement PlanDetail_Slider_Min;

	// Plan Detail Filter Option section
	@FindBy(css = "section#ispFilterOptions")
	private WebElement PlanDetails_Option_Section;

	// Plan Details > Bedroom Filter > Bedroom 3
	@FindBy(css = "div.isp-form-group:nth-child(3) div.isp-select-options label:nth-child(8)")
	private WebElement PlanDetails_BedroomThree;

	// SVG Zoom slider
	@FindBy(css = "div.isp-slidecontainer input")
	private WebElement SVG_ZoomSlider;

	// SVG
	@FindBy(css = "div#svgContainer svg")
	private WebElement SVG;

	// Available Plans on the selected Lot
	@FindBy(css = "a#isp-tab1-header")
	private WebElement Available_Plan_on_Lot;

	// Others Plan in This Community
	@FindBy(css = "li#allPlansTabHead a")
	private WebElement All_Available_Plan;

	// Lot Detail pop up close icon 'X'
	@FindBy(css = "button#isp-closeModel")
	private WebElement LotDetailPopUp_Close_icon;

	// Lot Detail Pop Up
	@FindBy(css = "div#isp-modaldialog")
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

	// Highlighted lots for Firefox
	@FindBy(css = "path[style='stroke-width: 5px; stroke: rgb(255, 0, 0);']")
	private List<WebElement> All_Highlighted_Lots_Firefox;

	// Highlighted lots for Chrome
	@FindBy(css = "g path[style='stroke-width: 5; stroke: rgb(224, 29, 55);']")
	private List<WebElement> All_Highlighted_Lots;

	// Change Community > 1st Community from the list
	@FindBy(css = "ul#isp-community-dropdown li:nth-child(1)")
	private WebElement ChangeCommunity_FirstCommunity;

	// Change Community Link
	@FindBy(css = "a#isp-change-community")
	private WebElement Change_Community;

	// Change Community List
	@FindBy(css = "ul#isp-community-dropdown.isp-tooltip-open")
	private WebElement changeCommunityList;

	public boolean masterMap_btn() {
		boolean elementStatus = masterMap_btn.isDisplayed();
		return elementStatus;
	}

	public void masterMap_btn_click() {
		masterMap_btn.click();
	}

	public boolean print_btn() {
		return print_btn.isDisplayed();
		// return elementStatus;
	}

	public void print_btn_click() {
		print_btn.click();
	}

	public boolean request_info_btn() {
		return request_info_btn_Footer.isDisplayed();
	}

	public boolean Request_Info_Visible() {
		return Request_Info_Visible.isDisplayed();
	}

	public void request_info_btn_click() {
		request_info_btn_Footer.click();
	}

	public void Request_info_First_Name_send(String firstName) {
		Request_info_First_Name.sendKeys(firstName);
	}

	public void Request_info_Last_Name_send(String lastName) {
		if (lastName.equals("Chrome")) {
			Request_info_Last_Name.sendKeys(lastName);
		} else if (lastName.equals("FireFox")) {
			Request_info_Last_Name.sendKeys(lastName);
		} else if (lastName.equals("Edge")) {
			Request_info_Last_Name.sendKeys(lastName);
		}
	}

	public void Request_info_Email_send(String eMail) {
		Request_info_Email.sendKeys(eMail);
	}

	public void Request_info_Phone_Send(String phone) {
		Request_info_Phone.sendKeys(phone);
	}

	public void Request_info_Zip_Send(String zipCode) {
		Request_info_Zip.sendKeys(zipCode);
	}

	public void Request_info_Comments_Send(String Comments) {
		Request_info_Comments.sendKeys(Comments);
	}

	public void Send_Request_Click() {
		Send_Request.click();
	}

	public void Great_Lets_Continue_btn_click() {
		Great_Lets_Continue_btn.click();
	}

	public boolean Great_Lets_Continue_btn() {
		boolean elementStatus = Great_Lets_Continue_btn.isDisplayed();
		return elementStatus;
	}

	public boolean print_modal_window() {
		boolean status = false;
		try {
			status = print_modal_window.isDisplayed();
			return status;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean print_modal_Cancel_btn() {
		boolean elementStatus = print_modal_Cancel_btn.isDisplayed();
		return elementStatus;
	}

	public void print_modal_Cancel_btn_Click() {
		print_modal_Cancel_btn.click();
	}

	public void Homesite_Status_button_ISP2_Click() {
		Homesite_Status_Filter_button_2.click();
	}

	public void Homesite_Status_button_ISP3_Click() {
		Homesite_Status_Filter_button_3.click();
	}

	public boolean Homesite_StatusFilter_Dropdown_ISP2() {
		try {
			Homesite_StatusFilter_Dropdown_2.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean Homesite_StatusFilter_Dropdown_ISP3() {
		try {
			Homesite_StatusFilter_Dropdown_3.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean Homesite_Status_Apply_btn_show() {
		return Homesite_StatusFilter_Dropdown_2.isDisplayed();
	}

	public void Homesite_Status_Apply_btn_click() {
		Homesite_Status_Apply_btn.click();
	}

	public void Homesite_Status_Clear_btn_click() {
		Homesite_Status_Clear_btn.click();
	}

	public void Homesite_Status_Close_btn_ISP2_click() {
		Homesite_Status_Close_btn_ISP2.click();
	}

	public void Homesite_Status_Close_btn_ISP3_click() {
		Homesite_Status_Close_btn_ISP3.click();
	}

	public boolean Community_Name_Header() {
		return Community_Name_Header.isDisplayed();
	}

	public String Community_Name_Header_GetText() {
		return Community_Name_Header.getText();
	}

	public boolean Community_Name_Footer() {
		return Community_Name_Footer.isDisplayed();
	}

	public String communityNameFromFooter() {
		return Community_Name_Footer.getText();
	}

	public void HoldALot_First_Name_send(String firstName) {
		HL_FirstName.sendKeys(firstName);
	}

	public void HoldALot_Last_Name_send(String lastName) {
		if (lastName.equals("Chrome")) {
			HL_LastName.sendKeys(lastName);
		} else if (lastName.equals("FireFox")) {
			HL_LastName.sendKeys(lastName);
		} else if (lastName.equals("Edge")) {
			HL_LastName.sendKeys(lastName);
		}
	}

	public void HoldALot_Phone_send(String phone) {
		HL_PhoneNumber.sendKeys(phone);
	}

	public void HoldALot_Email_send(String eMail) {
		HL_Email.sendKeys(eMail);
	}

	public void HoldALot_ContinueToPayment() {
		Continue_Payment_btn.click();
	}

	public void Select_SinglePlanAssigned_Lot() {
		//action.moveToElement(SinglePlanAssigned_2).click().build().perform();
		SinglePlanAssigned_2.click();
	}

	public void Select_TwoPlansAssigned_Lot() {
		//action.moveToElement(TwoPlansAssignedLot_2).click().build().perform();
		TwoPlansAssignedLot_2.click();
	}

	public void HoldALot_btn_click() {
		Hold_A_Lot_btn.click();
	}

	public String Detail_Popup_Header() {
		String element = Detail_Popup_Homesite_Name.getText();
		return element;
	}

	public String Detail_Popup_Homesite_Name() {
		String[] Homesite_Status = Detail_Popup_Homesite_Name.getText().split("/");
		return Homesite_Status[1];
	}

	public String Lot_id() {
		String[] Homesite_Status = Detail_Popup_Homesite_Name.getText().split("/");
		String Lot_id = Homesite_Status[0];
		return Lot_id;
	}

	public String Lot_Number() {
		String[] Homesite_Status = Detail_Popup_Homesite_Name.getText().split("/");
		String Lot_id = Homesite_Status[0];
		String[] Lot_Number = Lot_id.split(" ");
		return Lot_Number[1];
	}

	public void Complete_ReservationRequest(String firstName, String lastName, String eMail, String phone) {
		HoldALot_btn_click();
		HoldALot_First_Name_send(firstName);
		HoldALot_Last_Name_send(lastName);
		HoldALot_Phone_send(phone);
		HoldALot_Email_send(eMail);
	}

	public boolean Loading_Loader() {
		boolean element = Loading_Loader.isDisplayed();
		return element;
	}

	public boolean Loading_Loader_Transaction() {
		boolean elementstatus = Loading_Loader_Transaction.isDisplayed();
		return elementstatus;
	}

	public boolean Plan_details_Filter_btn() {
		boolean element = Plan_details_Filter_btn.isDisplayed();
		return element;
	}

	public void Plan_details_Filter_btn_click() {
		Plan_details_Filter_btn.click();
	}

	public List<WebElement> Plan_Price_List() {
		List<WebElement> List = Plan_Price_List;
		for (WebElement Lists : List) {
			System.out.println(Lists.getText());
		}
		return List;
	}

	public String Listing_Header_text() {
		String element = Listing_Header_text.getText();
		return element;
	}

	public boolean Request_Info_FirstListing() {
		boolean element = Request_Info_FirstListing.isDisplayed();
		return element;
	}

	public boolean Expent_View_FirstListing() {
		boolean element = Expent_View_FirstListing.isDisplayed();
		return element;
	}

	public boolean Right_Panel_hide() {
		boolean element;
		try {
			element = Right_Panel.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean Builder_Logo() {
		try {
			Builder_Logo.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void Fill_Request_Info_Form(String firstName, String lastName, String eMail, String phone, String zipCode,
			String Comments_Overview_Two) {
		Request_info_First_Name_send(firstName);
		Request_info_Last_Name_send(lastName);
		Request_info_Email_send(eMail);
		Request_info_Phone_Send(phone);
		Request_info_Zip_Send(zipCode);
		Request_info_Comments_Send(Comments_Overview_Two);
	}

	public boolean ri_Success_Popup_hide() {
		try {
			ri_Success_Popup_hide.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean PlanDetails_Option_Section() {
		boolean element = PlanDetails_Option_Section.isDisplayed();
		return element;
	}

	public void PlanDetail_Slider_Min_Select() {
		action= new Actions(driver);
		action.dragAndDropBy(PlanDetail_Slider_Min, 30, 0).build().perform();
		
	}

	public String PlanDetail_Slider_Min_value() {
		String element = PlanDetail_Slider_Min.getAttribute("Style");
		return element;
	}

	public String PlanDetail_Slider_Min_value1() {
		String element = PlanDetail_Slider_Min.getCssValue("left");
		return element;
	}

	public void PlanDetails_BedroomThree_Select() {
		PlanDetails_BedroomThree.click();
	}

	public String PlanDetails_BedroomThree_GetColor() {
		String Color_rgb = PlanDetails_BedroomThree.getCssValue("background-color");
		String Color_Hex = Color.fromString(Color_rgb).asHex();
		return Color_Hex;
	}

	public void SVG_ZoomSlider_Click() {
		action=new Actions(driver);
		action.dragAndDropBy(SVG_ZoomSlider, 30, 0).build().perform();
		action.clickAndHold(SVG_ZoomSlider);
		action.moveByOffset(2, 0).release().build().perform();
	}

	public String SVG_ZoomedSlider_Value() {
		String element = SVG.getCssValue("transform");
		return element;
	}

	public String Available_Plan_on_Lot() {
		String element = Available_Plan_on_Lot.getText();
		return element;
	}

	public String All_Available_Plan() {
		String element = All_Available_Plan.getText();
		return element;
	}

	public void LotDetailPopUp_Close_icon() {
		LotDetailPopUp_Close_icon.click();
	}

	public boolean LotDetailPopUp_Visibility() {
		return LotDetailPopUp.isDisplayed();
	}

	public boolean First_Listing_LightGallery_Image() {
		boolean element = First_Listing_LightGallery_Image.isDisplayed();
		return element;
	}

	public void First_Listing_LightGallery_Image_Click() {
		First_Listing_LightGallery_Image.click();
	}

	public boolean Light_Gallery_Image() {
		try {
			Light_Gallery_Image.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void Light_Gallery_CloseIcon() {
		Light_Gallery_CloseIcon.click();
	}

	// Get the Lot Size value method
	public String GetLotSize_Value() {
		return LotSize_Value.getText();
	}

	// Get Lot Block value method
	public String GetLotBlock_Value() {
		return LotBlock_Value.getText();
	}

	// Get Lot Face value method
	public String GetLotPhase_Value() {
		return LotPhase_Value.getText();
	}

	// Get Lot Swing Value method
	public String GetLotSwing_Value() {
		return LotSwing_Value.getText();
	}

	// Get Lot Elevation Value method
	public String GetLotElevation_Value() {
		return LotElevation_Value.getText();
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
	public HashMap<String, String> Expected_LotDetailsValues(String size, String block, String phase, String swing,
			String elevation) {
		HashMap<String, String> ISPLotDetails = new HashMap<String, String>();

		ISPLotDetails.put("Size", size);
		ISPLotDetails.put("Block", block);
		ISPLotDetails.put("Phase", phase);
		ISPLotDetails.put("Swing", swing);
		ISPLotDetails.put("Elevation", elevation);
		return ISPLotDetails;
	}

	public String SinglePlanAssigned_2_GetCSS() {
		return SinglePlanAssigned_2.getAttribute("style");
	}

	public boolean Hold_A_Lot_btn() {
		try {
			Hold_A_Lot_btn.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int All_Highlighted_Lots() {
		return All_Highlighted_Lots.size();
	}

	public void clickOnChangeCommunityLink() {
		Change_Community.click();
	}

	public void selectFirstCommunityfromChangeCommunityList() {
		ChangeCommunity_FirstCommunity.click();
	}

	public String getFirstCommunityNameFromChangeCommunityList() {
		return ChangeCommunity_FirstCommunity.getText();
	}

	public boolean changeCommunityListVisibility() {
		return changeCommunityList.isDisplayed();
	}

	public boolean checkCurrentCommunityNameInChangeCommunityList() {
		String element = communityNameFromFooter();
		for (WebElement check : Total_Other_Communities)
			if (check.getText().equals(element)) {
				return true;
			}
		return false;
	}

	public void Generate_PDF_Btn_Clicked() {
		Generate_PDF.click();
	}

	public void Log_Status(boolean flag) {
		ExtentTest test = null;
		if (flag) {
			test.log(Status.PASS, "Test case has been Passed.");
		} else {
			test.log(Status.FAIL, "Test case has been Failed.");
		}
	}
	
	public WebElement CheckPlanNameAvailability(String planName) {
		WebElement planname=planCard.stream().filter(plan->plan.findElement(By.cssSelector("h2")).getText().equals(planName)).findFirst().orElse(null);
		return planname;
	}
	
	public void selectPlanFromListing(String planName) {
		WebElement planname=CheckPlanNameAvailability(planName);
		planname.click();
	}
	
	public boolean RequestInfoLinkInListingVisibility(String planName) {
		WebElement plan=CheckPlanNameAvailability(planName);
		boolean status= plan.findElement(By.cssSelector("a.request-info")).isDisplayed();
		return status;
	}
	
	public boolean ExpendedViewLinkInListingVisibility(String planName) {
		WebElement plan=CheckPlanNameAvailability(planName);
		boolean status= plan.findElement(By.cssSelector("a.exapnd-view")).isDisplayed();
		return status;
	}
	
	public void waitToHideSkeleton() {
		waitForElementToDisappear(ISP_Skeleton);
	}
}
