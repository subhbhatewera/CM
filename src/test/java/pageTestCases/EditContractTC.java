package pageTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CommercialsObjects;
import pageObjects.ContractListObjects;
import pageObjects.DashboardObjects;
import pageObjects.GeneralInfromationObjects;
import pageObjects.HomepageObjects;
import pageObjects.TermObjects;

public class EditContractTC {

	WebDriver driver ;
	String sPath = System.getProperty("user.dir");
	String baseURL = "https://cm-qa.exela.global/#/login";
	HomepageObjects home ;
	DashboardObjects dashboard ;
	ContractListObjects contractList ;
	GeneralInfromationObjects generalInformation ;
	TermObjects term ;
	CommercialsObjects commercials ;

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
	public void openEditContractPage() {
		contractList = new ContractListObjects(driver);
		contractList.clicEditContractIcon("Fortis Hostipals");
	}

	@Test(priority = 3, enabled = false)
	public void updateGeneralInformation() {
		generalInformation = new GeneralInfromationObjects(driver);
		generalInformation.setGeneralInformation("Vendor", "Florists", "UGH", "Edited","Pune","€","2589","BA 1");
	}

	@Test(priority = 4, enabled = false)
	public void updateTermFixedPeriod() {
		term = new TermObjects(driver);
		term.setFixedPeriodTab("2020", "NOV" , "November 10, 2020" ,"2021", "NOV" , "November 10, 2021", "12" ,"Month","2020", "NOV" , "November 8, 2020" ,"written", "1", "Year", "4", "Week", "30", "Day", "Selenium");
	}

	@Test(priority = 5, enabled = false)
	public void updateTermFixedPeriodWithoutRenewal() {
		term = new TermObjects(driver);
		term.setFixedPeriodWithoutRenewalTab("2019", "JAN", "January 1, 2019", "2025", "JAN", "January 11, 2025", "6", "Year", "2018", "DEC", "December 30, 2018", "Auto", "2", "Month", "15", "Day", "Selenium");
	}

	@Test(priority = 6, enabled = false)
	public void updateTermOpenEndedContracts() {
		term = new TermObjects(driver);
		term.setOpenEndedContractTab("2019", "MAR", "March 20, 2019", "2", "Month", "10", "Year", "2019", "MAR", "March 5, 2019", "written", "2", "Week", "10", "Day", "Selenium");
	}

	@Test(priority = 7, enabled = false)
	public void updateCommercialsGeneralTerms() {
		commercials = new CommercialsObjects(driver);
		commercials.setGeneralTerms("Weekly", "30", "Day", "2019", "APR", "April 1, 2019", "2019", "MAY", "May 1, 2019", "EUR", "Automation");
	}

	@Test(priority = 8)
	public void updateTransactionRateStandard() {
		commercials = new CommercialsObjects(driver);
		commercials.setTransactionRateStandard("LineItem", "£", "101110", "Image", "2019", "APR", "April 1, 2019", "2019", "MAY", "May 1, 2019", "01", "02", "Beog", "Automation", "Accounts","Data Capture","Mandsaur");
	}
}
