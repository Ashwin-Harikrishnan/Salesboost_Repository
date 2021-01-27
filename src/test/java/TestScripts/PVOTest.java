package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AddCoursePage;
import ObjectRepository.CoursesPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import ObjectRepository.PVOAddQuestionsPage;
import ObjectRepository.PVOPage;
import TestData.AddCourseTestData;
import TestData.CourseFilterData;
import TestData.TestDataImport;

public class PVOTest extends BaseClass{
	LoginPage obj;
	MainMenuPage menuObj;
	CoursesPage coursesObj;
	static AddCourseTestData TestDataObj;
	static TestDataImport excelImportObj;
	static CourseFilterData filterDataObj;
	static AddCoursePage addCoursesPageObj;
	static PVOPage PVOobj;
	static PVOAddQuestionsPage PVOQnsobj;
	static String[] testData;

	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				coursesObj = new CoursesPage(driver);
				addCoursesPageObj = new AddCoursePage(driver);
				PVOQnsobj = new PVOAddQuestionsPage(driver);
				PVOobj = new PVOPage(driver);
				/*chromeDriver();
				driver.get("https://qa.salesboost.com/");*/
				TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("PVO");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Test(priority =1)
	public void addPVODataTest() {
		try {
		testData = TestDataObj.PVOData();
		obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Three");
		PVOobj.addPVOData(testData[0], testData[1], testData[2], testData[3]);
		PVOobj.updatePVO();
		sleep(1000);
		actualstring = PVOobj.PVOVideoName.getText();
		expectedstring = testData[2];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		
	}
	@Test(priority = 2)
	public void addPVOScoreBasedTest() {
		try {
		testData = TestDataObj.PVOData();
		obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Three");
		PVOobj.addPVOData(testData[0], testData[1], testData[2], testData[3]);
		PVOQnsobj.addQuestions(testData[7], testData[8], Boolean.parseBoolean(testData[9]), testData[10]);
		PVOobj.PVOScoreBasedPostQns(Boolean.parseBoolean(testData[6]), testData[5]);
		PVOobj.updatePVO();
		sleep(1000);
		actualstring = PVOobj.PVOVideoName.getText();
		expectedstring = testData[2];
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
