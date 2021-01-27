package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class RejectedRequestsPage extends BaseClass{
static WebDriver driver;	
	
	
	@FindBy(xpath = "///a[contains(text(),'Rejected Requests')]")
	public WebElement rejecctedRequestsTab;
	@FindBy(xpath = "//th[contains(text(),'First Name')]//following::input[1]")
	public WebElement requestCheckbox;
	@FindBy(xpath = "//span[contains(text(),'Process')]")//HAS TO BE CLICKED AFTER SEARCH
	public WebElement processBtn;
	@FindBy(xpath = "//input[@type = 'search']")
	public WebElement searchField;
	@FindBy(xpath = "//span[contains(text(),'Reject Selected Requests')]")//HAS TO BE CLICKED AFTER SELECTING ENTRIES
	public WebElement rejectSelectedBtn;
	
	
	
	public RejectedRequestsPage(WebDriver driver) {
		RejectedRequestsPage.driver = driver;
		PageFactory.initElements(RejectedRequestsPage.driver, this);
	}
}
