package com.exsq.isp_plugin.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase_Mobile extends TestBase {
	//public static WebDriver driver;
	DesiredCapabilities capabilities;
	
@BeforeClass
public void init() {
	capabilities = new DesiredCapabilities();
	String platformTypeMobileWeb = prop.getProperty("PlatformName");
	String deviceName = prop.getProperty("DeviceName");
	String platformVersionMobileWeb = prop.getProperty("PlatformVersion");
	String mobileBrowser = prop.getProperty("BrowserName");
	String timeoutValue = "45";
	String DeviceID=prop.getProperty("DeviceId");
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



}
