package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardObjects extends BasePage {

	@FindBy(xpath = "//div[@class='heading' and contains(text(),'Dashboard')]")
	WebElement heading ;

	@FindBy(xpath = "//a[@ng-reflect-message='Contracts']")
	WebElement contractsLink ;

	@FindBy(xpath = "//a[@ng-reflect-router-link='contract-list']")
	WebElement contractsListLink ;

	@FindBy(xpath = "//a[@ng-reflect-message='Notification']")
	WebElement notificationLink ;

	@FindBy(xpath = "//div[contains(@class,'logged-user')]")
	WebElement userDropDown ;

	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	WebElement profileLink ;

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	WebElement changePasswordLink ;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logOutLink ;	


	public DashboardObjects (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public DashboardObjects clickContractsLink() {
		clickElement(contractsLink);
		return this;
	}

	public DashboardObjects clickContractsListLink() {
		clickElement(contractsListLink);
		return this;
	}

	public DashboardObjects clickNotificationLink() {
		clickElement(notificationLink);
		return this;
	}

	public DashboardObjects openUserNavigationMenu() {
		clickElement(userDropDown);
		return this ;
	}

	public DashboardObjects clickProfileLink() {
		clickElement(profileLink);		
		return this ;
	}

	public DashboardObjects clickChangePasswordLink() {
		clickElement(changePasswordLink);
		return this ;
	}

	public DashboardObjects clickLogOutLink() {
		clickElement(logOutLink);
		return this ;
	}

	public DashboardObjects doLogOut() {
		openUserNavigationMenu();
		clickLogOutLink();
		return this ;
	}
}