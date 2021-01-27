package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class DeactivatedUsersPage extends BaseClass{
static WebDriver driver;	
	
	
	@FindBy(xpath = "//a[contains(text(),'Deactivated Users')]")
	public WebElement deactivatedUsersTab;
	@FindBy(xpath = "//th[contains(text(),'First Name')]//following::input[1]")
	public WebElement requestCheckbox;
	@FindBy(xpath = "//input[@id='checkall']")
	public WebElement checkAllBtn;
	@FindBy(xpath = "//span[contains(text(),'Activate User')]")//HAS TO BE CLICKED AFTER SEARCH
	public WebElement activateUserBtn;
	@FindBy(xpath = "//input[@type = 'search']")
	public WebElement searchField;
	@FindBy(xpath = "//span[contains(text(),'Activate Selected Users')]")//HAS TO BE CLICKED AFTER SELECTING ENTRIES
	public WebElement activateSelectedBtn;
	
	public void activateUser() {
		searchField.sendKeys("User1");
		requestCheckbox.click();
		activateUserBtn.click();
	}
	
	public  void activateSelected() {
		checkAllBtn.click();
		activateSelectedBtn.click();
	}
	
	
	public DeactivatedUsersPage(WebDriver driver) {
		DeactivatedUsersPage.driver = driver;
		PageFactory.initElements(DeactivatedUsersPage.driver, this);
	}
}
