package com.exsq.isp_plugin.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exsq.isp_plugin.base.TestBase;

import AbstractComponents.AbstractComponents;

public class UUPLoginSignUp extends AbstractComponents{

	WebDriver driver;
	public UUPLoginSignUp(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	

	//Login email text field
	@FindBy (css="input[type='email']")
	private WebElement LoginEmail;
	
	//Login Password text field
	@FindBy (css="input[type='password']")
	private WebElement LoginPassword;
	
	//Login button
	@FindBy (css="button[name='submit']")
	private WebElement UUPLoginButton;	
	
	public ISP_Overview Login(String email, String password) throws InterruptedException {
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String plugin= it.next();
		String UUPLoginWindow=it.next();
		//Switch to UUP Login window
		driver.switchTo().window(UUPLoginWindow);
		Thread.sleep(3000);
		LoginEmail.sendKeys(email);
		LoginPassword.sendKeys(password);
		UUPLoginButton.click();
		driver.switchTo().window(plugin);
		return new ISP_Overview(driver);
		}
}

