package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class OpenRequestsPage extends BaseClass{
	static WebDriver driver;	
	
	
	@FindBy(xpath = "//a[contains(text(),'Open Requests')]")
	public WebElement openRequestsTab;
	@FindBy(xpath = "//input[@id='checkall']")
	public WebElement checkallBtn;
	@FindBy(xpath = "//th[contains(text(),'First Name')]//following::input[1]")
	public WebElement requestCheckbox;
	@FindBy(xpath = "//span[contains(text(),'Process')]")//HAS TO BE CLICKED AFTER SEARCH
	public WebElement processBtn;
	@FindBy(xpath = "//input[@type = 'search']")
	public WebElement searchField;
	@FindBy(xpath = "//span[contains(text(),'Reject Selected Requests')]")//HAS TO BE CLICKED AFTER SELECTING ENTRIES
	public WebElement rejectSelectedBtn;
	@FindBy(xpath = "//textarea[@id='txtRejectionNotes']")
	public WebElement rejectSelectedNotesField;
	@FindBy(xpath = "//button[@id='rejectRequestsButton']")
	public WebElement rejectSelectedSaveBtn;
	@FindBy(xpath = "//p[contains(text(),'Are you sure you want to reject the selected reque')]//following::button[2]")
	public WebElement rejectSelectedCancelBtn;
	
	
	public void searchForEntry() {
		searchField.sendKeys("learner");
		processBtn.click();
	}
	public void checkall() {
		checkallBtn.click();
		rejectSelectedBtn.click();
		rejectSelectedNotesField.sendKeys("Test Reject");
		rejectSelectedSaveBtn.click();
	}
	
	
	public static void mulitpleCheckboxClick(int checkNumber)
	{
		for(int i=1;i<checkNumber;i++)
		{
	    WebElement cCheckBox =  driver.findElement(By.xpath("//th[contains(text(),'First Name')]//following::input["+i+"]"));
	    cCheckBox.click();
		}
	}
	
	public OpenRequestsPage(WebDriver driver) {
		OpenRequestsPage.driver = driver;
		PageFactory.initElements(OpenRequestsPage.driver, this);
	}
	
}
