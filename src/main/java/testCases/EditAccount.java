package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.AppLauncherPage;
import pages.SalesHomePage;

public class EditAccount extends BaseTest {

	
	@Test
	public void TC002_editAccountTest() throws InterruptedException {
		
		String accountName = "Revathi";
		String address = "123,xxyyzzz,abc";
		String number = "99";
		
		//LoginPage loginP = LoginPage.initialize(driver);
		//HomePage homeP= loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage appLauncherP = homeP.clickOnToggle().clickOnViewAll();
		SalesHomePage salesHomeP = appLauncherP.clickOnSales();
		AccountsPage accP = salesHomeP.clickOnAccounts().inputInSearch(accountName).clickDropDown();
		accP.clickEdit().selectType("Technology Partner").selectIndustry("Healthcare").enterBillingAddress(address).enterShippingAddress(address)
		.selectPriority("Low").selectSLA("Silver").selectActive("No").enterPhone(number).selectOpportunity("No").clickSave();
		accP = salesHomeP.clickOnAccounts();
		String actualNumber =  accP.getFirstPhoneNumber();
		System.out.println("Actual Result: " + actualNumber);
		Assert.assertEquals(actualNumber,number);
	}
}
