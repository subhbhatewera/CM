package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.FetchOTP;

public class HomepageObjects extends BasePage{

	String sBaseURL = "https://cm-qa.exela.global/#/login";
	JavascriptExecutor js ;
	FetchOTP fetch ;
	DashboardObjects dashboard ;

	@FindBy(id = "mat-input-22")
	WebElement userNameField ;

	@FindBy(id = "loginBtn")
	WebElement nextButton ;

	@FindBy(id = "inputPassword")
	WebElement passwordField ;

	@FindBy(id = "loginBtn")
	WebElement loginButton ;

	@FindBy(xpath = "//div[contains(@class,'toast-error')]")
	WebElement errorToaster ;

	@FindBy(xpath = "//p[contains(text(),'OTP LOGIN')]")
	WebElement otpLoginLink ;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and contains(text(),'Submit')]")
	WebElement submitButton ;

	//Constructor
	public HomepageObjects (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public HomepageObjects gotoHomepage() {
		driver.get(sBaseURL);
		return this ;
	}

	public HomepageObjects gotoExelaOnlineEmail() {
		js = (JavascriptExecutor)driver ;
		js.executeScript("window.open('https://mail.exelaonline.com/owa','_blank');");
		return this;
	}

	public HomepageObjects setUserName(String userName) {
		writeText(userNameField, userName);
		return this ;
	}

	public HomepageObjects clickNextButton() {
		clickElement(nextButton);
		return this ;
	}

	public HomepageObjects setPassword(String password) {
		writeText(passwordField, password);
		return this ;
	}

	public void clickLoginButton() {
		clickElement(loginButton);
	}

	public HomepageObjects verifyLandingPage(){
		dashboard = new DashboardObjects(driver);
		assertEquals(dashboard.heading, "Dashboard");
		return this ;
	}

	public HomepageObjects verifyToasterError(String errorMessage) {
		try {
			Thread.sleep(1500);
			assertEquals(errorToaster, errorMessage);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return this ;
	}

	public HomepageObjects clickOTPLoginLink() {
		clickElement(otpLoginLink);
		return this ;
	}

	public HomepageObjects clickSubmitButton() {
		clickElement(submitButton);
		return this ;
	}

	public HomepageObjects setWrongOTP() {
		for(int i = 0 ; i<6 ; i++) {
			WebElement element = driver.findElement(By.xpath("//input[@formcontrolname='digitFormControlName"+(i+1)+"']"));
			writeText(element, "0");
		}		
		return this;
	}

	public HomepageObjects doLogin(String userName, String password) {
		setUserName(userName);
		clickElement(nextButton);
		setPassword(password);
		clickElement(loginButton);
		return this;
	}

	public HomepageObjects doOTPLogin(String userName, String userEmail, String userPassword) {
		fetch = new FetchOTP(driver);
		setUserName(userName);
		clickNextButton();
		clickOTPLoginLink();
		String mainWindow = driver.getWindowHandle();
		gotoExelaOnlineEmail();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String childWindow = itr.next();
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				String OTP = fetch.fetchOTP(userEmail, userPassword);
				driver.switchTo().window(mainWindow);
				for(int i = 0 ; i<OTP.length() ; i++) {
					String digit = String.valueOf(OTP.charAt(i));
					System.out.println(digit);
					WebElement element = driver.findElement(By.xpath("//input[@formcontrolname='digitFormControlName"+(i+1)+"']"));
					writeText(element, digit);
				}
			}	
		}
		clickSubmitButton();
		return this;
	}
}
