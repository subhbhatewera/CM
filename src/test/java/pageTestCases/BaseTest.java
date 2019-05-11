package pageTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	WebDriver driver ;
	String sPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void setUpBrowser() {
		System.setProperty("webdriver.gecko.driver", sPath+"\\drivers\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@AfterClass(enabled = false)
	public void tearDown() {
		driver.quit();
	}

}