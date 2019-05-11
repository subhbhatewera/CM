package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPersonsObjects extends BasePage {

	@FindBy(id = "add-button")
	WebElement addButton ;

	@FindBy(xpath = "(//div[@class='mat-tab-label-content'][contains(text(),'Contact')])[1]")
	WebElement contactPersonsTab ;

	@FindBy(xpath = "//input[@placeholder='Function']")
	WebElement functionField ;

	@FindBy(xpath = "//input[@placeholder='Person']")
	WebElement personField ;

	@FindBy(xpath = "//input[@placeholder='Email ID']")
	WebElement emailIDField ;

	@FindBy(xpath = "//input[@placeholder='Country']")
	WebElement countryDropDown ;

	@FindBy(xpath = "//input[@placeholder='Country code']")
	WebElement countryCodeField ;

	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	WebElement phoneNumberField ;

	@FindBy(id = "cancel")
	WebElement cancelButton ;

	@FindBy(xpath = "(//button[@id='saveAndContinueContractButton'] )[1]")
	WebElement listingScreenSaveButton ;

	@FindBy(xpath = "(//button[@id='saveAndContinueContractButton'] )[2]")
	WebElement addScreenSaveButton ;

	@FindBy(xpath = "(//i[@mattooltip='Edit'])[1]")
	WebElement editIcon ;

	@FindBy(xpath = "(//i[@mattooltip='Delete'])[1]")
	WebElement deleteIcon ;

	public ContactPersonsObjects(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ContactPersonsObjects gotoOtherCommercialTermsTab() {
		clickElement(contactPersonsTab);
		return this;
	}

	public ContactPersonsObjects clickAddButtion() {
		clickElement(addButton);
		return this;
	}	

	public ContactPersonsObjects setFunction(String function) {
		writeText(functionField, function);
		return this;
	}

	public ContactPersonsObjects setPerson(String person) {
		writeText(personField, person);
		return this;
	}

	public ContactPersonsObjects setEmail(String email) {
		writeText(emailIDField, email);
		return this;
	}

	public ContactPersonsObjects setCountry(String country) {
		selectDropdownOption(countryDropDown, country);
		return this;
	}

	public ContactPersonsObjects setPhoneNumber(String phoneNumber) {
		writeText(phoneNumberField, phoneNumber);
		return this;
	}

	public ContactPersonsObjects clicklistingScreenSaveButtion() {
		clickElement(listingScreenSaveButton);
		return this;
	}

	public ContactPersonsObjects clickaddScreenSaveButtion() {
		clickElement(addScreenSaveButton);
		return this;
	}

	public ContactPersonsObjects setContactPerson(String function, String person, String email, String country, String phoneNumber) {
		setFunction(function);
		setPerson(person);
		setEmail(email);
		setCountry(country);
		setPhoneNumber(phoneNumber);
		return this;
	}	
}
