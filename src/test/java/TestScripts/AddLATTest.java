package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddCoursePage;
import ObjectRepository.CoursesPage;
import ObjectRepository.LATPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import TestData.AddCourseTestData;
import TestData.CourseFilterData;
import TestData.TestDataImport;

public class AddLATTest extends BaseClass{
	LoginPage obj;
	MainMenuPage menuObj;
	CoursesPage coursesObj;
	static AddCourseTestData TestDataObj;
	static TestDataImport excelImportObj;
	static CourseFilterData filterDataObj;
	static AddCoursePage addCoursesPageObj;
	static LATPage LATobj;
	static String[] testData;

	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				coursesObj = new CoursesPage(driver);
				addCoursesPageObj = new AddCoursePage(driver);
				LATobj = new LATPage(driver);
				/*chromeDriver();
				driver.get("https://qa.salesboost.com/");*/
				TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("LAT");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	@Test(priority = 1)
	public void addLATTest() {
		try {
			eTest = eReports.createTest("Add LAT");
			eTest.assignCategory("Courses");
		testData = TestDataObj.LATData();
		obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Two");
		LATobj.editLATPage(testData[0], testData[1], testData[2]);
		LATobj.AddUpdateLATBtn.click();
		sleep(3000);
		actualstring = LATobj.LATVideoName.getText();
		expectedstring = testData[1];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
	}
	
	@Test(priority = 2)
	public void addLATIncorrectDetails() {
		eTest = eReports.createTest("Add LAT incomplete");
		eTest.assignCategory("Courses");
		testData = TestDataObj.LATData();
		//obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Two");
		LATobj.editLATError(testData[0], testData[1]);
	}
	
	@Test(priority = 3)
	public void deleteLAT() {
		eTest = eReports.createTest("Delete LAT");
		eTest.assignCategory("Courses");
		//obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Two");
		sleep(1000);
		LATobj.deleteLAT();
		
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
