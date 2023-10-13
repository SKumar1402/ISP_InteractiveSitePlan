package com.exsq;


import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Android_Chrome {
	
	AndroidDriver driver;
		
	@Test
	public void Launch() {
		try {
        // Set the desired capabilities for your Android device
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Sunil's M51");
        caps.setCapability(MobileCapabilityType.UDID, "RZ8R320MKFD");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        //url = new URL("http://localhost:4723/wd/hub");
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
       // WebDriverManager.chromedriver().setup(); 
        ChromeOptions options=new ChromeOptions(); 
        options.addArguments("--remote-allow-origins=*");
       
    
		 driver=new AndroidDriver(url, caps);
		}catch(Exception exp) {
		System.out.println("Cause is : "+exp.getCause());
		System.out.println("Message is : "+exp.getMessage());
		exp.printStackTrace();
	}
		System.out.println("I am inside sample Test.");
		driver.get("www.google.com");
	}
	
	}
