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
}