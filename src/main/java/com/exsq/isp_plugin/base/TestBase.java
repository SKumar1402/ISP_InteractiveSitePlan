package com.exsq.isp_plugin.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.exsq.isp_plugin.pageObjects.ISP_Overview;
import com.exsq.isp_plugin.pageObjects.UUPLoginSignUp;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public ISP_Overview Overview;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	int failedCount = 0;
	int passedCount = 0;
	int skippedCount = 0;
	int totalExecutedCount = 0;
	public static DesiredCapabilities capabilities;

	public WebDriverWait wait;

	public TestBase() {
		try {
			prop = new Properties();
			final FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\Test_Data\\Test_data.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	@BeforeMethod
	public void TestReport(Method m, ITestContext context) {
		extentTest = extentReports.createTest(m.getName());
	}

	@BeforeSuite
	public void initialiseExtentReports() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentSparkReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Author", System.getProperty("user.name"));
		System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox; default-src 'self';");
	}

	@AfterMethod
	public void checkStatus(Method m, ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " is passed.");
		}
	}

	@AfterSuite
	public void generateExtentReports(ITestContext context) throws IOException, Exception {
		extentReports.flush();
		passedCount = context.getPassedTests().size();
		failedCount = context.getFailedTests().size();
		skippedCount = context.getSkippedTests().size();
		totalExecutedCount = passedCount + failedCount + skippedCount;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String formattedDate = sdf.format(date);

		// Desktop.getDesktop().browse(new File("ExtentSparkReport.html").toURI());
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("ExtentSparkReport.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Extent Report");

		// Create the email message MultiPartEmail email = new MultiPartEmail();
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sukumar@ex2india.com", "dsdidbgvgwnbueac"));
		email.setSSLOnConnect(true);
		email.setFrom("sukumar@ex2india.com");
		email.setSubject("Test Suite Result  (" + formattedDate + ")");
		email.addTo("sukumar@ex2india.com");
		// set the html message
		email.setHtmlMsg("<html>\r\n" + "	<body>\r\n" + "		<p>\r\n" + "		Hello All, <br> <br>\r\n"
				+ "		\r\n"
				+ "		Please find the detailed automation test result in the attachment. <br> <br>\r\n"
				+ "		\r\n <br> ISP Type : " + prop.getProperty("ISP_Type") + ""
				+ "		Total Executed Test Cases : " + totalExecutedCount + " <br>\r\n" + "		Total Passed :  "
				+ passedCount + "<br> \r\n" + "		Total Failed : " + failedCount + "<br> \r\n"
				+ "		Total Skipped : " + skippedCount + "<br> <br>\r\n" + "		\r\n"
				+ "		Download the attached report to view the detailed result. <br> <br>\r\n" + "		\r\n"
				+ "		Note : This is automated email please don't reply to this email.<br> <br>\r\n"
				+ "		Thanks,<br>\r\n" + "		Automation Team <br>(Sunil Kumar)\r\n" + "		</p>\r\n"
				+ "	</body>\r\n" + "</htm>");

		// set the alternative message
		email.setTextMsg("Your email client does not support HTML messages");

		// add the attachment
		email.attach(attachment);

		email.send();
	}
	
	@BeforeTest
	public WebDriver LaunchBrowser() {
		String browserName = prop.getProperty("Browser");

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			// Launching the browser
			driver = new ChromeDriver(options);
		} else if (browserName.equals("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	

	public void init() {
		capabilities = new DesiredCapabilities();
		String platformTypeMobileWeb = prop.getProperty("PlatformName");
		String deviceName = prop.getProperty("DeviceName");
		String platformVersionMobileWeb = prop.getProperty("PlatformVersion");
		String mobileBrowser = prop.getProperty("BrowserName");
		String timeoutValue = "45";
		String DeviceID = prop.getProperty("DeviceId");

		System.out.println(
				platformTypeMobileWeb + " : " + platformVersionMobileWeb + " : " + deviceName + " : " + mobileBrowser);

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
	
	public String getScreenshot(String testCaseName) throws IOException{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	
	@AfterClass
	public void closeDriver() {
		driver.close();
	}

}
