package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardObjects {

	WebDriver driver ;
	WebDriverWait myWait ;

	@FindBy(xpath = "//a[@ng-reflect-message='Contracts']")
	WebElement contractsLink ;

	@FindBy(xpath = "//a[@ng-reflect-router-link='contract-list']")
	WebElement contractsListLink ;

	public DashboardObjects (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void customWait(WebElement element) {
		myWait = new WebDriverWait(driver, 20);
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickContractsLink() {
		customWait(contractsLink);
		contractsLink.click();
	}

	public void clickContractsListLink() {
		customWait(contractsListLink);
		contractsListLink.click();
	}

	public void openContractListingPage() {
		clickContractsLink();
		clickContractsListLink();
	}
}
