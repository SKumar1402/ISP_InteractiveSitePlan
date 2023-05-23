package com.exsq.isp_plugin.base;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public ISP_Overview Overview;
	public Actions action;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;


	public WebDriverWait wait;
	
	public TestBase() {
        
        try {
            TestBase.prop = new Properties();
            final FileInputStream ip = new FileInputStream("D:\\ISP_PlugIn_Automation\\ISP_Plugin\\src\\main\\java\\Test_Data\\Test_data.properties");							
            TestBase.prop.load(ip);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
	
	
	@BeforeMethod
	public void TestReport(Method m,ITestContext context) {
		extentTest=extentReports.createTest(m.getName());
	}
	
	@AfterMethod
	public void checkStatus(Method m, ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) { 
			extentTest.fail(result.getThrowable());
		} else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.pass(m.getName()+" is passed.");
		}
	}
	
	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("ExtentSparkReport.html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox; default-src 'self';");
	}
	
	@AfterSuite
	public void generateExtentReports() throws IOException, Exception {
		extentReports.flush();
		//Desktop.getDesktop().browse(new File("ExtentSparkReport.html").toURI());
		
		 // Attach the extent Report and send email using code
/*	  EmailAttachment attachment = new EmailAttachment();
	  	attachment.setPath("ExtentSparkReport.html");
	  	attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  	attachment.setDescription("Extent Report");
	  	attachment.setName("Suite Test Report");
	
	  // Create the email message
	  MultiPartEmail email = new MultiPartEmail();
		//Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sukumar@ex2india.com", "dsdidbgvgwnbueac"));
		email.setSSLOnConnect(true);
		email.setFrom("sukumar@ex2india.com");
		email.setSubject("Test Suite Result");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("sukumar@ex2india.com");
		
		 // add the attachment
		email.attach(attachment);
		
		email.send();*/
	}
		
    public void LaunchBrowser()
    {
		String browserName = prop.getProperty("Browser");
		
		if(browserName.equals("Chrome")){
			WebDriverManager.chromedriver().setup(); 
			ChromeOptions options=new ChromeOptions();    
			options.addArguments("--remote-allow-origins=*");    
			//Launching the browser
			driver=new ChromeDriver(options);
		}
		else if(browserName.equals("FireFox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
		}else if(browserName.equals("Edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); 
		}
			
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

	public void Initialization() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Overview=new ISP_Overview(driver);
		action=new Actions(driver);		
	}
	
    //Navigate to Scenario 1 with ISP Start
    public void open_URL()
    {
    	String Type = prop.getProperty("ISP_Type");
    	if(Type.equals("Overview_2"))
    	{
    		driver.navigate().to(prop.getProperty("Overview_2_0"));
    	}else if(Type.equals("Preview_2")) 
    	{
    		driver.navigate().to(prop.getProperty("Preview_2_0"));
    	}else if(Type.equals("Overview_3")) 
    	{
    		driver.navigate().to(prop.getProperty("Overview_3_0"));
    	}else if(Type.equals("Preview_3")) 
    	{
    		driver.navigate().to(prop.getProperty("Preview_3_0"));
    	}
    }
    


}
