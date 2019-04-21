package pageTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashboardObjects;
import pageObjects.HomepageObjects;

public class DashboardTC {
	
	WebDriver driver ;
	String sPath = System.getProperty("user.dir");
	String baseURL = "https://cm-qa.exela.global/#/login";
	HomepageObjects home ;
	DashboardObjects dashboard ;
	
	@BeforeTest
	public void setUpBrowser() {
		System.setProperty("webdriver.gecko.driver", sPath+"\\drivers\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(baseURL);
	}
	
	@Test
	public void loginWithUsername() {
		home = new HomepageObjects(driver);
		home.doLogin("cvekaso", "cvekaso");
	}
	
	@Test
	public void openContractListingPage() {
		dashboard = new DashboardObjects(driver);
		dashboard.openContractListingPage();
	}

}
