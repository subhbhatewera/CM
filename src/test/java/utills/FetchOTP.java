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
	WebElement emailLink ;

	@FindBy(xpath = "//p[contains(text(),'Hi')]")
	WebElement emailBodyLink ;


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

	public void openEmail() {
		clickElement(cmAppFolder);
		clickElement(emailLink);		
	}

	public String getNumberFromString() {
		String number = null ;
		try {
		waitFor(emailBodyLink);
		Thread.sleep(3000);
		//Get Email Body Text
		String emailText = emailBodyLink.getText();
		//Get OTP from String Text
		number = emailText.replaceAll("[^0-9]", "");
		System.out.println(number);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return number;		
	}

	public String fetchOTP(String userEmail, String userPassword) {
		setUseremail(userEmail);
		setPassword(userPassword);
		clickSignInButton();
		openEmail();
		return getNumberFromString();
	}
}
