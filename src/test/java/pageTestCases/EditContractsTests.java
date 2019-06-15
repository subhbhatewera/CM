package pageTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CommercialsObjects;
import pageObjects.ContactPersonsObjects;
import pageObjects.ContractListObjects;
import pageObjects.DashboardObjects;
import pageObjects.GeneralInfromationObjects;
import pageObjects.HomepageObjects;
import pageObjects.OtherCommercialsTermsObjects;
import pageObjects.SLAObjects;
import pageObjects.TermObjects;

public class EditContractsTests extends BaseTest {

	HomepageObjects homepage ;
	DashboardObjects dashboard ;
	ContractListObjects contractList ;
	GeneralInfromationObjects generalInformation ;
	TermObjects term ;
	CommercialsObjects commercials ;
	OtherCommercialsTermsObjects otherCommercials ;
	ContactPersonsObjects contactPersons ;
	SLAObjects SLA ;

	@BeforeClass
	public void initializeClassObjects() {
		homepage = new HomepageObjects(driver);
		dashboard = new DashboardObjects(driver);
		contractList = new ContractListObjects(driver);
		generalInformation = new GeneralInfromationObjects(driver);
		term = new TermObjects(driver);
		commercials = new CommercialsObjects(driver);
		otherCommercials = new OtherCommercialsTermsObjects(driver);
		SLA = new SLAObjects(driver);
		contactPersons = new ContactPersonsObjects(driver);
	}
	
	@Test(priority = 0, enabled = true)
	public void loginTest() {
		homepage.gotoHomepage();
		homepage.doLogin("subh", "Pa$$w0rd")
		.verifyLandingPage();
	} 

	@Test(priority = 1, enabled = true)
	public void gotoContractsListingScreen() {
		dashboard.clickContractsLink()
		.clickContractsListLink();
		contractList = new ContractListObjects(driver);
		contractList.verifyLandingPage();
	}

	@Test(priority = 2, enabled = true)
	public void gotoEditContractScreen() {
		contractList.clickEditContractIcon1("HP");
		generalInformation = new GeneralInfromationObjects(driver);
		generalInformation.verifyEditContractLandingPage();
	}

	@Test(priority = 3, enabled = false)
	public void verifyGeneralInformationFieldValidations() {
		generalInformation.setCurrencyType("$")
		.setContractValue("abc")
		.setContractTitle("Test")
		.verifyFieldError("Invalid value");		
	}	

	@Test(priority = 4, enabled = false)
	public void addGeneralInformation() {
		generalInformation.setGeneralInfromation("Vendor", "Linens", "ZGG", "Automation Six", "BancTec", "$", "500", "NA")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract sucessfully added\n" + "Operation Success");		
	}

	@Test(priority = 5, enabled = false)
	public void addTermsFixedPeriod() {
		term.gotoTermTab()
		.gotoFixedPeriodTab()
		.setFixedPeriod("2016", "JAN", "January 1, 2016", "2019", "DEC", "December 1, 2019", "24", "Month", "2015", "DEC", "December 31, 2015", "Upon", "2", "Month", "2", "Week", "7", "Day", "Selenium")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 6, enabled = false)
	public void addTermsFixedPeriodWithoutRenewal() {
		term.gotoFixedPeriodWithoutRenewalTab()
		.setFixedPeriodWithoutRenewal("2019", "JAN", "January 1, 2019", "2019", "DEC", "December 1, 2019", "12", "Month", "2018", "DEC", "December 31, 2018", "2", "Month", "Selenium")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 7, enabled = false)
	public void addTermsOpenEndedContracts() {
		term.gotoOpenEndedContractTab()
		.setOpenEndedContracts("2019", "JAN", "January 1, 2019", "2018", "DEC", "December 31, 2018", "Selenium")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 8, enabled = false)
	public void addCommercialsGeneralTerms() {
		commercials.setGeneralTerms("Monthly", "30", "Day", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "EUR", "General Terms")
		.clickListingScreenSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");	
	}

	@Test(priority = 9, enabled = false)
	public void addCommercialsTransactionRateStandard() {
		commercials.gotoCommercialsTab()
		.gotoTransactionRateStandardTab()
		.clickAddButton()
		.setTransactionRateStandard("Standard Line Item", "$", "500", "Invoice", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "ATR01", "ATRR01", "Beograd", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 10, enabled = false)
	public void addCommercialsTransactionRateVolume() {
		commercials.clickAddButton()
		.setTransactionRateVolume("Volume Line Item", "Simple", "Overall", "2", "4", "100", "Volume", "Claim", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "ATR01", "ATRR01", "Beograd", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 11, enabled = false)
	public void addCommercialsTimeAndMaterialModel() {
		commercials.clickAddButton()
		.setTimeAndMaterialModel("Time and Material Model Line Item", "D1", "2020", "JAN", "January 1, 2020", "100", "Claim", "10", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "ATR01", "ATRR01", "Beograd", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 12, enabled = false)
	public void addCommercialsFixedFee() {
		commercials.clickAddButton()
		.setFixedFee("Fixed Fee Line Item", "$", "500", "MO", "Yes", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "Quarterly", "ARN01", "ARR01", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 13, enabled = false)
	public void addCommercialsMinimumBilling() {
		commercials.clickAddButton()
		.setMinimumBilling("Minimum Billing Line Item", "Volume", "250","$", "500", "Contract", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "One month", "ARN01", "ARR01", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 14, enabled = false)
	public void addOtherCommercialsCOLA() {
		otherCommercials.setCOLA("COLA Clause", "COLA Type", "COLA Index", "2020", "JAN", "January 1, 2020", "Monthly", "1", "Month", "10", "Active", "CRN1", "CRR1")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 15, enabled = false)
	public void addOtherCommercialsIncentive() {
		otherCommercials.setIncentive("Incentive Clause", "IR01", "12", "Incentive Type", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "Active", "1", "Week")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 16, enabled = false)
	public void addOtherCommercialsPenalty() {
		otherCommercials.setPenalty("Penalty Clause", "PR01", "PRR01", "12", "Quality" ,"2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "Met")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 17, enabled = false)
	public void addOtherCommercialsEarlyPaymentDiscount() {
		otherCommercials.setEarlyPaymentDiscount("Early Payment Discount Clause", "EPDR01", "EPDRR01", "4.5", "500", "2020", "JAN", "January 1, 2020", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "Paid")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 18, enabled = false)
	public void addOtherCommercialsLatePaymentFee() {
		otherCommercials.setLatePaymentFee("Late Payment Fee Clause", "LPF01", "LPFRR01", "2020", "JAN", "January 1, 2020", "30", "Day", "$", "100", "Paid")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 19, enabled = false)
	public void addOtherCommercialsTermination() {
		otherCommercials.gotoOtherCommercialTermsTab()
		.gotoTerminationTab()
		.setTermination("Termination Clause", "Termination Type", "2", "Week", "Annually", "Active", "TR01", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "$", "500")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 20, enabled = false)
	public void addOtherCommercialsLimitationOfLiability() {
		otherCommercials.gotoOtherCommercialTermsTab()
		.gotoLimitationOfLiabilityTab()
		.setLimitationOfLiability("Limitation of Liability Clause", "Limitation of Liability Type", "$", "500", "LOLR01")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 21, enabled = false)
	public void addSLATAT() {
		SLA.setTAT("TAT Clause", "TATR01", "TATRR01", "Met", "$", "100", "Percentage", "8", "Yes")
		.clickSaveAndContinueButton();
	}

	@Test(priority = 22, enabled = false)
	public void addSLAQuality() {
		SLA.gotoSLATab()
		.gotoQualityTab()
		.setQuality("Quality Clause", "QR01", "QRR01", "Non met", "12", "25", "2019", "JAN", "January 1, 2019", "25", "", "$", "100", "No")
		.clickSaveAndContinueButton();
	}

	@Test(priority = 23, enabled = true)
	public void addSLAUptime() {
		SLA.gotoSLATab()
		.gotoUptimeTab()
		.setUptime("Uptime Clause", "UR01", "URR01", "Met", "45", "Uptime Type", "$", "100", "Yes")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation success");
	}


	@Test(priority = 24, enabled = true)
	public void addContactPerson() {
		contactPersons.gotoContactPersonsTab()
		.clickAddButtion()
		.setContactPerson("CRM", "Subhash Bhatewera", "subhash.bhatewera@exelaonline.com", "United States", "2014555555")
		.clickaddScreenSaveButtion()
		.verifySuccessToaster("Contact person successfully created\n" + "Operation Success");
		contactPersons.clickSuccessToaster();
		contactPersons.clicklistingScreenSaveButtion();		
	}
}
