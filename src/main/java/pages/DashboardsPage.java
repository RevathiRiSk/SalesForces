package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardsPage extends Sales_BaseClass{

	public DashboardsPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//span[text()='Dashboards']")
	private WebElement tab_dashboard;
	
	
	@FindBy(xpath = "//div[text()='New Dashboard']")
	private WebElement btn_newDashboard;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search recent dashboards')]")
	private WebElement inputSearch;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[6]//button")
	private WebElement btn_dropdown;
	
	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement btnEdit;
	
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement btnDelete;
	
	@FindBy(xpath = "//button[@title='Delete']")
	private WebElement btnConfrmDelete;
	
	@FindBy(xpath = "//span[text()='No results found']")
	private WebElement txtResult;
	
	@FindBy(xpath = "//th[@aria-label='Dashboard Name']//span")
	private WebElement dash_nameSort;
	
	@FindBy(xpath = "//span[text()='Subscribe']")
	private WebElement btnSubscribe;
	
	@FindBy(xpath = "//span[text()='Daily']")
	private WebElement btnDaily;
	
	@FindBy(xpath = "//button[@title='Save']")
	private WebElement btnSave;
	
	@FindBy(xpath = "(//table[contains(@class,'slds-table slds-table_header-fixed')]/tbody/tr[1]/td[5]//span)[2]")
	private WebElement lblSubscribe;
	
	
	public DashboardsPage clickDashboard_tab() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab_dashboard);
		tab_dashboard.click();
		return this;
	}
	
	public CreateDashboardPage Click_NewDashboard() {
		btn_newDashboard.click();
		CreateDashboardPage create_dashboardP = new CreateDashboardPage(driver);
		PageFactory.initElements(driver, create_dashboardP);
		return create_dashboardP;
	}
	
	public DashboardsPage inputSearch(String dashboard_name) {
		inputSearch.sendKeys(dashboard_name);
		inputSearch.sendKeys(Keys.ENTER);
		return this;
	}
	
	public DashboardsPage btn_dropdown() throws InterruptedException {
		//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btn_dropdown));
		Thread.sleep(3000);
		btn_dropdown.click();
		return this;
	}
	
	public EditDashboardPage clickOnEdit() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btnEdit));
		btnEdit.click();
		EditDashboardPage editDB_P = new EditDashboardPage(driver);
		PageFactory.initElements(driver, editDB_P);
		return editDB_P;
	}
	
	public DashboardsPage clickOnDelete() {
		btnDelete.click();
		return this;
	}
	
	public DashboardsPage clickConfrmDelete() {
		btnConfrmDelete.click();
		return this;
	}
	
	public String getDeletedResult() {
		return txtResult.getText();
	}
	
	public DashboardsPage dashNameSorting() {
		dash_nameSort.click();
		return this;
	}
	
	public DashboardsPage clickOnSubscribe() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btnSubscribe));
		btnSubscribe.click();
		return this;
	}
	
	public DashboardsPage clickOnDaily() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(btnDaily));
		btnDaily.click();
		return this;
	}
	
	public DashboardsPage clickOnSave() {
		btnSave.click();
		return this;
	}
	
	public String verifySubscribe() {
		return lblSubscribe.getText();
	}
}
