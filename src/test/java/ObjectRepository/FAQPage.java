package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FAQPage {
	
	static WebDriver driver;
	
	//FAQ
		@FindBy(xpath = "//a[contains(text(),'Course FAQ')]")
		public WebElement FAQTabBtn;
		@FindBy(xpath = "//a[contains(text(),'Course FAQ')]//following::input[1]")
		public WebElement FAQAddUpdateBtn;
		@FindBy(xpath = "//textarea[@id='Course_FAQs_0__Question']")
		public WebElement FAQQuestion;
		@FindBy(xpath = "//th[contains(text(),'Answer')]//following::iframe")
		public WebElement FAQAnswer;
		
		
		@FindBy(xpath = "//input[@class = 'delete-faq-button button red']")
		public WebElement FAQDeleteBtn;
		@FindBy(xpath = "//input[@id='add-faq']")
		public WebElement FAQAddFAQBtn;
		
		public void addQuestionAnswerDetails(String question, String answer) {
			FAQTabBtn.click();
			FAQAddFAQBtn.click();
			FAQQuestion.clear();
			FAQQuestion.sendKeys(question);
			FAQAnswer.clear();
			FAQAnswer.sendKeys(answer);
			
		}
		public void updateFAQ() {
			FAQAddUpdateBtn.click();
		}
		public void deleteFAQ() {
			FAQDeleteBtn.click();
		}
		
		public FAQPage(WebDriver driver) {
			FAQPage.driver = driver;
			PageFactory.initElements(FAQPage.driver, this);
		}
		
		
}
