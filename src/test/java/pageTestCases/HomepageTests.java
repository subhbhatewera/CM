package pageTestCases;

import org.testng.annotations.Test;

import pageObjects.HomepageObjects;

public class HomepageTests extends BaseTest {

	HomepageObjects homepage ;

	@Test(priority = 0, enabled = true)
	public void emptyUserNameTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage()
		.setUserName("")
		.clickNextButton()
		.verifyErrorToaster("Must input username or email!\n" + "Error");		
	}

	@Test(priority = 1, enabled = true)
	public void emptyPasswordTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		driver.navigate().refresh();
		homepage.doLogin("subh", "")
		.verifyErrorToaster("Must input password!\n" + "Error");		
	}

	@Test(priority = 2, enabled = true)
	public void invalidCredentialsTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		driver.navigate().refresh();
		homepage.doLogin("subh", "456456")
		.verifyErrorToaster("Wrong credentials, try again.\n" + "Wrong credentilas");		
	}

	@Test(priority = 3, enabled = true)
	public void validCredentialsTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		driver.navigate().refresh();
		homepage.doLogin("subh", "Pa$$w0rd")
		.verifyLandingPage();
	}	


	@Test(priority = 4, enabled = true)
	public void emptyOTPTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage()
		.setUserName("subh")
		.clickNextButton()
		.clickOTPLoginLink()
		.clickSubmitButton()
		.verifyErrorToaster("Please enter OTP");
	}

	@Test(priority = 5, enabled = true)
	public void incorrectOTPTest() {
		homepage = new HomepageObjects(driver);
		homepage.setWrongOTP()
		.clickSubmitButton()
		.verifyErrorToaster("Wrong credentials, try again.\n" + "Wrong credentilas");		
	}

	@Test(priority = 6, enabled = true)
	public void correctOTPTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		driver.navigate().refresh();
		homepage.setUserName("subh")
		.clickNextButton()
		.clickOTPLoginLink()
		.verifySuccessToaster("Email sent. Please check your mailbox!\n" + "Email sent");
		homepage.doOTPLogin("subhash.bhatewera@exelaonline.com", "Welcome123")
		.verifyLandingPage();
	}

	@Test(priority = 7, enabled = true)
	public void emptyForgotPasswordUserNameTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage()
		.setUserName("subh")
		.clickNextButton()
		.clickForgotPasswordLink()
		.setForgotPasswordUsername("")
		.clickSendButton()
		.verifyErrorToaster("Field can't be blank!!!\n" + "Password reset!");		
	}

	@Test(priority = 8, enabled = true)
	public void incorrectForgotPasswordTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		driver.navigate().refresh();
		homepage.setUserName("subh")
		.clickNextButton()
		.clickForgotPasswordLink()
		.setForgotPasswordUsername("invalid user")
		.clickSendButton()
		.verifyErrorToaster("User not found, please type in existing email!!!\n" + "Not found!");		
	}

	@Test(priority = 9, enabled = true)
	public void correctForgotPasswordTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		driver.navigate().refresh();
		homepage.setUserName("subh")
		.clickNextButton()
		.clickForgotPasswordLink()
		.setForgotPasswordUsername("subh")
		.clickSendButton()
		.verifySuccessToaster("Please check you email, new password is sent!!!\n" + "Password reset!");
		homepage.fetchPassword("subh")
		.clickLoginButton()
		.verifyLandingPage();
	}
}
