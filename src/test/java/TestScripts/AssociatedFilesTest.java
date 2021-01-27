package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AssociatedFilesPage;
import ObjectRepository.CoursesPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;

import TestData.AddCourseTestData;
import TestData.CourseFilterData;
import TestData.TestDataImport;

public class AssociatedFilesTest extends BaseClass{
	LoginPage obj;
	MainMenuPage menuObj;
	CoursesPage coursesObj;
	static AddCourseTestData TestDataObj;
	static TestDataImport excelImportObj;
	static CourseFilterData filterDataObj;
	static AssociatedFilesPage AFobj;
	static String[] testData;

	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				coursesObj = new CoursesPage(driver);
				AFobj = new AssociatedFilesPage(driver);
				//chromeDriver();
				//driver.get("https://qa.salesboost.com/");
				TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("AssociatedFiles");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	@Test(priority = 1)
	public void AssociatedPageAddFileDataTest() {
		try {
		testData = TestDataObj.AssociatedFilesData();
		obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Three");
		AFobj.addFileButtonTest();
		AFobj.editAssociatedFilesTest(testData[0], testData[1]);
		sleep(1000);
		actualstring = AFobj.linkText.getText();
		expectedstring = testData[1];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 2)
	public void AssociatedPageAddIncompleteFileDataTest() {
		testData = TestDataObj.AssociatedFilesData();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("TestCourse1");
		AFobj.addFileButtonTest();
		AFobj.associatedFileIncompleteDetailsTest(testData[0]);
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
