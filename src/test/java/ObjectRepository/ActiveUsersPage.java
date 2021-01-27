package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class ActiveUsersPage extends BaseClass{
static WebDriver driver;	
	
	
	@FindBy(xpath = "//a[contains(text(),'Active Users')]")
	public WebElement activeUsersTab;
	@FindBy(xpath = "//th[contains(text(),'First Name')]//following::input[1]")
	public WebElement requestCheckbox;
	@FindBy(xpath = "//span[contains(text(),'Deactivate Selected Users')]")//HAS TO BE CLICKED AFTER SEARCH
	public WebElement deactivateUserBtn;
	@FindBy(xpath = "//input[@type = 'search']")
	public WebElement searchField;
	@FindBy(xpath = "//span[contains(text(),'Reject Selected Requests')]")//HAS TO BE CLICKED AFTER SELECTING ENTRIES
	public WebElement deactivateSelectedBtn;
	@FindBy(xpath = "//input[@id='checkall']")
	public WebElement checkAllBtn;
	
	public void deactivateUser() {
		searchField.sendKeys("User1");
		requestCheckbox.click();
		deactivateUserBtn.click();
	}
	
	public  void deactivateSelected() {
		checkAllBtn.click();
		deactivateSelectedBtn.click();
	}
	public ActiveUsersPage(WebDriver driver) {
		ActiveUsersPage.driver = driver;
		PageFactory.initElements(ActiveUsersPage.driver, this);
	}
}
