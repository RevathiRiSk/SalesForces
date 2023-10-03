package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesHomePage extends Sales_BaseClass {

	public SalesHomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[text()='Accounts']")
	private WebElement btn_accounts;

	@FindBy(xpath = "//span[text()='Opportunities']")
	private WebElement btn_opportunity;
	

	public AccountsPage clickOnAccounts() {
	//	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_accounts));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_accounts);
        AccountsPage accP = new AccountsPage(driver);
		PageFactory.initElements(driver, accP);
		return accP;
	}

	public OpportunityPage clickOnOpportunity() {
		//	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_accounts));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_opportunity);
	        OpportunityPage oppP = new OpportunityPage(driver);
			PageFactory.initElements(driver, oppP);
			return oppP;
		}
}
