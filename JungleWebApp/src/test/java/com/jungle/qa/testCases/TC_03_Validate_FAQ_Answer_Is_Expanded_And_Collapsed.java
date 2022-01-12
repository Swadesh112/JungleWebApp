package com.jungle.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.JungleWebApp.Base;
import com.jungle.qa.pages.HomePage;

public class TC_03_Validate_FAQ_Answer_Is_Expanded_And_Collapsed extends Base{

	HomePage homePage;
	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validateFAQAnswerIsExpandedAndCollapsed() throws IOException, InterruptedException {
		
		logger = report.createTest(tcName);
		homePage = new HomePage();
		
		homePage.clickExplore();
		
		getScreenshot(tcName+"_QUESTION_EXPANDED");
		
		String classValueFAQQuestion = getAttribute(homePage.faqQuestionExpanded, "class");
		
		homePage.clickFAQCollapseIcon();
		
		getScreenshot(tcName+"_ANSWER_HIDDEN");
		
		String classValueFAQAnswer = getAttribute(homePage.faqAnswerCollapsed, "class");
		
		Assert.assertTrue(classValueFAQQuestion.contains("expanded"), "FAQ Question is NOT Expanded");
		logger.pass("FAQ QUESTION IS EXPANDED");
		
		Assert.assertTrue(classValueFAQAnswer.contains("hidden"), "FAQ Answer is NOT Hidden");
		logger.pass("FAQ ANSWER IS HIDDEN");
	}
}
