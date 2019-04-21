package pageTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ContractListObjects;
import pageObjects.DashboardObjects;
import pageObjects.GeneralInfromationObjects;
import pageObjects.HomepageObjects;

public class ContractListTC {

	WebDriver driver ;
	String sPath = System.getProperty("user.dir");
	String baseURL = "https://cm-qa.exela.global/#/login";
	HomepageObjects home ;
	DashboardObjects dashboard ;
	ContractListObjects contractList ;
	GeneralInfromationObjects generalInformation ;

	@BeforeTest
	public void setUpBrowser() {
		System.setProperty("webdriver.gecko.driver", sPath+"\\drivers\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(baseURL);
	}

	@Test (priority = 0)
	public void loginWithUsername() {
		home = new HomepageObjects(driver);
		home.doLogin("cvekaso", "cvekaso");
	}

	@Test(priority = 1)
	public void openContractListingPage() {
		dashboard = new DashboardObjects(driver);
		dashboard.openContractListingPage();
	}

	@Test(priority = 2, enabled = false)
	public void openAddContractPage() {
		contractList = new ContractListObjects(driver);
		contractList.clickAddContractsButton();
	}

	@Test(priority = 3)
	public void openEditContractPage() {
		contractList = new ContractListObjects(driver);
		contractList.clicEditContractIcon("Automobile");
	}	
}
