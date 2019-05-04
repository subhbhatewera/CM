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
	public void doLogin() {
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
		contractList.clicEditContractIcon("Airtel Fiber");
	}

	@Test(priority = 3, enabled = false)
	public void saveGeneralInformation() {
		generalInformation = new GeneralInfromationObjects(driver);
		generalInformation.setGeneralInfromation("Customer", "Education", "ZGG", "Automation Testing", "Mandsaur", "$", "5200", "NA");
	}

	@Test(priority = 4, enabled = false)
	public void saveFixedPeriodTerm() {
		term = new TermObjects(driver);
		term.setFixedPeriod("2019", "JAN", "January 1, 2019", "2020", "JAN", "January 1, 2020", "12", "Month", "2018", "DEC", "December 1, 2018", "Auto", "2", "Month", "2", "Week", "10", "Day", "Page Object Model");
	}

	@Test(priority = 5, enabled = false)
	public void saveFixedPeriodWithRenewalTerm() {
		term = new TermObjects(driver);
		term.setFixedPeriodWithoutRenewal("2019", "JAN", "January 1, 2019", "2020", "JAN", "January 1, 2020", "12", "Month", "2018", "DEC", "December 1, 2018", "Auto", "2", "Week", "10", "Day", "Page Object Model");
	}

	@Test(priority = 6, enabled = false)
	public void saveOpenEndedContractsTerm() {
		term = new TermObjects(driver);
		term.setOpenEndedContracts("2019", "JAN", "January 1, 2019", "2", "Month", "1", "Year", "2018", "DEC", "December 1, 2018", "Auto", "2", "Week", "10", "Day", "Page Object Model");
	}

	@Test(priority = 7, enabled = false)
	public void saveGeneralTermsTab() {
		commercials = new CommercialsObjects(driver);
		commercials.setGeneralTerms("Monthly", "30", "Day", "2019", "JAN", "January 1, 2019", "2020", "JAN", "January 1, 2020", "EUR", "General Terms");
	}

	@Test(priority = 8, enabled = false)
	public void saveTransactionRateStandard() {
		commercials = new CommercialsObjects(driver);
		commercials.setTransactionRateStandard("Automation", "$", "5200", "Image", "2019", "JAN", "January 1, 2019", "2020", "JAN", "January 1, 2020", "AR01", "ARR01", "Beograd", "Windows 10", "Accounts Payable", "Mailroom", "Mandsaur");
	}
	
	@Test(priority = 8, enabled = false)
	public void saveTransactionRateVolume() {
		commercials = new CommercialsObjects(driver);
		commercials.setTransactionRateVolume("Automation","Simple","Overall","10", "12", "20", "Volume", "Image", "2019", "JAN", "January 1, 2019", "2020", "JAN", "January 1, 2020", "AR01", "ARR01", "Beograd", "Windows 10", "Accounts Payable", "Mailroom", "Mandsaur");
	}
	
	@Test(priority = 9, enabled = false)
	public void saveTimeAndMaterialModel(){
		commercials = new CommercialsObjects(driver);
		commercials.setTimeAndMaterialModel("Automation", "D1", "2019", "JAN", "January 1, 2019", "12", "Image", "5", "2019", "JAN", "January 1, 2019", "2020", "JAN", "January 1, 2020", "AR01", "ARR01", "Beograd", "Windows 10", "Accounts Payable", "Mailroom", "Mandsaur");
	}
	
	@Test(priority = 9, enabled = true)
	public void saveFixedFee(){
		commercials = new CommercialsObjects(driver);
		commercials.setFixedFee("Automation", "$", "100", "Hour", "Yes", "2019", "JAN", "January 1, 2019", "2020", "JAN", "January 1, 2020", "AR01", "ARR01", "Windows 10", "Accounts Payable", "Mailroom", "Mandsaur");
	}
}
