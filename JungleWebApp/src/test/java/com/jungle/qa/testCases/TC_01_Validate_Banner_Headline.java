package com.jungle.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jungle.qa.pages.HomePage;
import com.jungle.qa.JungleWebApp.Base;

public class TC_01_Validate_Banner_Headline extends Base{

	
	HomePage homePage;
	String tcName = this.getClass().getSimpleName();
	
	@Test
	public void validateBannerHeadline() throws IOException {
		
		logger = report.createTest(tcName);
		
		homePage = new HomePage();
		
		String bannerText = homePage.getBannerHeadlineText();
			
		getScreenshot(tcName+"_BANNER_TEXT");
		
		Assert.assertEquals(bannerText, "Buy, Sell & Create Digital Art");
		
		logger.pass("BANNER TEXT IS DISPLAYED");
		
	
	}
}
