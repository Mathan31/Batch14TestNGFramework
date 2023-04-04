package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.FakerDataFactory;

public class TC02_Registration extends BaseClass{
	
	@Test(priority = 1)
	public void registrationElementsValidation() {
		boolean resultRegistration = new LoginPage()
		.clickOnRegistrationLink()
		.verifyAllTheRegistrationFields();
	
		boolean resultLogin = new RegistrationPage()
		.clickOnUILogo()
		.validateLoginUIElements();
		
		Assert.assertTrue(resultRegistration);
		Assert.assertTrue(resultLogin);
	}
	
	@Test(priority = 2)
	public void registerWithMandatoryFields() {
		boolean result = new LoginPage()
		.clickOnRegistrationLink()
		.enterFirstName(FakerDataFactory.getFirstName())
		.selectTitle(FakerDataFactory.getTitle())
		.enterMiddleName("")
		.enterLastName(FakerDataFactory.getLastName())
		.selectGender(FakerDataFactory.getGender())
		.enterUserName(FakerDataFactory.getUserName())
		.enterEmail(FakerDataFactory.getEmailAddress())
		.enterPassword(FakerDataFactory.getPassword())
		.clickOnRegisterBtn()
		.verifyUserRegistration()
		.clickOnUILogo()
		.validateLoginUIElements();
		Assert.assertTrue(result);
	}
	
		
	//@Test(priority = 3)
	public void registerWithAllFields() {
		
	}

}
