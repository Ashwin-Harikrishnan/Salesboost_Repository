package TestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddCoursePage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import ObjectRepository.ManageIntegratedAccountsPage;
import ObjectRepository.OpenRequestsPage;
import ObjectRepository.ProcessRequestPopUpPage;
import ObjectRepository.ViewAccountsPage;
import TestData.AddCourseTestData;
import TestData.CourseFilterData;
import TestData.TestDataImport;


public class OpenRequestsTest extends BaseClass{
	LoginPage obj;
	MainMenuPage menuObj;
	ManageIntegratedAccountsPage MIAobj;
	ViewAccountsPage VAPobj;
	OpenRequestsPage ORPobj;
	ProcessRequestPopUpPage PRPobj;
	static AddCourseTestData TestDataObj;
	static TestDataImport excelImportObj;
	static CourseFilterData filterDataObj;
	static AddCoursePage addCoursesPageObj;
	static String[] testData;
	
	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				MIAobj = new ManageIntegratedAccountsPage(driver);
				VAPobj = new ViewAccountsPage(driver);
				ORPobj = new OpenRequestsPage(driver);
				PRPobj = new ProcessRequestPopUpPage(driver);
				chromeDriver();
				driver.get("https://qa.salesboost.com/");
				TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("OpenRequestForm");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	@Test
	public void openRequestSearchForEntryTest() {
		obj.login();
		sleep(1000);
		menuObj.navigateToManageIntegratedAccountsPage();
		sleep(1000);
		MIAobj.searchForEntry();
		sleep(1000);
		VAPobj.searchForEntry();
		sleep(1000);
		ORPobj.openRequestsTab.click();
		ORPobj.searchForEntry();
		sleep(500);
		PRPobj.addProcessDetails(testData[1], testData[2], testData[3], testData[4], testData[6], testData[7], testData[8], testData[9]);
		
	}
	
	@Test
	public void openRequestCheckAllRejectTest() {
		obj.login();
		sleep(1000);
		menuObj.navigateToManageIntegratedAccountsPage();
		sleep(1000);
		MIAobj.searchForEntry();
		sleep(1000);
		VAPobj.searchForEntry();
		sleep(1000);
		ORPobj.openRequestsTab.click();
		ORPobj.checkall();
	}
	
	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
