package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public AppLauncherPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//p[text()='Sales']")
	private WebElement btn_sales;
	
	@FindBy(xpath = "//p[text()='Dashboards']")
	private WebElement btn_dashboards;
	
	@FindBy(xpath = "//p[text()='Individuals']")
	private WebElement btn_individuals;

	public SalesHomePage clickOnSales() {
		btn_sales.click();
		SalesHomePage salesP = new SalesHomePage(driver);
		PageFactory.initElements(driver, salesP);
		return salesP;

	}
	
	public DashboardsPage clickDashboards() {
		Actions actions = new Actions(driver);
		actions.moveToElement(btn_dashboards).click().perform();
		DashboardsPage dashboardP = new DashboardsPage(driver);
		PageFactory.initElements(driver, dashboardP);
		return dashboardP;
		
	}
	
	public IndividualsPage clickIndividuals() {
		Actions actions = new Actions(driver);
		actions.moveToElement(btn_individuals).click().perform();
		IndividualsPage individualP = new IndividualsPage(driver);
		PageFactory.initElements(driver, individualP);
		return individualP;
	}

}
