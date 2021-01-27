package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class PVOAddQuestionsPage extends BaseClass {
	static WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Presentation with Voice Over Video (PVO)')]")
	public WebElement PVOTabBtn;
	@FindBy(xpath = "//a[contains(text(),'Presentation with Voice Over Video (PVO)')]//following::a[5]")
	public WebElement addQuestionBtn;
	@FindBy(xpath = "//textarea[@id='Question_Question']")
	public WebElement questionTextField;// same for add questions
	@FindBy(xpath = "//textarea[@id='Question_WrongAnswerText']")
	public WebElement wrongAnswerTextField;// same for add answers
	@FindBy(xpath = "//input[@id='orderNum_0']")
	public WebElement orderNumber;
	@FindBy(xpath = "//input[@id='Question_Answers_0__Correct']")
	public WebElement correctCheckbox;
	@FindBy(xpath = "//input[@id='Question_Answers_0__AnswerText']")
	public WebElement answerTextField;
	@FindBy(xpath = "//input[@class = 'delete-answer-button button red']")
	public WebElement deleteEntryBtn;
	@FindBy(xpath = "//th[contains(text(),'Answer Text')]//following::input[7]")
	public WebElement addQuestionEntryBtn;
	@FindBy(xpath = "//a[contains(text(),'Award')]//following::input[1]")
	public WebElement updateQuestionEntryBtn;
	@FindBy(xpath = "//a[contains(text(),'Presentation with Voice Over Video (PVO)')]//following::input[3]")
	public WebElement addCorrectAnswerBtn;

	/*
	 * public void editQuestions(String question, String wrongAnswer,String
	 * orderNum, String answer) { waitForElementToLoad(questionTextField);
	 * questionTextField.sendKeys(question);
	 * wrongAnswerTextField.sendKeys(wrongAnswer); orderNumber.sendKeys(orderNum);
	 * correctCheckbox.click(); answerTextField.sendKeys(answer);
	 * updateQuestionEntryBtn.click(); }
	 */

	public void addQuestions(String question, String wrongAnswer, boolean correctAnswerCheck, String correctAnswer)
			throws InterruptedException {
		addQuestionBtn.click();
		waitForElementToLoad(questionTextField);
		questionTextField.clear();
		questionTextField.sendKeys(question);
		wrongAnswerTextField.clear();
		wrongAnswerTextField.sendKeys(wrongAnswer);
		updateQuestionEntryBtn.click();
		waitForElementToLoad(addCorrectAnswerBtn);
		addCorrectAnswerBtn.click();
		if (correctAnswerCheck) {
			correctCheckbox.click();
		} else {
			System.out.println("User has not checked the checkbox");
		}
		answerTextField.clear();
		answerTextField.sendKeys(correctAnswer);
		updateQuestionEntryBtn.click();
		Thread.sleep(1000);
		PVOTabBtn.click();
	}

	public PVOAddQuestionsPage(WebDriver driver) {
		PVOAddQuestionsPage.driver = driver;
		PageFactory.initElements(PVOAddQuestionsPage.driver, this);
	}

	

}
