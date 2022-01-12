package com.jungle.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.pages.HomePage;
import com.jungle.qa.JungleWebApp.Base;

public class TC_02_Validate_Title_Of_HomePage extends Base{

	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validateTitleOfHomePage() throws IOException {
		
		logger = report.createTest(tcName);
		
		String title = driver.getTitle();
		
		getScreenshot(tcName+"_TITLE_OF_HOME_PAGE");
		
		Assert.assertTrue(title.contains("Jungle NFT"), "Title Text is NOT Correct");
		logger.pass("TITLE Of HOME PAGE IS VALID");
	}
}
