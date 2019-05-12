package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommercialsObjects extends BasePage {

	JavascriptExecutor js ;


	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Commercials')])[1]")
	WebElement commercialsTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'General Terms')])[1]")
	WebElement generalTermsTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Standard')])[1]")
	WebElement transactionRateStandardTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Volume')])[1]")
	WebElement transactionRateVolumeTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Time')])[1]")
	WebElement timeAndMaterialModelTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Fixed')])[1]")
	WebElement fixedFeeTab ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Minimum')])[1]")
	WebElement minimumBillingTab ;

	@FindBy(xpath = "//mat-select[@placeholder='Billing Frequency']")
	WebElement billingFrequencyDropDown ;

	@FindBy(xpath = "//input[@placeholder='Credit Period']")
	WebElement creditPeriodField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='creditPeriodType']")
	WebElement creditPeriodTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Billing Start Date']")
	WebElement billingStartDateField ;

	@FindBy(xpath = "//input[@placeholder='Billing End Date']")
	WebElement billingEndDateField ;

	@FindBy(xpath = "//mat-select[@placeholder='Billing Currency']")
	WebElement billingCurrencyDropDown ;

	@FindBy(xpath = "//textarea[@placeholder='Clause']")
	WebElement clauseField ;

	@FindBy(id = "cancel")
	WebElement cancelButton ;

	@FindBy(xpath = "(//button[@id='saveAndContinueContractButton'] )[1]")
	WebElement listingScreenSaveButton ;	

	@FindBy(id = "add-button")
	WebElement addButton ;

	@FindBy(xpath = "//input[@placeholder='Line Item']")
	WebElement lineItemField ;

	@FindBy(xpath = "//mat-select[@formcontrolname='currencyType']")
	WebElement currencyTypeDropDown ;

	@FindBy(xpath = "//input[@placeholder='Rate']")
	WebElement rateField ;

	@FindBy(xpath = "//mat-select[@placeholder='UOM']")
	WebElement uomDropDown ;

	@FindBy(xpath = "//input[@placeholder='Effective Start Date']")
	WebElement effectiveStartDateField ;

	@FindBy(xpath = "//input[@placeholder='Effective End Date']")
	WebElement effectiveEndDateField ;

	@FindBy(xpath = "//input[@placeholder='Reference No']")
	WebElement referenceNoField ;

	@FindBy(xpath = "//input[@placeholder='Related Ref No']")
	WebElement relatedReferenceNoField ;

	@FindBy(xpath = "//mat-select[@placeholder='Linked Opportunity']")
	WebElement linkedOpportunityDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Related Doc']")
	WebElement relatedDocDropDown ;

	@FindBy(xpath = "//input[@placeholder='Platforms Applicable']")
	WebElement platformsApplicableField ;

	@FindBy(xpath = "//mat-select[@placeholder='Service']")
	WebElement serviceDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Sub Service']")
	WebElement subServiceDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Project']")
	WebElement projectDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Sub Project']")
	WebElement subProjectDropDown ;

	@FindBy(xpath = "//input[@placeholder='Location']")
	WebElement locationField ;

	@FindBy(xpath = "(//button[@id='saveAndContinueContractButton'] )[2]")
	WebElement addScreenSaveButton ;

	@FindBy(xpath = "//mat-select[@placeholder='Tier Type']")
	WebElement tierTypeDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Volume Split']")
	WebElement volumeSplitDropDown ;

	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[2]")
	WebElement lowerTierField ;	

	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[3]")
	WebElement upperTierField ;	

	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[4]")
	WebElement transactionRateVolumeRateField ;	

	@FindBy(xpath = "(//mat-select[starts-with(@id,'mat-select')])[3]")
	WebElement applicableFactorDropDown ;	

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement descriptionField ;

	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[1]")
	WebElement timeAndMaterialModelDescriptionField ;

	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[2]")
	WebElement timeAndMaterialModelEffectiveDateField ;

	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[3]")
	WebElement timeAndMaterialModelRateField ;

	@FindBy(xpath = "(//mat-select[starts-with(@id,'mat-select')])[1]")
	WebElement timeAndMaterialModelUOMDropDown ;

	@FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[4]")
	WebElement timeAndMaterialModelQuantityField ;

	@FindBy(xpath = "//mat-select[@placeholder='Advance Billing']")
	WebElement advanceBillingDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Applicable Period']")
	WebElement applicablePeriodDropDown ;

	@FindBy(xpath = "//mat-select[@placeholder='Type']")
	WebElement typeDropDown ;

	@FindBy(xpath = "(//i[@mattooltip='Edit'])[1]")
	WebElement editIcon ;

	@FindBy(xpath = "(//i[@mattooltip='Copy'])[1]")
	WebElement copyIcon ;

	@FindBy(xpath = "(//i[@mattooltip='Delete'])[1]")
	WebElement deleteIcon ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn cancel')]")
	WebElement confirmationCancelButtonIcon ;

	@FindBy(xpath = "//button[contains(@class,'cm-btn accept')]")
	WebElement confirmationYesButtonIcon ;


	public CommercialsObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public CommercialsObjects gotoCommercialsTab() {
		clickElement(commercialsTab);
		return this;
	}

	public CommercialsObjects gotoGeneralTermsTab() {
		clickElement(generalTermsTab);
		return this;
	}

	public CommercialsObjects gotoTransactionRateStandardTab() {
		clickElement(transactionRateStandardTab);
		return this;
	}

	public CommercialsObjects gotoTransactionRateVolumeTab() {
		clickElement(transactionRateVolumeTab);
		return this;
	}

	public CommercialsObjects gotoTimeAndMaterialModelTab() {
		clickElement(timeAndMaterialModelTab);
		return this;
	}

	public CommercialsObjects gotoFixedFeeTab() {
		clickElement(fixedFeeTab);
		return this;
	}

	public CommercialsObjects gotoMinimumBillingTab() {
		clickElement(minimumBillingTab);
		return this;
	}

	public CommercialsObjects setBillingFrequency( String billingFrequency) {
		selectDropdownOption(billingFrequencyDropDown, billingFrequency);
		return this ;
	}

	public CommercialsObjects setCreditPeriod(String creditPeriod, String creditPeriodType) {
		writeText(creditPeriodField, creditPeriod);
		selectDropdownOption(creditPeriodTypeDropDown, creditPeriodType);
		return this;
	}	

	public CommercialsObjects setBillingStartDate(String billingStartYear, String billingStartMonth, String billingStartDay) {
		selectDate(billingStartDateField, billingStartYear, billingStartMonth, billingStartDay);
		return this;
	}

	public CommercialsObjects setBillingEndDate(String billingEndYear, String billingEndMonth, String billingEndDay) {
		selectDate(billingEndDateField, billingEndYear, billingEndMonth, billingEndDay);
		return this;
	}

	public CommercialsObjects setBillingCurrency( String billingCurrency) {
		selectDropdownOption(billingCurrencyDropDown, billingCurrency);
		return this ;
	}

	public CommercialsObjects setClause(String clause) {
		writeText(clauseField, clause);
		return this;
	}

	public CommercialsObjects clickListingScreenSaveAndContinueButton() {
		clickElement(listingScreenSaveButton);
		return this;
	}

	public CommercialsObjects clickAddScreenSaveAndContinueButton() {
		scrollIntoView(addScreenSaveButton);
		clickElement(addScreenSaveButton);
		return this;
	}

	public CommercialsObjects setGeneralTerms(String billingFrequency, String creditPeriod, String creditPeriodType, String billingStartYear, String billingStartMonth, String billingStartDay, String billingEndYear, String billingEndMonth, String billingEndDay, String billingCurrency, String clause) {
		setBillingFrequency(billingFrequency);
		setCreditPeriod(creditPeriod, creditPeriodType);
		setBillingStartDate(billingStartYear, billingStartMonth, billingStartDay);
		setBillingEndDate(billingEndYear, billingEndMonth, billingEndDay);
		setBillingCurrency(billingCurrency);
		setClause(clause);
		return this;
	}

	public CommercialsObjects clickAddButton() {
		try {
			Thread.sleep(1500);
			clickElement(addButton);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return this ;
	}

	public CommercialsObjects setLineItem(String lineItem) {
		writeText(lineItemField, lineItem);
		return this;
	}

	public CommercialsObjects setCurrency(String currency) {
		selectDropdownOption(currencyTypeDropDown, currency);
		return this;
	}

	public CommercialsObjects setRate(String rate) {
		writeText(rateField, rate);
		return this;
	}

	public CommercialsObjects setUOM(String uom) {
		selectDropdownOption(uomDropDown, uom);
		return this;
	}

	public CommercialsObjects setEffectiveStartDate(String effectiveStratYear, String effectiveStratMonth, String effectiveStratDay) {
		if(effectiveStartDateField.isEnabled()) {
			selectDate(effectiveStartDateField, effectiveStratYear, effectiveStratMonth, effectiveStratDay);
		}
		return this;
	}

	public CommercialsObjects setEffectiveEndDate(String effectiveEndYear, String effectiveEndMonth, String effectiveEndDay) {
		if(effectiveEndDateField.isEnabled()) {
			selectDate(effectiveEndDateField, effectiveEndYear, effectiveEndMonth, effectiveEndDay);
		}
		return this;
	}

	public CommercialsObjects setReferenceNo(String referenceNo) {
		writeText(referenceNoField, referenceNo);
		return this;
	}

	public CommercialsObjects setRelatedRefNo(String relatedRefNo) {
		writeText(relatedReferenceNoField, relatedRefNo);
		return this;
	}

	public CommercialsObjects setLinkedOpportunity(String linkedOpportunity) {
		scrollIntoView(linkedOpportunityDropDown);
		selectDropdownOption(linkedOpportunityDropDown, linkedOpportunity );
		return this;
	}

	public CommercialsObjects setRelatedDoc(String relatedDoc) {
		selectDropdownOption(relatedDocDropDown, relatedDoc );
		return this;
	}

	public CommercialsObjects setPlatformsApplicable(String platformsApplicable) {
		writeText(platformsApplicableField, platformsApplicable);
		return this;
	}

	public CommercialsObjects setService(String service) {
		selectDropdownOption(serviceDropDown, service);
		return this;
	}

	public CommercialsObjects setSubService(String subService) {
		selectDropdownOption(subServiceDropDown, subService);
		return this;
	}

	public CommercialsObjects setProject(String project) {
		selectDropdownOption(projectDropDown, project);
		return this;
	}

	public CommercialsObjects setSubProject(String subProject) {
		selectDropdownOption(subProjectDropDown, subProject);
		return this;
	}

	public CommercialsObjects setLocation(String location) {
		selectLocation(locationField, location);
		return this;
	}

	public CommercialsObjects setTransactionRateStandard(String lineItem, String currency, String rate, String uom, String effectiveStratYear, String effectiveStratMonth, String effectiveStratDay, String effectiveEndYear, String effectiveEndMonth, String effectiveEndDay, String referenceNo, String relatedRefNo, String linkedOpportunity, String platformsApplicable, String service, String subService, String location) {
		setLineItem(lineItem);
		setCurrency(currency);
		setRate(rate);
		setUOM(uom);
		setEffectiveStartDate(effectiveStratYear, effectiveStratMonth, effectiveStratDay);
		setEffectiveEndDate(effectiveEndYear, effectiveEndMonth, effectiveEndDay);
		setReferenceNo(referenceNo);
		setRelatedRefNo(relatedRefNo);
		setLinkedOpportunity(linkedOpportunity);
		setPlatformsApplicable(platformsApplicable);
		setService(service);
		setSubService(subService);
		setLocation(location);
		return this ;
	}

	public CommercialsObjects setTierType(String tierType) {
		selectDropdownOption(tierTypeDropDown, tierType);
		return this;
	}

	public CommercialsObjects setVolumeSplit(String volumeSplit) {
		selectDropdownOption(volumeSplitDropDown, volumeSplit);
		return this;
	}

	public CommercialsObjects setLowerTier(String lowerTier) {
		writeText(lowerTierField, lowerTier);
		return this ;
	}

	public CommercialsObjects setUpperTier(String upperTier) {
		writeText(upperTierField, upperTier);
		return this ;
	}

	public CommercialsObjects setTransactionRateVolumeRate(String rate) {
		writeText(transactionRateVolumeRateField, rate);
		return this ;
	}

	public CommercialsObjects setApplicableFactor(String applicableFactor) {
		selectDropdownOption(applicableFactorDropDown, applicableFactor);
		return this;
	}

	public CommercialsObjects setTransactionRateVolume(String lineItem, String tierType, String volumeSplit, String lowerTier, String upperTier, String rate, String applicableFactor, String uom, String effectiveStratYear, String effectiveStratMonth, String effectiveStratDay, String effectiveEndYear, String effectiveEndMonth, String effectiveEndDay, String referenceNo, String relatedRefNo, String linkedOpportunity, String platformsApplicable, String service, String subService, String location) {
		setLineItem(lineItem);
		setTierType(tierType);
		setVolumeSplit(volumeSplit);
		setLowerTier(lowerTier);
		setUpperTier(upperTier);
		setTransactionRateVolumeRate(rate);
		setApplicableFactor(applicableFactor);
		setUOM(uom);
		setEffectiveStartDate(effectiveStratYear, effectiveStratMonth, effectiveStratDay);
		setEffectiveEndDate(effectiveEndYear, effectiveEndMonth, effectiveEndDay);
		setReferenceNo(referenceNo);
		setRelatedRefNo(relatedRefNo);
		setLinkedOpportunity(linkedOpportunity);
		setPlatformsApplicable(platformsApplicable);
		setService(service);
		setSubService(subService);
		setLocation(location);
		return this ;
	}

	public CommercialsObjects setDescription (String description) {
		writeText(descriptionField, description);
		return this;
	}

	public CommercialsObjects setTimeAndMaterialModelDescription(String timeAndMaterialModelDescription) {
		writeText(timeAndMaterialModelDescriptionField, timeAndMaterialModelDescription);
		return this;
	}

	public CommercialsObjects setTimeAndMaterialModelEffectiveDate(String effectiveYear, String effectiveMonth, String effectiveDay) {
		selectDate(timeAndMaterialModelEffectiveDateField, effectiveYear, effectiveMonth, effectiveDay);
		return this;
	}

	public CommercialsObjects setTimeAndMaterialModelRate(String rate) {
		writeText(timeAndMaterialModelRateField, rate);
		return this;
	}

	public CommercialsObjects setTimeAndMaterialModelUOM(String uom) {
		selectDropdownOption(timeAndMaterialModelUOMDropDown, uom);
		return this ;
	}

	public CommercialsObjects setTimeAndMaterialModelQuantity (String quantity) {
		writeText(timeAndMaterialModelQuantityField, quantity);
		return this;
	}

	public CommercialsObjects setTimeAndMaterialModel(String description, String timeAndMaterialModelDescription, String effectiveYear, String effectiveMonth, String effectiveDay, String rate, String uom, String quantity, String effectiveStratYear, String effectiveStratMonth, String effectiveStratDay, String effectiveEndYear, String effectiveEndMonth, String effectiveEndDay, String referenceNo, String relatedRefNo, String linkedOpportunity, String platformsApplicable, String service, String subService, String location) {
		setDescription(description);
		setTimeAndMaterialModelDescription(timeAndMaterialModelDescription);
		setTimeAndMaterialModelEffectiveDate(effectiveYear, effectiveMonth, effectiveDay);
		setTimeAndMaterialModelRate(rate);
		setTimeAndMaterialModelUOM(uom);
		setTimeAndMaterialModelQuantity(quantity);
		setEffectiveStartDate(effectiveStratYear, effectiveStratMonth, effectiveStratDay);
		setEffectiveEndDate(effectiveEndYear, effectiveEndMonth, effectiveEndDay);
		setReferenceNo(referenceNo);
		setRelatedRefNo(relatedRefNo);
		setLinkedOpportunity(linkedOpportunity);
		setPlatformsApplicable(platformsApplicable);
		setService(service);
		setSubService(subService);
		setLocation(location);
		return this ;
	}

	public CommercialsObjects setAdvanceBilling(String advanceBilling) {
		selectDropdownOption(advanceBillingDropDown, advanceBilling);
		return this;
	}

	public CommercialsObjects setApplicablePeriod(String applicablePeriod) {
		selectDropdownOption(applicablePeriodDropDown, applicablePeriod);
		return this;
	}

	public CommercialsObjects setFixedFee(String lineItem, String currency, String rate, String uom, String advanceBilling, String effectiveStratYear, String effectiveStratMonth, String effectiveStratDay, String effectiveEndYear, String effectiveEndMonth, String effectiveEndDay, String applicablePeriod, String referenceNo, String relatedRefNo, String platformsApplicable, String service, String subService, String location) {
		setLineItem(lineItem);
		setCurrency(currency);
		setRate(rate);
		setUOM(uom);
		setAdvanceBilling(advanceBilling);
		setEffectiveStartDate(effectiveStratYear, effectiveStratMonth, effectiveStratDay);
		setEffectiveEndDate(effectiveEndYear, effectiveEndMonth, effectiveEndDay);
		setApplicablePeriod(applicablePeriod);
		setReferenceNo(referenceNo);
		setRelatedRefNo(relatedRefNo);
		//setLinkedOpportunity(linkedOpportunity);
		setPlatformsApplicable(platformsApplicable);
		setService(service);
		setSubService(subService);
		setLocation(location);
		return this ;
	}

	public CommercialsObjects setType(String type) {
		selectDropdownOption(typeDropDown, type);
		return this;
	}

	public CommercialsObjects setMinimumBilling(String lineItem, String type, String currency, String rate, String uom, String effectiveStratYear, String effectiveStratMonth, String effectiveStratDay, String effectiveEndYear, String effectiveEndMonth, String effectiveEndDay, String applicablePeriod, String referenceNo, String relatedRefNo, String platformsApplicable, String service, String subService, String location) {
		setLineItem(lineItem);
		setType(type);
		setCurrency(currency);
		setRate(rate);
		setUOM(uom);
		setEffectiveStartDate(effectiveStratYear, effectiveStratMonth, effectiveStratDay);
		setEffectiveEndDate(effectiveEndYear, effectiveEndMonth, effectiveEndDay);
		setApplicablePeriod(applicablePeriod);
		setReferenceNo(referenceNo);
		setRelatedRefNo(relatedRefNo);
		//setLinkedOpportunity(linkedOpportunity);
		setPlatformsApplicable(platformsApplicable);
		setService(service);
		setSubService(subService);
		setLocation(location);
		return this ;
	}


}
