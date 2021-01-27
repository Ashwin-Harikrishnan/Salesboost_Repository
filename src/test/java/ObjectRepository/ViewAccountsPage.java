package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class ViewAccountsPage extends  BaseClass{
static WebDriver driver;	
	
	
	@FindBy(xpath = "//input[@name = 'searchResults']")
	public WebElement searchField;
	@FindBy(xpath = "//input[@class = 'button btn-width']")
	public WebElement searchBtn;
	@FindBy(xpath = "//span[contains(text(),'View')]")//HAS TO BE CLICKED AFTER SEARCH
	public WebElement viewBtn;
	@FindBy(xpath = "//span[contains(text(),'Back')]")
	public WebElement backBtn;
	
	public void searchForEntry() {
		searchField.sendKeys("Rani");
		waitForElementToLoad(viewBtn);
		searchBtn.click();
		viewBtn.click();
	}
	public void back() {
		backBtn.click();
	}
	
	
	
	
	public ViewAccountsPage(WebDriver driver) {
		ViewAccountsPage.driver = driver;
		PageFactory.initElements(ViewAccountsPage.driver, this);
	}
}
