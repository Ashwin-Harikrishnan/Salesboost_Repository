package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class ProcessRequestPopUpPage extends BaseClass{
	static WebDriver driver;

	
	@FindBy(xpath = "//input[@id='txtUserName']")
	public WebElement userName;
	@FindBy(xpath = "//input[@id='txtFirstName']")
	public WebElement firstName;
	@FindBy(xpath = "//input[@id='txtLastName']")
	public WebElement lastName;
	@FindBy(xpath = "//input[@id='txtEmail']")
	public WebElement email;
	@FindBy(xpath = "//input[@id='txtEmail']")
	public WebElement phoneNo;
	@FindBy(xpath = "//select[@id='selectedAccount']")
	public WebElement accountName;
	@FindBy(xpath = "//select[@id='selectedProperty']")
	public WebElement propertyName;
	@FindBy(xpath = "//select[@id='selectedLevel']")
	public WebElement level;
	@FindBy(xpath = "//select[@id='selectedFocus']")
	public WebElement focusTrack;
	@FindBy(xpath = "//select[@id='selectedManager']")
	public WebElement reportingManager;
	@FindBy(xpath = "//input[@id='btnApprove']")
	public WebElement approveBtn;
	@FindBy(xpath = "//input[@id='btnReject']")
	public WebElement rejectBtn;
	@FindBy(xpath = "//input[@id='btnSaveLater']")
	public WebElement saveForLaterBtn;
	
	public void addProcessDetails(String fName, String lName, String email1, String pNumber,String propertyN, String Level,String FTrack, String  rManager) {
		firstName.sendKeys("Test");
		lastName.sendKeys("Learner");
		email.sendKeys("abcXYZ@gmail.com");
		phoneNo.sendKeys("908098422");
		propertyName.sendKeys("test");
		level.sendKeys("Individual");
		focusTrack.sendKeys("Leadership");
		reportingManager.sendKeys("");
	}
	public void approveProcess() {
		approveBtn.click();
	}
	
	public void rejectProcess() {
		rejectBtn.click();
	}
	public ProcessRequestPopUpPage(WebDriver driver) {
		ProcessRequestPopUpPage.driver = driver;
		PageFactory.initElements(ProcessRequestPopUpPage.driver, this);
	}
	
	
}
