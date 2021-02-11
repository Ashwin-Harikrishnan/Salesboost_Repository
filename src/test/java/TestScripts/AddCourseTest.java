package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddCoursePage;
import ObjectRepository.CoursesPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import TestData.AddCourseTestData;
import TestData.CourseFilterData;
import TestData.TestDataImport;

public class AddCourseTest extends BaseClass {
	LoginPage obj;
	MainMenuPage menuObj;
	CoursesPage coursesObj;
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
			coursesObj = new CoursesPage(driver);
			addCoursesPageObj = new AddCoursePage(driver);
			// chromeDriver();
			// driver.get("https://qa.salesboost.com/");
			TestDataObj = new AddCourseTestData();
			excelImportObj = new TestDataImport();
			excelImportObj.readExcel("AddCourse");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test(priority = 2)
	public void addCourseTest() {

		try {
			eTest = eReports.createTest("Add courses");
			eTest.assignCategory("Courses");
			log.info("Entered add courses test");
			testData = TestDataObj.AddCourseData();
			obj.login();
			log.info("Login method complete");
			sleep(1000);
			menuObj.ContentBtn.click();
			sleep(1000);
			menuObj.CoursesBtn.click();
			sleep(1000);
			menuObj.addCourseBtn.click();
			addCoursesPageObj.addCourseCompleteDetails(testData[0], testData[1], testData[2],
					Boolean.parseBoolean(testData[3]), Boolean.parseBoolean(testData[4]), testData[5], testData[6],
					Boolean.parseBoolean(testData[7]));

			sleep(1000);

			actualstring = addCoursesPageObj.actualVerificationText.getText();
			expectedstring = testData[0];

		} catch (Exception e) {
			System.out.println(e);
			log.info("Entered verification method");
		}

		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");

	}

	@Test(priority = 1)
	public void addCourseTestIncompleteDetails() {
		try {
			eTest = eReports.createTest("Add courses incomplete");
			eTest.assignCategory("Courses");
			log.info("Entered add courses test Incomplete data");
			testData = TestDataObj.AddCourseData();
			//obj.login();
			sleep(1000);
			menuObj.ContentBtn.click();
			sleep(1000);
			menuObj.CoursesBtn.click();
			sleep(1000);
			menuObj.addCourseBtn.click();
			addCoursesPageObj.addCourseIncompleteDetails(testData[0], testData[1], testData[2],
					Boolean.parseBoolean(testData[3]), Boolean.parseBoolean(testData[4]), testData[5], testData[6],
					Boolean.parseBoolean(testData[7]));
			actualstring = addCoursesPageObj.actualVerificationText.getText();
			expectedstring = "Add Course:";
		} catch (Exception e) {
			System.out.println(e);
			log.info("Entered verification method");
		}

		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		log.info("Verification complete");

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
