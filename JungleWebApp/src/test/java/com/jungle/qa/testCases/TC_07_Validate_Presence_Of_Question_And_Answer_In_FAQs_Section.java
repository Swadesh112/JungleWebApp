package com.jungle.qa.testCases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.JungleWebApp.Base;
import com.jungle.qa.pages.HomePage;

public class TC_07_Validate_Presence_Of_Question_And_Answer_In_FAQs_Section extends Base{

	HomePage homePage;
	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validatePresenceOfQustionAndAnswerInFAQSection() throws IOException, InterruptedException {
		
		logger = report.createTest(tcName);
		homePage = new HomePage();
		
		homePage.clickExplore();
		
		boolean flag = false;
		
		getScreenshot(tcName+"_FAQ_SECTION");
		
		flag = homePage.isFAQQuestionVisible();
		Assert.assertTrue(flag, "FAQ Question is Not Visible");
		logger.pass("FAQ QUESTION IS VISIBLE");
		
		flag = false;
		flag = homePage.isFAQAnswerVisible();
		Assert.assertTrue(flag, "FAQ Answer is Not Visible");
		logger.pass("FAQ ANSWER IS VISIBLE");

	}
}
