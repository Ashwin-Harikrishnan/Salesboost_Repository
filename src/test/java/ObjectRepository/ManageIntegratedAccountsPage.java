package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class ManageIntegratedAccountsPage extends BaseClass {
static WebDriver driver;	
	
	
	@FindBy(xpath = "//input[@name = 'searchResults']")
	public WebElement searchField;
	@FindBy(xpath = "//input[@class = 'button btn-width']")
	public WebElement searchBtn;
	@FindBy(xpath = "//span[contains(text(),'View')]")
	public WebElement viewBtn;
	
	public void searchForEntry() {
		searchField.sendKeys("Bee");
		searchBtn.click();
		viewBtn.click();
	}
	
	
	
	public ManageIntegratedAccountsPage(WebDriver driver) {
		ManageIntegratedAccountsPage.driver = driver;
		PageFactory.initElements(ManageIntegratedAccountsPage.driver, this);
	}
}
