package testCases;

import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.CreateDashboardPage;
import pages.DashboardsPage;
import pages.NamedDashboardPage;

public class CreateDashBoard extends BaseTest {

	@Test
	public void TC004_createDashBoardTest() throws InterruptedException {
		String dashboard_name = "SalesForce Automation by Revathi";
		
		
		//LoginPage loginP = LoginPage.initialize(driver);
		//HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage applauncherP = homeP.clickOnToggle().clickOnViewAll();
		DashboardsPage dashboardP = applauncherP.clickDashboards();
		CreateDashboardPage newdashboardP = dashboardP.Click_NewDashboard();
		NamedDashboardPage namedP = newdashboardP.enterName(dashboard_name).clickCreate().click_Errordismiss();
		DashboardsPage dashP = namedP.click_save();
		//String actualName =dashP.;
		//Assert.assertEquals(actualName, dashboard_name);
		
	}
}
