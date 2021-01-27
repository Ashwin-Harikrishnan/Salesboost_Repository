package TestScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.CoursesPage;
import ObjectRepository.FAQPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import TestData.AddCourseTestData;
import TestData.CourseFilterData;
import TestData.TestDataImport;

public class FAQTest extends BaseClass{
	static LoginPage obj;
	static MainMenuPage menuObj;
	static CoursesPage coursesObj;
	static AddCourseTestData TestDataObj;
	static TestDataImport excelImportObj;
	static CourseFilterData filterDataObj;
	static FAQPage FAQobj;
	static String[] testData;

	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				coursesObj = new CoursesPage(driver);
				FAQobj = new FAQPage(driver);
				/*chromeDriver();
				driver.get("https://qa.salesboost.com/");*/
				TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("FAQ");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Test(priority =1)
	public void FAQUpdateTest() {
		try {
	
		testData = TestDataObj.FAQData();
		obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Three");
		FAQobj.addQuestionAnswerDetails(testData[0], testData[1]);
		FAQobj.updateFAQ();
		sleep(1000);
		actualstring = FAQobj.FAQQuestion.getText();
		expectedstring = testData[0];
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		assertTrue(actualstring.contains(expectedstring));
		
	}
	
	
	@Test(priority = 2)
	public static void FAQDeleteTest() {
		try {
		testData = TestDataObj.FAQData();
		//obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("TestCourse1");
		FAQobj.addQuestionAnswerDetails(testData[0], testData[1]);
		FAQobj.deleteFAQ();
		sleep(1000);
		actualstring = FAQobj.FAQQuestion.getText();
		expectedstring = "";
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
