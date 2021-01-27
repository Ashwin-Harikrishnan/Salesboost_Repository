package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class AwardPage extends BaseClass{
	static WebDriver driver;

	
	@FindBy(xpath = "//a[contains(text(),'Award')]")
	public WebElement AwardsPageTab;
	@FindBy(xpath = "//select[@id='selectwhitelabel']")
	public WebElement AwardsPageDropDown;
	
	@FindBy(xpath = "//input[@id='certificatesignatoryName']")
	public WebElement CertificateSignName;
	
	@FindBy(xpath = "//input[@id='certificateSignatoryTitle']")
	public WebElement CertificateSignTitle;
	@FindBy(xpath = "//input[@id='certificateSignature']")
	public WebElement CertificateSignUpload;
	@FindBy(xpath = "//input[@id='certificateFooterLogo']")
	public WebElement CertificateLogoUpload;
	@FindBy(xpath = "//input[@id='clearallBtn']")
	public WebElement ClearAllBtn;
	@FindBy(xpath = "//input[@id='settingsBtn']")
	public WebElement UpdateBtn;
	@FindBy(xpath = "//input[@id='viewbtn']")
	public WebElement ViewAllBtn;
	
	
	
	public AwardPage(WebDriver driver) {
		AwardPage.driver = driver;
		PageFactory.initElements(AwardPage.driver, this);
	}
	
	
	public void editAwardsPage(String dropDownOption, String certificateSign,String certitiateTitle,String certificateSignURL, String certificateLogoURL) {
		AwardsPageTab.click();
		waitForElementToLoad(CertificateSignName);
		AwardsPageDropDown.sendKeys(dropDownOption);
		CertificateSignName.clear();
		CertificateSignTitle.clear();
		CertificateSignName.sendKeys(certificateSign);
		CertificateSignTitle.sendKeys(certitiateTitle);
		CertificateSignUpload.sendKeys(certificateSignURL);
		CertificateLogoUpload.sendKeys(certificateLogoURL);
		
		}
	
	public void addUpdateAwards() {
		UpdateBtn.click();
	}
	
	public void clearAwards() {
		ClearAllBtn.click();
	}
	
}
