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
	
	@FindBy(xpath = "//table[@aria-label='Recently Viewed']/tbody//tr[1]//td[6]//a")
	private WebElement btn_dropdown;
	
	@FindBy(xpath = "//a[@title='Edit']")
	private WebElement click_edit;
	
	@FindBy(xpath = "//a[@title='Delete']")
	private WebElement click_delete;
	
	@FindBy(xpath = "//table[@aria-label='Recently Viewed']/tbody//tr[1]/td[4]//span")
	private WebElement txtFirstPhoneNo;
	
	@FindBy(xpath = "//button[@title='Delete']")
	private WebElement btn_delete;
	
	@FindBy(xpath = "//th[@aria-label='Account Name']//a")
	private WebElement acc_nameSort;
	
	@FindBy(xpath = "//span[text()='No items to display.']")
	private WebElement getDelete_msg;

	public CreateAccountPage clickOnNew() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_new));
		btn_new.click();
		CreateAccountPage accountP = new CreateAccountPage(driver);
		PageFactory.initElements(driver, accountP);
		return accountP;

	}
	
	public AccountsPage inputInSearch(String accountName) throws InterruptedException {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(inputSearch));
		inputSearch.sendKeys(accountName);
		inputSearch.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}
	
	public AccountsPage clickDropDown() {
	//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn_dropdown);
	//	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_dropdown));
		driver.findElement(By.xpath("//table[@aria-label='Recently Viewed']/tbody//tr[1]//td[6]//a")).click();
		//btn_dropdown.click();
		return this;
	}
	
	public EditAccountPage clickEdit() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(click_edit));
		click_edit.click();
		EditAccountPage editP = new EditAccountPage(driver);
		PageFactory.initElements(driver, editP);
		return editP;
	}
	
	public AccountsPage clickDelete() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(click_delete));
		click_delete.click();
		return this;
	}
	
	public AccountsPage confrm_delete() throws InterruptedException {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_delete));
		Thread.sleep(3000);
		btn_delete.click();
		return this;
	}
	
	public String getLastCreatedAccountName() {
		return txtFirstAccName.getText();
	}
	
	public String getFirstPhoneNumber() {
		return txtFirstPhoneNo.getText();
	}
	
	public AccountsPage accNameSorting() {
		acc_nameSort.click();
		return this;
	}
	
	public String getdelete_msg() {
		return getDelete_msg.getText();
	}
}
