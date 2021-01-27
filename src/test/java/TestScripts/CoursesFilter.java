package TestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.CoursesPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import TestData.AddCourseTestData;
import TestData.CourseFilterData;
import TestData.TestDataImport;

public class CoursesFilter extends BaseClass {
	LoginPage obj;
	MainMenuPage menuObj;
	CoursesPage coursesObj;
	static AddCourseTestData TestDataObj;
	static TestDataImport excelImportObj;
	static CourseFilterData filterDataObj;
	static String[] testData;
	
	
	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				coursesObj = new CoursesPage(driver);
				chromeDriver();
				driver.get("https://qa.salesboost.com/");
				TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("Sheet1");

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Test
	public void courseTypeFilter() {
		testData = TestDataObj.coursesFilterList();
		obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesObj.courseFilterList.sendKeys(testData[1]);
		System.out.println("THE DATA BEING SENT IS: "+testData[1]);
		/*Select dropdown = new Select(coursesObj.courseFilterList);
		dropdown.selectByValue(testData[1]);*/
		
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
