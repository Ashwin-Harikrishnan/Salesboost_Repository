package TestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.ActiveUsersPage;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import ObjectRepository.ManageIntegratedAccountsPage;
 import ObjectRepository.ViewAccountsPage;

public class ActiveUserTest extends BaseClass{
	LoginPage obj;
	MainMenuPage menuObj;
	ManageIntegratedAccountsPage MIAobj;
	ViewAccountsPage VAPobj;
	ActiveUsersPage AUPobj;
	
	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				MIAobj = new ManageIntegratedAccountsPage(driver);
				VAPobj = new ViewAccountsPage(driver);
				AUPobj = new ActiveUsersPage(driver);
				chromeDriver();
				driver.get("https://qa.salesboost.com/");
				/*TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("Sheet1");*/

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	@Test
	public void deactivateUserTest() {
		obj.login();
		sleep(1000);
		menuObj.navigateToManageIntegratedAccountsPage();
		sleep(1000);
		MIAobj.searchForEntry();
		sleep(1000);
		VAPobj.searchForEntry();
		sleep(1000);
		AUPobj.activeUsersTab.click();
		AUPobj.deactivateUser();
		
	}
	
	@Test
	public void deactivateSelectedTest() {
		obj.login();
		sleep(1000);
		menuObj.navigateToManageIntegratedAccountsPage();
		sleep(1000);
		MIAobj.searchForEntry();
		sleep(1000);
		VAPobj.searchForEntry();
		sleep(1000);
		AUPobj.activeUsersTab.click();
		AUPobj.deactivateSelected();
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
