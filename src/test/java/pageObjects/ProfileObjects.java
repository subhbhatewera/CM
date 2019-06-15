package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileObjects extends BasePage {

	@FindBy(xpath = "//div[@class='heading' and text()='Profile']")
	WebElement heading ;
	
	@FindBy(id = "editButton")
	WebElement editButton ;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameField ;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastNameField ;

	@FindBy(id = "cancelButton")
	WebElement cancelButton ;

	@FindBy(id = "updateButton")
	WebElement updateButton ;
	
	@FindBy(xpath = "//input[@placeholder='Current Password']")
	WebElement currentPasswordField ;
	
	@FindBy(xpath = "//input[@placeholder='New Password']")
	WebElement newPasswordField ;
	
	@FindBy(xpath = "//input[@placeholder='Confirm New Password']")
	WebElement confirmNewPasswordField ;
	
	@FindBy(xpath = "//span[contains(@class,'mat-button') and contains(text(),'Save')]")
	WebElement saveButton ;

	public ProfileObjects (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public ProfileObjects verifyLandingPage() {
		assertEquals(heading, "Profile");
		return this ;
	}
	
	public ProfileObjects clickEditButton() {
		clickElement(editButton);
		return this ;
	}

	public ProfileObjects setFirstName(String firstName) {
		writeText(firstNameField, firstName);
		return this ;
	}

	public ProfileObjects setLastName(String lastName) {
		writeText(lastNameField, lastName);
		return this ;
	}

	public ProfileObjects clickCancelButton() {
		clickElement(cancelButton);
		return this ;
	}

	public ProfileObjects clickUpdateButton() {
		clickElement(updateButton);
		return this ;
	}
	
	public ProfileObjects setCurrentPasswordField(String currentPWD) {
		writeText(currentPasswordField, currentPWD) ;
		return this ;
	}
	
	public ProfileObjects setNewPasswordField(String newPWD) {
		writeText(newPasswordField, newPWD) ;
		return this ;
	}
	
	public ProfileObjects setConfirmNewPasswordField(String confirmNewPWD) {
		writeText(confirmNewPasswordField, confirmNewPWD) ;
		return this ;
	}
	
	public ProfileObjects clickSaveButton() {
		clickElement(saveButton) ;
		return this ;
	}
}