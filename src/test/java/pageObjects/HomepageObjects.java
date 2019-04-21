package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepageObjects {

	WebDriver driver ;
	WebDriverWait myWait ;

	@FindBy(id = "mat-input-22")
	WebElement userNameField ;

	@FindBy(id = "loginBtn")
	WebElement nextButton ;

	@FindBy(id = "inputPassword")
	WebElement passwordField ;

	@FindBy(id = "loginBtn")
	WebElement loginButton ;

	public HomepageObjects (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void customWait(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void setUserName(String uName) {
		customWait(userNameField);
		userNameField.clear();
		userNameField.sendKeys(uName);
	}

	public void clickNextButton() {
		customWait(nextButton);
		nextButton.click();
	}

	public void setPassword(String pwd) {
		customWait(passwordField);
		passwordField.clear();
		passwordField.sendKeys(pwd);
	}

	public void clickLoginButton() {
		customWait(loginButton);
		loginButton.click();
	}

	public void doLogin(String uName, String pwd) {
		setUserName(uName);
		clickNextButton();
		setPassword(pwd);
		clickLoginButton();
	}
}
