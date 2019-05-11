package utills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.BasePage;

public class FetchOTP extends BasePage {

	@FindBy(id = "username")
	WebElement userNameField ;

	@FindBy(id = "password")
	WebElement passwordField ;

	@FindBy(xpath = "//div[@class='signinbutton']")
	WebElement signInButton ;

	@FindBy(xpath = "//span[@title='CM App']")
	WebElement cmAppFolder ;

	@FindBy(xpath = "(//span[contains(text(),'Login with OTP')])[1]")
	WebElement otpEmailLink ;

	@FindBy(xpath = "(//span[contains(text(),'Forgot Password')])[1]")
	WebElement forgotPasswordEmailLink ;

	@FindBy(xpath = "//div//p[contains(text(),'Hi')]")
	WebElement otpEmailBodyLink ;

	@FindBy(xpath = "//div//p[contains(text(),'Your')]")
	WebElement passwordEmailBodyLink ;

	@FindBy(xpath = "//button[contains(@aria-label,'menu with submenu')]")
	WebElement userNavigationMenu;

	@FindBy(xpath = "//span[contains(text(),'Sign out')]")
	WebElement signOutLink ;


	public FetchOTP (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void setUseremail(String userEmail) {
		writeText(userNameField, userEmail);
	}

	public void setPassword(String userPassword) {
		writeText(passwordField, userPassword);
	}

	public void clickSignInButton() {
		clickElement(signInButton);
	}

	public void openOTPEmail() {
		clickElement(cmAppFolder);
		clickElement(otpEmailLink);
	}

	public void openForgotPasswordEmail() {
		clickElement(cmAppFolder);		
		clickElement(forgotPasswordEmailLink);		
	}

	public void signOut() {
		clickElement(userNavigationMenu);
		clickElement(signOutLink);
	}

	public String getNumberFromString() {
		String number = null ;		
		waitFor(otpEmailBodyLink);
		//Get Email Body Text
		String emailText = otpEmailBodyLink.getText();
		//Get OTP from String Text
		number = emailText.replaceAll("[^0-9]", "");			
		return number;		
	}

	public String getPasswordFromEmailBody() {
		String password = null;		
		waitFor(passwordEmailBodyLink);			
		//Get Email Body Text
		String emailText = passwordEmailBodyLink.getText();
		// Get Password from String Text
		password = emailText.substring(22,30);		
		return password ;
	}

	public String fetchOTP(String userEmail, String userPassword) {
		setUseremail(userEmail);
		setPassword(userPassword);
		clickSignInButton();
		openOTPEmail();
		return getNumberFromString();
	}

	public String fetchPassword() {		
		openForgotPasswordEmail();		
		return getPasswordFromEmailBody();
	}


}