package com.jungle.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.JungleWebApp.Base;
import com.jungle.qa.pages.HomePage;

public class TC_04_Validate_SignUp_Feature extends Base{

	HomePage homePage;
	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validateSignUpFeature() throws IOException, InterruptedException {
		
		logger = report.createTest(tcName);
		homePage = new HomePage();
			
		homePage.enterText_Email("abc@gmail.com");
		getScreenshot(tcName+"_EMAIL_ENTERED");
		
		homePage.clickSignUp();
		
		boolean flag = homePage.isSignUpConfirmed();
		getScreenshot(tcName+"_SIGNUP_CONFIRMED");
		Assert.assertTrue(flag,"Sign Up Confirmation NOT Displayed");
		logger.pass("SIGN UP FUNCTIONALITY IS WORKING");
		
	}
}
