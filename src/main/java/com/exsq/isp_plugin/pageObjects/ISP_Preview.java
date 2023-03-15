package com.exsq.isp_plugin.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exsq.isp_plugin.base.TestBase;

public class ISP_Preview extends TestBase{

	public ISP_Preview(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Plan Listing 
	@FindBy (css="aside.isp-right-sidebar")
	private WebElement Plan_Listing;
}

