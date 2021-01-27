package BaseClass;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Utility.Utilities;

public class BaseClass {

	public static WebDriver driver;
	public ChromeOptions options;
	public DesiredCapabilities caps;
	public static Utilities utilityObj;
	public String projectFolder = System.getProperty("user.dir");
	public String chromeDriverPath = projectFolder+"/Drivers/chromedriver.exe";
	public String firefoxDriverPath = projectFolder+"/Drivers/geckodriver.exe";
	public String edgeDriverPath = projectFolder+"/Drivers/msedgedriver.exe";
	public String excelPath = projectFolder+"/Excel/SalesboostTestdata.xlsx";
	WebDriverWait wait30Sec;
	public WebDriverWait wait600Sec;
	public static String suitename = "";
	public static String actualstring = "", expectedstring = "", currentDateTime = "";
	public static String username = "", password = "";
	public static Boolean actualBool, expectedBool;
	public static ArrayList<String> testData1 = new ArrayList<String>();
	public static ArrayList<Boolean> actualBoolArray = new ArrayList<Boolean>();
	public static ArrayList<Boolean> expectedBoolArray = new ArrayList<Boolean>();
	public static ArrayList<String> actualArray = new ArrayList<String>();
	public static ArrayList<String> expectedArray = new ArrayList<String>();
	public static ArrayList<String> chromeTab = new ArrayList<String>();
	public static Logger log;
	public static String reportDir = "";
	public static String reportTimestamp = "";
	public static ExtentTest eTest;
	public Capabilities cap;
	public DateFormat df;
	public Date date;
	public static ExtentSparkReporter esReporter;
	public static ExtentReports eReports;
	public String log4jConfPath = projectFolder + "/src/test/java/com/Salesboost_Adminpanel/resources/Log4j.properties";
	public String logPath = "";
	public File directory;

	@BeforeSuite
	@Parameters("browser")
	public void precondition(ITestContext context, @Optional("chrome") String browser) throws InterruptedException {
		try {
			log = Logger.getLogger(BaseClass.class.getName());
		
			reportTimestamp = getCurrentDateTime();// for providing current data and time for log file, use the same
													// time stamp in report zip for relative path
			reportDir = "C:/Salesboost_Automation/Reports/Report_" + reportTimestamp;// creates report folder with time
																						// stamp
			System.setProperty("logPath", "C:/Salesboost_Automation/Logs/LogFile_");
			PropertyConfigurator.configure(log4jConfPath);// Configured log files path
			utilityObj = new Utilities();
			utilityObj.createDirectoryIfNotExist();// for log, report, screenshot
			if (browser.equals("chrome"))
				chromeDriver();
			extendReport();// initializing report
			suitename = context.getCurrentXmlTest().getSuite().getName();
			driver.manage().window().maximize();
			driver.navigate().to("https://qa.salesboost.com/");
			log.info("Page loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void testReportResult(ITestResult result) {
		try {
			log.info("Report status initiated");
			// Passed test status along with screenshot will captured here
			if (result.getStatus() == ITestResult.SUCCESS) {
				eTest.log(Status.PASS, "Test passed");
			}

			// Failed test status along with screenshot will captured here
			else if (result.getStatus() == ITestResult.FAILURE) {
				eTest.log(Status.FAIL, "Test failed");
			}

			// Skipped test status along with screenshot will captured here
			else if (result.getStatus() == ITestResult.SKIP) {
				eTest.log(Status.SKIP, "Test failed");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@AfterSuite
	public void endSuite() {
		try {
			eReports.flush();
			utilityObj.createZip(reportDir);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void chromeDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			options = new ChromeOptions();

			// for disabling "Chrome is being controlled by automated test software" message
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

			// for disabling user name/password saving option
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);

			// options.addArguments("--headless");//for browser less script running
			driver = new ChromeDriver(options);
			cap = ((RemoteWebDriver) driver).getCapabilities();// for retrieving browser name which is printed in
																// reports
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private void extendReport() {
		try {
			log.info("Report initiated");
			esReporter = new ExtentSparkReporter(reportDir + "/TestReport_" + getCurrentDateTime() + ".html");
			esReporter.config().setDocumentTitle("Automation Report");
			esReporter.config().setReportName("Sales boost Automation Report");
			esReporter.config().setTheme(Theme.STANDARD);
			eReports = new ExtentReports();
			eReports.attachReporter(esReporter);
			eReports.setSystemInfo("Project Name", "salesBoost");
			eReports.setSystemInfo("Platform", System.getProperty("os.name"));
			eReports.setSystemInfo("Environment", "QA");
			eReports.setSystemInfo("Browser", cap.getBrowserName().substring(0, 1).toUpperCase()+ cap.getBrowserName().substring(1).toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementEnabled(WebElement element) {
		try {
			if (element.getAttribute("disabled").equals(null))
				return true;
			else
				return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean isChecked(WebElement element) {
		try {
			element.isSelected();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickIfElementIsPresent(WebElement element) {
		try {
			wait30Sec = new WebDriverWait(driver, 05);
			wait30Sec.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			System.out.println("Waited for 5 seconds");
		}
	}

	public void waitForElementToLoad(WebElement element) {
		try {
			wait30Sec = new WebDriverWait(driver, 30);// for normal explicit wait
			wait30Sec.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Waited for 30 seconds");
			e.printStackTrace();
		}
	}

	public void fileUploadWait(WebElement element) {
		try {
			wait600Sec = new WebDriverWait(driver, 600);// for normal explicit wait
			wait600Sec.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Waited for 600 seconds");
			e.printStackTrace();
		}
	}

	public void waitIfElementClickIsIntercepted(WebElement element, String action, String value) {
		wait30Sec = new WebDriverWait(driver, 30);// for normal explicit wait
		for (int i = 0; i < 20; i++) {
			try {
				wait30Sec.until(ExpectedConditions.visibilityOf(element));
				if (action.equals("click") || action.equals("checkbox"))
					element.click();
				// else if (action.equals("clear"))
				// element.clear();
				else if (action.equals("select"))
					element.sendKeys(value);
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println("Click Intercepted: waitIfElementClickIsIntercepted");
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale Exception: waitIfElementClickIsIntercepted");
			} catch (Exception e) {
				System.out.println("Stale Exception: waitIfElementClickIsIntercepted");
			}
		}
	}

	public String staleExceptionOnMessage(WebElement element) {
		String message = "";
		wait30Sec = new WebDriverWait(driver, 02);// for normal explicit wait
		for (int i = 0; i < 5; i++) {
			try {
				wait30Sec.until(ExpectedConditions.visibilityOf(element));
				message = element.getText();
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale Exception: staleExceptionOnMessage");
			} catch (NoSuchElementException e) {
				System.out.println("No Such Element: staleExceptionOnMessage");
			} catch (Exception e) {
				System.out.println("Exception: staleExceptionOnMessage");
			}
		}
		return message;
	}

	private String getCurrentDateTime() {
		try {
			log.info("Current date and time");
			df = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
			date = new Date();
			System.setProperty("currentDateTime", df.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentDateTime = df.format(date);
	}
}
