package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.CreateIndividualPage;
import pages.IndividualsPage;

public class CreateIndividual_NotMandatory extends BaseTest {

	@Test
	public void TC010_createIndividual_NotMandatoryTest() throws InterruptedException {
		
		String firstname = "Ganesh";
		
		
		//LoginPage loginP = LoginPage.initialize(driver);
		//HomePage homeP = loginP.loginWithValidCredentials("revmohan@gmail.com", "Mohanrevathi1!");
		AppLauncherPage appLauncherP = homeP.clickOnToggle().clickOnViewAll();
		IndividualsPage individualP = appLauncherP.clickIndividuals();
		CreateIndividualPage createIndividualP = individualP.click_IndividualDD().click_Newindividual();
		createIndividualP.selectSalutation("Mr.").inputFirstName(firstname).clickSave();
		String actualMsg = createIndividualP.getError_msg();
		String expectedMsg = "These required fields must be completed: Last Name";
		System.out.println("Actual Message: "+ actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);;
	}
}
