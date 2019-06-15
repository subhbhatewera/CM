package pageTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.DashboardObjects;
import pageObjects.HomepageObjects;
import pageObjects.ProfileObjects;

public class DashboardPageTests extends BaseTest {

	HomepageObjects homepage ;
	DashboardObjects dashboard ;
	ProfileObjects profile ;

	@BeforeClass
	public void intializeClassObjects() {
		homepage = new HomepageObjects(driver) ;	
		dashboard = new DashboardObjects(driver) ;
		profile = new ProfileObjects(driver) ;
	}

	@Test(priority = 0, enabled = true)
	public void loginTest() {
		homepage.gotoHomepage();
		homepage.doLogin("subh", "Pa$$w0rd")
		.verifyLandingPage();
	}

	@Test(priority = 1, enabled = false)
	public void updatePassword() {
		dashboard.openUserNavigationMenu()
		.clickChangePasswordLink();
		profile.setCurrentPasswordField("Pa$$w0rd")
		.setNewPasswordField("Pa$$w0rd")
		.setConfirmNewPasswordField("Pa$$w0rd")
		.clickSaveButton()
		.verifySuccessToaster("Password changed successfully.");
	}


	@Test(priority = 2, enabled = true)
	public void logOutTest() {
		dashboard.openUserNavigationMenu()
		.clickLogOutLink();
	}
}
