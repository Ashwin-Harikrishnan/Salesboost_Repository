package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class MainMenuPage extends BaseClass{
	static WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(),'Content')]")
	public WebElement ContentBtn;
	@FindBy(xpath = "//a[contains(text(),'Content')]//following::a[1]")
	public WebElement CoursesBtn;
	@FindBy(xpath = "//a[contains(text(),'TestCourse1')]")
	public WebElement AudioTestBtn;
	@FindBy(xpath = "//a[contains(text(),'Add New Course')]")
	public WebElement addCourseBtn;
	@FindBy(xpath = "//a[contains(text(),'Users')]")
	public WebElement usersBtn;
	@FindBy(xpath = "//a[contains(text(),'Manage Integrated Accounts')]")
	public WebElement manageIntegratedAccountsBtn;
	
	
	
	
	public void navigateToManageIntegratedAccountsPage() {
		waitForElementToLoad(usersBtn);
		usersBtn.click();
		manageIntegratedAccountsBtn.click();
		
	}

	
	public MainMenuPage(WebDriver driver) {
		MainMenuPage.driver = driver;
		PageFactory.initElements(MainMenuPage.driver, this);
	}
	
	
}
