package com.jungle.qa.JungleWebApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Base {

	
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	public static void setUpDriver() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\jungle\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("baseUrl");
		String timeout = prop.getProperty("timeOut");
		long timeOut = Long.parseLong(timeout);
		
		if(browser.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\com\\jungle\\qa\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	@BeforeSuite
	public void setUpSuite() {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\JungleWebAppReport.html");
		htmlReporter.config().setDocumentTitle("JUNGLE WEB APP Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Hostname", "LocalHost");
		report.setSystemInfo("Browser", "Chrome");
		
	}
	
	@BeforeClass
	public void setUpClass() throws Exception {

		setUpDriver();
		
	}
	
	@AfterMethod()
	public void tearDownMethod(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed : " + result.getThrowable());
			logger.fail("Test Failed : ", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(result.getName()+"_FAIL")).build());
			
		}	
	}
	
	@AfterClass
	public void tearDownClass() throws Exception {

		
		driver.close();
		driver.quit();
		
	}
	
	@AfterSuite
	public void tearDownSuite() {
		
		report.flush();
	}
	
	public void waitForElementClickable(WebElement elem) {

		try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(elem));
            //Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("The Element is NOT Clickable :: " + e);
        }
	}
	
	public void waitForElementVisible(WebElement elem) {

		try{
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(elem));
            //Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("The Element is NOT Visible :: " + e);
        }
	}
	
	public ArrayList<String> getWindowHandles() {
		
		ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
		return handles;
	}
	
	public void switchToTab(String tabIndex) {
		
		driver.switchTo().window(tabIndex);
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}
	
	public void closeTab() {
		
		driver.close();
	}
	
	public String getAttribute(WebElement ele, String attr) {
		
		return ele.getAttribute(attr);
	}
	
	public static String getScreenshot(String tcName) throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(new Date());
		String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + tcName + "_" + timeStamp + ".png";
		FileUtils.copyFile(srcFile, new File(screenshotPath));
		return screenshotPath;
	}
	
}
