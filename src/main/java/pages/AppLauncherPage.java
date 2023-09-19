package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppLauncherPage extends Sales_BaseClass {

	public AppLauncherPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//p[text()='Sales']")
	private WebElement btn_sales;

	public SalesHomePage clickOnSales() {
		btn_sales.click();
		SalesHomePage salesP = new SalesHomePage(driver);
		PageFactory.initElements(driver, salesP);
		return salesP;

	}

}
