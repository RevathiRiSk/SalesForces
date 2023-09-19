package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesHomePage extends Sales_BaseClass {

	public SalesHomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[text()='Accounts']")
	private WebElement btn_accounts;

	@FindBy(xpath = "//div[text()='New']")
	private WebElement btn_new;

	public AccountsPage clickOnAccounts() {
	//	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_accounts));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_accounts);
        AccountsPage accP = new AccountsPage(driver);
		PageFactory.initElements(driver, accP);
		return accP;
	}

	public CreateAccountPage clickOnNew() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_new));
		btn_new.click();
		CreateAccountPage accountP = new CreateAccountPage(driver);
		PageFactory.initElements(driver, accountP);
		return accountP;

	}
}
