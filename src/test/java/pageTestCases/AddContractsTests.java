package pageTestCases;

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

public class AddContractsTests extends BaseTest {

	HomepageObjects homepage ;
	DashboardObjects dashboard ;
	ContractListObjects contractList ;
	GeneralInfromationObjects generalInformation ;
	TermObjects term ;
	CommercialsObjects commercials ;
	OtherCommercialsTermsObjects otherCommercials ;
	ContactPersonsObjects contactPersons ;
	SLAObjects SLA ;

	@Test(priority = 0, enabled = true)
	public void loginTest() {
		homepage = new HomepageObjects(driver);
		homepage.gotoHomepage();
		homepage.doLogin("subh", "Pa$$w0rd")
		.verifyLandingPage();
	} 

	@Test(priority = 1, enabled = true)
	public void gotoContractsListingScreen() {
		dashboard = new DashboardObjects(driver);
		dashboard.clickContractsLink()
		.clickContractsListLink();
		contractList = new ContractListObjects(driver);
		contractList.verifyLandingPage();
	}

	@Test(priority = 2, enabled = true)
	public void gotoAddContractScreen() {
		contractList = new ContractListObjects(driver);
		contractList.clickAddContractButton();
		generalInformation = new GeneralInfromationObjects(driver);
		generalInformation.verifyAddContractLandingPage();
	}

	@Test(priority = 3, enabled = false)
	public void verifyGeneralInformationFieldValidations() {
		generalInformation = new GeneralInfromationObjects(driver);
		generalInformation.setCurrencyType("$")
		.setContractValue("abc")
		.setContractTitle("Test")
		.verifyFieldError("Invalid value");		
	}	

	@Test(priority = 4, enabled = true)
	public void addGeneralInformation() {
		generalInformation = new GeneralInfromationObjects(driver);
		generalInformation.setGeneralInfromation("Supplier", "Application", "UGH", "Reliance", "Reliance", "€", "10000", "ZA 1")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract sucessfully added\n" + "Operation Success");		
	}

	@Test(priority = 5, enabled = true)
	public void addTermsFixedPeriod() {
		term = new TermObjects(driver);
		term.setFixedPeriod("2019", "JAN", "January 1, 2019", "2020", "DEC", "December 1, 2020", "24", "Month", "2018", "DEC", "December 31, 2018", "Upon", "2", "Month", "2", "Week", "7", "Day", "Selenium")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 6, enabled = false)
	public void addTermsFixedPeriodWithoutRenewal() {
		term = new TermObjects(driver);
		term.gotoFixedPeriodWithoutRenewalTab()
		.setFixedPeriodWithoutRenewal("2019", "JAN", "January 1, 2019", "2019", "DEC", "December 1, 2019", "12", "Month", "2018", "DEC", "December 31, 2018", "Auto", "2", "Month", "7", "Day", "Selenium")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 7, enabled = false)
	public void addTermsOpenEndedContracts() {
		term = new TermObjects(driver);
		term.gotoOpenEndedContractTab()
		.setOpenEndedContracts("2019", "JAN", "January 1, 2019", "2", "Month", "10", "Year", "2018", "DEC", "December 31, 2018", "written", "2", "Month", "7", "Day", "Selenium")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 8, enabled = true)
	public void addCommercialsGeneralTerms() {
		commercials = new CommercialsObjects(driver);
		commercials.setGeneralTerms("Monthly", "30", "Day", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "EUR", "General Terms")
		.clickListingScreenSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");	
	}

	@Test(priority = 9, enabled = true)
	public void addCommercialsTransactionRateStandard() {
		commercials = new CommercialsObjects(driver);
		commercials.clickAddButton()
		.setTransactionRateStandard("Standard Line Item", "$", "500", "Invoice", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "ATR01", "ATRR01", "Beograd", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 10, enabled = true)
	public void addCommercialsTransactionRateVolume() {
		commercials = new CommercialsObjects(driver);
		commercials.clickAddButton()
		.setTransactionRateVolume("Volume Line Item", "Simple", "Overall", "2", "4", "100", "Volume", "Claim", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "ATR01", "ATRR01", "Beograd", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 11, enabled = true)
	public void addCommercialsTimeAndMaterialModel() {
		commercials = new CommercialsObjects(driver);
		commercials.clickAddButton()
		.setTimeAndMaterialModel("Time and Material Model Line Item", "D1", "2020", "JAN", "January 1, 2020", "100", "Claim", "10", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "ATR01", "ATRR01", "Beograd", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 12, enabled = true)
	public void addCommercialsFixedFee() {
		commercials = new CommercialsObjects(driver);
		commercials.clickAddButton()
		.setFixedFee("Fixed Fee Line Item", "$", "500", "MO", "Yes", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "One month", "ARN01", "ARR01", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 13, enabled = true)
	public void addCommercialsMinimumBilling() {
		commercials = new CommercialsObjects(driver);
		commercials.clickAddButton()
		.setMinimumBilling("Minimum Billing Line Item", "Volume", "$", "500", "Contract", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "One month", "ARN01", "ARR01", "Firefox", "Accounts Payable", "Data Capture", "BancTec")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 14, enabled = true)
	public void addOtherCommercialsCOLA() {
		otherCommercials = new OtherCommercialsTermsObjects(driver);
		otherCommercials.setCOLA("COLA Clause", "COLA Type", "COLA Index", "2020", "JAN", "January 1, 2020", "Monthly", "1", "Month", "10", "Active", "CRN1", "CRR1")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 15, enabled = true)
	public void addOtherCommercialsIncentive() {
		otherCommercials = new OtherCommercialsTermsObjects(driver);
		otherCommercials.setIncentive("Incentive Clause", "IR01", "12", "Incentive Type", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "Active", "1", "Week")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 16, enabled = true)
	public void addOtherCommercialsPenalty() {
		otherCommercials = new OtherCommercialsTermsObjects(driver);
		otherCommercials.setPenalty("Penalty Clause", "PR01", "PRR01", "12", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "Met")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 17, enabled = true)
	public void addOtherCommercialsEarlyPaymentDiscount() {
		otherCommercials = new OtherCommercialsTermsObjects(driver);
		otherCommercials.setEarlyPaymentDiscount("Early Payment Discount Clause", "EPDR01", "EPDRR01", "4.5", "500", "2020", "JAN", "January 1, 2020", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "Paid")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 18, enabled = true)
	public void addOtherCommercialsLatePaymentFee() {
		otherCommercials = new OtherCommercialsTermsObjects(driver);
		otherCommercials.setLatePaymentFee("Late Payment Fee Clause", "LPF01", "LPFRR01", "2020", "JAN", "January 1, 2020", "30", "Day", "$", "100", "Paid")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 19, enabled = true)
	public void addOtherCommercialsTermination() {
		otherCommercials = new OtherCommercialsTermsObjects(driver);
		otherCommercials.setTermination("Termination Clause", "Termination Type", "2", "Week", "Annualy", "Active", "TR01", "2020", "JAN", "January 1, 2020", "2020", "DEC", "December 1, 2020", "$", "500")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 20, enabled = true)
	public void addOtherCommercialsLimitationOfLiability() {
		otherCommercials = new OtherCommercialsTermsObjects(driver);
		otherCommercials.setLimitationOfLiability("Limitation of Liability Clause", "Limitation of Liability Type", "$", "500", "LOLR01")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 21, enabled = true)
	public void addContactPerson() {
		contactPersons = new ContactPersonsObjects(driver);
		contactPersons.clickAddButtion()
		.setContactPerson("Software Testing", "Subhash Bhatewera", "subhash.bhatewera@exelaonline.com", "India", "9586772365")
		.clickaddScreenSaveButtion()
		.verifySuccessToaster("Contact person successfully created\n" + "Pperation Success");
		contactPersons.clicklistingScreenSaveButtion();		
	}

	@Test(priority = 22, enabled = true)
	public void addSLATAT() {
		SLA = new SLAObjects(driver);
		SLA.setTAT("TAT Clause", "TATR01", "TATRR01", "Met", "$", "100", "Percentage", "8", "Yes")
		.clickSaveAndContinueButton();
	}

	@Test(priority = 23, enabled = true)
	public void addSLAQuality() {
		SLA = new SLAObjects(driver);
		SLA.setQuality("Quality Clause", "QR01", "QRR01", "non met", "12", "25", "2019", "JAN", "January 1, 2019", "25", "", "$", "100", "No")
		.clickSaveAndContinueButton();
	}

	@Test(priority = 24, enabled = true)
	public void addSLAUptime() {
		SLA = new SLAObjects(driver);
		SLA.setUptime("Uptime Clause", "UR01", "URR01", "Met", "45", "", "$", "100", "Yes")
		.clickSaveAndContinueButton();
	}
}
