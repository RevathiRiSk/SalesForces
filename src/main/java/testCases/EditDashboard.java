package testCases;

import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.DashboardsPage;
import pages.EditDashboardPage;

public class EditDashboard extends BaseTest {

	
	@Test
	public void TC005_edit_dashboardTest() throws InterruptedException {
		String dashboard_name = "Example";
		String detail = "SalesForce";
		
		//LoginPage loginP = LoginPage.initialize(driver);
		//HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage appLauncherP = homeP.clickOnToggle().clickOnViewAll();
		DashboardsPage dashP = appLauncherP.clickDashboards();
		EditDashboardPage editDbP = dashP.inputSearch(dashboard_name).btn_dropdown().clickOnEdit();
		editDbP.click_editProperty();
		editDbP.enterDescripition(detail).click_Errordismiss().click_saveEdit();
		
	}
}
