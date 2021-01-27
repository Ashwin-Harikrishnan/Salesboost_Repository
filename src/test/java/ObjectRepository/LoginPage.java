package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;


public class LoginPage extends BaseClass{
	
	static WebDriver driver;
	
	
	@FindBy(xpath = "//input[@id='Email']")
	public WebElement emailField;
	@FindBy(xpath = "//input[@id='Password']")
	public WebElement passwordField;
	@FindBy(xpath = "//input[@class='button action']")
	public WebElement loginBtn;
	
	public void login() {
		waitForElementToLoad(emailField);
		emailField.sendKeys("balu.kr@experionglobal.com");
		passwordField.sendKeys("qI85Jx$3");
		clickIfElementIsPresent(loginBtn);
		
	}
	
	
	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
		PageFactory.initElements(LoginPage.driver, this);
	}
	
	
	
}
