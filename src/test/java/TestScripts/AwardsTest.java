package TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.AwardPage;
import ObjectRepository.CoursesPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import TestData.AddCourseTestData;
import TestData.CourseFilterData;
import TestData.TestDataImport;

public class AwardsTest extends BaseClass{
	LoginPage obj;
	MainMenuPage menuObj;
	CoursesPage coursesObj;
	static AddCourseTestData TestDataObj;
	static TestDataImport excelImportObj;
	static CourseFilterData filterDataObj;
	static AwardPage awardsObj;
	static String[] testData;

	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				coursesObj = new CoursesPage(driver);
				awardsObj = new AwardPage(driver);
				//chromeDriver();
				//driver.get("https://qa.salesboost.com/");
				TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("Awards");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Test(priority = 1)
	public void addAwardDataTest() {
		try {
		testData = TestDataObj.AwardData();
		//String verification = "";
		obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("Course Three");
		awardsObj.editAwardsPage(testData[0], testData[1],testData[2] ,testData[3], testData[4]);
		sleep(1000);
		awardsObj.addUpdateAwards();
		sleep(2000);
		
		//VERIFICATION
		/*ArrayList<String> actualArray = new ArrayList<String>();
		verification = awardsObj.CertificateSignName.getText();
		actualArray.add(verification);
		verification = awardsObj.CertificateSignTitle.getText();
		actualArray.add(verification);
		System.out.println("ACTUAL: "+actualArray);
		
		ArrayList<String> expectedArray = new ArrayList<String>();
		expectedArray.add(testData[1]);
		expectedArray.add(testData[2]);
		System.out.println("EXPECTED: "+expectedArray);*/
		
		actualstring = awardsObj.CertificateSignName.getText();
		expectedstring = testData[1];
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Actual: " + actualstring + "\nExpcted: " + expectedstring);
		Assert.assertEquals(actualstring, expectedstring);
	}
	
	@Test(priority = 2)
	public void awardsClearAllTest() {
		testData = TestDataObj.AwardData();
		//obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.searchCourses("TestCourse1");
		awardsObj.editAwardsPage(testData[0], testData[1],testData[2] ,testData[3], testData[4]);
		awardsObj.clearAwards();
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
