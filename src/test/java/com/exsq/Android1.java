package com.exsq;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.remote.MobileCapabilityType;

public class Android1 {
	
	WebDriver driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	
@BeforeClass
public void init() {

	String platformTypeMobileWeb = "Android";
	String deviceName = "Sunil's M51";
	String platformVersionMobileWeb = "12";
	String mobileBrowser = "chrome";
	String timeoutValue = "45";
	String DeviceID="RZ8R320MKFD";
	//String DeviceID="emulator-5554";

	System.out.println(platformTypeMobileWeb + " : " + platformVersionMobileWeb + " : " + deviceName + " : "
			+ mobileBrowser);

	capabilities.setCapability("platformName", platformTypeMobileWeb);
	capabilities.setCapability("platformVersion", platformVersionMobileWeb);
	capabilities.setCapability("deviceName", deviceName);
	capabilities.setCapability("browserName", mobileBrowser);
	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, timeoutValue);
	capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
	capabilities.setCapability(MobileCapabilityType.UDID, DeviceID);
	
	try {
		driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub/"), capabilities);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@Test
public void TestChrome() throws InterruptedException {

	driver.get("https://salesarchitect-build.bhitest.com/ISP-3?bdxCommunityID=136348&Listings=true&Amenities=true");
	Thread.sleep(20000);
	driver.findElement(By.cssSelector("aside[style=\"bottom: -203px;\"] a.isp-arrowslide-up")).click();
}
}
