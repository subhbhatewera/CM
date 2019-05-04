package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopmailObjects {

	WebDriver driver ;
	WebDriverWait myWait ;


	@FindBy(id = "login")
	WebElement emailField ;

	@FindBy(xpath = "//input[@value='Check Inbox']")
	WebElement checkInboxButton ;

	public YopmailObjects (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void customWait(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void setEmail(String email) {
		customWait(emailField);
		emailField.sendKeys(email);
	}

	public void clickCheckInboxButton() {
		customWait(checkInboxButton);
		checkInboxButton.click();
	} 

	public void openEmail(String email) {
		setEmail(email);
		clickCheckInboxButton();
	}
}
