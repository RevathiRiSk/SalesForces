package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.DashboardsPage;

public class DeleteDashboard extends BaseTest{

	@Test
	public void TC006_DeleteDashboard() throws InterruptedException {
		
		
		String dashboard_name = "Login";
		String expectedResult = "No results found";
		
		//LoginPage loginP = LoginPage.initialize(driver);
		//HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage applauncherP = homeP.clickOnToggle().clickOnViewAll();
		DashboardsPage dashboardP = applauncherP.clickDashboards();
		//DashboardsPage dashboardP1 = dashboardP.clickDashboard_tab();
		DashboardsPage dashP = dashboardP.inputSearch(dashboard_name).btn_dropdown().clickOnDelete().clickConfrmDelete();
		String actualResult = dashP.getDeletedResult();
		System.out.println("Actual Result: " + actualResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
}
