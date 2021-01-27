package TestScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ObjectRepository.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage obj;
	@BeforeClass
	public void initialize() {
		try {
			obj = new LoginPage(driver);
			chromeDriver();
			driver.get("https://qa.salesboost.com/");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	 
	@Test
	public void loginTest() {
		obj.login();
	}

}
