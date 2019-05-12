package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInfromationObjects extends BasePage {

	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Add Contract')]")
	WebElement headingAddContract ;
	
	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Edit Contract')]")
	WebElement headingEditContract ;
	
	@FindBy(xpath = "//div[@class='mat-tab-label-content'][contains(text(),'General Information')]")
	WebElement generalInformationTab ;

	@FindBy(xpath = "//mat-select[@placeholder='Category']")
	WebElement categoryDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Subcategory']")
	WebElement subCategoryDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Business Partner']")
	WebElement businessPartnerDropDown ;

	@FindBy(xpath = "//input[@placeholder='Contract Title']")
	WebElement contractTitleField ;

	@FindBy(xpath = "//input[@placeholder='Location']")
	WebElement locationField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='currencyType']")
	WebElement currencyTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Contract Value']")
	WebElement contractValueField ;

	@FindBy(xpath = "//mat-select[@placeholder='Legal Entity']")
	WebElement legalEntityDropDown ;

	@FindBy(id="cancel")
	WebElement cancelButton ;

	@FindBy(id="saveAndContinueContractButton")
	WebElement saveAndContinueButton ;

	public GeneralInfromationObjects (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public GeneralInfromationObjects verifyAddContractLandingPage(){
		assertEquals(headingAddContract, "Add Contract");
		return this ;
	}
	
	public GeneralInfromationObjects verifyEditContractLandingPage(){
		assertEquals(headingEditContract, "Edit Contract");
		return this ;
	}

	public GeneralInfromationObjects setCategory(String category) {
		selectDropdownOption(categoryDropDown, category);
		return this;
	}

	public GeneralInfromationObjects setSubCategory(String subCategory) {
		selectDropdownOption(subCategoryDropDown, subCategory);
		return this;
	}

	public GeneralInfromationObjects setBusinessPartner(String businessPartner) {
		selectDropdownOption(businessPartnerDropDown, businessPartner);
		return this;
	}

	public GeneralInfromationObjects setContractTitle(String contractTitle) {
		writeText(contractTitleField, contractTitle);
		return this;
	}

	public GeneralInfromationObjects setLocation(String location) {
		selectLocation(locationField, location);
		return this;
	}

	public GeneralInfromationObjects setCurrencyType(String currency) {
		selectDropdownOption(currencyTypeDropDown, currency);
		return this;
	}

	public GeneralInfromationObjects setContractValue(String contractValue) {
		writeText(contractValueField, contractValue);	
		return this;
	}

	public GeneralInfromationObjects setLegalEntity(String legalEntity) {
		selectDropdownOption(legalEntityDropDown, legalEntity);
		return this;
	}

	public GeneralInfromationObjects clickCancelButton() {
		clickElement(cancelButton);
		return this;
	}

	public GeneralInfromationObjects clickSaveAndContinueButton() {
		clickElement(saveAndContinueButton);
		return this;
	}

	public GeneralInfromationObjects setGeneralInfromation(String category, String subCategory, String businessPartner, String contractTitle, String location, String currencyType, String contractValue, String legalEntity) {
		setCategory(category);
		setSubCategory(subCategory);
		setBusinessPartner(businessPartner);
		setContractTitle(contractTitle);
		setLocation(location);
		setCurrencyType(currencyType);
		setContractValue(contractValue);
		setLegalEntity(legalEntity);
		return this;
	}
}