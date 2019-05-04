package pageTestCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomepageObjects;
import pageObjects.YopmailObjects;
import utills.FetchOTP;

public class HomePageTC {

	WebDriver driver ;
	String sPath = System.getProperty("user.dir");
	String baseURL = "https://cm-qa.exela.global/#/login";
	String emailURL = "https://mail.exelaonline.com/owa";
	HomepageObjects home ;
	FetchOTP fetch ;
	JavascriptExecutor js ;
	YopmailObjects yop ;

	@BeforeTest
	public void setUpBrowser() {
		System.setProperty("webdriver.gecko.driver", sPath+"\\drivers\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(baseURL);
	}

	@Test(enabled = false)
	public void loginWithUsername() {
		home = new HomepageObjects(driver);
		home.doLogin("cvekaso", "cvekaso");
	}

	@Test
	public void loginWithOTP() {
		home = new HomepageObjects(driver);
		js = (JavascriptExecutor)driver ;
		//yop = new YopmailObjects(driver);
		fetch = new FetchOTP(driver);
	//	home.setUserName("subh");
	//	home.clickNextButton();
	//	home.clickOTPLoginLink();
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main Window "+mainWindow);
		js.executeScript("window.open('https://mail.exelaonline.com/owa','_blank');");
		//js.executeScript("window.open('http://www.yopmail.com/en/','_blank');");
		//fetch.openBrowser();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String childWindow = itr.next();
			System.out.println("Child Window "+childWindow);
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				//fetch.openEmail("subhash.bhatewera@exelaonline.com", "Welcome123");
				fetch.fetchOTP("subhash.bhatewera@exelaonline.com", "Welcome123");
				//yop.openEmail("cm@yopmail.com");
			}
		}


		//home.doOTPLogin("subhash.bhatewera@exelaonline.com", "Welcome123");
	}
}
