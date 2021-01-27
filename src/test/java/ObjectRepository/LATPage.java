package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class LATPage extends BaseClass{
	
	static WebDriver driver;
	
	//LAT
		@FindBy(xpath = "//a[contains(text(),'Live Action Training Video (LAT)')]")
		public WebElement LATTabBtn;
		@FindBy(xpath = "//h2[contains(text(),'Live Action Training Video (LAT)')]//following::input[1]")
		public WebElement LATUploadBtn;
		@FindBy(xpath = "//p[contains(text(),'Current File:')]")
		public WebElement LATUploadVerificationText;
		@FindBy(xpath = "//input[@id='LatAndFileList_0__LAT_Name']")
		public WebElement LATVideoName;
		@FindBy(xpath = "//textarea[@id='LatAndFileList_0__LAT_Description']")
		public WebElement LATVideoDescription;
		@FindBy(xpath = "//p[contains(text(),'Current File:')]//following::input[2]")
		public WebElement deleteBtn;
		@FindBy(xpath = "//a[contains(text(),'Live Action Training Video (LAT)')]//following::input[5]")
		public WebElement AddLAT2ndBtn;
		@FindBy(xpath = "//a[contains(text(),'Live Action Training Video (LAT)')]//following::input[1]")
		public WebElement AddUpdateLATBtn;
		@FindBy(xpath = "//input[@id='add-lat']")
		public WebElement AddLATBtn;
		
		
		
		public LATPage(WebDriver driver) {
			LATPage.driver = driver;
			PageFactory.initElements(LATPage.driver, this);
		}
		
		public void addLAT() {
			AddLAT2ndBtn.click();
		}
		public void editLATPage(String videoURL, String videoName, String videoDescription) {
			LATTabBtn.click();
			AddLATBtn.click();
			LATUploadBtn.sendKeys(videoURL);
			LATVideoName.sendKeys(videoName);
			LATVideoDescription.sendKeys(videoDescription);
		
		}
		public void editLATError(String videoURL, String videoName) {
			LATTabBtn.click();
			LATUploadBtn.sendKeys(videoURL);
			LATVideoName.sendKeys(videoName);
			LATVideoDescription.sendKeys("Error test description");
		}
		public void addUpdateLAT() {
			AddUpdateLATBtn.click();
		}
		public void deleteLAT() {
			LATTabBtn.click();
			AddLAT2ndBtn.click();
		}
		
		


}
