package testCases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.DashboardsPage;

public class DashboardSorting extends BaseTest{

	
	@Test
	public void TC006_dashboardSortingTest() {
			
	
		
		
//		LoginPage loginP = LoginPage.initialize(driver);
//		HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage applauncherP = homeP.clickOnToggle().clickOnViewAll();
		DashboardsPage dashboardP = applauncherP.clickDashboards();
		DashboardsPage dashboardP1 = dashboardP.clickDashboard_tab();
		
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'slds-table_header-fixed')]"));
		List<String> dataBeforeSorting = extractDatatable(table);
		
		DashboardsPage dashP = dashboardP.dashNameSorting();
			
		List<String> dataAfterSorting = extractDatatable(table);
		
		assertEquals(dataBeforeSorting,dataAfterSorting,"Table is sorted correctly in ascending order");
			
	}

	private List<String> extractDatatable(WebElement table) {
		
		List<WebElement> rows = table.findElements(By.xpath("//th[@aria-label='Dashboard Name']"));
		List<String> rowData = new ArrayList<>();
		
		for(WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.xpath("//table[contains(@class,'slds-table_header-fixed')]/tbody//th"));
			
			if(!cells.isEmpty()) {
				rowData.add(cells.get(0).getText());
			}
	}
		return rowData;
	}
}
