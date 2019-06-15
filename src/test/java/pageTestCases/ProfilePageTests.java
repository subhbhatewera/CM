package pageTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.DashboardObjects;
import pageObjects.HomepageObjects;
import pageObjects.ProfileObjects;

public class ProfilePageTests extends BaseTest {

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
	public void gotoProfilePage() {
		dashboard.openUserNavigationMenu()
		.clickProfileLink();
		profile.verifyLandingPage() ;				 
	}

	@Test(priority = 2, enabled = false)
	public void updatePersonalInfo() {
		profile.clickEditButton()
		//.setFirstName("subh")
		.setLastName("bhatewera")
		.clickUpdateButton()
		.verifySuccessToaster("User profile updated successfully");
	}	
}
