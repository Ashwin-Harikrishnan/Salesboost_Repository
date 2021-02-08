package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.ATAPage;
import ObjectRepository.ATASnippetPage;
import ObjectRepository.CoursesPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import TestData.AddCourseTestData;
import TestData.CourseFilterData;
import TestData.TestDataImport;

public class ATATest extends BaseClass{
	LoginPage obj;
	MainMenuPage menuObj;
	CoursesPage coursesObj;
	static AddCourseTestData TestDataObj;
	static TestDataImport excelImportObj;
	static CourseFilterData filterDataObj;
	static ATAPage ATAobj;
	static ATASnippetPage snippetObj;
	static String[] testData;

	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				coursesObj = new CoursesPage(driver);
				ATAobj = new ATAPage(driver);
				snippetObj = new ATASnippetPage(driver);
				/*chromeDriver();
				driver.get("https://qa.salesboost.com/");*/
				TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("ATA");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Test(priority = 1)
	public void addATADataTest() {
		try {
			eTest = eReports.createTest("Add ATA");
			eTest.assignCategory("Courses");
		
		testData = TestDataObj.ATAData();
		obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Two");
		ATAobj.editATAPage(testData[0], testData[1], testData[2]);
		ATAobj.updateATA();
		sleep(1000);
		actualstring = ATAobj.ATAIntroText.getText();
		expectedstring = testData[0];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		
	}
	
	@Test(priority = 2)
	public void addSnippetPageTest() {
		try {
			eTest = eReports.createTest("Add ATA snippet");
			eTest.assignCategory("Courses");
		testData = TestDataObj.ATAData();
		//obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Two");
		sleep(1000);
		ATAobj.ATATabBtn.click();
		snippetObj.addSnippet(testData[3], testData[4]);
		sleep(1000);
		actualstring = snippetObj.snippetDescription.getText();
		expectedstring = testData[4];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
	
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
