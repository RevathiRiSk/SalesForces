package testCases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.AppLauncherPage;
import pages.SalesHomePage;

public class AccountSorting extends BaseTest {
	
	@Test
	public void TC008_accountSortingTest() {
		//LoginPage loginP = LoginPage.initialize(driver);
		//HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage appLauncherP = homeP.clickOnToggle().clickOnViewAll();
		SalesHomePage salesHomeP = appLauncherP.clickOnSales();
		AccountsPage accP = salesHomeP.clickOnAccounts();
		
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]"));
		List<String> dataBeforeSorting = extractTableData(table);
		
		AccountsPage accP2 = accP.accNameSorting();
		
		 List<String> dataAfterSorting = extractTableData(table);
		 
		 assertEquals(dataBeforeSorting, dataAfterSorting,"Table is sorted correctly in ascending order");
	}
		 private static List<String> extractTableData(WebElement table) {
		        List<WebElement> rows = table.findElements(By.xpath("//table//th[@title='Account Name']"));
		        List<String> rowData = new ArrayList<>();

		        for (WebElement row : rows) {
		            List<WebElement> cells = row.findElements(By.xpath("//table//tbody//th"));
		            if (!cells.isEmpty()) {
		                rowData.add(cells.get(2).getText()); 
		            }
		        }

		        return rowData;
	}

}
