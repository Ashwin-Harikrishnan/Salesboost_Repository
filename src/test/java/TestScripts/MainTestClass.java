package TestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.CoursesPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;


public class MainTestClass extends BaseClass{
	LoginPage obj;
	MainMenuPage menuObj;
	CoursesPage coursesMenuObj;
	
	
	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				coursesMenuObj = new CoursesPage(driver);
				chromeDriver();
				driver.get("https://qa.salesboost.com/");


		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Test
	public void TestLogin() {
		
		obj.login();
		sleep(1000);
		menuObj.ContentBtn.click();
		sleep(1000);
		menuObj.CoursesBtn.click();
		sleep(1000);
		coursesMenuObj.searchCourses("TestCourse1");
		
		
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
