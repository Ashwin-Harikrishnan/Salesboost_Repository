package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class ATASnippetPage extends BaseClass{
	static WebDriver driver;
	
	@FindBy(xpath = "//input[@name = 'submit']")
	public WebElement ATAAddSnippetButton;
	@FindBy(xpath = "//input[@name = 'submit']//following::input[1]")
	public WebElement snippetUpload;
	@FindBy(xpath = "//textarea[@id='Snippet_ScriptSnippet']")
	public WebElement snippetDescription;
	@FindBy(xpath = "//a[contains(text(),'Add Audio Snippet')]")
	public WebElement ATAAddSnippet;
	
	
	
	
	public void addSnippet(String snippedURL, String snippetDesc) {
		ATAAddSnippet.click();
		waitForElementToLoad(snippetUpload);
		snippetUpload.sendKeys(snippedURL);
		snippetDescription.sendKeys(snippetDesc);
		ATAAddSnippetButton.click();
	}
	
	
	
	public ATASnippetPage(WebDriver driver) {
		ATASnippetPage.driver = driver;
		PageFactory.initElements(ATASnippetPage.driver, this);
	}
	
}
