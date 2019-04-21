package pageTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomepageObjects;

public class HomePageTC {
	
	WebDriver driver ;
	String sPath = System.getProperty("user.dir");
	String baseURL = "https://cm-qa.exela.global/#/login";
	HomepageObjects home ;
	
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

}
