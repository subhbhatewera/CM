package pageTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.DashboardObjects;
import pageObjects.HomepageObjects;

public class HomepageTests extends BaseTest {

	HomepageObjects homepage ;
	DashboardObjects dashboard ;

	@BeforeClass
	public void intializeClassObjects() {
		homepage = new HomepageObjects(driver);	
		dashboard = new DashboardObjects(driver);
	}

	@Test(priority = 0, enabled = true)
	public void emptyUserNameTest() {
		homepage.gotoHomepage()
		.setUserName("")
		.clickNextButton()
		.verifyErrorToaster("Must input username or email!\n" + "Error")
		.clickErrorToaster();
	}

	@Test(priority = 1, enabled = true)
	public void emptyPasswordTest() {
		homepage.doLogin("subh", "")
		.verifyErrorToaster("Must input password!\n" + "Error")
		.clickErrorToaster();
	}

	@Test(priority = 2, enabled = true)
	public void invalidCredentialsTest() {
		driver.navigate().refresh();
		homepage.doLogin("subh", "456456")
		.verifyErrorToaster("Wrong credentials, try again.\n" + "Wrong credentilas")
		.clickErrorToaster();
	}

	@Test(priority = 3, enabled = true)
	public void validCredentialsTest() {
		driver.navigate().refresh();
		homepage.doLogin("subh", "Pa$$w0rd")
		.verifyLandingPage();
		dashboard.doLogOut();
	}

	@Test(priority = 4, enabled = true)
	public void emptyOTPTest() {
		homepage.setUserName("subh")
		.clickNextButton()
		.clickOTPLoginLink()
		.clickSubmitButton()
		.verifyErrorToaster("Please enter OTP")
		.clickErrorToaster();
	}

	@Test(priority = 5, enabled = true)
	public void incorrectOTPTest() {
		homepage.setWrongOTP()
		.clickSubmitButton()
		.verifyErrorToaster("Wrong credentials, try again.\n" + "Wrong credentilas")
		.clickErrorToaster();
	}

	@Test(priority = 6, enabled = true)
	public void correctOTPTest() {
		driver.navigate().refresh();
		homepage.setUserName("subh")
		.clickNextButton()
		.clickOTPLoginLink()
		.verifySuccessToaster("Email sent. Please check your mailbox!\n" + "Email sent");
		homepage.clickSuccessToaster();
		homepage.doOTPLogin("subhash.bhatewera@exelaonline.com", "Welcome123")
		.verifyLandingPage();
		dashboard.doLogOut();
	}

	@Test(priority = 8, enabled = true)
	public void incorrectForgotPasswordTest() {
		homepage.setUserName("invalid user")
		.clickNextButton()
		.clickForgotPasswordLink()
		.verifyErrorToaster("User not found, please type in existing email!!!\n" + "Not found!")
		.clickErrorToaster();
	}

	@Test(priority = 9, enabled = true)
	public void correctForgotPasswordTest() {
		driver.navigate().refresh();
		homepage.setUserName("subh")
		.clickNextButton()
		.clickForgotPasswordLink()
		.verifyInfoToaster("Please check your email, new password is sent!!!\n" + "Password reset!");
		homepage.clickInfoToaster();
		homepage.fetchPassword("subh")
		.clickLoginButton()
		.verifyLandingPage();
		dashboard.doLogOut();
	}
}
