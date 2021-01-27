package TestScripts;

import org.testng.annotations.BeforeClass;

import BaseClass.BaseClass;
import ObjectRepository.LoginPage;
import ObjectRepository.MainMenuPage;
import ObjectRepository.ManageIntegratedAccountsPage;
import ObjectRepository.OpenRequestsPage;
import ObjectRepository.RejectedRequestsPage;
import ObjectRepository.ViewAccountsPage;

public class RejectedRequestsTest extends BaseClass{
	LoginPage obj;
	MainMenuPage menuObj;
	ManageIntegratedAccountsPage MIAobj;
	ViewAccountsPage VAPobj;
	RejectedRequestsPage RRPobj;
	
	@BeforeClass
	public void initialize() {
			try {
				obj = new LoginPage(driver);
				menuObj = new MainMenuPage(driver);
				MIAobj = new ManageIntegratedAccountsPage(driver);
				VAPobj = new ViewAccountsPage(driver);
				RRPobj = new RejectedRequestsPage(driver);
				chromeDriver();
				driver.get("https://qa.salesboost.com/");
				/*TestDataObj = new AddCourseTestData();
				excelImportObj = new TestDataImport();
				excelImportObj.readExcel("Sheet1");*/

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	

}
