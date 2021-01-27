package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class AssociatedFilesPage extends BaseClass{
	static WebDriver driver;

	
	@FindBy(xpath = "//a[contains(text(),'Associated Files')]")
	public WebElement AssociatedFileTabBtn;
	//a[contains(text(),'Associated Files')]
	@FindBy(xpath = "//a[contains(text(),'Associated Files')]//following::input[1]")
	public WebElement AssociatedFileUpdateAddBtn;
	
	@FindBy(xpath = "//input[@name='file']")
	public WebElement AssociatedFileUploadFile;
	
	@FindBy(xpath = "//input[@id='File_LinkText']")
	public WebElement AssociatedFileLinkText;
	
	@FindBy(xpath = "//a[contains(text(),'Add File')]")
	public WebElement addFileBigBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Associated Files')]//following::input[1]")
	public WebElement addFileSmallBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Associated Files')]//following::input[2]")
	public WebElement fileUploadBtn;
	
	@FindBy(xpath = "//input[@id='File_LinkText']")
	public WebElement linkText;
	@FindBy(xpath = "//th[contains(text(),'Link Text')]//following::td[2]")
	public WebElement linkTextVerification;
	
	
	
	
	public AssociatedFilesPage(WebDriver driver) {
		AssociatedFilesPage.driver = driver;
		PageFactory.initElements(AssociatedFilesPage.driver, this);
	}
	
	public void addFileButtonTest() {
		AssociatedFileTabBtn.click();
		waitForElementToLoad(addFileBigBtn);
		addFileBigBtn.click();
	}
	
	public void editAssociatedFilesTest(String fileURL, String linktext) {
	System.out.println("edit files test start");
		fileUploadBtn.sendKeys(fileURL);
		linkText.sendKeys(linktext);
		addFileSmallBtn.click();
		
		
	}
	public void associatedFileIncompleteDetailsTest(String fileURL) {
		System.out.println("incompkete test start");
		fileUploadBtn.sendKeys(fileURL);
		linkText.sendKeys("");
		addFileSmallBtn.click();
	}
	
}
