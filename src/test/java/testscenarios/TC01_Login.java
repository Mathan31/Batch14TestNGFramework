package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC01_Login extends BaseClass{
	
	@BeforeTest
	public void initialization() {
		excelName = "TC001";
	}
	
	@Test(priority = 1)
	public void loginElementsValidation() {
		boolean result = new LoginPage(driver).validateLoginUIElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "ExcelData")
	public void loginWithValidateCredential(String userName,String password) {
		boolean result = new LoginPage(driver)
		.enterUserName(userName)
		.enterPassword(password)
		.clickOnSignInButton()
		.validateHomePage()
		.clickonLogout()
		.validateLoginUIElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidateCredential() {
		boolean result = new LoginPage(driver)
		.enterUserName("Mathan")
		.enterPassword("Testing321")
		.clickOnSignInButtonWithInvalid()
		.validateLoginFailedText();
		Assert.assertTrue(result);
	}

}
