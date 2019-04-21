package pageTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ContractListObjects;
import pageObjects.DashboardObjects;
import pageObjects.GeneralInfromationObjects;
import pageObjects.HomepageObjects;
import pageObjects.TermObjects;

public class AddContractTC {

	WebDriver driver ;
	String sPath = System.getProperty("user.dir");
	String baseURL = "https://cm-qa.exela.global/#/login";
	HomepageObjects home ;
	DashboardObjects dashboard ;
	ContractListObjects contractList ;
	GeneralInfromationObjects generalInformation ;
	TermObjects term ;

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

	@Test(priority = 2)
	public void openAddContractPage() {
		contractList = new ContractListObjects(driver);
		contractList.clickAddContractsButton();
	}

	@Test(priority = 3)
	public void saveGeneralInformation() {
		generalInformation = new GeneralInfromationObjects(driver);
		generalInformation.setGeneralInformation("Vendor", "Florists", "UGH", "Edited","Pune","€","2589","BA 1");
	}

	@Test(priority = 4)
	public void saveTermFixedPeriod() {
		term = new TermObjects(driver);
		term.setFixedPeriodTab("2020", "NOV" , "November 10, 2020" ,"2021", "NOV" , "November 10, 2021", "12" ,"Month","2020", "NOV" , "November 8, 2020" ,"written", "1", "Year", "4", "Week", "30", "Day", "Selenium");
	}

	@Test(priority = 5)
	public void saveTermFixedPeriodWithoutRenewal() {
		term = new TermObjects(driver);
		term.setFixedPeriodWithoutRenewalTab("2019", "JAN", "January 1, 2019", "2025", "JAN", "January 11, 2025", "6", "Year", "2018", "DEC", "December 30, 2018", "Auto", "2", "Month", "15", "Day", "Selenium");
	}

	@Test(priority = 6)
	public void saveTermOpenEndedContracts() {
		term = new TermObjects(driver);
		term.setOpenEndedContractTab("2019", "MAR", "March 20, 2019", "2", "Month", "10", "Year", "2019", "MAR", "March 5, 2019", "written", "2", "Week", "10", "Day", "Selenium");
	}

}
