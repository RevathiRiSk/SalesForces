package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.DashboardsPage;

public class DashboardSubscription extends BaseTest {

	@Test
	public void TC007_dashboardSubscriptionTest() throws InterruptedException {

		String dashboard_name = "Sale";

		//LoginPage loginP = LoginPage.initialize(driver);
		//HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage applauncherP = homeP.clickOnToggle().clickOnViewAll();
		DashboardsPage dashboardP = applauncherP.clickDashboards();
		// DashboardsPage dashboardP1 = dashboardP.clickDashboard_tab();
		DashboardsPage dashP = dashboardP.inputSearch(dashboard_name).btn_dropdown().clickOnSubscribe().clickOnDaily()
				.clickOnSave();
		dashP.inputSearch(dashboard_name);
		String actualResult = dashP.verifySubscribe();
		System.out.println("Actual Result: " + actualResult);
		Assert.assertTrue(actualResult.equals("True"), "Verify subscribe is successful");
	}

}
