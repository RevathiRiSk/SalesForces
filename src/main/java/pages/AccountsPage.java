package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsPage extends Sales_BaseClass {

	public AccountsPage(WebDriver driver) {
		super(driver);

	}


	@FindBy(xpath = "//div[text()='New']")
	private WebElement btn_new;
	
	@FindBy(xpath = "//table[@aria-label='Recently Viewed']/tbody//tr[1]/th[1]//a[1]")
	private WebElement txtFirstAccName;
	
	@FindBy(xpath = "//input[contains(@aria-label,'Search Recently')]")
	private WebElement inputSearch;
	
	@FindBy(xpath = "//table[@aria-label='Recently Viewed']/tbody/tr[1]/td[6]")
	private WebElement btn_dropdown;
	
	@FindBy(xpath = "//div[@class='forceActionLink']")
	private WebElement click_edit;
	
	@FindBy(xpath = "//span[contains(@class,'forceOutputPhone')]")
	private WebElement txtFirstPhoneNo;

	public CreateAccountPage clickOnNew() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_new));
		btn_new.click();
		CreateAccountPage accountP = new CreateAccountPage(driver);
		PageFactory.initElements(driver, accountP);
		return accountP;

	}
	
	public AccountsPage inputInSearch(String accountName) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(inputSearch));
		inputSearch.sendKeys(accountName , Keys.ENTER);
		return this;
	}
	
	public AccountsPage clickDropDown() {
		btn_dropdown.click();
		return this;
	}
	
	public EditPage clickEdit() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(click_edit));
		click_edit.click();
		EditPage editP = new EditPage(driver);
		PageFactory.initElements(driver, editP);
		return editP;
	}
	
	public String getLastCreatedAccountName() {
		return txtFirstAccName.getText();
	}
	
	public String getFirstPhoneNumber() {
		return txtFirstPhoneNo.getText();
	}
}
