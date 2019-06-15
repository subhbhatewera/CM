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
		homepage.doLogin("cvekaso", "cvekaso")
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
	public void gotoAddContractScreen() {
		contractList.clickAddContractButton();
		generalInformation = new GeneralInfromationObjects(driver);
		generalInformation.verifyAddContractLandingPage();
	}

	@Test(priority = 3, enabled = false)
	public void verifyGeneralInformationFieldValidations() {
		generalInformation.setCurrencyType("$")
		.setContractValue("abc")
		.setContractTitle("Test")
		.verifyFieldError("Invalid value");		
	}	

	@Test(priority = 4, enabled = true)
	public void addGeneralInformation() {
		generalInformation.setGeneralInfromation("Supplier", "Applications", "UGH", "Xento", "Pune", "$", "1000", "NA")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully added\n" + "Operation Success");		
	}

	@Test(priority = 5, enabled = false)
	public void addTermsFixedPeriod() {
		term.clickSuccessToaster();
		term.setFixedPeriod("2017", "AUG", "August 31, 2017", "2027", "DEC", "December 1, 2027", "10", "Year", "2017", "JUL", "July 8, 2017", "Auto", "2", "Month", "2", "Week", "10", "Day", "Selenium")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 6, enabled = true)
	public void addTermsFixedPeriodWithoutRenewal() {
		term.clickSuccessToaster();
		term.gotoFixedPeriodWithoutRenewalTab()
		.setFixedPeriodWithoutRenewal("2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "5", "Year", "2016", "JAN", "January 31, 2016", "30", "Day", "Selenium")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 7, enabled = false)
	public void addTermsOpenEndedContracts() {
		term.clickSuccessToaster();
		term.gotoOpenEndedContractTab()
		.setOpenEndedContracts("2016", "JAN", "January 1, 2016", "2015", "DEC", "December 31, 2015", "Selenium")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 8, enabled = true)
	public void addCommercialsGeneralTerms() {
		commercials.clickSuccessToaster();
		commercials.setGeneralTerms("Monthly", "30", "Day", "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "USD", "General Terms")
		.clickListingScreenSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");	
	}

	@Test(priority = 9, enabled = true)
	public void addCommercialsTransactionRateStandard() {
		commercials.clickSuccessToaster();
		commercials.clickAddButton()
		.setTransactionRateStandard("Standard Line Item", "$", "1000", "Check", "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "ATR01", "ATRR01", "Beograd", "Firefox", "Accounts Payable", "Data Capture", "Pune")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 10, enabled = true)
	public void addCommercialsTransactionRateVolume() {
		commercials.clickAddButton()
		.setTransactionRateVolume("Volume Line Item", "Simple", "Overall", "2", "4", "100", "Volume", "Claim", "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "01", "02", "Beograd", "Firefox", "Accounts Payable", "Data Capture", "Pune")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 11, enabled = true)
	public void addCommercialsTimeAndMaterialModel() {
		commercials.clickAddButton()
		.setTimeAndMaterialModel("Time and Material Model Line Item", "D1", "2016", "JAN", "January 1, 2016", "100", "Claim", "10", "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "ATR01", "ATRR01", "Beograd", "Firefox", "Accounts Payable", "Data Capture", "Pune")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 12, enabled = true)
	public void addCommercialsFixedFee() {
		commercials.clickAddButton()
		.setFixedFee("Fixed Fee Line Item", "$", "1000", "MO", "Yes", "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "Monthly", "ARN01", "ARR01", "Firefox", "Accounts Payable", "Data Capture", "Pune")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 13, enabled = true)
	public void addCommercialsMinimumBilling() {
		commercials.clickAddButton()
		.setMinimumBilling("Minimum Billing Line Item", "Volume", "110", "$", "500", "Contract", "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "One month", "ARN01", "ARR01", "Firefox", "Accounts Payable", "Data Capture", "Pune")
		.clickAddScreenSaveAndContinueButton()
		.clickListingScreenSaveAndContinueButton();
	}

	@Test(priority = 14, enabled = true)
	public void addOtherCommercialsCOLA() {
		otherCommercials.setCOLA("COLA Clause", "COLA Type", "COLA Index", "2016", "MAR", "March 1, 2016", "Monthly", "1", "Month", "10", "Active", "CRN1", "CRR1")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 15, enabled = true)
	public void addOtherCommercialsIncentive() {
		otherCommercials.clickSuccessToaster();
		otherCommercials.setIncentive("Incentive Clause", "IR01", "12", "Incentive Type", "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "Active", "1", "Week")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 16, enabled = true)
	public void addOtherCommercialsPenalty() {
		otherCommercials.clickSuccessToaster();
		otherCommercials.setPenalty("Penalty Clause", "PR01", "PRR01", "12", "TAT" , "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "Met")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 17, enabled = true)
	public void addOtherCommercialsEarlyPaymentDiscount() {
		otherCommercials.clickSuccessToaster();
		otherCommercials.setEarlyPaymentDiscount("Early Payment Discount Clause", "EPDR01", "EPDRR01", "4.5", "500", "2016", "JAN", "January 1, 2016", "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "Paid")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 18, enabled = true)
	public void addOtherCommercialsLatePaymentFee() {
		otherCommercials.clickSuccessToaster();
		otherCommercials.setLatePaymentFee("Late Payment Fee Clause", "LPF01", "LPFRR01", "2021", "MAR", "March 1, 2021", "30", "Day", "$", "100", "Paid")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 19, enabled = true)
	public void addOtherCommercialsTermination() {
		otherCommercials.clickSuccessToaster();
		otherCommercials.setTermination("Termination Clause", "Termination Type", "2", "Week", "Annually", "Active", "TR01", "2016", "MAR", "March 1, 2016", "2021", "MAR", "March 1, 2021", "$", "500")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 20, enabled = true)
	public void addOtherCommercialsLimitationOfLiability() {
		otherCommercials.clickSuccessToaster();
		otherCommercials.setLimitationOfLiability("Limitation of Liability Clause", "Limitation of Liability Type", "$", "500", "LOLR01")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");		
	}

	@Test(priority = 21, enabled = true)
	public void addSLATAT() {
		SLA.clickSuccessToaster();
		SLA.setTAT("TAT Clause", "TATR01", "TATRR01", "Met", "$", "100", "Percentage", "8", "Yes")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 22, enabled = true)
	public void addSLAQuality() {
		SLA.clickSuccessToaster();
		SLA.setQuality("Quality Clause", "QR01", "QRR01", "Non met", "12", "25", "2019", "JAN", "January 1, 2019", "25", "Quality", "$", "1000", "No")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 23, enabled = true)
	public void addSLAUptime() {
		SLA.clickSuccessToaster();
		SLA.setUptime("Uptime Clause", "UR01", "URR01", "Met", "45", "Uptime", "$", "245", "Yes")
		.clickSaveAndContinueButton()
		.verifySuccessToaster("Contract successfully update\n" + "Operation Success");
	}

	@Test(priority = 24, enabled = true)
	public void addContactPerson() {
		contactPersons.clickSuccessToaster();
		contactPersons.clickAddButtion()
		.setContactPerson("CRM", "Subhash Bhatewera", "subhash.bhatewera@exelaonline.com", "United States", "5614283677")
		.clickaddScreenSaveButtion()
		.verifySuccessToaster("Contact person successfully created\n" + "Operation Success");
		contactPersons.clickSuccessToaster();
		contactPersons.clicklistingScreenSaveButtion();		
	}
}
