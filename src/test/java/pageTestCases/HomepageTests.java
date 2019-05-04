package pageTestCases;

import org.testng.annotations.Test;

import pageObjects.HomepageObjects;

public class HomepageTests extends BaseTest {

	HomepageObjects homepage ;

	@Test(priority = 0, enabled = false)
	public void emptyUserNameTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage()
		.setUserName("")
		.clickNextButton()
		.verifyToasterError("Must input username or email!\n" + 
				"Error");		
	}

	@Test(priority = 1, enabled = false)
	public void emptyPasswordTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		driver.navigate().refresh();
		homepage.doLogin("subh", "")
		.verifyToasterError("Must input password!\n" + 
				"Error");		
	}

	@Test(priority = 2, enabled = false)
	public void invalidCredentialsTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		driver.navigate().refresh();
		homepage.doLogin("subh", "456456")
		.verifyToasterError("Wrong credentials, try again.\n" + 
				"Wrong credentilas");		
	}

	@Test(priority = 3, enabled = false)
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
		.verifyToasterError("Please enter OTP");
	}

	@Test(priority = 5, enabled = true)
	public void incorrectOTPTest() {
		homepage = new HomepageObjects(driver);
		homepage.setWrongOTP()
		.clickSubmitButton()
		.verifyToasterError("Wrong credentials, try again.\n" + 
			"Wrong credentilas");		
	}

	@Test(priority = 6, enabled = true)
	public void correctOTPTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		driver.navigate().refresh();
		homepage.doOTPLogin("subh", "subhash.bhatewera@exelaonline.com", "Welcome123")
		.verifyLandingPage();
	}
}


